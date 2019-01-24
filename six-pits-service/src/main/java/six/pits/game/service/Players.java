package six.pits.game.service;

import java.util.List;

import org.springframework.stereotype.Service;

import six.pits.game.model.Player;

@Service
public class Players extends BaseService<Player, Integer> {

  public Players() {
    super(Player.class);
  }

  public List<Player> listByName(String name, int page, int pageSize) {
    return em.createQuery("select p from Player p where p.playerName like :name", Player.class)//
        .setParameter("name", "%" + name + "%")//
        .setFirstResult((page - 1) * pageSize)//
        .setMaxResults(pageSize)//
        .getResultList();
  }

  public List<Player> listNonOffline(int page, int pageSize) {
    return em.createQuery("select p from Player p where p.status.playerStatusId != 1", Player.class)//
        .setFirstResult((page - 1) * pageSize)//
        .setMaxResults(pageSize)//
        .getResultList();
  }

  public Player login(String playerName, String playerHash) {

    String q = "select p from Player p where p.playerName = :playerName and p.playerHash = :playerHash";

    return em.createQuery(q, Player.class)//
        .setParameter("playerName", playerName)//
        .setParameter("playerHash", playerHash)//
        .getSingleResult();
  }

}