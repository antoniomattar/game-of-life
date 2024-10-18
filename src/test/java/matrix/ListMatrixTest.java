package matrix;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

class ListMatrixTest {

    private final MatrixInitializer<Integer> sumInitializer =
            coord -> coord.x() + coord.y();

    @Test
    public void testMatrixCreationWithInitializer() {
        ListMatrix<Integer> matrix = new ListMatrix<>(3, 4, sumInitializer);
        assertEquals(3, matrix.width());
        assertEquals(4, matrix.height());
        assertEquals(4, matrix.get(2, 2));
        assertEquals(3, matrix.get(1, 2));
        assertEquals(3, matrix.get(2, 1));
        assertEquals(2, matrix.get(1, 1));
    }

    @Test
    public void testMatrixCreationWithInitialValue() {
        ListMatrix<String> matrix = new ListMatrix<>(2, 2, "Foo");
        assertEquals(2, matrix.width());
        assertEquals(2, matrix.height());
        assertEquals("Foo", matrix.get(1, 1)); // Test a specific cell value.
    }

    @Test
    public void testMatrixSetAndGet() {
        ListMatrix<Integer> matrix = new ListMatrix<>(3, 3, 0);
        matrix.set(1, 1,42);
        assertEquals(42, matrix.get(1, 1));
        matrix.set(0, 2,10);
        assertEquals(10, matrix.get(0, 2));
        matrix.set(Coordinate.of(2, 2),99);
        assertEquals(99, matrix.get(Coordinate.of(2, 2)));
    }

    @Test
    public void testMatrixWidthAndHeight() {
        ListMatrix<String> matrix = new ListMatrix<>(4, 2, "A");
        assertEquals(4, matrix.width());
        assertEquals(2, matrix.height());
        matrix.set(3, 1,"B");
        assertEquals(4, matrix.width());
        assertEquals(2, matrix.height());
    }

    @Test
    public void testMatrixIterator() {
        ListMatrix<Integer> matrix = new ListMatrix<>(2, 2, sumInitializer);
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
        ListMatrix<Integer> matrix = new ListMatrix<>(2, 2, 0);
        Iterable<Coordinate> coordinates = matrix.coordinates();
        int count = 0;
        for (Coordinate coord : coordinates) {
            count++;
        }
        assertEquals(4, count);
    }


    @Test
    public void testSubMatrix() {
      Matrix<Integer> matrix = new ListMatrix<>(5, 5, 0);
      for (int x = 0; x < 5; x++) {
        for (int y = 0; y < 5; y++) {
          matrix.set(x,y,x + y * 5);
        }
      }
      Matrix<Integer> sub = matrix.subMatrix(Coordinate.of(2,1),2,3);
      assertEquals(2, sub.width());
      assertEquals(3, sub.height());
      for (int x = 2; x < 4; x++) {
        for (int y = 1; y < 4; y++) {
          assertEquals(x + y * 5, sub.get(x-2,y-1));
        }
      }
    }


}
