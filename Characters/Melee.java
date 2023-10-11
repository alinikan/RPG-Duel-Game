package Characters;

import java.awt.*;

/**
 * This is an abstract class which extends the RPGCharacter class. It creates a Melee with name, strength, maxHP, position, maxEnergy, and currentEnergy.
 * The Melee can attack with the attack method.
 *
 * @author Ali Nikan
 */

public abstract class Melee extends RPGCharacter {
    private int maxEnergy;
    private int currentEnergy;

    /**
     * This a constructor for the Melee class. It creates a Melee with name, strength, intellect (set as 1), maxHP, position, maxEnergy, and currentEnergy set as maxEnergy.
     * @param name - String for the melee's name
     * @param strength - int for the melee's strength
     * @param maxHP - int for the melee's maxHP
     * @param position - Point for the melee's position
     * @param maxEnergy - the maximum amount of energy (int)
     */

    public Melee(String name, int strength, int maxHP, Point position, int maxEnergy){
        // use super to use the RPGCharacter's constructor and set intellect as 1
        super(name, 1, strength, maxHP, position);
        // set the maxEnergy instance variable to maxEnergy parameter
        this.maxEnergy = maxEnergy;
        // set the currentEnergy instance variable to maxEnergy parameter
        this.currentEnergy = maxEnergy;
    }

    public int getCurrentEnergy() {
        return currentEnergy;
    }

    /**
     * This method is used when the character wants to attack the target (RPGCharacter type) with melee and chooses a type of attack with an index (int) from the attackList
     * Return -1 if the index is not in the range of attackList
     * Return -2 if the target is not in the range of the attack
     * Return -3 if the currentEnergy is not enough for the attack's energy
     * If the attack is successful, interact with the target ( to deal damage on target), then, deduct the attack's energy from currentEnergy, and return it.
     * @param target - an RPGCharacter which is our target of the attack
     * @param attackIndex - an int which chooses which attack we're going to do between the list of our attacks.
     * @return targetCurrentHP - it is an integer which represents the target's HP after the attack.
     */

    public int attack(RPGCharacter target, int attackIndex){
        // if the index is negative or more than the attackList size, return -1
        if((attackIndex<0) || (attackIndex>=attackList.size())){
            return -1;
        }
        // calculate the distance between the target and the character
        double distance = this.getPosition().distance(target.getPosition());
        // calculate the range of the attack
        double range = attackList.get(attackIndex).getRange();
        // if their distance is more than the attack's range, return -2
        if(distance>range){
            return -2;
        }
        // if the currentEnergy is less than the attack's cost (energy to do the attack), return -3
        else if(currentEnergy<attackList.get(attackIndex).getCost()){
            return -3;
        }
        // else (if the attack is successful):
        else{
            // interact with target using interactWithTarget method of MeleeAttack class
            attackList.get(attackIndex).interactWithTarget(target, this.strength);
            // deduct the attack's energy from the currentEnergy of the character
            currentEnergy = currentEnergy - attackList.get(attackIndex).getCost();
        }
        // calculate the target's currentHP after the attack and then return it
        int targetCurrentHP = target.getCurrentHP();
        return targetCurrentHP;
    }
    public String toString(){
        return super.toString() + "\n" + String.format("Energy: %d/%d", currentEnergy, maxEnergy);
    }
}
