package datastruct;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class MatrixTest {

    private final MatrixInitializer<Integer> sumInitializer =
            coord -> coord.x() + coord.y();

    @Test
    public void testMatrixCreationWithInitializer() {
        Matrix<Integer> matrix = new Matrix<>(3, 4, sumInitializer);
        assertEquals(3, matrix.width());
        assertEquals(4, matrix.height());
        assertEquals(4, matrix.get(2, 2));
        assertEquals(3, matrix.get(1, 2));
        assertEquals(3, matrix.get(2, 1));
        assertEquals(2, matrix.get(1, 1));
    }

    @Test
    public void testMatrixCreationWithInitialValue() {
        Matrix<String> matrix = new Matrix<>(2, 2, "Foo");
        assertEquals(2, matrix.width());
        assertEquals(2, matrix.height());
        assertEquals("Foo", matrix.get(1, 1)); // Test a specific cell value.
    }

    @Test
    public void testMatrixSetAndGet() {
        Matrix<Integer> matrix = new Matrix<>(3, 3, 0);
        matrix.set(1, 1, 42);
        assertEquals(42, matrix.get(1, 1));
        matrix.set(0, 2, 10);
        assertEquals(10, matrix.get(0, 2));
        matrix.set(Coordinate.of(2, 2), 99);
        assertEquals(99, matrix.get(Coordinate.of(2, 2)));
    }

    @Test
    public void testMatrixWidthAndHeight() {
        Matrix<String> matrix = new Matrix<>(4, 2, "A");
        assertEquals(4, matrix.width());
        assertEquals(2, matrix.height());
        matrix.set(3, 1, "B");
        assertEquals(4, matrix.width());
        assertEquals(2, matrix.height());
    }

    @Test
    public void testMatrixIterator() {
        Matrix<Integer> matrix = new Matrix<>(2, 2, sumInitializer);
        Iterator<Integer> iterator = matrix.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(0, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(1, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(2, iterator.next());
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testMatrixCoordinates() {
        Matrix<Integer> matrix = new Matrix<>(2, 2, 0);
        Iterable<Coordinate> coordinates = matrix.coordinates();
        int count = 0;
        for (Coordinate coord : coordinates) {
            count++;
        }
        assertEquals(4, count);
    }

    @Test
    public void testMatrixLens() {
        Matrix<Integer> matrix = new Matrix<>(2, 2, 0);
        Lens<Integer> lens = matrix.at(1, 1);
        assertEquals(0, lens.get());
        lens.set(42);
        assertEquals(42, matrix.get(1, 1));
    }
}
