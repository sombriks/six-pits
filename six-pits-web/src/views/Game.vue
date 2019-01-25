<template>
  <v-container grid-list-xl>
    <v-layout column v-if="game">
      <h1>The Six Pits Game #{{game.gameId}}</h1>
      <h3>
        <b>{{game.player1.playerName}}</b> versus
        <b>{{game.player2.playerName}}</b>
      </h3>
      <div>
        It's
        <i>{{who}}</i> turn
      </div>
      <v-container grid-list-xl>
        <v-layout row>
          <v-flex xs2>
            <six-pits-score :scores="p1Score"/>
          </v-flex>
          <v-flex xs8>
            <six-pits-board :game="game"/>
          </v-flex>
          <v-flex xs2>
            <six-pits-score :scores="p2Score"/>
          </v-flex>
        </v-layout>
      </v-container>
    </v-layout>
  </v-container>
</template>

<script>
export default {
  name: "game",
  data: _ => ({ game: null, p1Scores: [], p2Scores: [] }),
  async mounted() {
    const { gameId } = this.$route.params;
    const ret = await this.$store.dispatch("getGame", gameId);
    this.game = ret.data;
    this.p1Scores = await this.getScores(this.game.player1.playerId, gameId);
    this.p2Scores = await this.getScores(this.game.player2.playerId, gameId);
  },
  methods: {
    async getScores(playerId, gameId) {
      const ret = await this.$store.dispatch("getScores", { playerId, gameId });
      return ret.data;
    }
  },
  computed: {
    isPlayer1Turn() {
      return this.game.gameTurn % 2 == 1;
    },
    amIPlayer1() {
      return this.$store.state.player.playerId == this.game.player1.playerId;
    },
    who() {
      if (this.game) {
        if (this.isPlayer1Turn && this.amIPlayer1) return "your";
        else if (this.isPlayer1Turn && !this.amIPlayer1)
          return this.game.player1.playerName;
        else if (!this.isPlayer1Turn && this.amIPlayer1)
          return this.game.player2.playerName;
        else return "your";
      }
    }
  }
};
</script>

<style>
</style>
