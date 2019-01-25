<template>
  <v-card>
    <v-card-text>
      <v-chip v-if="player">
        <v-avatar v-if="isOnline" class="green"></v-avatar>
        <v-avatar v-if="isOffline" class="grey darken-1"></v-avatar>
        <v-avatar v-if="isGaming" class="orange"></v-avatar>
        <span class="subheading">{{player.playerName}}</span>
      </v-chip>
      <span v-if="isMyself">(you)</span>
    </v-card-text>
    <v-card-actions v-if="!isMyself && isOnline">
      <v-btn flat @click="makeChallenge">challenge</v-btn>
    </v-card-actions>
  </v-card>
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
  },
  methods: {
    makeChallenge() {
      const game = { player1: {}, player2: {} };
      game.player1.playerId = this.$store.state.player.playerId;
      game.player2.playerId = this.player.playerId;
      this.$store.dispatch("newGame", game).then(ret => {
        alert("challenge created!");
        this.$store.dispatch("listGames");
      });
    }
  }
};
</script>

<style>
</style>
