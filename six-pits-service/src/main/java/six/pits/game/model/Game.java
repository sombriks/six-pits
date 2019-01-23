package six.pits.game.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;

@Data
@Entity
@Table(name="game")
public class Game {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="game_id")
  private Integer gameId;

  @Column(name="game_creation")
  @Temporal(TemporalType.TIMESTAMP)
  private Date gameCreation;

  @OneToOne
  @JoinColumn(name="game_status_id")
  private GameStatus status;

  @OneToOne
  @JoinColumn(name="player_id_1")
  private Player player1;
  
  @OneToOne
  @JoinColumn(name="player_id_2")
  private Player player2;
  
}