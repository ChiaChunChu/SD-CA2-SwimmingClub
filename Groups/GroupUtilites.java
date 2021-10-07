/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Groups;

import Constants.WeekDay;
import java.util.ArrayList;

/**
 *
 * @author Chia Chun
 */
public class GroupUtilites {

    
    public static ArrayList<Groups> listGroupsByType(ArrayList<Groups> allGroups, GroupType type) {
        ArrayList<Groups> groups = new ArrayList();
        for (Groups g: allGroups) {
            if (g.getGroupName() == type)
                groups.add(g);
        }
        return groups;
    }
    
    public static ArrayList<Groups> listGroupsByTrainDay(ArrayList<Groups> allGroups, WeekDay trainDay) {
        ArrayList<Groups> groups = new ArrayList();
        for (Groups g: allGroups) {
            if (g.getTrainDay() == trainDay)
                groups.add(g);
        }
        return groups;        
    }
    
    public static ArrayList<Groups> listGroupsByCoach(ArrayList<Groups> allGroups, int coachID ) {
        ArrayList<Groups> groups = new ArrayList();

        for (Groups g: allGroups) {
            if (coachID == g.coach.getID()) {
                groups.add(g);
            }
        }
        return groups;
    }
    
    
}
