<template>
  <v-app>
    <v-navigation-drawer v-if="$store.state.player" app v-model="showDrawer">
      <v-container grid-list-xl>
        <v-layout column>
          <router-link tag="v-btn" to="/lobby">Lobby</router-link>
          <router-link tag="v-btn" to="/score-table">Score Table</router-link>
          <v-btn color="warning" @click="doLogout">Logout</v-btn>
        </v-layout>
      </v-container>
    </v-navigation-drawer>
    <v-toolbar v-if="$store.state.player" app color="primary">
      <v-btn v-if="!showDrawer" @click="showDrawer = !showDrawer">Menu</v-btn>
    </v-toolbar>
    <v-content>
      <v-container fluid>
        <router-view></router-view>
        <six-pits-alert/>
        <six-pits-confirm/>
        <six-pits-prompt/>
      </v-container>
    </v-content>
    <v-footer v-if="$store.state.player" app color="primary">
      <v-layout justify-center align-center row>&copy; sombriks</v-layout>
    </v-footer>
  </v-app>
</template>
<script>
export default {
  name: "app",
  data: _ => ({ showDrawer: false }),
  methods: {
    doLogout() {
      confirm("Are you sure?", ok => {
        if (ok) {
          this.$store
            .dispatch("goOffline")
            .then(_ => this.$store.dispatch("doLogout"))
            .then(_ => this.$router.push("/login"));
        }
      });
    }
  }
};
</script>
