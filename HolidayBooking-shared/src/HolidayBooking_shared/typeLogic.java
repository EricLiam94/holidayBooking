/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HolidayBooking_shared;

import holidaybooking.shared.entity.activity;
import java.util.List;
import java.util.Set;
import javax.ejb.Remote;

/**
 *
 * @author 46048
 */
@Remote
public interface typeLogic {
    public List<activity> searchingActivity(String type);
    public activity getActivity(int id);
    public List<activity> getAllactivites();
}
