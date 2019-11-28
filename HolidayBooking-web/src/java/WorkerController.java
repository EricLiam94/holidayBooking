
import HolidayBooking_shared.userLogin;
import holidaybooking.shared.entity.users;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 46048
 */
@ManagedBean(name="workController")
@RequestScoped
public class WorkerController implements Serializable {
    @EJB
    private userLogin ul;
    
    private int deleteId;
    private List<users> list;
    private String id;
    private String lname;
    private String fname;
    private String type;
    private String email;
    public WorkerController()  {
    }
    @PostConstruct
    public void init(){
        try {
            list=ul.viewUser();
        } catch (Exception ex) {
            Logger.getLogger(WorkerController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public int getDeleteId() {
        return deleteId;
    }

    public void setDeleteId(int deleteId) {
        this.deleteId = deleteId;
    }

    public List<users> getList() throws Exception {
        return list;
    }

    public void setList(List<users> list) {
        this.list = list;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    public void combinationSearch()
    {
        if(type==null)
            type="";
      list=ul.combinedSearch(id, fname, lname, email, type);
  
    }
    public void clear(){
    email="";
    type="";
    id="";
    fname="";
    lname="";
    }
    
}
