package six.pits.game;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import six.pits.game.model.Game;
import six.pits.game.model.HighScore;
import six.pits.game.model.Player;
import six.pits.game.service.Games;
import six.pits.game.service.HighScores;
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
	@Autowired
	private HighScores highScores;

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
		int len = games.listByPlayerName("Alice", 1, 100).size();
		assertEquals(2, len);
	}

	@Test
	public void shouldListPlayers() {
		int len = players.list(1, 6).size();
		assertEquals(6, len);
	}

	@Test
	public void shouldListBobAndBetty() {
		int len = players.listByName("B", 1, 100).size();
		assertEquals(2, len);
	}

	@Test
	public void shouldListNonOfflinePlayers() {
		int len = players.listNonOffline(1, 4).size();
		assertEquals(4, len);
	}

	@Test
	public void shouldListScores() {
		int len = scores.list(1, 100).size();
		assertEquals(17, len);
	}

	@Test
	public void shouldListAliceScores() {
		Player p = players.listByName("Alice", 1, 1).get(0);
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

	@Test
	public void shouldRenameBob() {
		Player p = players.find(4);
		p.setPlayerName("Bobby");
		players.update(p);
		p = players.find(4);
		assertEquals("Bobby", p.getPlayerName());
	}

	@Test
	public void shouldDeleteJoeAndMaryGame() {
		Game g = new Game();
		Player p1 = new Player();
		p1.setPlayerId(1);// Joe
		g.setPlayer1(p1);
		Player p2 = new Player();
		p2.setPlayerId(2);// Mary
		g.setPlayer2(p2);
		games.insert(g);
		// now let's destroy it
		int gameId = g.getGameId();
		games.del(gameId);
		g = games.find(gameId);
		assertNull(g);
	}

	@Test
	public void shouldGetMaryScore() {
		HighScore h = highScores.find(2);
		Long expected = 10l;
		assertEquals(expected, h.getPoints());
	}

	@Test
	public void shouldListPlayersPontuations() {
		int len = highScores.list(1, 6).size();
		assertEquals(6, len);
	}
}
