package org.woehlke.jakartaee.petclinic.oodm.dao.impl;

import lombok.extern.log4j.Log4j2;
import org.woehlke.jakartaee.petclinic.oodm.dao.VisitDao;
import org.woehlke.jakartaee.petclinic.oodm.entities.Visit;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.PostActivate;
import javax.ejb.PrePassivate;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.UUID;

/**
 * Created with IntelliJ IDEA.
 * User: tw
 * Date: 07.01.14
 * Time: 12:43
 * To change this template use File | Settings | File Templates.
 */
@Log4j2
@Stateless
public class VisitDaoImpl implements VisitDao {

  private static final long serialVersionUID = 892248114140040519L;

  @PersistenceContext(unitName = PERSISTENCE_UNIT_NAME)
  private EntityManager entityManager;

  @Override
  public List<Visit> getAll() {
    String qlString = "select p from Visit p order by p.date";
    TypedQuery<Visit> q = entityManager.createQuery(qlString, Visit.class);
    List<Visit> list = q.getResultList();
    return list;
  }

  @Override
  public Visit findById(long id) {
    return entityManager.find(Visit.class, id);
  }

  @Override
  public Visit addNew(Visit visit) {
    visit.setUuid(UUID.randomUUID());
    log.debug("addNewVisit: " + visit.toString());
    entityManager.persist(visit);
    return visit;
  }

  @Override
  public Visit update(Visit visit) {
    return entityManager.merge(visit);
  }

  @Override
  public void delete(long id) {
    Visit visit = entityManager.find(Visit.class, id);
    entityManager.remove(visit);
  }


  @PostConstruct
  public void postConstruct() {
    log.debug("postConstruct");
  }

  @PreDestroy
  public void preDestroy() {
    log.debug("preDestroy");
  }

  @PrePassivate
  public void prePassivate() {
    log.debug("prePassivate");
  }

  @PostActivate
  public void postActivate() {
    log.debug("postActivate");
  }
}
