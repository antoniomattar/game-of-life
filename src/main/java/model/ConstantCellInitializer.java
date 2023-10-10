package model;

import datastruct.Coordinate;
import datastruct.MatrixInitializer;

public class ConstantCellInitializer<T>  implements MatrixInitializer<Cell<T>> {
    private final T defaultValue;

    public ConstantCellInitializer(T defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public Cell<T> initialValueAt(Coordinate coordinate) {
        return new Cell<>(defaultValue);
    }
}
