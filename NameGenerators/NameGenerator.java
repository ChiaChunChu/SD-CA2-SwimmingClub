/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NameGenerators;

import java.util.Random;

/**
 *
 * @author User
 */
public class NameGenerator {
    
	protected String[] firstNames = {"Ken", "Tom", "Sally", "Pavel", "Priscilla", "Claudia", "Molly", "Elton", "Alan", 
            "Cathy", "Anna", "Linn", "Eion", "Jerry", "Joe", "Rose", "Morries", "Nicky", "Pablito", "Jeff", "Jeremy", "Tommy",
            "Amy", "Toffee", "Kelly", "Jess", "Nusa", "Franco", "John", "Billy", "Ben", "May", "Nacy", "Willy", "Luca", "Lily"};
	
	protected String[] surnames = {"Murphy", "Silva", "Smith", "Jones", "Carvalho", "Ernst", "Power", "Bacon", "Backer",
            "Babka", "Eason", "Eaddy", "Emm", "Endo", "Enciso", "Elbert", "Eiser", "Sacchetti", "Saban", "Sami", "Sammon", "Saran",
            "Tager", "Taha", "Tesson", "Teske", "Thums", "Tick", "Thyne", "Wafer", "Wan", "Warble", "Weil", "Westin", "Weston"};
	
	public NameGenerator() {
		
		//nothing here - deliberate
		
	}
	
	public String getRandomName() {
		//return a random name
		
		Random r = new Random();
		
		//pick a firstname and surname based on length of array
		String fname = this.firstNames[r.nextInt(firstNames.length)];
		String sname = this.surnames[r.nextInt(surnames.length)];
		
		return ( fname + " " + sname);
		
	}    
}
