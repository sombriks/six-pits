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
export default {
  name: "six-pits-player",
  props: ["player"],
  computed: {
    isOnline() {
      return this.player && this.player.status.playerStatusId == 2;
    },
    isOffline() {
      return this.player && this.player.status.playerStatusId == 1;
    },
    isGaming() {
      return this.player && this.player.status.playerStatusId == 3;
    },
    isMyself() {
      return (
        this.player &&
        this.$store.state.player &&
        this.player.playerId == this.$store.state.player.playerId
      );
    }
  }
};
</script>

<style>
</style>
