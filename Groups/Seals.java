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
public class Seals extends Groups{

    private int ID;
    private static int currentNum = 0;	//Start the group ID badges at 0
    
    //CONSTRUCTOR
    public Seals() {
        this.ID = generateIDBadge();
        this.identifier = getIdentifier();
    }
    
    private int generateIDBadge () {

        this.currentNum++;
        return this.currentNum;

    }
    
    @Override
    protected String getIdentifier() {
        return GroupType.SEALS.toString() + Integer.toString(this.ID);
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
        return GroupType.SEALS;
    }
    
    
}
