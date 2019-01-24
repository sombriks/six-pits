package six.pits.game.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import six.pits.game.model.Game;
import six.pits.game.service.Games;

@RestController
@RequestMapping("game")
public class GameResource extends BaseResource<Game, Integer> {

  private Games games;

  public GameResource(@Autowired Games games) {
    super(games);
    this.games = games;
  }

  @GetMapping("by-player-name")
  public List<Game> byPlayerName(@RequestParam(required = true) String name,
      @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
    return games.listByPlayerName(name, page, pageSize);
  }
}