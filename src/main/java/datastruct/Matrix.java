package datastruct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


/**
 * Represents a matrix, a rectangular array, with generic values in each cell.
 *
 * @param <T> The type of values stored in the matrix cells.
 */
public class Matrix<T> implements Iterable<T> {

    private final List<List<T>> matrix;
    private final int width;
    private final int height;

    /**
     * Creates a new {@link Matrix} with the specified width, height, and an initializer to set
     * values.
     *
     * @param width       The width of the {@link Matrix}.
     * @param height      The height of the {@link Matrix}.
     * @param initializer A matrix initializer to set values in the {@link Matrix}.
     */
    public Matrix(int width, int height, MatrixInitializer<T> initializer) {
        this.width = width;
        this.height = height;
        this.matrix = new ArrayList<>();
        this.initializeWith(initializer);
    }

    /**
     * Creates a new {@link Matrix} with the specified width, height, and initial value for all
     * cells.
     *
     * @param width        The width of the {@link Matrix}.
     * @param height       The height of the {@link Matrix}.
     * @param initialValue The initial value to set in all cells of the {@link Matrix}.
     */
    public Matrix(int width, int height, T initialValue) {
        this(width, height, new ConstantMatrixInitializer<>(initialValue));
    }

    private void initializeWith(MatrixInitializer<T> initializer) {
        for (int x = 0; x < width; x++) {
            List<T> row = new ArrayList<>();
            this.matrix.add(row);
            for (int y = 0; y < height; y++) {
                row.add(initializer.initialValueAt(Coordinate.of(x, y)));
            }
        }
    }

    /**
     * Returns the width of the {@link Matrix}.
     *
     * @return The width of the {@link Matrix}.
     */
    public int width() {
        return width;
    }

    /**
     * Returns the height of the {@link Matrix}.
     *
     * @return The height of the {@link Matrix}.
     */
    public int height() {
        return height;
    }

    /**
     * Gets the value at the specified coordinates (x, y) in the {@link Matrix}.
     *
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     * @return The value at the specified coordinates.
     */
    public T get(int x, int y) {
        return this.matrix.get(x).get(y);
    }

    /**
     * Gets the value at the specified {@link Coordinate} in the {@link Matrix}.
     *
     * @param coordinate The {@link Coordinate}.
     * @return The value at the specified {@link Coordinate}.
     */
    public T get(Coordinate coordinate) {
        return this.get(coordinate.x(), coordinate.y());
    }

    /**
     * Sets the value at the specified coordinates (x, y) in the {@link Matrix}.
     *
     * @param x     The x-coordinate.
     * @param y     The y-coordinate.
     * @param value The value to set at the specified coordinates.
     */
    public void set(int x, int y, T value) {
        this.matrix.get(x).set(y, value);
    }


    /**
     * Sets the value at the specified {@link Coordinate} in the {@link Matrix}.
     *
     * @param coordinate The {@link Coordinate}.
     * @param value      The value to set at the specified {@link Coordinate}.
     */
    public void set(Coordinate coordinate, T value) {
        this.set(coordinate.x(), coordinate.y(), value);
    }

    /**
     * Returns an {@link Iterator} that allows iterating over the elements in the {@link Matrix} in
     * row-major order.
     *
     * @return An {@link Iterator} for the {@link Matrix}.
     */
    public Iterator<T> iterator() {
        Iterator<Coordinate> coordIterator = this.coordinatesIterator();
        return new MatrixIterator<>(this, coordIterator);
    }

    /**
     * Returns an {@link Iterable} that provides access to the {@link Coordinate}s of the
     * {@link Matrix} in row-major order. This means that a {@code for} loop on a {@link Matrix}
     * will loop over the coordinates of the {@link Matrix}.
     *
     * @return An {@link Iterable} for the {@link Coordinate}s of the {@link Matrix}.
     */
    public Iterable<Coordinate> coordinates() {
        return this::coordinatesIterator;
    }

    /**
     * Returns an {@link Iterator} that allows iterating over the {@link Coordinate}s in the
     * {@link Matrix} in row-major order.
     *
     * @return An {@link Iterator} for the {@link Matrix}.
     */
    private Iterator<Coordinate> coordinatesIterator() {
        return new CoordinateIterator(this.width, this.height);
    }

    /**
     * Returns a lens for accessing and modifying the value at the specified coordinates (x, y) in
     * the {@link Matrix}.
     *
     * @param x The x-coordinate.
     * @param y The y-coordinate.
     * @return A lens for the specified coordinates.
     */
    public Lens<T> at(int x, int y) {
        return new Lens<T>() {
            @Override
            public T get() {
                return Matrix.this.get(x, y);
            }

            @Override
            public void set(T value) {
                Matrix.this.set(x, y, value);
            }
        };
    }

    /**
     * Returns a lens for accessing and modifying the value at the specified coordinate in the
     * {@link Matrix}.
     *
     * @param coordinate The {@link Coordinate}.
     * @return A lens for the specified  {@link Coordinate}.
     */
    public Lens<T> at(Coordinate coordinate) {
        return this.at(coordinate.x(), coordinate.y());
    }

}
