package Characters;

import Attacks.Attack;

import java.awt.*;
import java.util.ArrayList;

/**
 * This class acts like a core class. It makes an RPG Character with a name, maxHP, position, currentHP, intellect, strength
 * and a list of attacks. This character can attack, heal, and take damage.
 *
 * @author Ali Nikan
 */

public abstract class RPGCharacter {
    private String name;
    private int maxHP;
    private Point position;
    protected int currentHP;
    protected int intellect;
    protected int strength;
    protected ArrayList <Attack> attackList;

    /**
     * The constructor for RPGCharacter. It has five parameters (name, intellect, strength, maxHP, position). It sets the
     * character's currentHP to maxHP and makes a new list for attacks.
     *
     * @param name - String for the character's name
     * @param intellect - int for the character's intellect
     * @param strength - int for the character's strength
     * @param maxHP - int for the maximum amount of HP
     * @param position - Point for the character's position
     */

    public RPGCharacter(String name, int intellect, int strength, int maxHP, Point position){
        this.name = name;
        this.intellect = intellect;
        this.strength = strength;
        this.maxHP = maxHP;
        this.position = position;
        currentHP = maxHP;
        attackList = new ArrayList<>();
    }

    public int getCurrentHP(){
        return currentHP;
    }

    public Point getPosition() {
        return position;
    }

    public int getMaxHP() {
        return maxHP;
    }

    public String getName() {
        return name;
    }

    /**
     * This method has two parameters (x and y) and moves the character's position Points to the new Point (which are x and y)
     * @param x - the x of the new Point
     * @param y - the y of the new Point
     */

    public void move(int x, int y){
        // use the translate method to move a Point from one to another.
        position.translate(x,y);
    }

    /**
     * This method takes damage from character's currentHP. It has an integer parameter. The new currentHP would be currentHP - parameter
     * If the currentHP is negative or 0, return false. Otherwise, return true.
     * @param damageTaken - it is an int and currentHP would get deducted from it.
     * @return - boolean type. returns false if currentHP is negative or zero (Character is dead). Returns true otherwise (Character is alive).
     */

    public boolean takeDamage(int damageTaken){
        currentHP -= damageTaken;
        if(currentHP<=0){
            // set currentHP to 0 if it is negative or zero. It means the character is dead.
            currentHP = 0;
            return false;
        }
        return true;
    }

    /**
     * This method acts the opposite of the previous method. It has an int parameter which adds to the character's currentHP.
     * If the new currentHP is more than or equal to maxHP, set it to maxHP and return true (fully healed). Otherwise, return false (not fully healed).
     * @param healAmount - int type. It gets added to currentHP to heal the character.
     * @return - boolean type. returns true if the new currentHP is fully healed. Returns false otherwise.
     */

    public boolean heal(int healAmount){
        if ((healAmount+currentHP)>=maxHP){
            // Set currentHP to maxHP if it is more than or equal to maxHP.
            currentHP = maxHP;
            return true;
        }
        else{
            currentHP += healAmount;
            return false;
        }
    }

    /**
     * This is an abstract method which will be used in other classes. It attacks a target (RPGCharacter type for parameter) and
     * there is an attackIndex (int type for parameter) which every attack has to choose an attack from the list of attacks.
     * @param target - an RPGCharacter which is our target of the attack
     * @param attackIndex - an int which chooses which attack we're going to do between the list of our attacks.
     * @return - returns the target's new currentHP IF the attack is successful. (we'll see it in the next classes)
     */

    public abstract int attack(RPGCharacter target, int attackIndex);

    /**
     * This method returns a string of all the info about the attacks of the attackList.
     * @return - it is a string which is all the info of all the attacks that we have in our attackList.
     */

    public String getAttacks(){
        String result = "";
        // for loop to choose every index of attackList and print its info with toString() method of the Attack class. Then, add a new line for the next index.
        for(int i=0; i<attackList.size(); i++){
            result += (i + " - " + attackList.get(i).toString() + "\n");
        }
        return result;

    }

    public String toString(){
        return String.format("%s (%s) - %d/%d", name, this.getClass().getSimpleName(), currentHP, maxHP);
    }
}
