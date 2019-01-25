import Vue from "vue";
import VueRouter from "vue-router";

Vue.use(VueRouter);

export const routes = [
  { path: "/", redirect: "/login" },
  { path: "/login", component: require("./views/Login.vue") },
  { path: "/register", component: require("./views/Register.vue") },
  { path: "/lobby", component: require("./views/Lobby.vue") },
  { path: "/score-table", component: require("./views/ScoreTable.vue") },
  { path: "/game/:gameId", component: require("./views/Game.vue") }
];

export const router = new VueRouter({ routes });
