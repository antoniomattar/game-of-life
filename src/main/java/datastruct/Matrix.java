package datastruct;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Matrix<T> {

    private final List<List<T>> matrix;
    private final int width;
    private final int height;

    public Matrix(int width, int height, MatrixInitializer<T> initializer) {
        this.width = width;
        this.height = height;
        this.matrix = new ArrayList<>();
        this.initializeWith(initializer);
    }

    public Matrix(int width, int height, T initialValue) {
        this(width, height, new ConstantMatrixInitializer<>(initialValue));
    }

    private void initializeWith(MatrixInitializer<T> initializer) {
        for (int x = 0; x < width; x++) {
            List<T> row = new ArrayList<>();
            this.matrix.add(row);
            for (int y = 0; y < height; y++) {
                row.add(initializer.initialValueAt(Coordinate.of(x,y)));
            }
        }
    }

    public T get(int x, int y) {
        return this.matrix.get(x).get(y);
    }

    public T get(Coordinate coord) {
        return this.get(coord.x(), coord.y());
    }

    public void set(int x, int y, T value) {
        this.matrix.get(x).set(y,value);
    }

    public void set(Coordinate coord, T value) {
        this.set(coord.x(), coord.y(), value);
    }


    public Iterator<T> iterator() {
        Iterator<Coordinate> coordIterator = this.coordinatesIterator();
        return new MatrixIterator(this, coordIterator);
    }

    public Iterable<Coordinate> coordinates() {
        return this::coordinatesIterator;
    }

    private Iterator<Coordinate> coordinatesIterator() {
        return new CoordinateIterator(this.width, this.height);
    }


    public Lens<T> at(int x, int y) {
        return new Lens<T>() {
            @Override
            public T get() {
                return Matrix.this.get(x,y);
            }

            @Override
            public void set(T value) {
                Matrix.this.set(x,y,value);
            }
        };
    }

    public Lens<T> at(Coordinate coord) {
        return this.at(coord.x(), coord.y());
    }

}
