/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import HolidayBooking_shared.userLogin;
import holidaybooking.shared.entity.users;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/**
 *
 * @author 46048*/
@Named(value="userC")
@RequestScoped
public class userController implements Serializable {
    @EJB
    private userLogin ul;
    private String id;
    @Size(min = 7, max = 20, message = "Please enter the password length longer than 7 less than 20")
    private String password;
    @Size(min = 1, message = "Please enter the first name")
    @Pattern(regexp = "([a-zA-Z]+)", message = "only letters are valid")
    private String fname;
    @Size(min = 1, message = "Please enter the last name")
    @Pattern(regexp = "([a-zA-Z]+)", message = "only letters are valid")
    private String lname;
    @Size(min = 1, message = "Please enter the Email")
    @Pattern(regexp = "[a-zA-Z0-9]+@[a-zA-Z0-9]+\\.[a-zA-Z0-9]+", message = "Email format is invalid.")
    private String email;
    private String type;
    public userController() {
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

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String register() throws Exception{
        users u =new users(lname,fname, email,password,type);
        ul.register(u);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("user has been added succesfully"));
                return null;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
   
}
