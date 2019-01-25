import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";

Vue.use(Vuex);

const env = process.env.NODE_ENV || "development";

const baseURL = {
  development: "http://127.0.0.1:8080",
  // production:"-TBD-"
};

const api = axios.create({
  baseURL: baseURL[env],
});

const state = {
  player: null,
  players: [],
  games: [],
};

// remember login
state.player = localStorage.getItem("six-pits-player");
if (state.player) state.player = JSON.parse(state.player);

const mutations = {
  setPlayer(state, player) {
    state.player = player;
    if (player) localStorage.setItem("six-pits-player", JSON.stringify(player));
    else localStorage.removeItem("six-pits-player");
  },
  setPlayers(state, players) {
    state.players = players;
  },
  setGames(state, games) {
    state.games = games;
  },
};

const actions = {
  async listPlayers({commit}) {
    const ret = await api.get("/player/list");
    commit("setPlayers", ret.data);
  },
  doLogin(_, login) {
    return api.post("/player/login", login);
  },
  doRegister(_, login) {
    return api.post("/player/register", login);
  },
  async doLogout({commit}) {
    commit("setPlayer", null);
  },
  goOnline({state}) {
    let player = state.player;
    player.status.playerStatusId = 2;
    return api.put("/player/save", player);
  },
  goOffline({state}) {
    let player = state.player;
    player.status.playerStatusId = 1;
    return api.put("/player/save", player);
  },
  goGaming({state}) {
    let player = state.player;
    player.status.playerStatusId = 3;
    return api.put("/player/save", player);
  },
  async listGames({commit}) {
    const ret = await api.get("/game/list");
    commit("setGames", ret.data);
  },
  newGame(_, game) {
    return api.post("/game/save", game);
  },
  refuseGame({state}, game) {
    // player 1 aborted
    if (game.player1.playerId == state.player.playerId) game.status.gameStatusId = 5;
    // player 2 aborted
    else if (game.player2.playerId == state.player.playerId) game.status.gameStatusId = 6;
    return api.put("/game/save", game);
  },
  acceptGame(_, game) {
    game.status.gameStatusId = 2;
    return api.put("/game/save", game);
  },
  getGame(_, gameId) {
    return api.get(`/game/${gameId}`);
  },
};

export const store = new Vuex.Store({state, mutations, actions});
