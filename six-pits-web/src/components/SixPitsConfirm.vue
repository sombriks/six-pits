<template>
  <v-dialog v-if="msg" v-model="open" max-width="50%">
    <v-card>
      <v-card-title class="headline">Six Pits</v-card-title>
      <v-card-text>{{msg}}</v-card-text>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn flat @click.native="conf(false)">No</v-btn>
        <v-btn flat @click.native="conf(true)">Yes</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  name: "six-pits-confirm",
  data: _ => ({ open: false, msg: null, cb: null }),
  created() {
    window.confirm = (msg, cb) => {
      this.msg = msg;
      this.open = true;
      this.cb = cb;
    }
  },
  methods: {
    conf(yesno) {
      this.open = false
      if (this.cb) this.cb(yesno);
      this.msg = null
    }
  }
}
</script>

<style>
</style>