/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Groups;

import Constants.WeekDay;
import Staffs.Staff;
import Swimmers.Swimmers;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Chia Chun
 */
public abstract class Groups {
    
    protected String identifier;
    protected WeekDay trainDay;
    protected Staff coach;
    protected ArrayList<Swimmers> swimmers = new ArrayList();

    //CONSTRUCTOR
    public Groups() {
        this.trainDay = assignTrainDay();
        this.coach = null;
    }

    protected abstract String getIdentifier();
    public abstract int getGroupID();
    public abstract GroupType getGroupName();

    private WeekDay assignTrainDay() {
       Random r = new Random();
       return WeekDay.values()[r.nextInt(WeekDay.values().length)];
    }
    
    public void setCoach(Staff coach) {
        this.coach = coach;
    }
    
    public Staff getCoach() {
        return this.coach;
    }
    
    public String getCoachDetail() {
        return this.coach.getID() + "/" + this.coach.getfirstName() + " " + this.coach.getSurname() + "/" + this.coach.getRole();
    }
    
    public WeekDay getTrainDay() {
        return this.trainDay;
    }
    
    public void assignSwimmer (Swimmers swimmer) {
        this.swimmers.add(swimmer);
    }
    
    public ArrayList<Swimmers> getSwimmers() {
        return this.swimmers;
    }
    
    public int getSwimmerNumbers() {
        return this.swimmers.size();
    }
    
    
}
