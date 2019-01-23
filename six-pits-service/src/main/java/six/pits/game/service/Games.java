package six.pits.game.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Service;

import six.pits.game.model.Game;

@Service
public class Games {

  @PersistenceContext
  private EntityManager em;

  public List<Game> listGames(int page, int pageSize) {
    return listGames(null, page, pageSize);
  }

  public List<Game> listGames(String name, int page, int pageSize) {
    TypedQuery<Game> q = null;
    if (name != null) {
      q = em.createQuery(
          "select g from Game g where g.player1.playerName like :name or g.player2.playerName like :name", Game.class);
      q.setParameter("name", "%" + name + "%");
    } else
      q = em.createQuery("select g from Game g", Game.class);
    return q.setFirstResult((page - 1) * pageSize).setMaxResults(pageSize).getResultList();
  }
}