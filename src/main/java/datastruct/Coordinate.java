package datastruct;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a 2D integer coordinate used to specify positions in a grid.
 */
public record Coordinate(int x, int y) {

    /**
     * Creates a new {@link Coordinate} instance with the given {@code x} and {@code y} values.
     *
     * @param x The x-coordinate value.
     * @param y The y-coordinate value.
     * @return A new {@link Coordinate} instance.
     */
    public static Coordinate of(int x, int y) {
        // TODO: compléter ce fabriquant
        return null;
    }

    /**
     * Computes and returns the {@link Coordinate} to the left of this one.
     *
     * @return The left adjacent {@link Coordinate}.
     */
    public Coordinate left() {
        // TODO: à compléter
        return null;
    }

    /**
     * Computes and returns the {@link Coordinate} to the right of this one.
     *
     * @return The right adjacent {@link Coordinate}.
     */
    public Coordinate right() {
        // TODO: à compléter
        return null;
    }

    /**
     * Computes and returns the {@link Coordinate} above this one.
     *
     * @return The above adjacent {@link Coordinate}.
     */
    public Coordinate above() {
        // TODO: à compléter
        return null;
    }

    /**
     * Computes and returns the {@link Coordinate} below this one.
     *
     * @return The below adjacent {@link Coordinate}.
     */
    public Coordinate below() {
        // TODO: à compléter
        return null;
    }

    /**
     * Computes and returns a list of orthogonal (adjacent in horizontal or vertical direction) neighbors.
     *
     * @return A list of orthogonal neighboring {@link Coordinate}s.
     */
    public List<Coordinate> orthogonalNeighbours() {
        // TODO: à compléter
        return List.of();
    }

    /**
     * Computes and returns a list of diagonal (adjacent in diagonal direction) neighbors.
     *
     * @return A list of diagonal neighboring {@link Coordinate}s.
     */
    public List<Coordinate> diagonalNeighbours() {
        // TODO: à compléter
        return List.of();
    }

    /**
     * Computes and returns a list of all orthogonal and diagonal neighbors.
     *
     * @return A list of all neighboring {@link Coordinate}s.
     */
    public List<Coordinate> orthodiagonalNeighbours() {
        // TODO: à compléter
        return List.of();
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }
}