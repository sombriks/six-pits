<template>
  <v-dialog v-model="open" max-width="50%">
    <v-card>
      <v-card-title class="headline">Six Pits</v-card-title>
      <v-card-text>
        <v-layout align-center justify-center row>
          <v-flex xs10>
            <v-text-field :label="msg" v-model="val" required></v-text-field>
          </v-flex>
        </v-layout>
      </v-card-text>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn flat @click.native="promp(false)">Não</v-btn>
        <v-btn flat @click.native="promp(true)">Sim</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  name: "six-pits-prompt",
  data: _ => ({ open: false, msg: "", val: "", cb: null }),
  created() {
    window.prompt = (msg, cb, val) => {
      this.cb = cb;
      this.msg = msg;
      this.open = true;
      this.val = val || "";
    };
  },
  methods: {
    promp(val) {
      if (this.cb && val) this.cb(this.val);
      this.open = false;
      this.msg = "";
      this.val = "";
    }
  }
};
</script>

<style>
</style>