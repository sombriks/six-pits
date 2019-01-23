package six.pits.game;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import six.pits.game.service.Games;

@SpringBootTest
@RunWith(SpringRunner.class)
@TestPropertySource(locations = "classpath:application-test.properties")
public class GameApplicationTests {

	@Autowired
	private Games games;

	@Test
	public void contextLoads() {
	}

	@Test
	public void shouldListGames() {
		int len = games.listGames(1, 100).size();
		assertEquals(7, len);
	}

	@Test
	public void shouldListAliceGames() {
		int len = games.listGames("Alice", 1, 100).size();
		assertEquals(2, len);
	}

}
