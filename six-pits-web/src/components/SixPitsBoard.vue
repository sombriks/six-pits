<template>
  <v-container v-if="game">
    <v-layout row wrap>
      <v-flex xs2>
        <v-container>
          <!-- big pit 1 -->
          <v-layout row align-center justify-center>
            <v-avatar size="48">
              <img src="assets/rock1.png" alt="rock">
            </v-avatar>
            {{game.gameBigPitPlayer1}}
          </v-layout>
        </v-container>
      </v-flex>
      <v-flex xs8>
        <v-container>
          <v-layout column>
            <v-layout align-center justify-center>
              <h3>Palyer 1 pits</h3>
            </v-layout>
            <v-layout row>
              <v-flex>
                <v-layout row align-center justify-center>
                  <v-avatar size="32" @click="pickRocks(1,1)">
                    <img src="assets/rock1.png" alt="rock">
                  </v-avatar>
                  {{game.gamePit1Player1}}
                </v-layout>
              </v-flex>
              <v-flex>
                <v-layout row align-center justify-center>
                  <v-avatar size="32" @click="pickRocks(2,1)">
                    <img src="assets/rock1.png" alt="rock">
                  </v-avatar>
                  {{game.gamePit2Player1}}
                </v-layout>
              </v-flex>
              <v-flex>
                <v-layout row align-center justify-center>
                  <v-avatar size="32" @click="pickRocks(3,1)">
                    <img src="assets/rock1.png" alt="rock">
                  </v-avatar>
                  {{game.gamePit3Player1}}
                </v-layout>
              </v-flex>
              <v-flex>
                <v-layout row align-center justify-center>
                  <v-avatar size="32" @click="pickRocks(4,1)">
                    <img src="assets/rock1.png" alt="rock">
                  </v-avatar>
                  {{game.gamePit4Player1}}
                </v-layout>
              </v-flex>
              <v-flex>
                <v-layout row align-center justify-center>
                  <v-avatar size="32" @click="pickRocks(5,1)">
                    <img src="assets/rock1.png" alt="rock">
                  </v-avatar>
                  {{game.gamePit5Player1}}
                </v-layout>
              </v-flex>
              <v-flex>
                <v-layout row align-center justify-center>
                  <v-avatar size="32" @click="pickRocks(6,1)">
                    <img src="assets/rock1.png" alt="rock">
                  </v-avatar>
                  {{game.gamePit6Player1}}
                </v-layout>
              </v-flex>
            </v-layout>
            <v-layout align-center justify-center>
              <h3>Palyer 2 pits</h3>
            </v-layout>
            <v-layout row>
              <v-flex>
                <v-layout row align-center justify-center>
                  <v-avatar size="32" @click="pickRocks(1,2)">
                    <img src="assets/rock2.png" alt="rock">
                  </v-avatar>
                  {{game.gamePit1Player2}}
                </v-layout>
              </v-flex>
              <v-flex>
                <v-layout row align-center justify-center>
                  <v-avatar size="32" @click="pickRocks(2,2)">
                    <img src="assets/rock2.png" alt="rock">
                  </v-avatar>
                  {{game.gamePit2Player2}}
                </v-layout>
              </v-flex>
              <v-flex>
                <v-layout row align-center justify-center>
                  <v-avatar size="32" @click="pickRocks(3,2)">
                    <img src="assets/rock2.png" alt="rock">
                  </v-avatar>
                  {{game.gamePit3Player2}}
                </v-layout>
              </v-flex>
              <v-flex>
                <v-layout row align-center justify-center>
                  <v-avatar size="32" @click="pickRocks(4,2)">
                    <img src="assets/rock2.png" alt="rock">
                  </v-avatar>
                  {{game.gamePit4Player2}}
                </v-layout>
              </v-flex>
              <v-flex>
                <v-layout row align-center justify-center>
                  <v-avatar size="32" @click="pickRocks(5,2)">
                    <img src="assets/rock2.png" alt="rock">
                  </v-avatar>
                  {{game.gamePit5Player2}}
                </v-layout>
              </v-flex>
              <v-flex>
                <v-layout row align-center justify-center>
                  <v-avatar size="32" @click="pickRocks(6,2)">
                    <img src="assets/rock2.png" alt="rock">
                  </v-avatar>
                  {{game.gamePit6Player2}}
                </v-layout>
              </v-flex>
            </v-layout>
          </v-layout>
        </v-container>
      </v-flex>
      <v-flex xs2>
        <v-container>
          <!-- big pit 2 -->
          <v-layout row align-center justify-center>
            <v-avatar size="48">
              <img src="assets/rock2.png" alt="rock">
            </v-avatar>
            {{game.gameBigPitPlayer2}}
          </v-layout>
        </v-container>
      </v-flex>
    </v-layout>
    <v-layout column v-if="myTurn && gameNotEnded">
      <!-- game controls -->
      <!-- <v-slider v-model="sow"/> -->
      <input type="range" min="1" max="100" v-model="sow" style="width:100%;">
      <v-layout align-center justify-center>
        <v-btn color="primary" v-if="!ranging" @click="makeItSow">Rocks remaining: {{myStones}}</v-btn>
        <v-btn color="warning" v-if="ranging" @click="stopIt">Throw now!</v-btn>
      </v-layout>
    </v-layout>
    <v-layout align-center justify-center v-if="!myTurn && gameNotEnded">
      <h4>Waiting opponent's move. come back later.</h4>
    </v-layout>
    <v-layout align-center justify-center v-if="gameEnded">
      <h2>This game ended, {{game.status.gameStatusDescription}}</h2>
    </v-layout>
  </v-container>
