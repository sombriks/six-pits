package six.pits.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import six.pits.game.model.Game;
import six.pits.game.model.HighScore;
import six.pits.game.model.Player;
import six.pits.game.web.LoginTO;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestPropertySource(locations = "classpath:application-test.properties")
public class ResourcesTestSuite {

  @LocalServerPort
  private int port;

  @Autowired
  private TestRestTemplate template;

  private final String BASE_URL = "http://127.0.0.1";

  private String url(String uri) {
    return BASE_URL + ":" + port + uri;

  }

  @Test
  public void shouldLoginWithBob() {
    LoginTO payload = new LoginTO("Bob", "e10adc3949ba59abbe56e057f20f883e");
    Player result = template.postForObject(url("/player/login"), payload, Player.class);
    assertNotNull(result);
  }

  @Test
  public void shouldRegisterDavid() {
    LoginTO payload = new LoginTO("David", "e10adc3949ba59abbe56e057f20f883e");
    Player result = template.postForObject(url("/player/register"), payload, Player.class);
    assertNotNull(result);
  }

  @Test
  public void shouldListNonOfflinePlayers() {
    List<?> result = template.getForObject(url("/player/non-offline"), List.class);
    assertEquals(4, result.size());
  }

  @Test
  public void shouldListPlayersByName() {
    List<?> result = template.getForObject(url("/player/by-name?name={name}"), List.class, "B");
    assertEquals(2, result.size());
  }

  @Test
  public void shouldListScores() {
    List<?> result = template.getForObject(url("/score/list"), List.class);
    assertEquals(10, result.size());
  }

  @Test
  public void shouldGetGame7() {
    Game result = template.getForObject(url("/game/{id}"), Game.class, "1");
    assertNotNull(result);
  }

  @Test
  public void shouldDeleteScore14() {
    template.delete("/score/14");
  }

  @Test
  public void shouldSaveNewGame() {
    Game payload = new Game(3, 4);
    Game result = template.postForObject(url("/game/save"), payload, Game.class);
    assertNotNull(result.getGameId());
  }

  @Test
  public void shouldRenameJoe() {
    Player p = template.getForObject(url("/player/1"), Player.class);
    p.setPlayerName("Joey");
    template.put(url("/player/save"), p);
    p = template.getForObject(url("/player/1"), Player.class);
    assertEquals("Joey", p.getPlayerName());
  }

  @Test
  public void shouldFindMaryGames() {
    List<?> result = template.getForObject(url("/game/by-player-name?name=Mary"), List.class);
    assertEquals(6, result.size());
  }

  @Test
  public void shouldListScoresByGame() {
    List<?> result = template.getForObject(url("/score/by-game-id?gameId=1"), List.class);
    assertEquals(3, result.size());
  }

  @Test
  public void shouldListJoeScores() {
    List<?> result = template.getForObject(url("/score/by-player-id?playerId=1"), List.class);
    assertEquals(1, result.size());
  }

  @Test
  public void shouldListJoeScoresOnGame1() {
    List<?> result = template.getForObject(url("/score/by-player-and-game?playerId=1&gameId=1"), List.class);
    assertEquals(1, result.size());
  }

  @Test
  public void shouldFindHighScore() {
    HighScore result = template.getForObject(url("/high-score/1"), HighScore.class);
    assertNotNull(result);
  }

  @Test
  public void shouldListHighScores() {
    List<?> result = template.getForObject(url("/high-score/list"), List.class);
    assertEquals(6, result.size());

  }
}