/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package CoachStaffs;

import Constants.Constants;
import Staffs.CoachingStaff;
import Staffs.StaffType;
import java.util.Random;

/**
 *
 * @author Chia Chun
 */
public class SwimTeacher extends CoachingStaff {

    //CONSTRUCTOR
    public SwimTeacher(String firstname, String surname) {
        super(firstname, surname, StaffType.SWIM_TEACHER);
    }

    @Override
    protected int getQualificationLevel() {
        Random r = new Random();
        int level = r.nextInt(Constants.MAX_QUALIFICATION_LEVEL-1);
        level += 1;
        return level;
    }

    @Override
    //return the staff member's name in full
    public String toString () {

        return this.staffID + "/" + this.dept + "/" + this.role + "/" + this.firstname + " " + this.surname + "/" + this.quaLevel + "/" + this.roaster;
    }    
}
