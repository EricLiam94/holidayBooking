/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HolidayBooking_shared;

import holidaybooking.shared.entity.activity;
import holidaybooking.shared.entity.holiday;
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
public class holidayOperationImpl implements holidayOperation{
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public holiday searchHoliday(int id) {
      return  em.find(holiday.class, id);
    }

    @Override
    public List<holiday> searchHolidayType(String Type) {
                 CriteriaBuilder builder = em.getCriteriaBuilder();
         CriteriaQuery cQuery = builder.createQuery(holiday.class);
         Root<holiday> e = cQuery.from(holiday.class);
         cQuery.select(e);
         Predicate predicate = builder.equal(e.get("type").as(String.class),Type);
         cQuery.where(predicate);
         TypedQuery tQuery = em.createQuery(cQuery);
         return tQuery.getResultList();
    }

    @Override
    public void addHoliday(int id, String name, String type) {
        holiday h = new holiday(id,name,type);
        em.persist(h);
        
    }

    @Override
    public void deleteHoliday(int id) {
       em.detach(id);
    }
    
    @Override
    public List<String> typeList()
    {
        String q = "Select distinct u.type from holiday u";
       return em.createQuery(q,String.class).getResultList();
    }

    @Override
    public List<holiday> searching(String id, String type, String name) {
        String q ="select h from holiday h ";
       if(id.trim().length()!=0||name.trim().length()!=0||type.trim().length()!=0)
       {
           q=q+" where ";
       if(type.trim().length()!=0){
           q=q+ "h.type= "+"'"+type+"'";}
       if(name.trim().length()!=0){
            if(q.endsWith("'"))
                 q=q+ " and ";
            q=q+" h.name = "+"'"+name+"'"; }
       if(id.trim().length()!=0){
            if(q.endsWith("'"))
                q=q+ " and ";
            q=q + "h.id="+Integer.parseInt(id);}
       }
       return em.createQuery(q,holiday.class).getResultList();     
               }

    @Override
    public void updateHoliday(holiday h) {
       em.merge(h);
    }

    @Override
    public String getDesc(int id) {
          String q = "select h.Description from holiday h where h.id ="+id;
          return (String) em.createQuery(q).getResultList().get(0);
  }

   
}
