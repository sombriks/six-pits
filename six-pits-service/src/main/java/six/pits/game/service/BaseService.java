package six.pits.game.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

public abstract class BaseService<T, I extends Serializable> {

  @PersistenceContext
  protected EntityManager em;

  private Class<T> entityClass;

  public BaseService(Class<T> entityClass) {
    this.entityClass = entityClass;
  }

  public List<T> list(int page, int pageSize) {
    CriteriaQuery<T> query = em.getCriteriaBuilder().createQuery(entityClass);
    Root<T> root = query.from(entityClass);
    query.select(root);
    return em.createQuery(query)//
        .setFirstResult((page - 1) * pageSize)//
        .setMaxResults(pageSize)//
        .getResultList();
  }

  public T find(I id) {
    return em.find(entityClass, id);
  }

  @Transactional
  public T insert(T entity) {
    em.persist(entity);
    em.flush();
    return entity;
  }

  @Transactional
  public T update(T entity) {
    em.merge(entity);
    em.flush();
    return entity;
  }

  @Transactional
  public void del(I id) {
    T entity = find(id);
    em.remove(entity);
    em.flush();
  }

}