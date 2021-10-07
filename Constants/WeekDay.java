/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Constants;

/**
 *
 * @author Chia Chun
 */
public enum WeekDay {
    
    MONDAY {
        @Override
        public String toString() {
            return "Monday";
        }
    },
    
    TUESDAY {
        @Override
        public String toString() {
            return "Tuesday";
        }
    },
    
    WEDNESDAY {
        @Override
        public String toString() {
            return "Wednesday";
        }
    },
    
    THURSDAY {
        @Override
        public String toString() {
            return "Thursday";
        }
    },
    
    FRIDAY {
        @Override
        public String toString() {
            return "Friday";
        }
    },
    
    SATURDAY {
        @Override
        public String toString() {
            return "Saturday";
        }
    },
    
    SUNDAY {
        @Override
        public String toString() {
            return "Sunday";
        }
    };
    
    public abstract String toString();
}
