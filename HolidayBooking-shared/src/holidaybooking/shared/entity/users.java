/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holidaybooking.shared.entity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
@Entity(name="users")
@NamedQueries({@NamedQuery(name = users.GET_ALL_QUERY_NAME, query = "SELECT u FROM users u")})
public class users implements Serializable{
    public static final String GET_ALL_QUERY_NAME = "users.getAll";  
    @Id
    @GeneratedValue
    private int id;
    @Column(name="lastName")
    private String lName;
    @Column(name="fristName")
    private String fName;
    @Column(name="email")
    private String eMail;
    @Column(name="password")
    private String password;
    @Column(name="type")
    private String type;
    @Column(name="street")
    private String street;
    @Column(name="city")
    private String city;
    @Column(name="country")
    private String country;
    @Column(name="postcode")
    private String postcode;
    @Column(name="phone_number")
    private String phoneNuml;
    @OneToMany(mappedBy="ausers",cascade=CascadeType.REMOVE)
    private Set<holiday> holidays;


    public users() {
    }
    
    public users(int id,String password){
    this.id=id;
    this.password=password;
    }   
    
    public users(String lName, String fName, String password) {
        this.lName = lName;
        this.fName = fName;
        this.password = password;
    }    

    public users(String lName, String fName, String eMail, String password) {
        this.lName = lName;
        this.fName = fName;
        this.eMail = eMail;
        this.password = password;
    }

    public users(String lName, String fName, String eMail, String password,String type) {
        this.lName = lName;
        this.fName = fName;
        this.eMail = eMail;
         try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }   
            this.password = hexString.toString();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            
        }
        this.type = type;
    }
    

   public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }
    
    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }
    
    public String geteMail() {
        return eMail;
    }
    
    public void seteMail(String eMail) {
        this.eMail = eMail;
    }
    
    public String getPassword() {
        return password;
    }

    public void setPassword(String password)  {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer();

            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }   
            this.password = hexString.toString();
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e) {
            
        }
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

    public Set<holiday> getHolidays() {
        return holidays;
    }

    public void setHolidays(Set<holiday> holidays) {
        this.holidays = holidays;
    }
    
}
