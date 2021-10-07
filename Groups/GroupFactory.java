/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Groups;

import java.util.Random;

/**
 *
 * @author Chia Chun
 */
public class GroupFactory {

    public Groups getGroupFromFactory() {
        Random r = new Random();
        return GroupType.values()[r.nextInt(GroupType.values().length)].getGroup();
    }
    
}
