package matrix;

public class SubMatrixInitializer<T> implements MatrixInitializer<T> {

    private final Matrix<T> motherMatrix;
    private final int x0;
    private final int y0;

    public SubMatrixInitializer(Matrix<T> matrix, int x0, int y0) {
        this.motherMatrix = matrix;
        this.x0 = x0;
        this.y0 = y0;
    }

    @Override
    public T initialValueAt(Coordinate coordinate) {
        return motherMatrix.get(coordinate.x() + x0, coordinate.y() + y0);
    }
}
