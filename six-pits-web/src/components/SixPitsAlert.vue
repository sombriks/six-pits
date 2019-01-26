<template>
  <v-dialog v-if="msg.length" v-model="open" max-width="50%">
    <v-card>
      <v-card-title class="headline">Six Pits</v-card-title>
      <v-card-text>
        <p v-for="m in msg" :key="m">{{m}}</p>
      </v-card-text>
      <v-card-actions>
        <v-spacer></v-spacer>
        <v-btn @click.native="close" color="primary">OK</v-btn>
      </v-card-actions>
    </v-card>
  </v-dialog>
</template>

<script>
export default {
  name: "six-pits-alert",
  data: _ => ({ open: false, msg: [] }),
  created() {
    window.alert = msg => {
      this.msg.push(msg);
      this.open = true;
    };
  },
  methods: {
    close() {
      this.msg = [];
      open = false;
    }
  }
};
</script>