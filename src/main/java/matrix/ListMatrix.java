package matrix;

import java.util.List;


/**
 * Represents a matrix, a rectangular array, with generic values in each cell.
 *
 * @param <T> The type of values stored in the matrix cells.
 */
public class ListMatrix<T> implements Matrix<T> {

  private final List<List<T>> matrix;
  private final int width;
  private final int height;

  /**
   * Creates a new {@link ListMatrix} with the specified width, height, and an initializer to set
   * values.
   *
   * @param width       The width of the {@link ListMatrix}.
   * @param height      The height of the {@link ListMatrix}.
   * @param initializer A matrix initializer to set values in the {@link ListMatrix}.
   */
  public ListMatrix(int width, int height, MatrixInitializer<T> initializer) {
    // TODO
    this.width = 0;
    this.height = 0;
    this.matrix = null;
    this.initializeWith(initializer); // fills the matrix using initializer
  }

  public ListMatrix(int width, int height, T constant) {
    this(width, height, new ConstantMatrixInitializer<>(constant));
  }

  private void initializeWith(MatrixInitializer<T> initializer) {
    // TODO initialize each cell of the matrix, with a value determined by initializer
  }

  public int width() {
    // TODO
    return 0;
  }

  public int height() {
    // TODO
    return 0;
  }

  @Override
  public T get(int x, int y) {
    // TODO
    return null;
  }


  @Override
  public void set(int x, int y, T newValue) {
    // TODO
  }

  public Matrix<T> subMatrix(Coordinate corner, int width, int height) {
    // TODO
    return this;
  }

}
