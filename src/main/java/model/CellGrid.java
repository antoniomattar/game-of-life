package model;

import datastruct.Coordinate;
import datastruct.Lens;
import datastruct.Matrix;

import java.util.Iterator;
import java.util.function.Supplier;


/**
 * {@link CellGrid} instances represent the grid in <i>The Game of Life</i>.
 */
public class CellGrid<S extends State<S>> implements Iterable<Cell<S>> {

    private final int numberOfRows;
    private final int numberOfColumns;
    private final Matrix<Cell<S>> cells;

    /**
     * Creates a new {@code Grid} instance given the number of rows and columns.
     *
     * @param numberOfColumns the number of columns
     * @param numberOfRows    the number of rows
     * @throws IllegalArgumentException if {@code numberOfRows} or {@code numberOfColumns} are
     *                                  less than or equal to 0
     */
    public CellGrid(int numberOfColumns, int numberOfRows, S defaultState) {
        this.numberOfRows = numberOfRows;
        this.numberOfColumns = numberOfColumns;
        this.cells = new Matrix<>(numberOfColumns, numberOfRows, coord -> new Cell<>(defaultState));
    }


    public boolean contains(Coordinate coordinate) {
        return (coordinate.x() >= 0)
                && (coordinate.x() < this.numberOfColumns)
                && (coordinate.y() > 0)
                && (coordinate.y() <= this.numberOfRows);
    }


    /**
     * Returns an iterator over the cells in this {@code Grid}.
     *
     * @return an iterator over the cells in this {@code Grid}
     */
    @Override
    public Iterator<Cell<S>> iterator() {
        return this.cells.iterator();
    }

    public Iterable<Coordinate> coordinates() {
        return this.cells.coordinates();
    }

    public Lens<S> at(Coordinate coord) {
        return new CellLens<>(this.cellAt(coord));
    }


    public Cell<S> cellAt(Coordinate coord) {
        return this.cells.at(coord).get();
    }

    private Coordinate wrap(Coordinate coordinate) {
        return new Coordinate(
                 modulo(coordinate.x(), getNumberOfColumns()),
                 modulo(coordinate.y(), getNumberOfRows())
                );
    }

    private static int modulo(int n, int d) {
        int result = n % d;
        return n < 0 ? result + d : result;
    }
    public Lens<S> atWrapped(Coordinate coord) {
        return this.at(wrap(coord));
    }

    public Cell<S> cellAtWrapped(Coordinate coord) {
        return this.cellAt(wrap(coord));
    }

    /**
     * Returns the number of rows in this {@code Grid}.
     *
     * @return the number of rows in this {@code Grid}
     */
    public int getNumberOfRows() {
        return numberOfRows;
    }

    /**
     * Returns the number of columns in this {@code Grid}.
     *
     * @return the number of columns in this {@code Grid}
     */
    public int getNumberOfColumns() {
        return numberOfColumns;
    }




    private Matrix<S> nextGenerationMatrix() {
        return new Matrix<>(
                this.numberOfColumns,
                this.numberOfRows,
                new OneStepMatrixInitializer<>(this)
        );
    }

    /**
     * Transitions all {@link Cell}s in this {@code Grid} to the next generation.
     *
     * <p>The following rules are applied:
     * <ul>
     * <li>Any live {@link Cell} with fewer than two live neighbours dies, i.e. underpopulation.</li>
     * <li>Any live {@link Cell} with two or three live neighbours lives on to the next
     * generation.</li>
     * <li>Any live {@link Cell} with more than three live neighbours dies, i.e. overpopulation.</li>
     * <li>Any dead {@link Cell} with exactly three live neighbours becomes a live cell, i.e.
     * reproduction.</li>
     * </ul>
     */
    // TODO: Écrire une version correcte de cette méthode.
    public void updateToNextGeneration() {
        Matrix<S> nextStates = this.nextGenerationMatrix();
        for (Coordinate coordinate : this.coordinates()) {
            this.cellAt(coordinate).setState(nextStates.get(coordinate));
        }
    }


    /**
     * Sets all {@link Cell}s in this {@code Grid} as dead.
     */
    // TODO: Écrire une version correcte de cette méthode.
    public void clear(S clearState) {
        for (Cell<S> cell : this) {
            cell.setState(clearState);
        }
    }


    /**
     * Goes through each {@link Cell} in this {@code Grid} and sets it states with a
     * state obtained from the supplier.
     *
     * @param supplier {@link Supplier} instance used to decide a state for each cell {@link Cell}.
     * @throws NullPointerException if {@code supplier} is {@code null}.
     */
    // TODO: Écrire une version correcte de cette méthode.
    public void fillRandomly(Supplier<S> supplier) {
        for (Cell<S> cell : this) {
            cell.setState(supplier.get());
        }
    }
}
