package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.*;

public class EnchantmentScanner implements ArtifactVisitor {

    @Override
    public void visit(Weapon weapon) {
        if (weapon.getAttackBonus() > 5) {
            System.out.println("  [Magic] " + weapon.getName() + " glows with powerful attack enchantment!");
        } else if (weapon.getAttackBonus() > 0) {
            System.out.println("  [Magic] " + weapon.getName() + " has a minor attack boost");
        } else {
            System.out.println("  [Magic] " + weapon.getName() + " has no magical aura");
        }
    }

    @Override
    public void visit(Potion potion) {
        if (potion.getHealing() > 30) {
            System.out.println("  [Magic] " + potion.getName() + " radiates strong healing energy!");
        } else {
            System.out.println("  [Magic] " + potion.getName() + " glows faintly");
        }
    }

    @Override
    public void visit(Scroll scroll) {
        System.out.println("  [Magic] " + scroll.getName() + " hums with " + scroll.getSpellName() + " magic!");
    }

    @Override
    public void visit(Ring ring) {
        if (ring.getMagicBonus() > 3) {
            System.out.println("  [Magic] " + ring.getName() + " shimmers with powerful magic!");
        } else {
            System.out.println("  [Magic] " + ring.getName() + " has a subtle magical presence");
        }
    }

    @Override
    public void visit(Armor armor) {
        if (armor.getDefenseBonus() > 8) {
            System.out.println("  [Magic] " + armor.getName() + " radiates protective magic!");
        } else if (armor.getDefenseBonus() > 0) {
            System.out.println("  [Magic] " + armor.getName() + " is lightly enchanted");
        } else {
            System.out.println("  [Magic] " + armor.getName() + " has no magical properties");
        }
    }
}