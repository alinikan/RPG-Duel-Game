package Characters;

import Attacks.MeleeAttack;

import java.awt.*;

/**
 * This class creates a Warrior which is a Melee (so Warrior extends Melee). Warrior has three MeleeAttack. We add them in the attackList in its constructor.
 *
 * @author Ali Nikan
 */

public class Warrior extends Melee{

    /**
     * This is the constructor for Warrior class. It creates a Warrior with name, strength, HP, position, Energy. Then, we add the Warrior's special abilities to the attackList.
     * @param name - String for Warrior's name
     * @param strength - int for Warrior's strength
     * @param maxHP - int to set the maximum amount of HP
     * @param position - Point for Warrior's position
     * @param maxEnergy - int to set the maximum amount of Energy
     */

    public Warrior(String name, int strength, int maxHP, Point position, int maxEnergy){
        // Use super to use the Melee's constructor to create a Warrior (since Warrior extends Melee)
        super(name, strength, maxHP, position, maxEnergy);
        // Add Warrior's special abilities to the attackList. There are three of them and all of them are MeleeAttack.
        attackList.add(new MeleeAttack(0, "Punch", 5, 3));
        attackList.add((new MeleeAttack(3, "Slam", 5, 3)));
        attackList.add((new MeleeAttack(20, "Charge", 30, 15)));
    }
}
