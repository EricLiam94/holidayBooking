/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holidaybooking.shared.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Transient;
@Entity(name="holiday")
@NamedQueries({@NamedQuery(name = holiday.GET_ALL_QUERY_NAME, query = "SELECT h FROM holiday h")})
public class holiday implements Serializable {
    public final static String GET_ALL_QUERY_NAME="holiday.getAll";
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable=false)
    private String name;
    @Column(name="type",nullable=false)
    private String type;
    private String Description;
    @ManyToOne()
    @JoinColumn(name ="belonged_to",nullable=false)
    private users ausers;
    @ManyToOne()
    @JoinColumn(name = "activity",nullable=false)
    private activity activity;
    public holiday() {
    }

    public holiday(int id, String name, String type) {
        this.id = id;
        this.name = name;
        this.type = type;
    }

    public holiday(int id, String name, String type, String Description) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.Description = Description;
    }

    public holiday(String name, String type, users ausers, activity activity) {
        
        this.name = name;
        this.type = type;
        this.ausers = ausers;
        this.activity = activity;
    }

    public holiday(int id, String name, String type, String Description, users ausers, activity activity) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.Description = Description;
        this.ausers = ausers;
        this.activity = activity;
    }
   
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }

    public users getAusers() {
        return ausers;
    }

    public void setAusers(users ausers) {
        this.ausers = ausers;
    }

    public activity getActivity() {
        return activity;
    }

    public void setActivity(activity activity) {
        this.activity = activity;
    }
    
}
