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
public abstract class Staff {
    
    protected int staffID;
    protected String firstname;
    protected String surname;
    protected Department dept;
    protected StaffType role;
	
    private static int currentStaffNumber = 1000;	//Start the staff ID badges at 1000
    
    //CONSTRUCTOR
    public Staff(String firstname, String surname, Department dept, StaffType role) {
        this.staffID = generateIDBadge();
        this.firstname = firstname;
        this.surname = surname;
        this.dept = dept;
        this.role = role;
    }
    
    private int generateIDBadge () {

        this.currentStaffNumber++;
        return this.currentStaffNumber;

    }
    

    @Override
    //return the staff member's name in full
    public String toString () {

        return this.firstname + " " + this.surname;
    }

    public int getID () {
        
        return this.staffID;
    }
    
    public Department getDept () {

        return this.dept;
    }
    
    public StaffType getRole () {

        return this.role;
    }

    public String getfirstName () {

        return this.firstname;
    }

    public String getSurname () {

        return this.surname;
    }

}
