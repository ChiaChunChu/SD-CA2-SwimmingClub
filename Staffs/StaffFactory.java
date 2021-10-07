/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Staffs;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Chia Chun
 */
public class StaffFactory {

    public Staff getStaffFromFactory(Department dept) {
        Random r = new Random();
        ArrayList<StaffType> staffTypes = new ArrayList();

        if (dept == Department.ADMIN) {
            staffTypes = StaffType.listAdmins();
        } else {
            staffTypes = StaffType.listCoaches();
        }
        
        return staffTypes.get(r.nextInt(staffTypes.size())).getStaff();
    }
    
    public Staff getStaffFromFactory(StaffType type) {
        return type.getStaff();
    }
    
}
