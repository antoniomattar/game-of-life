package matrix;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CoordinateIteratorTest {

    @Test
    public void testIteratorWithZeroDimensions() {
        CoordinateIterator iterator = new CoordinateIterator(0, 0);
        assertFalse(iterator.hasNext());
    }

    @Test
    public void testIteratorWithOneDimension() {
        CoordinateIterator iterator = new CoordinateIterator(5, 1);
        assertTrue(iterator.hasNext());
        assertEquals(Coordinate.of(0, 0), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Coordinate.of(1, 0), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Coordinate.of(2, 0), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Coordinate.of(3, 0), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Coordinate.of(4, 0), iterator.next());
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void testIteratorWithTwoDimensions() {
        CoordinateIterator iterator = new CoordinateIterator(3, 2);
        assertTrue(iterator.hasNext());
        assertEquals(Coordinate.of(0, 0), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Coordinate.of(1, 0), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Coordinate.of(2, 0), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Coordinate.of(0, 1), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Coordinate.of(1, 1), iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(Coordinate.of(2, 1), iterator.next());
        assertFalse(iterator.hasNext());
        assertThrows(NoSuchElementException.class, iterator::next);
    }

}