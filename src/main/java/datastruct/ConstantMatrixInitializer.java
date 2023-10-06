package datastruct;

public class ConstantMatrixInitializer<T> implements MatrixInitializer<T> {

    private final T constant;

    public ConstantMatrixInitializer(T constant) {
        this.constant = constant;
    }
    @Override
    public T initialValueAt(Coordinate coordinate) {
        return constant;
    }
}
