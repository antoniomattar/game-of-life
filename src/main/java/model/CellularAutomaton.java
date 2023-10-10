package model;

import java.util.Random;

/**
 * Represents a cellular automaton, which defines the main parameters of a cellular automaton.
 * The rules for updating states are defined in the class used as {@code S}.
 *
 * @param <S> The type of state used in the cellular automaton.
 */
public interface CellularAutomaton<S extends State<S>> {

    /**
     * Returns the number of columns in the grid of the cellular automaton.
     *
     * @return The number of columns in the grid.
     */
    int numberOfColumns();

    /**
     * Returns the number of rows in the grid of the cellular automaton.
     *
     * @return The number of rows in the grid.
     */
    int numberOfRows();

    /**
     * Returns the default state that is used to initialize cells in the automaton.
     *
     * @return The default state for cells in the automaton.
     */
    S defaultState();


    /**
     * Generates a random state using the specified random number generator.
     *
     * @param generator The random number generator to use.
     * @return A randomly generated state.
     */
    S randomState(Random generator);
}