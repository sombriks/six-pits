package six.pits.game.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="game_status")
public class GameStatus {

  @Id
  @Column(name="game_status_id")
  private Integer gameStatusId;

  @Column(name="game_status_description")
  private String gameStatusDescription;

}