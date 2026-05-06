package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.*;

public class CurseDetector implements ArtifactVisitor {
    private int cursedCount = 0;

    @Override
    public void visit(Weapon weapon) {
        if (weapon.getAttackBonus() < 0) {
            System.out.println("  [Curse] " + weapon.getName() + " is CURSED! Negative attack bonus!");
            cursedCount++;
        }
    }

    @Override
    public void visit(Potion potion) {
        if (potion.getHealing() < 0) {
            System.out.println("  [Curse] " + potion.getName() + " is CURSED! It damages instead of healing!");
            cursedCount++;
        }
    }

    @Override
    public void visit(Scroll scroll) {
        if (scroll.getSpellName().contains("Doom") || scroll.getSpellName().contains("Decay")) {
            System.out.println("  [Curse] " + scroll.getName() + " contains a forbidden curse spell!");
            cursedCount++;
        }
    }

    @Override
    public void visit(Ring ring) {
        if (ring.getMagicBonus() < 0) {
            System.out.println("  [Curse] " + ring.getName() + " is CURSED! It weakens the wearer!");
            cursedCount++;
        }
    }

    @Override
    public void visit(Armor armor) {
        if (armor.getDefenseBonus() < 0) {
            System.out.println("  [Curse] " + armor.getName() + " is CURSED! It offers no protection!");
            cursedCount++;
        }
    }

    public int getCursedCount() {
        return cursedCount;
    }
}