package matrix;

/**
 * An interface for initializing a {@link ListMatrix} by providing initial values for each cell.
 *
 * @param <T> The type of values to initialize the {@link ListMatrix} with.
 */
public interface MatrixInitializer<T> {

    /**
     * Returns the initial value to be set in a {@link ListMatrix} cell at the specified
     * {@link Coordinate}.
     *
     * @param coordinate The {@link Coordinate} at which to set the initial value.
     * @return The initial value for the specified cell.
     */
    T initialValueAt(Coordinate coordinate);
}
