package model;

import controller.Simulation;
import datastruct.Coordinate;
import javafx.beans.property.ReadOnlyLongProperty;
import javafx.beans.property.ReadOnlyLongWrapper;
import javafx.scene.paint.Color;

import java.util.Iterator;
import java.util.function.Supplier;

import static java.util.Objects.requireNonNull;

/**
 * {@link CellularAutomatonSimulation} instances run <i>The Game of Life</i>.
 */
public class CellularAutomatonSimulation<S extends State<S>>
        implements Simulation {

    private final CellGrid<S> grid;
    private final Supplier<S> randomState;
    private final S defaultState;
    private final ReadOnlyLongWrapper generationNumber = new ReadOnlyLongWrapper();

    /**
     * Creates a new {@code CellularAutomataSimulation} instance for a given automaton.
     *
     * @param width         an {@code int} representing the number of columns
     * @param height        an {@code int} representing the number of rows
     * @param defaultState  a state {@code S} used to fill the grid when using
     *                      the clear action
     * @param randomState  a generator of states {@code} used to fill the grid
     *                      when using the reset action
     */
    public CellularAutomatonSimulation(int width, int height, S defaultState, Supplier<S> randomState) {
        this.grid = new CellGrid<>(width, height, defaultState);
        this.defaultState = defaultState;
        this.randomState = randomState;
        grid.fillRandomly(randomState);
    }



    @Override
    public int numberOfColumns() {
        return this.grid.getNumberOfColumns();
    }

    @Override
    public int numberOfRows() {
        return this.grid.getNumberOfRows();
    }

    /**
     * Transitions into the next generationNumber.
     */
    @Override
    public void updateToNextGeneration() {
        this.grid.updateToNextGeneration();
        this.generationNumber.set(getGenerationNumber() + 1);
    }

    @Override
    public void next(Coordinate coordinate) {
        this.grid.cellAt(coordinate).toggleState();
    }

    @Override
    public void copy(Coordinate source, Coordinate destination) {
        S state = this.grid.at(source).get();
        this.grid.at(destination).set(state);
    }

    @Override
    public Color getColor(Coordinate coordinate) {
        return this.grid.at(coordinate).get().getColor();
    }

    @Override
    public void setChangeListener(Coordinate coordinate, Runnable runnable) {
        this.grid.cellAt(coordinate).getStateProperty().addListener(
                (obs,oldV,newV) -> runnable.run()
        );
    }


    /**
     * Returns the current generationNumber.
     *
     * @return the current generationNumber
     */
    private long getGenerationNumber() {
        return this.generationNumber.get();
    }

    /**
     * Returns the generationNumber {@link ReadOnlyLongProperty}.
     *
     * @return the generationNumber {@link ReadOnlyLongProperty}
     */
    public ReadOnlyLongProperty generationNumberProperty() {
        return this.generationNumber.getReadOnlyProperty();
    }


    /**
     * Clears the current game.
     */
    public void clear() {
        this.grid.clear(this.defaultState);
        this.generationNumber.set(0);
    }

    /**
     * Clears the current game and randomly generates a new one.
     */
    public void reset() {
        this.clear();
        this.grid.fillRandomly(this.randomState);
    }

    @Override
    public Iterator<Coordinate> iterator() {
        return this.grid.coordinates().iterator();
    }
}
