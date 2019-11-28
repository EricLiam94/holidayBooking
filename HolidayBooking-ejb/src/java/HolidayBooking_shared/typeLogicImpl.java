/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HolidayBooking_shared;

import holidaybooking.shared.entity.activity;
import holidaybooking.shared.entity.holidayType;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/**
 *
 * @author 46048
 */
@Stateless
public class typeLogicImpl implements typeLogic {
    @PersistenceContext
    private EntityManager em;
    @Override
    public List<activity> searchingActivity(String type) {
           CriteriaBuilder builder = em.getCriteriaBuilder();
         CriteriaQuery cQuery = builder.createQuery(activity.class);
         Root<activity> e = cQuery.from(activity.class);
         cQuery.select(e);
         Predicate predicate = builder.equal(e.get("type").as(holidayType.class),em.find(holidayType.class,type));
         cQuery.where(predicate);
         TypedQuery tQuery = em.createQuery(cQuery);
         return tQuery.getResultList();
    }

    @Override
    public activity getActivity(int id) {
       return em.find(activity.class, id);
    }

    @Override
    public List<activity> getAllactivites() {
        String q = "select a from activity a";
        return em.createQuery(q,activity.class).getResultList();
    }
}
