package six.pits.game.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name = "game")
public class Game {

  public Game() {
  }

  public Game(int playerId1, int playerId2) {
    this.player1 = new Player(playerId1);
    this.player2 = new Player(playerId2);
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "game_id")
  private Integer gameId;

  @Column(name = "game_creation")
  @Temporal(TemporalType.TIMESTAMP)
  private Date gameCreation;

  @OneToOne
  @JoinColumn(name = "game_status_id")
  private GameStatus status;

  @OneToOne
  @JoinColumn(name = "player_id_1")
  private Player player1;

  @OneToOne
  @JoinColumn(name = "player_id_2")
  private Player player2;

  @Column(name = "game_turn")
  private Integer gameTurn;

  @Column(name = "game_pit1_player1")
  private Integer gamePit1Player1;
  @Column(name = "game_pit2_player1")
  private Integer gamePit2Player1;
  @Column(name = "game_pit3_player1")
  private Integer gamePit3Player1;
  @Column(name = "game_pit4_player1")
  private Integer gamePit4Player1;
  @Column(name = "game_pit5_player1")
  private Integer gamePit5Player1;
  @Column(name = "game_pit6_player1")
  private Integer gamePit6Player1;

  @Column(name = "game_pit1_player2")
  private Integer gamePit1Player2;
  @Column(name = "game_pit2_player2")
  private Integer gamePit2Player2;
  @Column(name = "game_pit3_player2")
  private Integer gamePit3Player2;
  @Column(name = "game_pit4_player2")
  private Integer gamePit4Player2;
  @Column(name = "game_pit5_player2")
  private Integer gamePit5Player2;
  @Column(name = "game_pit6_player2")
  private Integer gamePit6Player2;

  @Column(name = "game_big_pit_player1")
  private Integer gameBigPitPlayer1;
  @Column(name = "game_big_pit_player2")
  private Integer gameBigPitPlayer2;

  @PrePersist
  public void preInsert() {

    if (gameCreation == null)
      gameCreation = new Date();

    if (status == null)
      status = new GameStatus(1);

    if (gameTurn == null)
      gameTurn = 1;

    if (gamePit1Player1 == null)
      gamePit1Player1 = 6;
    if (gamePit2Player1 == null)
      gamePit2Player1 = 6;
    if (gamePit3Player1 == null)
      gamePit3Player1 = 6;
    if (gamePit4Player1 == null)
      gamePit4Player1 = 6;
    if (gamePit5Player1 == null)
      gamePit5Player1 = 6;
    if (gamePit6Player1 == null)
      gamePit6Player1 = 6;
    if (gamePit1Player2 == null)
      gamePit1Player2 = 6;
    if (gamePit2Player2 == null)
      gamePit2Player2 = 6;
    if (gamePit3Player2 == null)
      gamePit3Player2 = 6;
    if (gamePit4Player2 == null)
      gamePit4Player2 = 6;
    if (gamePit5Player2 == null)
      gamePit5Player2 = 6;
    if (gamePit6Player2 == null)
      gamePit6Player2 = 6;

    if (gameBigPitPlayer1 == null)
      gameBigPitPlayer1 = 0;

    if (gameBigPitPlayer2 == null)
      gameBigPitPlayer2 = 0;
  }
}