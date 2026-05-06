package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.*;

public class GoldAppraiser implements ArtifactVisitor {
    private int totalValue = 0;

    @Override
    public void visit(Weapon weapon) {
        totalValue += weapon.getValue();
        System.out.println("  [Gold] " + weapon.getName() + " (Weapon): " + weapon.getValue() + " gold, +" + weapon.getAttackBonus() + " attack");
    }

    @Override
    public void visit(Potion potion) {
        totalValue += potion.getValue();
        System.out.println("  [Gold] " + potion.getName() + " (Potion): " + potion.getValue() + " gold, heals " + potion.getHealing());
    }

    @Override
    public void visit(Scroll scroll) {
        totalValue += scroll.getValue();
        System.out.println("  [Gold] " + scroll.getName() + " (Scroll): " + scroll.getValue() + " gold, spell: " + scroll.getSpellName());
    }

    @Override
    public void visit(Ring ring) {
        totalValue += ring.getValue();
        System.out.println("  [Gold] " + ring.getName() + " (Ring): " + ring.getValue() + " gold, +" + ring.getMagicBonus() + " magic");
    }

    @Override
    public void visit(Armor armor) {
        totalValue += armor.getValue();
        System.out.println("  [Gold] " + armor.getName() + " (Armor): " + armor.getValue() + " gold, +" + armor.getDefenseBonus() + " defense");
    }

    public int getTotalValue() {
        return totalValue;
    }
}