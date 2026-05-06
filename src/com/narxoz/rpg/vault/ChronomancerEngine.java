package com.narxoz.rpg.vault;

import com.narxoz.rpg.combatant.Hero;
import java.util.List;
import com.narxoz.rpg.artifact.Artifact;
import com.narxoz.rpg.artifact.Armor;
import com.narxoz.rpg.artifact.Inventory;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.Ring;
import com.narxoz.rpg.artifact.Scroll;
import com.narxoz.rpg.artifact.Weapon;
import com.narxoz.rpg.memento.Caretaker;
import com.narxoz.rpg.visitor.CurseDetector;
import com.narxoz.rpg.visitor.EnchantmentScanner;
import com.narxoz.rpg.visitor.GoldAppraiser;
import com.narxoz.rpg.visitor.WeightCalculator;

/**
 * Orchestrates the Chronomancer's Vault demo run.
 */
public class ChronomancerEngine {
    private int artifactsAppraised = 0;
    private int mementosCreated = 0;
    private int restoredCount = 0;
    /**
     * Runs the vault sequence for the supplied party.
     *
     * @param party the heroes entering the vault
     * @return a placeholder result in the scaffold
     */
    public VaultRunResult runVault(List<Hero> party) {
        System.out.println("\n=== BREACHING THE CHRONOMANCER'S SANCTUM ===\n");

        for (Hero hero : party) {
            System.out.println(">> Champion: " + hero.getName());
            System.out.println("   [HP: " + hero.getHp() + " | Mana: " + hero.getMana() + " | Gold: " + hero.getGold() + "]");

            Inventory inventory = new Inventory();
            inventory.addArtifact(new Weapon("Wyrmbane Greatsword", 550, 10, 18));
            inventory.addArtifact(new Potion("Vial of Vitality", 60, 1, 50));
            inventory.addArtifact(new Scroll("Scroll of Blink", 120, 1, "Blink"));
            inventory.addArtifact(new Ring("Signet of the Magi", 250, 1, 8));
            inventory.addArtifact(new Armor("Adamantine Cuirass", 350, 12, 15));
            hero.setInventory(inventory);

            System.out.println("\n   [!] Appraising discovered artifacts...");

            GoldAppraiser goldAppraiser = new GoldAppraiser();
            inventory.accept(goldAppraiser);
            artifactsAppraised += inventory.size();
            System.out.println("       => Total market value: " + goldAppraiser.getTotalValue() + " coins");

            WeightCalculator weightCalc = new WeightCalculator();
            inventory.accept(weightCalc);
            System.out.println("       => Total encumbrance: " + weightCalc.getTotalWeight() + " kg");

            EnchantmentScanner scanner = new EnchantmentScanner();
            inventory.accept(scanner);

            CurseDetector curseDetector = new CurseDetector();
            inventory.accept(curseDetector);
            if (curseDetector.getCursedCount() > 0) {
                System.out.println("       /!\\ Danger: Found " + curseDetector.getCursedCount() + " cursed items!");
            }

            System.out.println("\n   [~] Initiating Time Crystal Protocol...");
            Caretaker caretaker = new Caretaker();

            com.narxoz.rpg.combatant.HeroMemento snapshot = hero.createMemento();
            caretaker.save(snapshot);
            mementosCreated++;
            System.out.println("       Chronological snapshot secured! (Vault size: " + caretaker.size() + ")");

            System.out.println("       *SNAP* A hidden trap severely wounds " + hero.getName() + "!");
            hero.takeDamage(35);
            hero.spendGold(40);
            System.out.println("       Post-trap status: HP=" + hero.getHp() + ", Gold=" + hero.getGold());

            com.narxoz.rpg.combatant.HeroMemento peek = caretaker.peek();
            System.out.println("       Checking temporal anomaly... " + (peek != null ? "Valid state found" : "Void"));

            com.narxoz.rpg.combatant.HeroMemento restored = caretaker.undo();
            if (restored != null) {
                hero.restoreFromMemento(restored);
                restoredCount++;
                System.out.println("       << Rewinding time... Vitality and wealth restored: HP=" + hero.getHp() + ", Gold=" + hero.getGold());
            }

            System.out.println("   [Final Status] HP=" + hero.getHp() + " | Mana=" + hero.getMana() + " | Gold=" + hero.getGold());
            System.out.println("--------------------------------------------------");
        }

        return new VaultRunResult(artifactsAppraised, mementosCreated, restoredCount);
    }
}
