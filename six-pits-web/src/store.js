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
  player: null
};

const mutations = {
  setPlayer(state, player) {
    state.player = player;
  }
};

const actions = {
  doLogin({ commit, state }, login) {
    return api.post("/player/login", login);
  },
  doRegister({ commit, state }, login) {
    return api.post("/player/register", login);
  },
};

export const store = new Vuex.Store({ state, mutations, actions });
