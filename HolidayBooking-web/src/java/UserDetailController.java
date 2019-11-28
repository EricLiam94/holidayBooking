

import HolidayBooking_shared.userLogin;
import holidaybooking.shared.entity.holiday;
import holidaybooking.shared.entity.users;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import javax.inject.Named;
import javax.jms.Session;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 46048
 */
@ManagedBean(name="userDC")
@ViewScoped
public class UserDetailController implements Serializable{
   @EJB
    private userLogin ul;   
    private int index;
    private users aUser;
    private String lname;
    private String fname;
    private String email;
    private String password;
    private String type;
    private String street;
    private String city;
    private String country;
    private String postcode;
    private String phoneNuml;
     
     public UserDetailController(){
       
 }
    @PostConstruct 
    public void init()
    {
      index= Integer.valueOf(FacesContext.getCurrentInstance()
 .getExternalContext()
 .getRequestParameterMap()
 .get("userIndex"));
      try{
aUser = getaUser();}
      catch(Exception e){}
  lname=aUser.getlName();
fname=aUser.getfName();
email=aUser.geteMail();
password=aUser.getPassword();
type=aUser.getType();
street=aUser.getStreet();
city=aUser.getCity();
country=aUser.getCountry();
postcode=aUser.getPostcode();
phoneNuml=aUser.getPhoneNuml();  
    }
  public users getaUser() throws Exception   {
 if (aUser == null) {
 ELContext context
 = FacesContext.getCurrentInstance().getELContext();
WorkerController app
 = (WorkerController) FacesContext.getCurrentInstance()
 .getApplication()
.getELResolver()
.getValue(context, null, "workController");
 return app.getList().get(--index);
 }
   return aUser;   
}

    public void setaUser(users aUser) {
        this.aUser = aUser;
    }
     
     public String updateUser() throws Exception
     {     
         aUser.setCity(city);
         aUser.setCountry(country);
         aUser.setPassword(password);
         aUser.setPhoneNuml(phoneNuml);
         aUser.setPostcode(postcode);
         aUser.setStreet(street);
         aUser.seteMail(email);
         aUser.setfName(fname);
         aUser.setlName(lname);
         aUser.setType(type);
        ul.updateUser(aUser);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("user has been updated succesfully"));
        return "/worker/UserView";
     }

        public String delete() throws Exception
        {
            ul.deleteUser(aUser.getId());
            return "/worker/UserView";
        }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhoneNuml() {
        return phoneNuml;
    }

    public void setPhoneNuml(String phoneNuml) {
        this.phoneNuml = phoneNuml;
    }
     
}
