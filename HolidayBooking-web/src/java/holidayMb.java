
import HolidayBooking_shared.holidayOperation;
import HolidayBooking_shared.typeLogic;
import HolidayBooking_shared.userLogin;
import holidaybooking.shared.entity.activity;
import holidaybooking.shared.entity.holiday;
import holidaybooking.shared.entity.users;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
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
@Named(value="holidaymb")
@SessionScoped
public class holidayMb implements Serializable{
    @EJB
    private holidayOperation hoi;
    @EJB
    private typeLogic tl;
    @EJB
    private userLogin ul;
    private String uid;
    private String id;
    private String name;
    private String type;
    private String des;
    private int activityId;
    private List<holiday> lists;
    private List<String> types;


    public holidayMb() {

    }
    
    @PostConstruct
    public void init()
    {        types = hoi.typeList();
            id="";
            name="";
            type="";
            des="";
             uid = FacesContext.getCurrentInstance().getExternalContext().getRemoteUser();
    }

    public String getId() {
        return id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
    
    public void setId(String id) {
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

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    public List<holiday> getLists() {
        //lists=hoi.searchHolidayType(type);
        return lists;
    }

    public void setLists(List<holiday> lists) {
        this.lists = lists;
    }

    public int getActivityId() {
        return activityId;
    }

    public void setActivityId(int activityId) {
        this.activityId = activityId;
    }
   
    public void addHoliday()
    {
        hoi.addHoliday(Integer.parseInt(id), name, type);
    
    }
    
    public void deleteHoliday()
    {
        hoi.deleteHoliday(Integer.parseInt(id));
    }
    
    public holiday searchHoliday()
    {
        return hoi.searchHoliday(Integer.parseInt(id));
    }
    
    public void searchHolidaytype()
    {
   lists= hoi.searchHolidayType(type);
    }
 
    public void searching(){
        id=id==null?"":id;
        type=type==null?"":type;
        name=name==null?"":name;
    List<holiday> temp =  hoi.searching(id, type, name)  ;
    lists=new ArrayList<>();
    for(holiday h:temp)
    {
        if(h.getAusers().getId()==Integer.parseInt(uid))
        lists.add(h);
    }
    }
    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
    
    public void clearData()
    {
        name=null;
        id=null;
        lists=null;
        type=null;
    }
    
    public List<activity> getActivities()
    {
       return tl.searchingActivity(type);
    }
    
    public void cancelBooking()
    {
        holiday h = hoi.searchHoliday(Integer.parseInt(id));
        if(!h.getDescription().trim().endsWith(")") && h.getDescription().length()!=0)
            h.setDescription(h.getDescription()+"(Cancelled)\n");
        else
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Privious activity has been cancelled or no activity exist"));
        hoi.updateHoliday(h);
    }
    public void clearRecord()
    {
        holiday h = hoi.searchHoliday(Integer.parseInt(id));
        h.setDescription("");
        hoi.updateHoliday(h);
    }
    public String holidayBooking(int aId){
        holiday h = hoi.searchHoliday(Integer.parseInt(id));
if(h.getDescription().trim().endsWith(")") ||h.getDescription().length()==0 ){
        activity a =tl.getActivity(aId);
        String descrip = a.getActivityID() + " " +a.getName()+" " + a.getDetail();
        h.setDescription(h.getDescription()+descrip);
        hoi.updateHoliday(h);
         FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Booking succesfully"));}
else{FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Privious activity exist "));}
        return "/faces/Transaction";
    }
    
    public String bookHoliday(activity a)
    {
        return null;
    }   
}
