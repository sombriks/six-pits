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
    <v-layout column v-if="myTurn">
      <!-- game controls -->
      <!-- <v-slider v-model="sow"/> -->
      <input type="range" min="1" max="100" v-model="sow" style="width:100%;">
      <v-layout align-center justify-center>
        <v-btn color="primary" v-if="!ranging" @click="makeItSow">Rocks remaining: {{myStones}}</v-btn>
        <v-btn color="warning" v-if="ranging" @click="stopIt">Stop!</v-btn>
      </v-layout>
    </v-layout>
    <v-layout align-center justify-center v-if="!myTurn">
      <h4>Waiting opponent's move</h4>
    </v-layout>
  </v-container>
</template>

<script>
export default {
  name: "six-pits-board",
  props: ["game", "myTurn"],
  data: _ => ({ sow: 0, myStones: 0, ranging: false, interval: null }),
  methods: {
    whichPlayerIam() {
      if (this.$store.state.player.playerId == this.game.player1.playerId)
        return 1;
      else return 2;
    },
    pickRocks(pit, player) {
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
      const opponent = player == 2 ? 1 : 2;
      this.ranging = false;
      clearInterval(this.interval);
      // miss
      if (this.sow < 20) alert("Miss!");
      // first pit
      else if (this.sow < 30) {
        this.rockInPit(1);
      }
      // second pit
      else if (this.sow < 40) {
        if (this.myStones) {
          this.game[`gamePit2Player${player}`]++;
          this.newScore(1);
        }
      }
      // third pit
      else if (this.sow < 50) {
        if (this.myStones) {
          this.game[`gamePit3Player${player}`]++;
          this.newScore(1);
        }
      }
      // fourth pit
      else if (this.sow < 60) {
        if (this.myStones) {
          this.game[`gamePit4Player${player}`]++;
          this.newScore(1);
        }
      }
      // fifth pit
      else if (this.sow < 70) {
        if (this.myStones) {
          this.game[`gamePit5Player${player}`]++;
          this.newScore(1);
        }
      }
      // sixth pit
      else if (this.sow < 80) {
        if (this.myStones) {
          this.game[`gamePit6Player${player}`]++;
          this.newScore(1);
        }
      }
      // the big pit
      else if (this.sow < 90) {
        this.game[`gameBigPitPlayer${player}`]++;
        if (this.myStones) {
          alert("You hit your big pit!");
        } else {
          alert("You hit your last stone in the big pit! keep your turn!");
          this.sow = 0;
          return;
        }
        this.newScore(1);
      }
      // miss again
      else alert("Miss!");
      this.sow = 0;
      if (!this.myStones) {
        alert("You're out of stones. Your turn ended.");
        this.endTurn();
      }
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
    rockInPit(pit) {
      if (this.myStones) {
        this.newScore(1);
      } else {
        // must be last rock and pit must be empty
        if (this.game[`gamePit${pit}Player${player}`] == 0) {
          const captured = this.game[`gamePit${pit}Player${opponent}`];
          this.game[`gamePit${pit}Player${opponent}`] = 0;
          this.game[`gamePit${pit}Player${player}`] += captured;
          alert("Your last rock captured " + captured + " rocks");
          this.newScore(captured);
        }
      }
      this.game[`gamePit${pit}Player${player}`]++;
    },
    endTurn() {
      this.game.gameTurn++;
      this.$store.dispatch("updateGame", this.game);
      this.$emit("endTurn");
    }
  }
};
</script>

<style>
</style>
