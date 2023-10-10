package model;

import datastruct.Lens;

import java.util.ArrayList;
import java.util.List;

/**
 * {@link Cell} instances represent the cells of the grid in a simulation of cellular automata.
 */

public class Cell<T> implements Lens<T> {
    private T content;
    private final List<OnChangeListener<T>> listeners = new ArrayList<>();

    /** Initialize a new cell with a given value.
     *
     * @param initialContent the value initially stored by the cell.
     */
    public Cell(T initialContent) {
        this.content = initialContent;
    }

    public void addOnChangeListener(OnChangeListener<T> listener) {
        this.listeners.add(listener);
    }

    /**
     * Sets the content of this {@link Cell}.
     *
     * @param value the new content of this {@link Cell}
     */
    public void set(T value) {
        this.content = value;
        for (OnChangeListener<T> listener : this.listeners) {
            listener.valueChanged(this.content, value);
        }
    }

    /**
     * Returns the current content of this {@link Cell}.
     *
     * @return the current content of this {@link Cell}
     */
    public T get(){
        return this.content;
    }


}
