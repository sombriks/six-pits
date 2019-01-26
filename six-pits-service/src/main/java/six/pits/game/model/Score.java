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
@Table(name = "score")
public class Score {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "score_id")
  private Integer scoreId;

  @Column(name = "score_creation")
  @Temporal(TemporalType.TIMESTAMP)
  private Date scoreCreation;

  @Column(name = "score_points")
  private Integer scorePoints;

  @OneToOne
  @JoinColumn(name = "game_id")
  private Game game;

  @OneToOne
  @JoinColumn(name = "player_id")
  private Player player;

  @PrePersist
  public void preInsert() {
    if (scoreCreation == null)
      scoreCreation = new Date();
    if (scorePoints == null)
      scorePoints = 1;
  }
}