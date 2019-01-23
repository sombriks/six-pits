package six.pits.game.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="player")
public class Player {

  @Id
  @Column(name="player_id")
  private Integer playerId;

  @Column(name="player_creation")
  @Temporal(TemporalType.TIMESTAMP)
  private Date playerCreation;

  @Column(name="player_name")
  private String playerName;

  @Column(name="player_hash")
  private String playerHash;
}