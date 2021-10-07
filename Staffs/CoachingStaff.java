/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Staffs;

import Constants.WeekDay;
import java.util.ArrayList;

/**
 *
 * @author Chia Chun
 */
public abstract class CoachingStaff extends Staff {

    protected int quaLevel;
    protected ArrayList<WeekDay> roaster = new ArrayList();
    
    //CONSTRUCTOR
    public CoachingStaff(String firstname, String surname, StaffType role) {
        super(firstname, surname, Department.COACH, role);
        this.quaLevel = getQualificationLevel();
    }
    
    protected abstract int getQualificationLevel();

    public void setRoaster (WeekDay roaster) {
        this.roaster.add(roaster);
    }
    public ArrayList<WeekDay> getRoaster () {
        return this.roaster;
    }
   
}
