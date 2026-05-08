package com.narxoz.rpg;

import com.narxoz.rpg.artifact.*;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;

import java.util.ArrayList;
import java.util.List;

/**
 * Demo launcher for Homework 9:
 * Visitor + Memento patterns.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("=== Chronomancer's Vault Simulation ===");

        Inventory knightInventory = new Inventory();
        knightInventory.addArtifact(new Weapon("Knight Blade", 110, 6, 14));
        knightInventory.addArtifact(new Armor("Guardian Armor", 180, 12, 18));
        knightInventory.addArtifact(new Potion("Greater Heal", 60, 1, 25));
        knightInventory.addArtifact(new Ring("Ring of Strength", 140, 1, 7));
        knightInventory.addArtifact(new Scroll("Lightning Scroll", 90, 1, "Chain Lightning"));

        Inventory mageInventory = new Inventory();
        mageInventory.addArtifact(new Weapon("Magic Staff", 75, 3, 9));
        mageInventory.addArtifact(new Armor("Cloth Robe", 40, 4, 4));
        mageInventory.addArtifact(new Potion("Mana Potion", 35, 1, 15));
        mageInventory.addArtifact(new Ring("Ancient Ring", 95, 1, 4));
        mageInventory.addArtifact(new Scroll("Ice Scroll", 85, 1, "Frozen Storm"));

        Hero knight = new Hero(
                "Leon",
                130,
                40,
                18,
                14,
                150,
                knightInventory
        );

        Hero mage = new Hero(
                "Selena",
                85,
                120,
                11,
                6,
                250,
                mageInventory
        );

        List<Hero> team = new ArrayList<>();
        team.add(knight);
        team.add(mage);

        ChronomancerEngine vaultEngine = new ChronomancerEngine();
        VaultRunResult vaultResult = vaultEngine.runVault(team);

        System.out.println("\n=== Vault Expedition Result ===");
        System.out.println(vaultResult);
    }
}