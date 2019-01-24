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
@Table(name = "game_status")
public class GameStatus {

  public GameStatus(int gameStatusId) {
    this.gameStatusId = gameStatusId;
  }

  public GameStatus() {
  }

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "game_status_id")
  private Integer gameStatusId;

  @Column(name = "game_status_description")
  private String gameStatusDescription;

}