<template>
  <v-container grid-list-xl>
    <v-layout row wrap>
      <v-flex xs6 sm4 md3 lg2 v-for="p in $store.state.players" :key="p.playerId">
        <v-card>
          <v-card-text>
            <v-chip>
              <v-avatar v-if="p.status.playerStatusId==2" class="green"> </v-avatar>
              <v-avatar v-if="p.status.playerStatusId==1" class="gray"> </v-avatar>
              {{p.playerName}}
            </v-chip>
          </v-card-text>
        </v-card>
      </v-flex>
    </v-layout>
  </v-container>
</template>

<script>
export default {
  name: "lobby",
  async mounted() {
    await this.$store.dispatch("goOnline");
    await this.$store.dispatch("listPlayers");
  }
};
</script>

<style>
</style>
