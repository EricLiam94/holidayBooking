
import HolidayBooking_shared.holidayOperation;
import holidaybooking.shared.entity.holiday;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.el.ELContext;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
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
@ManagedBean(name="transaction")
@ViewScoped
public class TransactionController implements Serializable {
    @EJB
    private holidayOperation hoi;
    private int index;
    private holiday holiday;
    private String descrip;

    public TransactionController() {
        
         index= Integer.valueOf(FacesContext.getCurrentInstance()
 .getExternalContext()
 .getRequestParameterMap()
 .get("ind"));
 holiday=getHoliday();
    }
    
    public holiday getHoliday()
   {
 if (holiday == null) {
// Get application context bean MovieApplication
 ELContext context
 = FacesContext.getCurrentInstance().getELContext();
 holidayMb app
 = (holidayMb) FacesContext.getCurrentInstance()
 .getApplication()
.getELResolver()
.getValue(context, null, "holidaymb");
// -1 to movieId since we +1 in JSF (to always have positive movie id!)
 return app.getLists().get(--index);
 }
   return holiday;   
   }

    public String getDescrip() {
        descrip=hoi.getDesc(holiday.getId());
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }
    
}