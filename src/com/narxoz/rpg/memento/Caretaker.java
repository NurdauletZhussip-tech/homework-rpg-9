package com.narxoz.rpg.memento;
import java.util.Stack;
import com.narxoz.rpg.combatant.HeroMemento;

/**
 * Stores hero snapshots for the Chronomancer's Vault rewind mechanic.
 *
 * This class intentionally sits in a different package from {@link HeroMemento}
 * so it can only treat mementos as opaque values.
 */
public class Caretaker {
    private final Stack<HeroMemento> history = new Stack<>();
    public void save(HeroMemento memento) {
        if (memento != null) {
            history.push(memento);
        }    }

    /**
     * Removes and returns the most recent snapshot.
     *
     * @return the latest stored snapshot, or null in the scaffold
     */
    public HeroMemento undo() {
        if (history.isEmpty()) {
            return null;
        }
        return history.pop();
    }

    /**
     * Returns the most recent snapshot without removing it.
     *
     * @return the latest stored snapshot, or null in the scaffold
     */
    public HeroMemento peek() {
        if (history.isEmpty()) {
            return null;
        }
        return history.peek();
    }

    /**
     * Reports how many snapshots are stored.
     *
     * @return the number of saved snapshots
     */
    public int size() {
        return history.size();
    }
}
