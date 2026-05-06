package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.*;

public class WeightCalculator implements ArtifactVisitor {
    private int totalWeight = 0;

    @Override
    public void visit(Weapon weapon) {
        totalWeight += weapon.getWeight();
        System.out.println("  [Weight] " + weapon.getName() + " weighs " + weapon.getWeight() + " kg");
    }

    @Override
    public void visit(Potion potion) {
        totalWeight += potion.getWeight();
        System.out.println("  [Weight] " + potion.getName() + " weighs " + potion.getWeight() + " kg");
    }

    @Override
    public void visit(Scroll scroll) {
        totalWeight += scroll.getWeight();
        System.out.println("  [Weight] " + scroll.getName() + " weighs " + scroll.getWeight() + " kg");
    }

    @Override
    public void visit(Ring ring) {
        totalWeight += ring.getWeight();
        System.out.println("  [Weight] " + ring.getName() + " weighs " + ring.getWeight() + " kg");
    }

    @Override
    public void visit(Armor armor) {
        totalWeight += armor.getWeight();
        System.out.println("  [Weight] " + armor.getName() + " weighs " + armor.getWeight() + " kg");
    }

    public int getTotalWeight() {
        return totalWeight;
    }
}