/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swimmingclub;


import Constants.Constants;
import Groups.GroupFactory;
import Groups.Groups;
import Staffs.CoachingStaff;
import Staffs.Department;
import Staffs.Staff;
import Staffs.StaffFactory;
import Staffs.StaffType;
import static Staffs.StaffUtilities.listStaffByDept;
import Swimmers.SwimmerFactory;
import Swimmers.Swimmers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author Chia Chun
 */
public class SwimmingClub {

    private ArrayList<Staff> staffList;
    private ArrayList<Staff> adminStaffList;
    private ArrayList<Staff> coachStaffList;
    private ArrayList<Groups> groupList;
    private ArrayList<Swimmers> swimmerList;
    
    //CONSTRUCTOR
    public SwimmingClub () {
        //
        // create all the entities (staff, group, swimmer)
        //
        
        // create staff
        this.staffList = new ArrayList();
        createStaff();
        this.adminStaffList = listStaffByDept(this.staffList, Department.ADMIN);
        this.coachStaffList = listStaffByDept(this.staffList, Department.COACH);

        // create groups        
        this.groupList = new ArrayList();
        createGroups();
        
        // create swimmers
        this.swimmerList = new ArrayList();
        createSwimmers();
        
        // Once we got all entities, the system should assigna coach to a group 
        assignCoach();
        // assign swimers to a group
        assignSwimmer();
        
    }
    
    private void createStaff (){
        StaffFactory staffFactory = new StaffFactory();

        //create admin staff
        for (int i=0; i < Constants.ADMIN_STAFF_NUMBER; i++) {
            this.staffList.add(staffFactory.getStaffFromFactory(Department.ADMIN));
        }
        
        // create only one head coach
        this.staffList.add(staffFactory.getStaffFromFactory(StaffType.HEAD_COACH));
        
        // create coaching staff
        for (int i=0; i < (Constants.COACHING_STAFF_NUMBER-1); i++) {
            this.staffList.add(staffFactory.getStaffFromFactory(Department.COACH));
        }        

    }
    
    private void createGroups() {
        GroupFactory groupFactory = new GroupFactory();
        
        for (int i=0; i < Constants.GROUPS_NUMBER; i++) {
            this.groupList.add(groupFactory.getGroupFromFactory());
        }
    }

    private void createSwimmers() {
        SwimmerFactory swimmerFactory = new SwimmerFactory();

        for (int i=0; i < Constants.SWIMMERS_NUMBER; i++) {
            this.swimmerList.add(swimmerFactory.getSwimmer());
        }        
    }
    

    /**
     * Assign coach to groups
     *  1. Each coach must be assigned to at least one Group 
     *  2. It is allowed to have the same coach for several Groups even if they are on the same day
     *  3. Restrict coaches so they can only teach 2 Groups on any one day 
     */
    private void assignCoach () {

        ArrayList<Groups> tempGroup = new ArrayList();
        Random r = new Random();
        int index;
        
        // first run assignment
        // make sure that each coach must be assigned to a group 
        for (Staff s: this.coachStaffList) {
            //
            // By using a temp list to store the group had been assigned,
            // once a new object been added on "tempGroup", then the system will
            // remove the one in groupList database to avoid it to be picked again
            //
            if (this.groupList.size() > 0) {
                // pick a group from group database by random
                index = r.nextInt(this.groupList.size());
                // set up coach object in the group property
                this.groupList.get(index).setCoach(s);
                // copy this group to the temp list
                tempGroup.add(this.groupList.get(index));
                // also set up the train day on coach's property according to the group's train day
                ((CoachingStaff)s).setRoaster(this.groupList.get(index).getTrainDay());
                // remove the object from the database in case to be picked again
                this.groupList.remove(index);
            }
        }
        
        // second run assinment
        // assign the rest groups to rendom coach
        int pickCoach, time;
        while (this.groupList.size() > 0) {
            index = r.nextInt(this.groupList.size());
            do {
                pickCoach = r.nextInt(this.coachStaffList.size());
                //
                // one train day in a coach property means the coach has to train a group in that day
                // So using collections class to know if the coach has two groups in the same weekday already
                // System will fine another coach randomly if the coach who has been picked has already two group in a day.
                //
                time = Collections.frequency(((CoachingStaff)this.coachStaffList.get(pickCoach)).getRoaster(), this.groupList.get(index).getTrainDay());
            } while (time > 2);
            // set up coach object in the group property
            this.groupList.get(index).setCoach(this.coachStaffList.get(pickCoach));
            // copy this group to the temp list
            tempGroup.add(this.groupList.get(index));
            // also set up the train day on coach's property according to the group's train day
            ((CoachingStaff)this.coachStaffList.get(pickCoach)).setRoaster(this.groupList.get(index).getTrainDay());
            // remove the object from the database in case to be picked again
            this.groupList.remove(index);
        }
        
        // copy back the whole group data to groupList
        this.groupList = tempGroup;

    }
    
    private ArrayList<Integer> getSwimmerPool() {
        ArrayList<Integer> poolList = new ArrayList();
        // create a list of all swimmers, and the value of each element is the index of the original list
        for (int i = 0; i < this.swimmerList.size(); i++) {
            poolList.add(i);
        }
        return poolList;
    }
    
    /**
     * Assign swimmers to each group reandomly but not duplicate 
     */
    private void assignSwimmer () {
        ArrayList<Integer> poolList;
        
        Random r = new Random();
        
        for (Groups g: this.groupList) {
            
            // decide how many swimmer in this group by random
            int swimmersPick = r.nextInt(Constants.MAX_SWIMMERS);
            
            // get the whole swimmers database
            poolList = getSwimmerPool();
            
            // a do while loop to pick a swimmer to the group by everytime
            do {
                // pick a swimmer from swimmer pool
                int pick = r.nextInt(poolList.size());
                // assign swimmer member to the group
                g.assignSwimmer(this.swimmerList.get(poolList.get(pick)));
                //
                // remove the member has been picked from the pool
                //
                // the swimmer list index won't be changed by removing object from the poolList
                // because we store the real index in the object value
                //
                poolList.remove(pick);
                swimmersPick--;
            } while (swimmersPick >= 0);
        }
        
    } 

    public ArrayList<Staff> getStaff() {
       return this.staffList; 
    }
    
    public ArrayList<Staff> getAdminStaff() {
       return this.adminStaffList; 
    }

    public ArrayList<Staff> getCoachStaff() {
       return this.coachStaffList; 
    }

    public ArrayList<Groups> getGroups() {
       return this.groupList; 
    }
    
    public ArrayList<Swimmers> getSwimmers() {
       return this.swimmerList; 
    }
    
}
