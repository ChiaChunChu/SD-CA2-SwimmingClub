/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Groups;


/**
 *
 * @author Chia Chun
 */
public enum GroupType {
    
    DOLPHIN {
        @Override
        public String toString() {
            return "Dolphin";
        }

        @Override
        public Groups getGroup() {
            return new Dolphin();
        }
    },
    
    SEALS {
        @Override
        public String toString() {
            return "Seals";
        }

        @Override
        public Groups getGroup() {
            return new Seals();
        }
    },
    
    TURTLES {
        @Override
        public String toString() {
            return "Turtles";
        }

        @Override
        public Groups getGroup() {
            return new Turtles();
        }
    };
    
    public abstract String toString();
    public abstract Groups getGroup();
}
