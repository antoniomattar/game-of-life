package model;

import javafx.beans.property.Property;
import javafx.beans.property.SimpleObjectProperty;
import javafx.scene.paint.Color;

/**
 * {@link Cell} instances represent the cells of <i>The Game of Life</i>.
 */

public class Cell<S extends State<S>> {
    private final Property<S> stateProperty;

    public Cell(S initialState) {
        this.stateProperty = new SimpleObjectProperty<>(initialState);
    }

    /**
     * Determines the color associated with the state in which
     * this {@link Cell} is.
     *
     * @return the {@link Color} associated with the state in
     * which this {@link Cell} is
     */

    public Color getColor() {
        return this.getState().getColor();
    }

    /**
     * Sets the state of this {@link Cell}.
     *
     * @param state the new state of this {@link Cell}
     */

    public void setState(S state) {
        getStateProperty().setValue(state);
    }

    /**
     * Returns the current state of this {@link Cell}.
     *
     * @return the current state of this {@link Cell}
     */

    public S getState(){
        return getStateProperty().getValue();
    }

    /**
     * Change the state of this {@link Cell} to the next possible state.
     */

    public void toggleState() {
        setState(getState().next());
    }

    /**
     * Returns this {@link Cell}'s state property.
     *
     * @return this {@link Cell}'s state property.
     */
    public Property<S> getStateProperty() {
        return stateProperty;
    }

}
