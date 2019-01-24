package six.pits.game.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import six.pits.game.model.HighScore;

@Service
public class HighScores {

  @PersistenceContext
  private EntityManager em;

  // Since HighScore is a view, we don't need complete CRUD operations.
  public HighScore find(int playerId) {
    return em.find(HighScore.class, playerId);
  }

  public List<HighScore> list(int page, int pageSize) {
    return em.createQuery("select h from HighScore h", HighScore.class)//
        .setFirstResult((page - 1) * pageSize)//
        .setMaxResults(pageSize)//
        .getResultList();
  }

}