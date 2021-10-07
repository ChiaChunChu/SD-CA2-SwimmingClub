/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Utilities;

import Constants.WeekDay;
import Groups.GroupType;
import Staffs.StaffType;
import java.util.Scanner;

/**
 *
 * @author Chia Chun
 */
public class InputUtilities {


    /**
     * 
     * @param prompt
     * @return true:  exit the program
     *         fales: not exit the program
     */    
    public static boolean exitOrNot(String prompt) {
        Scanner myKB = new Scanner(System.in); 
        String input;
        boolean exitProgm = false;
        
        System.out.println(prompt);
        input = myKB.nextLine();
        input = input.trim();
        if (input.equalsIgnoreCase("Q")) {
            exitProgm = true;
        }
        return exitProgm;
        
    }
    
    public static int getUserInt(String question) {

        Scanner myKB = new Scanner(System.in); 
        String input;
        boolean isValidInt = false;
        
        do {
            System.out.print(question);            
            input = myKB.nextLine();
            input = input.trim();
                            
            if (!input.matches("[0-9]+")) {
                
                System.out.println("Please select the function by number\n");
                               
            } else {
                //
                // We got a valid number, escape the loop.
                //
                isValidInt = true;
            }

        } while (!isValidInt);
        
        return Integer.parseInt(input);
    }
    
    /*
       Method - Get the integer number from user input
        @param String question - A string to show to the user before user input.
        @param    int      min - The minimum value allows user input.
        @return   int          - The integer which user inputed.
    */    
    public static int getUserInt(String question, int min, int max) {

        Scanner myKB = new Scanner(System.in); 
        String input;
        boolean isValidInt = false;
        
        do {
            System.out.print(question);            
            input = myKB.nextLine();
            input = input.trim();
                            
            if (!input.matches("[0-9]+")) {
                
                System.out.println("Please select the function by number\n");
                
               
            } else if (Integer.parseInt(input) < min || Integer.parseInt(input) > max) {
                
                System.out.println("Your input out of range, please try again\n");

            } else {
                //
                // We got a valid number, escape the loop.
                //
                isValidInt = true;
            }

        } while (!isValidInt);
        
        return Integer.parseInt(input);
    }

    public static FunNumber getFunNumByInt(int userInput) {
        FunNumber FunNum;
        switch (userInput) {
            case 1:
                FunNum = FunNumber.FUNCTION1;
                break;
            case 2:
                FunNum = FunNumber.FUNCTION2;
                break;
            case 3:
                FunNum = FunNumber.FUNCTION3;
                break;
            case 4:
                FunNum = FunNumber.FUNCTION4;
                break;
            case 5:
                FunNum = FunNumber.FUNCTION5;
                break;
            case 6:
                FunNum = FunNumber.FUNCTION6;
                break;
            case 7:
                FunNum = FunNumber.FUNCTION7;
                break;
            case 8:
            default:
                FunNum = FunNumber.FUNCTION8;
                break;
        }
        return FunNum;
    }
    
    public static StaffType getStaffTypeByInt(int userInput) {
        StaffType role;
        switch (userInput) {
            case 1:
                role = StaffType.RECEPTIONIST;
                break;
            case 2:
                role = StaffType.CLEANER;
                break;
            case 3:
                role = StaffType.MAINTAINER;
                break;
            case 4:
                role = StaffType.HEAD_COACH;
                break;
            case 5:
                role = StaffType.ASSISTANT_COACH;
                break;
            case 6:
            default:
                role = StaffType.SWIM_TEACHER;
                break;
        }
        return role;
    }
    
    public static GroupType getGroupTypeByInt(int userInput) {
        GroupType type;
        switch (userInput) {
            case 1:
                type = GroupType.DOLPHIN;
                break;
            case 2:
                type = GroupType.SEALS;
                break;
            case 3:
            default:
                type = GroupType.TURTLES;
                break;
        }
        return type;
    }

    public static WeekDay getWeekDayByInt(int userInput) {
        WeekDay day;
        switch (userInput) {
            case 1:
                day = WeekDay.MONDAY;
                break;
            case 2:
                day = WeekDay.TUESDAY;
                break;
            case 3:
                day = WeekDay.WEDNESDAY;
                break;
            case 4:
                day = WeekDay.THURSDAY;
                break;
            case 5:
                day = WeekDay.FRIDAY;
                break;
            case 6:
                day = WeekDay.SATURDAY;
                break;
            case 7:
            default:
                day = WeekDay.SUNDAY;
                break;
                }
        return day;
    }

    
}
