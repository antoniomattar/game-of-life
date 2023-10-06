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
 * {@link CellularAutomataSimulation} instances run <i>The Game of Life</i>.
 */
public class CellularAutomataSimulation<S extends State<S>>
        implements Simulation {

    private final CellGrid<S> grid;
    private final Supplier<S> supplier;
    private final S defaultState;
    private final ReadOnlyLongWrapper generationNumber = new ReadOnlyLongWrapper();

    /**
     * Creates a new {@code GameOfLife} instance given the underlying {@link CellGrid}.
     *
     * @param grid     the underlying {@link CellGrid}
     * @param defaultState   the state value to use when clearing the grid
     * @param supplier  a {@Link Supplier} to produce values to initialize or reset the grid
     * @throws NullPointerException if {@code grid} is {@code null}
     */
    public CellularAutomataSimulation(CellGrid<S> grid, S defaultState, Supplier<S> supplier) {
        this.grid = requireNonNull(grid, "grid is null");
        this.supplier = requireNonNull(supplier, "supplier is null");
        this.defaultState = requireNonNull(defaultState, "defaultState is null");
        grid.fillRandomly(this.supplier);
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
        grid.updateToNextGeneration();
        generationNumber.set(getGenerationNumber() + 1);
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
        return generationNumber.get();
    }

    /**
     * Returns the generationNumber {@link ReadOnlyLongProperty}.
     *
     * @return the generationNumber {@link ReadOnlyLongProperty}
     */
    public ReadOnlyLongProperty generationNumberProperty() {
        return generationNumber.getReadOnlyProperty();
    }


    /**
     * Clears the current game.
     */
    public void clear() {
        grid.clear(defaultState);
        generationNumber.set(0);
    }

    /**
     * Clears the current game and randomly generates a new one.
     */
    public void reset() {
        clear();
        grid.fillRandomly(supplier);
    }

    @Override
    public Iterator<Coordinate> iterator() {
        return this.grid.coordinates().iterator();
    }
}
