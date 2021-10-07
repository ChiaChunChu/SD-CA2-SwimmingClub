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
public class Dolphin extends Groups {

    private int ID;
    private static int currentNum = 0;	//Start the group ID badges at 0
    
    //CONSTRUCTOR
    public Dolphin() {
        
        this.ID = genIDBadge();
        this.identifier = getIdentifier();
    }
    
    private int genIDBadge () {

        this.currentNum++;
        return this.currentNum;

    }
    
    @Override
    public String getIdentifier() {
        return GroupType.DOLPHIN.toString() + Integer.toString(this.ID);
    }

    @Override
    public String toString() {
        return this.identifier + " " + this.trainDay.toString();
    }

    @Override
    public int getGroupID() {
        return this.ID;
    }

    @Override
    public GroupType getGroupName() {
        return GroupType.DOLPHIN;
    }
    
    
}
