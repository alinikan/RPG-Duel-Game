package Characters;

import Attacks.Attack;
import Attacks.DamageSpell;
import Attacks.MeleeAttack;

import java.awt.*;

/**
 * This class creates a Mage which is a Caster (so Mage extends Caster). Mage has one MeleeAttack and three DamageSpell. We add all of them in the attackList in its constructor.
 *
 * @author Ali Nikan
 */

public class Mage extends Caster {

    /**
     * This is the constructor for Mage class. It creates a Mage with name, intellect, HP, position, Mana. Then, we add the Mage's special abilities to the attackList.
     * @param name - String for Mage's name
     * @param intellect - int for Mage's intellect
     * @param maxHP - int to set the maximum amount of HP
     * @param position - Point for Mage's position
     * @param maxMana - int to set the maximum amount of Mana
     */

    public Mage(String name, int intellect, int maxHP, Point position, int maxMana){
        // Use super to use the Caster's constructor to create a Mage (since Mage extends Caster)
        super(name,intellect,maxHP,position,maxMana);
        // Add Mage's special abilities to the attackList. One of them is a MeleeAttack and three are DamageSpell.
        attackList.add(new MeleeAttack(0, "Staff", 3, 3));
        attackList.add(new DamageSpell(20, "Fire Ball",10,20));
        attackList.add(new DamageSpell(15, "Frost Ball",7,15));
        attackList.add(new DamageSpell(30, "Lightning",15,20));
    }
}
