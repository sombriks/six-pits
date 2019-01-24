<template>
  <v-app>
    <v-navigation-drawer app v-model="show">
      <v-layout column>
        
      </v-layout>
    </v-navigation-drawer>
    <v-toolbar app color="primary">
      <v-btn @click="show = !show">Menu</v-btn>
    </v-toolbar>
    <v-content>
      <v-container fluid>
        <router-view></router-view>
      </v-container>
    </v-content>
    <v-footer app color="primary">
      <v-layout justify-center align-center row>&copy; sombriks</v-layout>
    </v-footer>
  </v-app>
</template>
<script>
export default {
  name: "app",
  data: _ => ({ show: false })
};
</script>
