<template>
  <v-layout column>
    <div class="display-1">Players</div>
    <v-container grid-list-xl>
      <v-layout row wrap>
        <v-flex xs6 sm4 md3 v-for="p in $store.state.players" :key="p.playerId">
          <six-pits-player :player="p"/>
        </v-flex>
      </v-layout>
    </v-container>
    <div class="display-1">Games</div>
    <v-container grid-list-xl>
      <v-layout row wrap>
        <v-flex xs6 sm4 md3 v-for="g in $store.state.games" :key="g.gameId">
          <six-pits-game :game="g"/>
        </v-flex>
      </v-layout>
    </v-container>
  </v-layout>
</template>

<script>
export default {
  name: "lobby",
  async mounted() {
    await this.$store.dispatch("goOnline");
    await this.$store.dispatch("listPlayers");
    await this.$store.dispatch("listGames");
  },
  methods: {
  }
};
</script>

<style>
</style>
