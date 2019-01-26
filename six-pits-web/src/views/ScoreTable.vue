<template>
  <v-container grid-list-xl>
    <v-layout column justify-center align-center>
      <v-flex xs12>
        <div
          v-for="hs in highScores"
          :key="hs.playerId"
        >Player #{{hs.playerId}} Games {{hs.games}} Score {{hs.points}}</div>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
export default {
  name: "score-table",
  data: _ => ({ highScores: [] }),
  async mounted() {
    const ret = await this.$store.dispatch("listHighScores");
    this.highScores = ret.data;
  }
};
</script>

<style>
</style>
