package Characters;

import Attacks.*;

import java.awt.*;

/**
 * This class creates a Priest which is a Caster (so Priest extends Caster). Priest has one MeleeAttack, one DamageSpell, one HealingSpell, and the ability to do Resurrection. We add all of them in the attackList in its constructor.
 *
 * @author Ali Nikan
 */

public class Priest extends Caster {

    /**
     * This is the constructor for Priest class. It creates a Priest with name, intellect, HP, position, Mana. Then, we add the Priest's special abilities to the attackList.
     * @param name - String for Priest's name
     * @param intellect - int for Priest's intellect
     * @param maxHP - int to set the maximum amount of HP
     * @param position - Point for Priest's position
     * @param maxMana - int to set the maximum amount of Mana
     */

    public Priest(String name, int intellect, int maxHP, Point position, int maxMana) {
        // Use super to use the Caster's constructor to create a Priest (since Priest extends Caster)
        super(name,intellect,maxHP,position,maxMana);
        // Add Priest's special abilities to the attackList. One of them is a MeleeAttack, one DamageSpell, one HealingSpell, and the ability to do Resurrection.
        attackList.add(new MeleeAttack(0, "Wand", 3,3));
        attackList.add(new DamageSpell(10,"Smite",10,7));
        attackList.add(new HealingSpell(20,"Flash Heal",15,15));
        attackList.add(new Resurrection());
    }
}
