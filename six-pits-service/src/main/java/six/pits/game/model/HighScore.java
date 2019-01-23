package six.pits.game.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="vw_high_score")
public class HighScore {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="player_id")
  private Integer playerId;
  
  @Column
  private Long games;

  @Column
  private Long points;

}