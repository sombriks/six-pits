<template>
  <v-chip v-if="player">
    <v-avatar v-if="isOnline" class="green"></v-avatar>
    <v-avatar v-if="isOffline" class="grey darken-1"></v-avatar>
    <v-avatar v-if="isGaming" class="orange"></v-avatar>
    <span class="subheading">{{player.playerName}}</span>&nbsp;
    <span v-if="isMyself">(you)</span>
  </v-chip>
</template>

<script>
import { ComputedHelper } from "./SixPitsPlayerMixin";
export default {
  name: "six-pits-player-chip",
  mixins: [ComputedHelper],
  
};
</script>

<style>
</style>
