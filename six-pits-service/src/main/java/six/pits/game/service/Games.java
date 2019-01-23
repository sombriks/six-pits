package six.pits.game.service;

import java.util.List;

import org.springframework.stereotype.Service;

import six.pits.game.model.Game;

@Service
public class Games extends BaseService<Game, Integer> {

  public Games(){
    super(Game.class);
  }

  public List<Game> listGamesByPlayerName(String name, int page, int pageSize) {

    String q = "select g from Game g where g.player1.playerName like :name or g.player2.playerName like :name";

    return em.createQuery(q, Game.class)//
        .setParameter("name", "%" + name + "%")//
        .setFirstResult((page - 1) * pageSize)//
        .setMaxResults(pageSize)//
        .getResultList();

  }

}