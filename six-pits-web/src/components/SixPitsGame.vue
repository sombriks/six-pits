<template>
  <V-card v-if="game" :color="color">
    <v-card-title>
      <div class="title">Game #{{game.gameId}}</div>
    </v-card-title>
    <v-card-text>
      <v-container grid-list-lg>
        <v-layout column>
          <six-pits-player :player="game.player1"/>
          <six-pits-player :player="game.player2"/>
        </v-layout>
      </v-container>
    </v-card-text>
  </V-card>
</template>
<script>
export default {
  name: "six-pits-game",
  props: ["game"],
  computed: {
    color() {}
  }
};
</script>

<style>
</style>
