package model;

import controller.Simulation;
import datastruct.Coordinate;
import datastruct.Matrix;
import javafx.beans.property.ReadOnlyLongProperty;
import javafx.beans.property.ReadOnlyLongWrapper;
import javafx.scene.paint.Color;
import java.util.Iterator;
import java.util.Random;
import java.util.function.Supplier;



/**
 * {@link CellularAutomatonSimulation} instances run <i>The Game of Life</i>.
 */
public class CellularAutomatonSimulation<S extends State<S>>
        implements Simulation {

    private final Matrix<Cell<S>> grid;
    private final ReadOnlyLongWrapper generationNumber = new ReadOnlyLongWrapper();
    private final CellularAutomaton<S> automaton;
    private final Random generator;

    /**
     * Creates a new {@link CellularAutomatonSimulation} instance for a given automaton.
     *
     * @param automaton         a description of the {@link CellularAutomaton}
     */
    public CellularAutomatonSimulation(CellularAutomaton<S> automaton, Random generator) {
        this.automaton = automaton;
        this.grid = new Matrix<>(
                automaton.numberOfColumns(),
                automaton.numberOfRows(),
                new ConstantCellInitializer<>(automaton.defaultState())
        );
        this.generator = generator;
    }

    /**
     * Goes through each {@link Cell} in this {@code CellGrid} and sets it states with a
     * state obtained from the supplier.
     *
     * @param generator {@link Random} instance used to generate a random state for each cell
     *                  {@link Cell}.
     */
    public void fillRandomly(Random generator) {
        for (Cell<S> cell : this.grid) {
            cell.set(this.automaton.randomState(generator));
        }
    }

    @Override
    public int numberOfColumns() {
        return this.grid.width();
    }

    @Override
    public int numberOfRows() {
        return this.grid.height();
    }

    public Cell<S> at(Coordinate coordinate) {
        return this.grid.get(coordinate);
    }

    public void updateToNextGeneration() {
        this.generationNumber.set(getGenerationNumber() + 1);
        Matrix<S> nextStates = this.nextGenerationMatrix();
        for (Coordinate coordinate : this.grid.coordinates()) {
            this.at(coordinate).set(nextStates.get(coordinate));
        }
    }
    /** Computes the {link Matrix} of states obtained after a single step of updates
     * of the simulation.
     *
     * @return the states of each cell after one generation
     */
    private Matrix<S> nextGenerationMatrix() {
        return new Matrix<S>(
                this.grid.width(),
                this.grid.height(),
                new NextGenerationInitializer<>(this)
        );
    }
    @Override
    public void next(Coordinate coordinate) {
        S oldState = this.grid.get(coordinate).get();
        this.at(coordinate).set(oldState.next());
    }

    @Override
    public void copy(Coordinate source, Coordinate destination) {
        System.out.println("bip (" + source + ") (" + destination + ")");
        S state = this.at(source).get();
        this.at(destination).set(state);
    }

    @Override
    public Color getColor(Coordinate coordinate) {
        return this.at(coordinate).get().getColor();
    }

    @Override
    public void setChangeListener(Coordinate coordinate, Runnable listener) {
        this.at(coordinate).addOnChangeListener(
                (oldValue, newValue) -> listener.run()
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
        for (Cell<S> cell : this.grid) {
            cell.set(this.automaton.defaultState());
        }
        this.generationNumber.set(0);
    }

    /**
     * Clears the current game and randomly generates a new one.
     */
    public void reset() {
        this.clear();
        this.fillRandomly(this.generator);
    }

    @Override
    public Iterator<Coordinate> iterator() {
        return this.grid.coordinates().iterator();
    }
}
