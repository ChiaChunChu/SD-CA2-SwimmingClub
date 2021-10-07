/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Swimmers;

/**
 *
 * @author Chia Chun
 */
public class Swimmers {
    private String firstname;
    private String surname;
    private int age;
    
    //CONSTRUCTOR
    public Swimmers (String firstname, String surname, int age) {
        this.firstname = firstname;
        this.surname = surname;
        this.age = age;
    }
    
    @Override
    public String toString() {
        return "Swimmer - " + this.firstname + " " + this.surname + " - " + age + " years old";
    }
    
}
