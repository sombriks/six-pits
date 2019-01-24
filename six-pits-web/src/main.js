import "./main.css";
import { version } from "../package.json";
console.log(`This is six pits version [${version}]`);

import Vue from "vue";
import Vuetify from "vuetify";
Vue.use(Vuetify);

import { router } from "./router";
import { store } from "./store";

new Vue({
  store,
  router,
  el: "#app",
  name: "six-pits",
  render: r => r(require("./App.vue"))
});
