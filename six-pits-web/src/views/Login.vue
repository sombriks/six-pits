<template>
  <v-container grid-list-xl>
    <v-layout column>
      <v-layout justify-center align-center v-if="$store.state.player">
        <v-btn @click="$router.push('/lobby')">Continue as&nbsp;<b>[{{$store.state.player.playerName}}]</b></v-btn>
      </v-layout>
      <form @submit.prevent="doLogin" v-if="!$store.state.player">
        <v-card>
          <v-card-title>
            <v-layout justify-center align-center>
              <h2>Login</h2>
            </v-layout>
          </v-card-title>
          <v-card-text>
            <v-container grid-list-xl>
              <v-layout column>
                <v-text-field label="Player name" v-model="login.playerName" required/>
                <v-text-field label="Password" v-model="password" type="password" required/>
              </v-layout>
            </v-container>
          </v-card-text>
          <v-card-actions>
            <v-container grid-list-xl>
              <v-layout row>
                <v-flex xs6>
                  <v-layout justify-start>
                    <router-link to="/register" tag="v-btn">Register</router-link>
                  </v-layout>
                </v-flex>
                <v-flex xs6>
                  <v-layout justify-end>
                    <v-btn type="submit" color="primary">Login</v-btn>
                  </v-layout>
                </v-flex>
              </v-layout>
            </v-container>
          </v-card-actions>
        </v-card>
      </form>
    </v-layout>
  </v-container>
</template>

<script>
import md5 from "md5";
export default {
  name: "login",
  data: _ => ({ login: { playerName: "", playerHash: "" }, password: "" }),
  methods: {
    doLogin() {
      this.login.playerHash = md5(this.password);
      this.$store
        .dispatch("doLogin", this.login)
        .then(ret => {
          this.$store.commit("setPlayer", ret.data);
          this.$router.push("/lobby");
        })
        .catch(err => {
          console.log(err);
          alert("Invalid username or password");
        });
    }
  }
};
</script>

<style>
</style>
