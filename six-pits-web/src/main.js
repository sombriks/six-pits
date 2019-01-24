import "./main.css";
import { version } from "../package.json";
import Vue from "vue";
import Vuetify from "vuetify";
import { router } from "./router";
import { store } from "./store";

console.log(`This is six pits version [${version}]`);

Vue.use(Vuetify);

new Vue({
  store,
  router,
  el: "#app",
  name: "six-pits",
  render: r => r(require("./App.vue"))
});
