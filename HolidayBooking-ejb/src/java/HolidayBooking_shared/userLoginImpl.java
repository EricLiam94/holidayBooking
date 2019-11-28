package HolidayBooking_shared;



import holidaybooking.shared.entity.users;
import java.util.List;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

@Stateful
public class userLoginImpl implements userLogin{
    @PersistenceContext
    private EntityManager entityManager;
    private users u = new users();
    @Override
    public boolean login(int id, String password) throws Exception {
        return false;
    }

    @Override
    public void register(users u) {
      entityManager.persist(u);
    }

    @Override
    public void deleteUser(int id) throws Exception {
      users x = entityManager.find(users.class,id);
      entityManager.remove(x);
       
    }

    @Override
    public void addUser(int id, String password) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<users> viewUser() throws Exception {
        String q = "select u from users u";
     return entityManager.createQuery(q,users.class).getResultList();
    }

    @Override
    public users searchUser(int id) {
        users u =entityManager.find(users.class, id);
        return u;
    }

    @Override
    public List checkID(int id) {
        CriteriaBuilder builder = entityManager.getCriteriaBuilder();
         CriteriaQuery cQuery = builder.createQuery(users.class);
         Root<users> e = cQuery.from(users.class);
         cQuery.select(e);
         Predicate predicate = builder.equal(e.get("id").as(Integer.class),id);
         cQuery.where(predicate);
         TypedQuery tQuery = entityManager.createQuery(cQuery);
         return tQuery.getResultList();
    }

    @Override
    public String getPassword(int id) {
       users u = this.entityManager.find(users.class, id);
       return u.getPassword();
    }

    @Override
    public void updateUser(users u) {
        entityManager.merge(u);
    }

    @Override
    public users getUsers() {
       return u;
    }

    @Override
    public void setUsers(users user) {
       this.u=user;
    }

    @Override
    public List<users> combinedSearch(String id, String fname, String lname, String email, String type) {
        String q ="select u from users u ";
       if(id.trim().length()!=0||fname.trim().length()!=0||lname.trim().length()!=0||email.trim().length()!=0||type.trim().length()!=0)
       {
           q=q+" where ";
       if(type.trim().length()!=0&&type!=null){
           q=q+ "u.type= "+"'"+type+"'";}
       if(fname.trim().length()!=0){
            if(q.endsWith("'"))
                 q=q+ " and ";
            q=q+" u.fName = "+"'"+fname+"'"; }
       if(lname.trim().length()!=0){
            if(q.endsWith("'"))
                 q=q+ " and ";
            q=q+" u.lName = "+"'"+lname+"'"; }
       if(email.trim().length()!=0){
            if(q.endsWith("'"))
                 q=q+ " and ";
            q=q+" u.eMail = "+"'"+email+"'"; }
       if(id.trim().length()!=0){
            if(q.endsWith("'"))
                q=q+ " and ";
            q=q + "u.id="+Integer.parseInt(id);}
       }
       return entityManager.createQuery(q).getResultList();
    }
    
}
