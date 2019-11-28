
import HolidayBooking_shared.holidayOperation;
import HolidayBooking_shared.typeLogic;
import HolidayBooking_shared.userLogin;
import holidaybooking.shared.entity.activity;
import holidaybooking.shared.entity.holiday;
import holidaybooking.shared.entity.users;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author 46048
 */
@ManagedBean(name = "newBook")
@ViewScoped
public class NewBookController implements Serializable {

    @EJB
    private typeLogic tl;
    @EJB
    private userLogin ul;
    @EJB
    private holidayOperation hop;
    private List<activity> activities;
    private holiday trans;
    private String type;
    private users user;
    private String id;

    public NewBookController() {
         id = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("uid");
    }

    
    
    @PostConstruct
    public void init() {
        activities = tl.getAllactivites();
    }

    public List<activity> getActivities() {
        return activities;
    }

    public void setActivities(List<activity> activities) {
        this.activities = activities;
    }

    

    public holiday getTrans() {
        return trans;
    }

    public void setTrans(holiday trans) {
        this.trans = trans;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public users getUser() {
        return user;
    }

    public void setUser(users user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void p() {
        System.out.println(id);
    }
}
