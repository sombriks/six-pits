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
@Table(name="player")
public class Player {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name="player_id")
  private Integer playerId;

  @Column(name="player_creation")
  @Temporal(TemporalType.TIMESTAMP)
  private Date playerCreation;

  @Column(name="player_name")
  private String playerName;

  @Column(name="player_hash")
  private String playerHash;

  @OneToOne
  @JoinColumn(name="player_status_id")
  private PlayerStatus status;
}