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
    return em.createQuery("select s from Score s where s.player.playerId = :playerId", Score.class)//
        .setParameter("playerId", playerId)//
        .setFirstResult((page - 1) * pageSize)//
        .setMaxResults(pageSize)//
        .getResultList();
  }

  public List<Score> listByGameId(int gameId, int page, int pageSize) {
    return em.createQuery("select s from Score s where s.game.gameId = :gameId", Score.class)//
        .setParameter("gameId", gameId)//
        .setFirstResult((page - 1) * pageSize)//
        .setMaxResults(pageSize)//
        .getResultList();
  }

  public List<Score> listByPlayerIdAndGameId(int playerId, int gameId, int page, int pageSize) {

    String q = "select s from Score s where s.player.playerId = :playerId and s.game.gameId = :gameId";

    return em.createQuery(q, Score.class)//
        .setParameter("playerId", playerId)//
        .setParameter("gameId", gameId)//
        .setFirstResult((page - 1) * pageSize)//
        .setMaxResults(pageSize)//
        .getResultList();
  }
}