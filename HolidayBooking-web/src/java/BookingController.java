
import HolidayBooking_shared.typeLogic;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
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
@ManagedBean(name="booking")
@ViewScoped
public class BookingController implements Serializable {
    @EJB
    private typeLogic tl;
    private holidayMb hmb;
    private String type;

    public BookingController() {
    }
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
