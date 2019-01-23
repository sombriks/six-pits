package six.pits.game.service;

import java.util.List;

import org.springframework.stereotype.Service;

import six.pits.game.model.Player;

@Service
public class Players extends BaseService<Player, Integer> {

  public Players() {
    super(Player.class);
  }

  public List<Player> listPlayersByName(String name, int page, int pageSize) {
    return em.createQuery("select p from Player p where p.playerName like :name", Player.class)//
        .setParameter("name", "%" + name + "%")//
        .setFirstResult((page - 1) * pageSize)//
        .setMaxResults(pageSize)//
        .getResultList();
  }

}