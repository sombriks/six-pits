package six.pits.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import six.pits.game.model.Game;
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
		int len = players.list(1, 6).size();
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
		Game g = games.find(3);
		int len = scores.listByGameId(g.getGameId(), 1, 100).size();
		assertEquals(3, len);
	}

	@Test
	public void shouldSaveNewPlayer() throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("MD5");

		Player p = new Player();
		p.setPlayerName("Max");
		p.setPlayerHash(new String(md.digest("123456".getBytes())));
		
		players.insert(p);

		assertNotNull(p.getPlayerId());
	}
}
