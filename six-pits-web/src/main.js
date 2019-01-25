import "./main.css";
import { version } from "../package.json";
import Vue from "vue";
import Vuetify from "vuetify";
import { router } from "./router";
import { store } from "./store";

console.log(`This is six pits version [${version}]`);

Vue.use(Vuetify);

// common alerts
Vue.component("six-pits-alert", require("./components/SixPitsAlert.vue"));
Vue.component("six-pits-confirm", require("./components/SixPitsConfirm.vue"));
Vue.component("six-pits-prompt", require("./components/SixPitsPrompt.vue"));

// lobby components
Vue.component("six-pits-player-chip", require("./components/SixPitsPlayerChip.vue"));
Vue.component("six-pits-player", require("./components/SixPitsPlayer.vue"));
Vue.component("six-pits-game", require("./components/SixPitsGame.vue"));

// game components
Vue.component("six-pits-score", require("./components/SixPitsScore.vue"));
Vue.component("six-pits-board", require("./components/SixPitsBoard.vue"));

new Vue({
  store,
  router,
  el: "#app",
  name: "six-pits",
  render: r => r(require("./App.vue"))
});
