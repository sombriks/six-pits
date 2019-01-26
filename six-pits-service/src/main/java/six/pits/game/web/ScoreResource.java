package six.pits.game.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import six.pits.game.model.Score;
import six.pits.game.service.Scores;

@RestController
@RequestMapping("score")
public class ScoreResource extends BaseResource<Score, Integer> {

  private Scores scores;

  public ScoreResource(@Autowired Scores scores) {
    super(scores);
    this.scores = scores;
  }

  @GetMapping("by-player-id")
  public List<Score> byPlayerId(@RequestParam(name = "playerId", required = true) Integer playerId,
      @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
    return scores.listByPlayerId(playerId, page, pageSize);
  }

  @GetMapping("by-game-id")
  public List<Score> byGameId(@RequestParam(name = "gameId", required = true) Integer gameId,
      @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
    return scores.listByGameId(gameId, page, pageSize);
  }

  @GetMapping("by-player-and-game")
  public List<Score> byPlayerAndGame(@RequestParam(name = "playerId", required = true) Integer playerId,
      @RequestParam(name = "gameId", required = true) Integer gameId, @RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "10") Integer pageSize) {
    return scores.listByPlayerIdAndGameId(playerId, gameId, page, pageSize);
  }
}