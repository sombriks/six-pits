package six.pits.game.service;

import java.util.List;

import org.springframework.stereotype.Service;

import six.pits.game.model.Score;

@Service
public class Scores extends BaseService<Score, Integer> {

  public Scores() {
    super(Score.class);
  }

  public List<Score> listByPlayerId(int playerId, int page, int pageSize) {
    return em.createQuery("select s from Score s where s.playerId = :playerId", Score.class)//
        .setParameter("playerId", playerId)//
        .setFirstResult((page - 1) * pageSize)//
        .setMaxResults(pageSize)//
        .getResultList();
  }
}