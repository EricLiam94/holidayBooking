/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HolidayBooking_shared;
import holidaybooking.shared.entity.users;
import javax.ejb.Remote;
import java.util.List;

@Remote
public interface userLogin {
 public boolean login(int id,String password) throws Exception;
 public void register(users u);
 public void  deleteUser(int id) throws Exception;
 public void updateUser(users u);
 public void  addUser(int id,String password) throws Exception;
 public List<users> viewUser() throws Exception;
 public users searchUser(int id);
 public List checkID(int id);
 public String getPassword(int id);
 public users getUsers();
 public void setUsers(users u);
 public List<users> combinedSearch(String id,String fname,String lname,String email,String type);
}