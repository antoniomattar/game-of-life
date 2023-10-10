package datastruct;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CoordinateTest {
    @Test
    public void testCoordinateCreation() {
        Coordinate coordinate = Coordinate.of(3, 4);
        assertEquals(3, coordinate.x());
        assertEquals(4, coordinate.y());
    }

    @Test
    public void testLeft() {
        Coordinate coordinate = Coordinate.of(3, 4);
        Coordinate left = coordinate.left();
        assertEquals(2, left.x());
        assertEquals(4, left.y());
    }

    @Test
    public void testRight() {
        Coordinate coordinate = Coordinate.of(3, 4);
        Coordinate right = coordinate.right();
        assertEquals(4, right.x());
        assertEquals(4, right.y());
    }

    @Test
    public void testAbove() {
        Coordinate coordinate = Coordinate.of(3, 4);
        Coordinate above = coordinate.above();
        assertEquals(3, above.x());
        assertEquals(5, above.y());
    }

    @Test
    public void testBelow() {
        Coordinate coordinate = Coordinate.of(3, 4);
        Coordinate below = coordinate.below();
        assertEquals(3, below.x());
        assertEquals(3, below.y());
    }

    @Test
    public void testOrthogonalNeighbours() {
        Coordinate coordinate = Coordinate.of(3, 4);
        List<Coordinate> neighbours = coordinate.orthogonalNeighbours();
        assertEquals(4, neighbours.size());
        assertTrue(neighbours.contains(Coordinate.of(2, 4)));
        assertTrue(neighbours.contains(Coordinate.of(4, 4)));
        assertTrue(neighbours.contains(Coordinate.of(3, 3)));
        assertTrue(neighbours.contains(Coordinate.of(3, 5)));
        assertFalse(neighbours.contains(coordinate));
        assertFalse(neighbours.contains(Coordinate.of(1, 4)));
        assertFalse(neighbours.contains(Coordinate.of(5, 4)));
        assertFalse(neighbours.contains(Coordinate.of(3, 6)));
        assertFalse(neighbours.contains(Coordinate.of(3, 1)));
    }

    @Test
    public void testDiagonalNeighbours() {
        Coordinate coordinate = Coordinate.of(3, 4);
        List<Coordinate> neighbours = coordinate.diagonalNeighbours();
        assertEquals(4, neighbours.size());
        assertTrue(neighbours.contains(Coordinate.of(2, 3)));
        assertTrue(neighbours.contains(Coordinate.of(4, 3)));
        assertTrue(neighbours.contains(Coordinate.of(2, 5)));
        assertTrue(neighbours.contains(Coordinate.of(4, 5)));
        assertFalse(neighbours.contains(coordinate));
        assertFalse(neighbours.contains(Coordinate.of(1, 4)));
        assertFalse(neighbours.contains(Coordinate.of(5, 4)));
        assertFalse(neighbours.contains(Coordinate.of(3, 6)));
        assertFalse(neighbours.contains(Coordinate.of(3, 1)));
    }

    @Test
    public void testOrthodiagonalNeighbours() {
        Coordinate coordinate = Coordinate.of(3, 4);
        List<Coordinate> neighbours = coordinate.orthodiagonalNeighbours();
        assertEquals(8, neighbours.size());
        assertTrue(neighbours.contains(Coordinate.of(2, 4)));
        assertTrue(neighbours.contains(Coordinate.of(4, 4)));
        assertTrue(neighbours.contains(Coordinate.of(3, 3)));
        assertTrue(neighbours.contains(Coordinate.of(3, 5)));
        assertTrue(neighbours.contains(Coordinate.of(2, 3)));
        assertTrue(neighbours.contains(Coordinate.of(4, 3)));
        assertTrue(neighbours.contains(Coordinate.of(2, 5)));
        assertTrue(neighbours.contains(Coordinate.of(4, 5)));
        assertFalse(neighbours.contains(coordinate));
        assertFalse(neighbours.contains(Coordinate.of(1, 4)));
        assertFalse(neighbours.contains(Coordinate.of(5, 4)));
        assertFalse(neighbours.contains(Coordinate.of(3, 6)));
        assertFalse(neighbours.contains(Coordinate.of(3, 1)));
    }
}