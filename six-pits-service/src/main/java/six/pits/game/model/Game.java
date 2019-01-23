package six.pits.game.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="game")
public class Game {

  @Id
  @Column(name="game_id")
  private Integer gameId;

  @Column(name="game_creation")
  @Temporal(TemporalType.TIMESTAMP)
  private Date gameCreation;

  public Integer getGameId() {
    return gameId;
  }

  public void setGameId(Integer gameId) {
    this.gameId = gameId;
  }

  public Date getGameCreation() {
    return gameCreation;
  }

  public void setGameCreation(Date gameCreation) {
    this.gameCreation = gameCreation;
  }

}