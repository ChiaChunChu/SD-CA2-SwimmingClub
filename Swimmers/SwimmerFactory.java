/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package Swimmers;

import Constants.Constants;
import NameGenerators.NameGenerator;
import java.util.Random;

/**
 *
 * @author Chia Chun
 */
public class SwimmerFactory {

    public Swimmers getSwimmer () {
        Random r = new Random();
        int age = r.nextInt(Constants.SWIMMERS_MAX_AGE - Constants.SWIMMERS_MIN_AGE) + Constants.SWIMMERS_MIN_AGE + 1;
        String[] name = generateName();
        return new Swimmers(name[0], name[1], age);   
    }

    private static String[] generateName() {

            NameGenerator NG = new NameGenerator();

            String name = NG.getRandomName();

            return name.split(" ");
    }


}
