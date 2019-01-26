<template>
  <v-layout column justify-center align-center>
    <div v-if="!scores || scores.length==0">-</div>
    <div v-for="s in scores" :key="s.scoreId">{{s.scorePoints}}</div>
  </v-layout>
</template>

<script>
export default {
  name: "six-pits-score",
  props: ["scores"]
};
</script>

<style>
</style>
