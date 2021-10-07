/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clients;

import Constants.WeekDay;
import Groups.GroupType;
import Groups.GroupUtilites;
import Groups.Groups;
import Staffs.Department;
import Staffs.Staff;
import Staffs.StaffType;
import Staffs.StaffUtilities;
import Swimmers.Swimmers;
import Utilities.FunNumber;
import Utilities.InputUtilities;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import swimmingclub.SwimmingClub;

/**
 *
 * @author Chia Chun
 */
public class SwimmingClubManagement {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        SwimmingClub myClub = new SwimmingClub();
        int userInput;
        
        System.out.println("\n*****Welcome to Swimming Club*****\n");
       
        do {
            // print all the functions
            printFunctions();

            userInput = InputUtilities.getUserInt ("\nPlease select the function above by entering the number: ", 1, 8);

            FunNumber funNum = InputUtilities.getFunNumByInt(userInput);
            switch (funNum) {

                case FUNCTION1:
                    //
                    // List all staff  
                    //
                    printAllStaff(myClub);
                    break;

                case FUNCTION2:
                    //
                    // List staff by categories (e.g. list all Assistant Coaches) 
                    //
                    System.out.println("\n(1) Receptionist        (4) Head Coach");
                    System.out.println("(2) Cleaner             (5) Assistant Coach");
                    System.out.println("(3) Maintainer          (6) Swim Teacher");
                    userInput = InputUtilities.getUserInt ("\nPlease select the categories by entering the number: ", 1, 6);
                    StaffType role = InputUtilities.getStaffTypeByInt(userInput);                
                    ArrayList<Staff> staffByRole = StaffUtilities.listStaffByRole(myClub.getStaff(), role);
                    printStaffByRole(staffByRole, role);
                    break;

                case FUNCTION3:
                    //
                    // List all Groups, showing the coach and the number of swimmers in the group
                    //
                    printAllGroups(myClub.getGroups());
                    break;

                case FUNCTION4:
                    //
                    // List Groups by various types (e.g. list all Dolphin Groups) 
                    //
                    System.out.println("\n(1) Dolphin Groups");
                    System.out.println("(2) Seal Groups");
                    System.out.println("(3) Turtle Groups");
                    userInput = InputUtilities.getUserInt ("\nPlease select the group by entering the number: ", 1, 3);
                    GroupType type = InputUtilities.getGroupTypeByInt(userInput);
                    ArrayList<Groups> groupByType = GroupUtilites.listGroupsByType(myClub.getGroups(), type);
                    printGroupByType(groupByType, type);
                    break;

                case FUNCTION5:
                    //
                    // List Groups by the day they train (e.g. list all who train on Monday) 
                    //
                    System.out.println("\n(1) Monday            (5) Friday");
                    System.out.println("(2) Tuesday           (6) Saturday");
                    System.out.println("(3) Wednesday         (7) Sunday");
                    System.out.println("(4) Thursday");
                    userInput = InputUtilities.getUserInt ("\nPlease select the day by entering the number: ", 1, 7);
                    WeekDay trainDay = InputUtilities.getWeekDayByInt(userInput);
                    ArrayList<Groups> groupByTrainDay = GroupUtilites.listGroupsByTrainDay(myClub.getGroups(), trainDay);
                    printGroupByTrainDay(groupByTrainDay, trainDay);
                    break;

                case FUNCTION6:
                    //
                    // List all the swimmers in a particular Group 
                    //
                    System.out.println("\n(1) Dolphin Groups");
                    System.out.println("(2) Seal Groups");
                    System.out.println("(3) Turtle Groups");
                    userInput = InputUtilities.getUserInt ("\nPlease select the group by entering the number: ", 1, 3);
                    GroupType group = InputUtilities.getGroupTypeByInt(userInput);

                    // get the groups
                    ArrayList<Groups> groupList = GroupUtilites.listGroupsByType(myClub.getGroups(), group);
                    printGroupByType(groupList, group);
                    userInput = InputUtilities.getUserInt ("\nPlease enter the group ID you want to list: ", 1, groupList.size());
                    printSwimmerByGroup(groupList, userInput);
                    break;

                case FUNCTION7:
                    //
                    // List the swimmers coached by a particular coach 
                    //
                    
                    // list all the coach to let user choose who to search
                    printAllCoach(myClub.getCoachStaff());
                    ArrayList<Integer> allCoachID = StaffUtilities.getAllCoachID (myClub.getCoachStaff());

                    // ask user to enter the sepecific coach ID
                    userInput = InputUtilities.getUserInt ("\nPlease enter the coach ID you want to list: ");

                    //
                    // if the ID user entered is not in the list, then system will ask to enter again 
                    //
                    while (!allCoachID.contains(userInput)) {
                        userInput = InputUtilities.getUserInt ("\nThe ID you entered is invalid, please enter again!");
                    }
                    
                    // get the coach by ID which user entered
                    // then list the group and swimmers coached by him
                    ArrayList<Groups> groups = GroupUtilites.listGroupsByCoach(myClub.getGroups(), userInput);
                    Staff coach = StaffUtilities.getCoachByID(myClub.getCoachStaff(), userInput);
                    printSwimmersByCoach(groups, coach);
                    break;                

                case FUNCTION8:
                    //
                    // List all swimmers in the club 
                    //
                    printAllSwimmers(myClub.getSwimmers());
                    break;                

            }
            
        } while (!InputUtilities.exitOrNot("\n\nPress anykey to continue or press 'q/Q' to quit..."));

    }
    
    
    public static void printFunctions () {
        
        System.out.println("(1) List all staff");
        System.out.println("(2) List staff by categories (e.g. list all Assistant Coach)");
        System.out.println("(3) List all Groups, showing the coach and the number of swimmers in the group");
        System.out.println("(4) List Groups by various types (e.g. list all Dolphin Groups)");
        System.out.println("(5) List Groups by the day they train (e.g. list all who train on Monday)");
        System.out.println("(6) List all the swimmers in a particular Group");
        System.out.println("(7) List the swimmers coached by a particular coach");
        System.out.println("(8) List all swimmers in the club");
    }
    
    
    
    public static void printAllStaff (SwimmingClub myClub) {
        
        System.out.println("\n======== Administration ========");
        System.out.println("-----------------------------------");
        System.out.println("[StaffID]/[Dept]/[Role]/[StaffName]");
        System.out.println("-----------------------------------");
        for (Staff s: myClub.getAdminStaff()) {
            System.out.println(s.toString());
        }
        
        System.out.println("\n======== Coaching ========");
        System.out.println("---------------------------------------------------------");
        System.out.println("[StaffID]/[Dept]/[Role]/[StaffName]/[QualLevel]/[Roaster]");
        System.out.println("---------------------------------------------------------");
        for (Staff s: myClub.getCoachStaff()) {
            System.out.println(s.toString());
        }
        
    }

    public static void printStaffByRole (ArrayList<Staff> staffByRole, StaffType role) {
        
        System.out.println("\n======== "+ role.toString() +" ========");
        if (role.whichDept() == Department.ADMIN) {
            System.out.println("-----------------------------------");
            System.out.println("[StaffID]/[Dept]/[Role]/[StaffName]");
            System.out.println("-----------------------------------");            
        } else if (role.whichDept() == Department.COACH) {
            System.out.println("---------------------------------------------------------");
            System.out.println("[StaffID]/[Dept]/[Role]/[StaffName]/[QualLevel]/[Roaster]");
            System.out.println("---------------------------------------------------------");
        }
        for (Staff s: staffByRole) {
            System.out.println(s.toString());
        }
        
    }
    
    public static void printAllGroups (ArrayList<Groups> allGroups) {
        ArrayList<Groups> oneGroup = new ArrayList();
        for (GroupType t: GroupType.values()) {
            oneGroup = GroupUtilites.listGroupsByType (allGroups, t);
            //
            // sort the groups' name and ID
            //
            Collections.sort(oneGroup, new Comparator<Groups>() {
            @Override
            public int compare(Groups o1, Groups o2) {
                
                return o1.getGroupID() - o2.getGroupID();
            }
            });
            System.out.println("\n======== "+ t.toString() + "========");
            for (Groups g: oneGroup) {
                System.out.println(g.toString() + " [SwimmerNumer:"+ g.getSwimmerNumbers() + "] [Coach:"+ g.getCoachDetail()+"]");
            }
        }
    }
    
    public static void printGroupByType (ArrayList<Groups> groupByType, GroupType type) {
        System.out.println("\n======== "+ type.toString() + "========");
        //
        // sort the groups' name and ID
        //
        Collections.sort(groupByType, new Comparator<Groups>() {
        @Override
        public int compare(Groups o1, Groups o2) {

            return o1.getGroupID() - o2.getGroupID();
        }
        });
        for (Groups g: groupByType) {
            System.out.println(g.toString() + " [SwimmerNumer:"+ g.getSwimmerNumbers() + "] [Coach:"+ g.getCoachDetail()+"]");
        }
    }
    
    public static void printGroupByTrainDay(ArrayList<Groups> groupByTrainDay, WeekDay trainDay) {
        System.out.println("\n======== Train on "+ trainDay.toString() + "========");
        ArrayList<Groups> oneGroup = new ArrayList();
        for (GroupType t: GroupType.values()) {
            oneGroup = GroupUtilites.listGroupsByType (groupByTrainDay, t);
            //
            // sort the groups' name and ID
            //
            Collections.sort(oneGroup, new Comparator<Groups>() {
            @Override
            public int compare(Groups o1, Groups o2) {
                
                return o1.getGroupID() - o2.getGroupID();
            }
            });
            for (Groups g: oneGroup) {
                System.out.println(g.toString() + " [SwimmerNumer:"+ g.getSwimmerNumbers() + "] [Coach:"+ g.getCoachDetail()+"]");
            }
        }
        
    }
    
    public static void printSwimmerByGroup(ArrayList<Groups> groups, int groupID) {
        for (Groups g: groups) {
            if (g.getGroupID() == groupID) {
                System.out.println("\n======== Swimmers in "+ g.getGroupName()+ g.getGroupID() + " ========");
                for (Swimmers s: g.getSwimmers()) {
                    System.out.println(s.toString());
                }
                break;
            }
        }
        
    }

    public static void printSwimmersByCoach(ArrayList<Groups> groups, Staff coach) {
        
        System.out.println("\n======== Swimmers coached by "+ coach.getID() + " "+ coach.getfirstName()+ " " + coach.getSurname() + " " +coach.getRole() + " ========");
        for (Groups g: groups) {
            System.out.println(g.getGroupName() + Integer.toString(g.getGroupID()));
            for (Swimmers s: g.getSwimmers()) {
                System.out.println(s.toString());
            }
        }
        
    }
    
    public static void printAllCoach (ArrayList<Staff> coachList) {
        System.out.println("\n======== "+ Department.COACH.toString() +" ========");
        System.out.println("---------------------------------------------------------");
        System.out.println("[StaffID]/[Dept]/[Role]/[StaffName]/[QualLevel]/[Roaster]");
        System.out.println("---------------------------------------------------------");
        
        for (Staff s: coachList) {
            System.out.println(s.toString());
        }
    }
    
    public static void printAllSwimmers(ArrayList<Swimmers> swmmerList) {
        System.out.println("\n======== Swimmers ========");
        for (Swimmers s: swmmerList) {
            System.out.println(s.toString());
        }
    }
    
}
