/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Staffs;

/**
 *
 * @author User
 */
public abstract class AdminStaff extends Staff {

    //CONSTRUCTOR
    public AdminStaff(String firstname, String surname, StaffType role) {
        super(firstname, surname, Department.ADMIN, role);
    }
    
}
