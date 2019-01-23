package six.pits.game.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="score")
public class Score {

  @Id
  @Column(name="score_id")
  private Integer scoreId;

  @Column(name="score_creation")
  private Date scoreCreation;

  @Column(name="score_points")
  private Integer scorePoints;

  @OneToOne
  @JoinColumn(name="game_id")
  private Game game;

  @OneToOne
  @JoinColumn(name="player_id")
  private Player player;
}