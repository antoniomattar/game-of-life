package model;

import javafx.scene.paint.Color;

import java.util.List;

/**
 * Represents a state of a cell in a cellular automaton, and the update rules for the cellular
 * automaton.
 *
 * @param <S> The type of state used in the cellular automaton.
 */
public interface State<S> {

    /**
     * Returns the color associated with this state.
     *
     * @return The color representing this state.
     */
    Color getColor();

    /**
     * Computes and returns the next state based on the rules of the cellular automaton.
     *
     * @return The next state.
     */
    S next();

    /**
     * Updates the state based on the states of its neighboring cells.
     *
     * @param neighbours A list of neighboring cell states.
     * @return The updated state based on the neighbors.
     */
    S update(List<State<S>> neighbours);

    /**
     * Counts the occurrences of a specific state within a list of neighboring states.
     *
     * @param <T>       The type of state to count.
     * @param state     The state to count occurrences of.
     * @param neighbours A list of neighboring states to search within.
     * @return The number of times the specified state appears in the list of neighbors.
     */
    static <T> int count(T state, List<T> neighbours) {
        int count = 0;
        for (T neighbour : neighbours) {
            if (neighbour.equals(state)) {
                count++;
            }
        }
        return count;
    }
}