package Characters;
import Attacks.*;
import java.awt.*;

/**
 * This class is an abstract class which is extends the RPGCharacter class. It creates a Caster with name, intellect, maxMana, position, maxMana, and currentMana.
 * The caster can attack with the attack method.
 *
 * @author Ali Nikan
 */

public abstract class Caster extends RPGCharacter {
    private int maxMana;
    private int currentMana;

    /**
     * This is a constructor for the Caster class. It creates a caster with name, intellect, currentMana (set as maxMana) , strength set as 1, and a position.
     * @param name - String for the caster's name
     * @param intellect - int for the caster's intellect
     * @param maxHP - the maximum HP for caster (int)
     * @param position - Point for the caster's position
     * @param maxMana - the maximum Mana for caster (int)
     */

    public Caster(String name, int intellect, int maxHP, Point position, int maxMana){
        // use super to use the RPGCharacter class constructor. Set strength to 1.
        super(name, intellect, 1, maxHP, position);
        // set the maxMana instance variable to maxMana parameter
        this.maxMana = maxMana;
        // set the currentMana instance variable to maxMana parameter
        this.currentMana = maxMana;

    }

    public int getCurrentMana() {
        return currentMana;
    }

    /**
     * This method is used when the character wants to attack the target (RPGCharacter type) with Caster and chooses a type of attack with an index (int) from the attackList
     * Return -1 if the index is not in the range of attackList
     * Return -2 if the target is not in the range of the attack
     * Return -3 if the currentMana is not enough for the attack's energy
     * If the attack is successful, deduct the attack's energy from currentMana and see what type of attack it is, then interact with the target depending on what type of attack you're doing.
     * Then, return the target's currentHP
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
        // if the currentMana is less than the attack's cost (energy to do the attack), return -3
        else if(currentMana<attackList.get(attackIndex).getCost()){
            return -3;
        }
        // else (if the attack is successful):
        else{
            // deduct the attack's cost (energy) from currentMana of the character
            currentMana = currentMana - attackList.get(attackIndex).getCost();
            // if the attack is an instance of HealingSpell:
            if(attackList.get(attackIndex) instanceof HealingSpell){
                // interact with target based on its method in the HealingSpell class
                attackList.get(attackIndex).interactWithTarget(this, intellect);
            }
            // if the attack is an instance of DamageSpell:
            else if(attackList.get(attackIndex) instanceof DamageSpell){
                // interact with target based on its method in the DamageSpell class
                attackList.get(attackIndex).interactWithTarget(target, intellect);
            }
            // else (non-spell attacks):
            else{
                // interact with target and pass 0 as the modifier
                attackList.get(attackIndex).interactWithTarget(target, 0);
            }
        }
        // calculate the target's currentHP after the attack and then return it
        int targetCurrentHP = target.getCurrentHP();
        return targetCurrentHP;

    }

    public String toString(){
       return super.toString() + "\n" + String.format("Mana: %d/%d", currentMana, maxMana);
    }
}
