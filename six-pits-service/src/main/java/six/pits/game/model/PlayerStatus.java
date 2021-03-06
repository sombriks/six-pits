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
@Table(name = "player_status")
public class PlayerStatus {

  public PlayerStatus(int playerStatusId) {
    this.playerStatusId = playerStatusId;
  }

  public PlayerStatus() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "player_status_id")
  private Integer playerStatusId;

  @Column(name = "player_status_description")
  private String playerStatusDescription;

}