
import HolidayBooking_shared.holidayOperation;
import HolidayBooking_shared.userLogin;
import holidaybooking.shared.entity.activity;
import holidaybooking.shared.entity.holiday;
import holidaybooking.shared.entity.users;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 46048
 */
@Named(value="login")
@SessionScoped
public class loginController implements Serializable {
    @EJB
    private userLogin ul;
    @EJB
    private holidayOperation hoi;
    private users u;
    private String id;
    private String password;
    private String type;
    private String payment;
    
    @PostConstruct
    public void init()
    {
        id = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
    }

    public users getU() {
        return u;
    }

    public void setU(users u) {
        this.u = u;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void book(activity ac) {
        u=ul.searchUser(Integer.parseInt(id));
        if(u.getfName()!=null){
        
        Date now =new Date();
        String name = now + " " + ac.getName();
        holiday trans = new holiday(name, payment, u, ac);
        trans.setAusers(u);
        trans.setDescription(ac.getDetail() + "\t Price:" + ac.getPrice());
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Activity booked succussfully,New transaction is generated"));
        hoi.updateHoliday(trans);}
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
