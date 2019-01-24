import "./main.css";
import { version } from "../package.json";
import Vue from "vue";
import Vuetify from "vuetify";
import { router } from "./router";
import { store } from "./store";

console.log(`This is six pits version [${version}]`);

Vue.use(Vuetify);

Vue.component("six-pits-alert", require("./components/SixPitsAlert.vue"));
Vue.component("six-pits-confirm", require("./components/SixPitsConfirm.vue"));
Vue.component("six-pits-prompt", require("./components/SixPitsPrompt.vue"));

new Vue({
  store,
  router,
  el: "#app",
  name: "six-pits",
  render: r => r(require("./App.vue"))
});
