/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package holidaybookingapp;

import HolidayBooking_shared.userLogin;
import holidaybookingapp.holidayBooking.gui.managingSection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.ejb.EJB;

/**
 *
 * @author 46048
 */
public class Main implements ActionListener{
    @EJB
    private static userLogin ul;
    private managingSection gui;
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
    
}
