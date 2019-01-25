<template>
  <v-card>
    <v-card-text>
      <six-pits-player-chip :player="player"/>
    </v-card-text>
    <v-card-actions v-if="!isMyself && isOnline">
      <v-btn flat @click="makeChallenge(p)">challenge</v-btn>
    </v-card-actions>
  </v-card>
</template>

<script>
import { ComputedHelper } from "./SixPitsPlayerMixin";
export default {
  name: "six-pits-player",
  mixins: [ComputedHelper],
  methods:{
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
