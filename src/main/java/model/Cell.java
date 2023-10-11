package model;

import datastruct.Lens;

import java.util.ArrayList;
import java.util.List;


/**
 * A class representing a cell that holds a value and allows adding listeners to track value changes.
 *
 * @param <T> The type of value stored in the cell.
 */
public class Cell<T> implements Lens<T> {

    //TODO: ajouter la ou les propriétés nécessaires

    // la liste des objets écoutant les modifications du contenu de la cellule
    private final List<OnChangeListener<T>> listeners = new ArrayList<>();

    /** Initialize a new cell with a given value.
     *
     * @param initialContent the value initially stored by the cell.
     */
    public Cell(T initialContent) {
        //TODO: à compléter
    }

    /** Add a {@link OnChangeListener} to react to any change of value in the cell.
     *
     * @param listener the {@link OnChangeListener} to activate when the value in the cell is
     *                 changed.
     */
    public void addOnChangeListener(OnChangeListener<T> listener) {
        this.listeners.add(listener);
    }

    /**
     * Sets the content of this {@link Cell}. This will also call all the listeners that were
     * registered by the method {@code addOnChangeListener}.
     *
     * @param value the new content of this {@link Cell}
     */
    public void set(T value) {
        //TODO: modifier le contenu de la cellule, puis appeler les méthodes valueChanged des
        // listeners
    }

    /**
     * Returns the current content of this {@link Cell}.
     *
     * @return the current content of this {@link Cell}
     */
    public T get(){
        //TODO: à compléter
        return null;
    }
}
