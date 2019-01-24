import Vue from "vue";
import Vuex from "vuex";
import axios from "axios";

Vue.use(Vuex);

const env = process.env.NODE_ENV || "development";

const baseURL = {
  development: "http://127.0.0.1:8080"
  // production:"-TBD-"
};

const api = axios.create({
  baseURL: baseURL[env]
});

const state = {
  player: null,
  players: []
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
  }
};

const actions = {
  doLogin({ commit, state }, login) {
    return api.post("/player/login", login);
  },
  doRegister({ commit, state }, login) {
    return api.post("/player/register", login);
  },
  async doLogout({ commit, state }) {
    commit("setPlayer", null);
  },
  async listPlayers({ commit, state }) {
    const ret = await api.get("/player/list");
    commit("setPlayers", ret.data);
  },
  goOnline({ commit, state }) {
    let player = state.player;
    player.status.playerStatusId = 2;
    return api.put("/player/save", player);
  }
};

export const store = new Vuex.Store({ state, mutations, actions });
