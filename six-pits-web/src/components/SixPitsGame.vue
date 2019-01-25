<template>
  <V-card v-if="game" :color="color">
    <v-card-title>
      <div class="title">Game #{{game.gameId}}</div>
    </v-card-title>
    <v-card-text>
      <v-container grid-list-lg>
        <v-layout column>
          <six-pits-player-chip :player="game.player1"/>
          <six-pits-player-chip :player="game.player2"/>
        </v-layout>
      </v-container>
    </v-card-text>
    <v-card-actions>
      <v-container grid-list-md>
        <v-layout row justify-end align-center wrap>
          <v-btn
            v-if="game.status.gameStatusId==2 && myGame"
            color="indigo"
            flat
            @click="continueGame"
          >Continue</v-btn>
          <v-btn
            v-if="game.status.gameStatusId==1 && myGame"
            color="warning"
            flat
            @click="refuseGame"
          >Refuse</v-btn>
          <v-btn
            v-if="game.status.gameStatusId==1 && myGame"
            color="primary"
            flat
            @click="acceptGame"
          >Accept</v-btn>
        </v-layout>
      </v-container>
    </v-card-actions>
  </V-card>
</template>
<script>
export default {
  name: "six-pits-game",
  props: ["game"],
  computed: {
    color() {
      if (this.game) {
        switch (this.game.status.gameStatusId) {
          case 1:
            return "green lighten-3"; // challenge made
          case 2:
            return "orange lighten-3 "; // running
          default:
            return "grey"; // everythig else
        }
      }
    },
    myGame() {
      return (
        this.game &&
        (this.game.player1.playerId == this.$store.state.player.playerId ||
          this.game.player2.playerId == this.$store.state.player.playerId)
      );
    }
  },
  methods: {
    acceptGame() {
      confirm("Proceed?", async ok => {
        if (ok) {
          await this.$store.dispatch("acceptGame", this.game);
          this.$router.push(`/game/${this.game.gameId}`);
        }
      });
    },
    refuseGame() {
      confirm("Are you sure?", async ok => {
        if (ok) {
          await this.$store.dispatch("refuseGame", this.game);
          await this.$store.dispatch("listPlayers");
          await this.$store.dispatch("listGames");
        }
      });
    },
    continueGame() {
      this.$router.push(`/game/${this.game.gameId}`);
    }
  }
};
</script>

<style>
</style>
