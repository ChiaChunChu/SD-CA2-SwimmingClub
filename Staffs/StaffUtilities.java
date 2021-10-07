/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Staffs;

import java.util.ArrayList;

/**
 *
 * @author Chia Chun
 */
public class StaffUtilities {

    public static ArrayList<Staff> listStaffByDept (ArrayList<Staff> allStaff, Department dept) {
        
        ArrayList<Staff> staff = new ArrayList();
        for (Staff s: allStaff) {
            if (s.dept == dept) {
                staff.add(s);
            }
        }
        return staff;
        
    }
    
    public static ArrayList<Staff> listStaffByRole (ArrayList<Staff> allStaff, StaffType role) {
        
        ArrayList<Staff> staff = new ArrayList();
        for (Staff s: allStaff) {
            if (s.role == role) {
                staff.add(s);
            }
        }
        return staff;
        
    }    
    
    public static ArrayList<Integer> getAllCoachID (ArrayList<Staff> allCoach) {
        ArrayList<Integer> allCoachID = new ArrayList();
        for (Staff c: allCoach) {
            allCoachID.add(c.staffID);
        }
        return allCoachID;
    }
    
    public static Staff getCoachByID (ArrayList<Staff> allCoach, int coachID) {
        Staff coach = null;
        for (Staff c: allCoach) {
            if (coachID == c.getID()) {
                coach=c;
            }
        }
        return coach;
    }
    
}
