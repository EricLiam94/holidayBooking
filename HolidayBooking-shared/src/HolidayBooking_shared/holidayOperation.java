/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HolidayBooking_shared;

import holidaybooking.shared.entity.activity;
import holidaybooking.shared.entity.holiday;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author 46048
 */
@Remote
public interface holidayOperation {
    public holiday searchHoliday(int id);
    public List<holiday> searchHolidayType(String Type);
    public void addHoliday(int id,String name,String type);
    public void deleteHoliday(int id);
    //public void updateHoliday(int)
    public List<String> typeList();
    public List<holiday> searching(String id,String type,String name);
    public void updateHoliday(holiday h);
    public String getDesc(int id);
}
