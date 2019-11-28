/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holidaybooking.shared.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author 46048
 */
@Entity(name="activity")
@NamedQueries({@NamedQuery(name = activity.GET_ALL_QUERY_NAME, query = "SELECT a FROM activity a")})
public class activity implements Serializable {
    public final static String GET_ALL_QUERY_NAME="activity.getAll";
    @Id
    private int activityID;
    @ManyToOne
    @JoinColumn(name ="type")
    private holidayType type;
    private double price;
    private String name;
    private String Detail;
    @OneToMany(mappedBy="activity")
    private List<holiday> h;

    public activity() {
        h=new ArrayList();
    }

    
    public activity(int activityID, holidayType type, double price, String name, String Detail) {
        this.activityID = activityID;
        this.type = type;
        this.price = price;
        this.name = name;
        this.Detail = Detail;
        this.h=new ArrayList();
    }

    
    public int getActivityID() {
        return activityID;
    }

    public void setActivityID(int activityID) {
        this.activityID = activityID;
    }

    public holidayType getType() {
        return type;
    }

    public void setType(holidayType type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDetail() {
        return Detail;
    }

    public void setDetail(String Detail) {
        this.Detail = Detail;
    }

    public List<holiday> getH() {
        return h;
    }

    public void setH(List<holiday> h) {
        this.h = h;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

 
    
    
}
