<template>
  <v-container grid-list-xl>
    <v-layout column v-if="game">
      <h1>The Six Pits Game #{{game.gameId}}</h1>
      <h3>
        <b>{{game.player1.playerName}}</b> versus
        <b>{{game.player2.playerName}}</b>
      </h3>
      <div>It's <i>{{who}}</i> turn</div>
    </v-layout>
  </v-container>
</template>

<script>
export default {
  name: "game",
  data: _ => ({ game: null }),
  async mounted() {
    const { gameId } = this.$route.params;
    const ret = await this.$store.dispatch("getGame", gameId);
    this.game = ret.data;
  },
  computed: {
    isPlayer1Turn(){
      return this.game.gameTurn % 2 == 1;
    },
    who() {
      if (this.game) {
        const amIPlayer1 =
          this.$store.state.player.playerId == this.game.player1.playerId;
        if (this.isPlayer1Turn && amIPlayer1) return "your";
        else if (this.isPlayer1Turn && !amIPlayer1)
          return this.game.player1.playerName;
        else if (!this.isPlayer1Turn && amIPlayer1)
          return this.game.player2.playerName;
        else return "your";
      }
    }
  }
};
</script>

<style>
</style>
