/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holidaybooking.shared.entity;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author 46048
 */
@Entity(name="holidayType")
@NamedQueries({@NamedQuery(name = holidayType.GET_ALL_QUERY_NAME, query = "SELECT t FROM holidayType t")})
public class holidayType implements Serializable {
    public final static String GET_ALL_QUERY_NAME="holidayType.getAll";
    @Id
    private String typeName;
    private String typeDescreption;
    @OneToMany(mappedBy="type")
    private Set<activity> activities;

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeDescreption() {
        return typeDescreption;
    }

    public void setTypeDescreption(String typeDescreption) {
        this.typeDescreption = typeDescreption;
    }

    public Set<activity> getActivities() {
        return activities;
    }

    public void setActivities(Set<activity> activities) {
        this.activities = activities;
    }


    
    
    
}
