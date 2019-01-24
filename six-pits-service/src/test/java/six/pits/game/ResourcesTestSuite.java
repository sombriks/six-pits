package six.pits.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
import six.pits.game.model.GameStatus;
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

  @Test
  public void shouldLoginWithBob() {
    String url = BASE_URL + ":" + port + "/player/login";
    Player p = template.postForObject(url, new LoginTO("Bob", "e10adc3949ba59abbe56e057f20f883e"), Player.class);
    assertNotNull(p);
  }

}