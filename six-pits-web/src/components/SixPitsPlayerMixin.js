export const ComputedHelper = {
  props: ["player"],
  computed: {
    isOnline() {
      return this.player && this.player.status.playerStatusId == 2;
    },
    isOffline() {
      return this.player && this.player.status.playerStatusId == 1;
    },
    isGaming() {
      return this.player && this.player.status.playerStatusId == 3;
    },
    isMyself() {
      return this.player && this.$store.state.player && this.player.playerId == this.$store.state.player.playerId;
    },
  },
};
