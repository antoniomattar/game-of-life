package matrix;

import java.util.Iterator;
import java.util.NoSuchElementException;

class MatrixIterator<T> implements Iterator<T> {
    private final Iterator<Coordinate> coordIterator;
    private final Matrix<T> matrix;

    public MatrixIterator(Matrix<T> matrix, Iterator<Coordinate> coordIterator) {
        this.coordIterator = coordIterator;
        this.matrix = matrix;
    }

    @Override
    public boolean hasNext() {
        return coordIterator.hasNext();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return matrix.get(coordIterator.next());
    }
}
