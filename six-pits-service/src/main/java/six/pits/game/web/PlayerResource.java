package six.pits.game.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import six.pits.game.model.Player;
import six.pits.game.service.Players;

@RestController
@RequestMapping("player")
public class PlayerResource extends BaseResource<Player, Integer> {

  private Players players;

  public PlayerResource(@Autowired Players players) {
    super(players);
    this.players = players;
  }

  @GetMapping("by-name")
  public List<Player> byName(@RequestParam(required = true) String name,
      @RequestParam(required = false, defaultValue = "false") Boolean nonOffline,
      @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
    return players.listByName(name, page, pageSize);
  }

  @GetMapping("non-offline")
  public List<Player> nonOffline(@RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "10") Integer pageSize) {
    return players.listNonOffline(page, pageSize);
  }

}