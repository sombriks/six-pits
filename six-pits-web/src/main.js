import "./main.css";
import { version } from "../package.json";
console.log(`This is six pits version [${version}]`);

import Vue from "vue";

new Vue({
  el: "#app",
  name: "six-pits",
  render: r => r(require("./App.vue"))
});
