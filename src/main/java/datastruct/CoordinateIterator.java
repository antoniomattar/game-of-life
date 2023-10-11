package datastruct;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * An {@link Iterator} for generating 2D {@link Coordinate}s within a specified width and
 * height range.
 */
class CoordinateIterator implements Iterator<Coordinate> {

    /**
     * Creates a new {@link CoordinateIterator} with the specified width and height.
     *
     * @param width  The width of the coordinate range.
     * @param height The height of the coordinate range.
     */
    public CoordinateIterator(int width, int height) {
        // TODO: à compléter
    }

    /**
     * Checks if there are more {@link Coordinate}s to iterate over.
     *
     * @return true if there are more {@link Coordinate}s; otherwise, false.
     */
    @Override
    public boolean hasNext() {
        // TODO: à compléter
        return false;
    }

    /**
     * Returns the next {@link Coordinate} in the iteration.
     *
     * @return The next {@link Coordinate} in the iteration.
     * @throws NoSuchElementException if there are no more {@link Coordinate}s to iterate over.
     */
    @Override
    public Coordinate next() {
        // TODO: à compléter
        return null;
    }
}
