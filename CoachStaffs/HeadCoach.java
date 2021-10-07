/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CoachStaffs;

import Constants.Constants;
import Staffs.CoachingStaff;
import Staffs.StaffType;

/**
 *
 * @author Chia Chun
 */
public class HeadCoach extends CoachingStaff {

    //CONSTRUCTOR
    public HeadCoach(String firstname, String surname) {
        super(firstname, surname, StaffType.HEAD_COACH);
    }

    @Override
    protected int getQualificationLevel() {
        // Head Coach must be the maximum level
        return Constants.MAX_QUALIFICATION_LEVEL;
    }

    @Override
    //return the staff member's name in full
    public String toString () {

        return this.staffID + "/" + this.dept + "/" + this.role + "/" + this.firstname + " " + this.surname + "/" + this.quaLevel + "/" + this.roaster;
    }        
    
}
