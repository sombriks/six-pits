package six.pits.game.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import six.pits.game.model.HighScore;
import six.pits.game.service.HighScores;

@RestController
@RequestMapping("high-score")
public class HighScoreResource {

  @Autowired
  private HighScores highScores;

  @GetMapping("{id}")
  public HighScore find(@PathVariable(name = "id", required = true) Integer id) {
    return highScores.find(id);
  }

  @GetMapping("list")
  public List<HighScore> list(@RequestParam(defaultValue = "1") Integer page,
      @RequestParam(defaultValue = "10") Integer pageSize) {
    return highScores.list(page, pageSize);
  }

}