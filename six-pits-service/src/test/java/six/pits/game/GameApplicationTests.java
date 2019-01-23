package six.pits.game;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import six.pits.game.model.Player;
import six.pits.game.service.Games;
import six.pits.game.service.Players;
import six.pits.game.service.Scores;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class GameApplicationTests {

	@Autowired
	private Games games;
	@Autowired
	private Players players;
	@Autowired
	private Scores scores;

	@Test
	public void contextLoads() {
		// proves that spring boot is up and running
	}

	@Test
	public void shouldListGames() {
		int len = games.list(1, 100).size();
		assertEquals(7, len);
	}

	@Test
	public void shouldListAliceGames() {
		int len = games.listGamesByPlayerName("Alice", 1, 100).size();
		assertEquals(2, len);
	}

	@Test
	public void shouldListPlayers() {
		int len = players.list(1, 100).size();
		assertEquals(6, len);
	}

	@Test
	public void shouldListBobAndBetty() {
		int len = players.listPlayersByName("B", 1, 100).size();
		assertEquals(2, len);
	}

	@Test
	public void shouldListScores() {
		int len = scores.list(1, 100).size();
		assertEquals(17, len);
	}

	@Test
	public void shouldListAliceScores() {
		Player p = players.listPlayersByName("Alice", 1, 1).get(0);
		int len = scores.listByPlayerId(p.getPlayerId(), 1, 100).size(); 
		assertEquals(2, len);
	}

	@Test
	public void shouldListScoresByGameId() {
	}

}
