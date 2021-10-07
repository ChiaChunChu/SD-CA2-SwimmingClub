/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Staffs;

/**
 *
 * @author Chia Chun
 */
public enum Department {

    ADMIN {
        @Override
        public String toString() {
            return "Admin Dept";
        }
    },
    COACH {
        @Override
        public String toString() {
            return "Coach Dept";
        }
    };
    
    public abstract String toString();
}
