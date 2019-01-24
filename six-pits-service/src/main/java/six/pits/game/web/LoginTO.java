package six.pits.game.web;

import lombok.Data;
import six.pits.game.model.Player;

@Data
public class LoginTO {

  private String playerName;
  private String playerHash;

  public Player toPlayer() {
    Player p = new Player();
    p.setPlayerName(playerName);
    p.setPlayerHash(playerHash);
    return p;
  }

  public LoginTO(String playerName, String playerHash) {
    this.playerName = playerName;
    this.playerHash = playerHash;
  }

  public LoginTO() {
  }

}