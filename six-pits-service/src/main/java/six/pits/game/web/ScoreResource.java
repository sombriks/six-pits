package six.pits.game.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

  @GetMapping("by-player-id/{id}")
  public List<Score> byPlayerId(@PathVariable(name = "id", required = true) Integer id,
      @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
    return scores.listByPlayerId(id, page, pageSize);
  }

  @GetMapping("by-game-id/{id}")
  public List<Score> byGameId(@PathVariable(name = "id", required = true) Integer id,
      @RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer pageSize) {
    return scores.listByGameId(id, page, pageSize);
  }
}