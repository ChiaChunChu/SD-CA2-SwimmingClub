/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Staffs;

import CoachStaffs.AssistantCoach;
import CoachStaffs.HeadCoach;
import CoachStaffs.SwimTeacher;
import AdminStaffs.Maintainer;
import AdminStaffs.Cleaner;
import AdminStaffs.Receptionist;
import NameGenerators.NameGenerator;
import java.util.ArrayList;

/**
 *
 * @author Chia Chun
 */
public enum StaffType {
    
    RECEPTIONIST {

        @Override
        public AdminStaff getStaff() {
            String[] name = generateName();
            return new Receptionist(name[0], name[1]);    
        }

        @Override
        public String toString() {
            return "Receptionist";
        }

        @Override
        public Department whichDept() {
            return Department.ADMIN;
        }

    },

    CLEANER {

        @Override
        public AdminStaff getStaff() {
            String[] name = generateName();
            return new Cleaner(name[0], name[1]); 
        }

        @Override
        public String toString() {
            return "Cleaner";
        }

        @Override
        public Department whichDept() {
            return Department.ADMIN;
        }

    },

    MAINTAINER {

        @Override
        public AdminStaff getStaff() {
            String[] name = generateName();
            return new Maintainer(name[0], name[1]); 
        }

        @Override
        public String toString() {
            return "Maintainer";
        }

        @Override
        public Department whichDept() {
            return Department.ADMIN;
        }

    },
    
    HEAD_COACH {

        @Override
        public CoachingStaff getStaff() {
            String[] name = generateName();
            return new HeadCoach(name[0], name[1]);
        }

        @Override
        public String toString() {
            return "Head Coach";
        }

        @Override
        public Department whichDept() {
            return Department.COACH;
        }

    },
    
    ASSISTANT_COACH {

        @Override
        public CoachingStaff getStaff() {
            String[] name = generateName();
            return new AssistantCoach(name[0], name[1]);
        }

        @Override
        public String toString() {
            return "Assistant Coach";
        }

        @Override
        public Department whichDept() {
            return Department.COACH;
        }

    },
    
    SWIM_TEACHER {
        
        @Override
        public CoachingStaff getStaff() {
            String[] name = generateName();
            return new SwimTeacher(name[0], name[1]);
        }
        
        @Override
        public String toString() {
            return "Swim Teacher";
        }

        @Override
        public Department whichDept() {
            return Department.COACH;
        }

    };
    
    public abstract Staff getStaff ();
    public abstract String toString ();
    public abstract Department whichDept();
    
    private static String[] generateName() {

            NameGenerator NG = new NameGenerator();

            String name = NG.getRandomName();

            return name.split(" ");
    }

    public static ArrayList<StaffType> listAdmins() {
        
        StaffType[] allTypes = StaffType.values();
        ArrayList<StaffType> admins = new ArrayList<StaffType>();
    
        for (StaffType s: allTypes) {
            if (s.whichDept() == Department.ADMIN) {
                admins.add(s);
            }
        }
        
        return admins;
    }

    public static ArrayList<StaffType> listCoaches() {
        
        StaffType[] allTypes = StaffType.values();
        ArrayList<StaffType> coaches = new ArrayList<StaffType>();
    
        for (StaffType s: allTypes) {
            if ((s.whichDept() == Department.COACH) && (s != StaffType.HEAD_COACH)) {
                coaches.add(s);
            }
        }
        
        return coaches;
    }

}
