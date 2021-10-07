/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package AdminStaffs;

import Staffs.AdminStaff;
import Staffs.StaffType;

/**
 *
 * @author Chia Chun
 */
public class Receptionist extends AdminStaff {

    //CONSTRUCTOR
    public Receptionist(String firstname, String surname) {
        super(firstname, surname, StaffType.RECEPTIONIST);
    }

    @Override
    //return the staff member's name in full
    public String toString () {

        return this.staffID + "/" + this.dept + "/" + this.role + "/" + this.firstname + " " + this.surname;
    }    
    
}
