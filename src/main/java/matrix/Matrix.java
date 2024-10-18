package matrix;

import java.util.Iterator;

public interface Matrix<T> extends Iterable<T> {

  /**
   * Returns the width of the {@link Matrix}.
   *
   * @return The width of the {@link Matrix}.
   */
  int width();

  /**
   * Returns the height of the {@link Matrix}.
   *
   * @return The height of the {@link Matrix}.
   */
  int height();

  /**
   * Returns the value at the specified coordinates (x, y) in
   * the {@link Matrix}.
   *
   * @param x The x-coordinate.
   * @param y The y-coordinate.
   * @return The content of the matrix at the coordinates (x,y).
   */
  T get(int x, int y);
  /**
   * Returns the value at the specified coordinates (x, y) in
   * the {@link Matrix}.
   *
   * @param coordinate The coordinates (x,y).
   * @return The content of the matrix at the coordinates (x,y).
   */
  default T get(Coordinate coordinate) {
    return this.get(coordinate.x(), coordinate.y());
  }

  /**
   *  Changes the value at the specified coordinates (x,y) in the {@link Matrix}
   *
   * @param x the x-coordinate
   * @param y the y-coordinate
   * @param newValue the value to assign to coordinates (x,y).
   */
  void set(int x, int y, T newValue);

  /**
   *  Changes the value at the specified coordinates (x,y) in the {@link Matrix}
   *
   * @param coordinate The coordinates (x,y)
   * @param newValue the value to assign to coordinates (x,y).
   */
  default void set(Coordinate coordinate, T newValue) {
    this.set(coordinate.x(), coordinate.y(), newValue);
  }

  Matrix<T> subMatrix(Coordinate corner, int width, int height);


  /**
   * Returns an {@link Iterable} that provides access to the {@link Coordinate}s of the
   * {@link Matrix} in row-major order. This means that a {@code for} loop on a {@link Matrix}
   * will loop over the coordinates of the {@link Matrix}.
   *
   * @return An {@link Iterable} for the {@link Coordinate}s of the {@link Matrix}.
   */
  default Iterable<Coordinate> coordinates() {
    return () -> new CoordinateIterator(this.width(), this.height());
  }

  /**
   * Returns an {@link Iterator} that allows iterating over the elements in the {@link Matrix} in
   * row-major order.
   *
   * @return An {@link Iterator} for the {@link Matrix}.
   */
  default Iterator<T> iterator() {
    Iterator<Coordinate> coords =
      new CoordinateIterator(this.width(),this.height());
    return new MatrixIterator<>(this, coords);
  }
}