</template>

<script>
export default {
  name: "six-pits-board",
  props: ["game", "myTurn"],
  data: _ => ({ sow: 0, myStones: 0, ranging: false, interval: null }),
  computed: {
    gameEnded() {
      return this.game && this.game.status.gameStatusId > 2;
    },
    gameNotEnded() {
      return !this.gameEnded;
    }
  },
  methods: {
    whichPlayerIam() {
      if (this.$store.state.player.playerId == this.game.player1.playerId)
        return 1;
      else return 2;
    },
    pickRocks(pit, player) {
      if (!this.myTurn) return alert("Not your turn yet.");
      if (this.whichPlayerIam() != player) return alert("Not your rocks :P");
      if (!this.game[`gamePit${pit}Player${player}`])
        return alert("This pit is empty!");
      if (this.myStones) return alert("You still have stones in your hand!");
      confirm("Take these rocks?", ok => {
        if (!ok) return;
        this.myStones = this.game[`gamePit${pit}Player${player}`];
        this.game[`gamePit${pit}Player${player}`] = 0;
      });
    },
    makeItSow() {
      if (this.myStones) {
        if (!this.ranging) {
          console.log("engage!");
          this.ranging = true;
          this.myStones--;
          this.interval = setInterval(_ => {
            this.sow++;
            if (this.sow > 100) this.sow = 0;
          }, 20);
        }
      } else {
        alert("Pick stones from one of your pits");
      }
    },
    stopIt() {
      const player = this.whichPlayerIam();
      const remaining = this.remainingStones(player);
      clearInterval(this.interval);
      this.ranging = false;
      // miss
      if (this.sow < 20) alert("Miss!");
      // first pit
      else if (this.sow < 30) this.rockInPit(1, player);
      // second pit
      else if (this.sow < 40) this.rockInPit(2, player);
      // third pit
      else if (this.sow < 50) this.rockInPit(3, player);
      // fourth pit
      else if (this.sow < 60) this.rockInPit(4, player);
      // fifth pit
      else if (this.sow < 70) this.rockInPit(5, player);
      // sixth pit
      else if (this.sow < 80) this.rockInPit(6, player);
      // the big pit
      else if (this.sow < 90) {
        this.game[`gameBigPitPlayer${player}`]++;
        this.newScore(1);
        if (this.myStones) {
          alert("You hit your big pit!");
        } else {
          if (remaining) {
            alert("You hit your last stone in the big pit! keep your turn!");
            this.$store.dispatch("updateGame", this.game);
            this.sow = 0;
            return;
          } else this.endGame(player);
        }
      }
      // miss again
      else alert("Miss!");
      this.sow = 0;
      if (!this.myStones) {
        if (remaining) {
          alert("You're out of stones. Your turn ended.");
          this.endTurn();
        } else this.endGame(player);
      }
      this.$store.dispatch("updateGame", this.game);
    },
    newScore(scorePoints) {
      const { playerId } = this.$store.state.player;
      const { gameId } = this.game;
      this.$store.dispatch("saveScore", {
        scorePoints,
        game: { gameId },
        player: { playerId }
      });
      this.$emit("newScore");
    },
    rockInPit(pit, player) {
      const opponent = player == 2 ? 1 : 2;
      if (this.myStones) {
        this.newScore(1);
      } else {
        // must be last rock and pit must be empty
        if (this.game[`gamePit${pit}Player${player}`] == 0) {
          const captured = this.game[`gamePit${pit}Player${opponent}`];
          this.game[`gamePit${pit}Player${opponent}`] = 0;
          this.game[`gamePit${pit}Player${player}`] += captured;
          alert("Your last rock captured " + captured + " rock(s)");
          this.newScore(captured + 1);
        }
      }
      this.game[`gamePit${pit}Player${player}`]++;
    },
    remainingStones(player) {
      let remaining = 0;
      [1, 2, 3, 4, 5, 6].map(pit => {
        remaining += this.game[`gamePit${pit}Player${player}`];
      });
      return remaining;
    },
    endTurn() {
      this.game.gameTurn++;
      this.$emit("endTurn");
    },
    endGame(player) {
      alert("The game is over!");
      const opponent = player == 2 ? 1 : 2;
      let total1 = this.remainingStones(player);
      total1 += this.game[`gameBigPitPlayer${player}`];
      let total2 = this.remainingStones(opponent);
      total2 += this.game[`gameBigPitPlayer${opponent}`];
      if (total1 > total2) {
        alert("you win!!!");
        this.game.status.gameStatusId = player == 1 ? 3 : 4;
      } else if (total1 < total2) {
        this.game.status.gameStatusId = player == 1 ? 4 : 3;
        alert("You Lose.");
      } else {
        alert("It's a draw!");
        this.game.status.gameStatusId = 7;
      }
      this.$store.dispatch("updateGame", this.game);
      this.$router.push("/lobby");
    }
  }
};
</script>

<style>
</style>
