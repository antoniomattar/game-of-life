package model.automata;

import javafx.scene.paint.Color;
import model.State;
import org.junit.jupiter.api.Test;

import java.util.List;

import static model.automata.GameOfLifeState.*;
import static org.junit.jupiter.api.Assertions.*;

class GameOfLifeStateTest {
    @Test
    public void testGetColor() {
        assertEquals(Color.WHITE, DEAD.getColor());
        assertEquals(Color.RED, ALIVE.getColor());
    }

    @Test
    public void testNext() {
        assertEquals(ALIVE.next(), DEAD);
        assertEquals(DEAD.next(), ALIVE);
    }

    @Test
    public void testAliveUpdate() {
        // Test with three alive neighbors, should be ALIVE
        List<State<GameOfLifeState>> aliveNeighbors =
                List.of(ALIVE, DEAD, ALIVE, DEAD, ALIVE);
        assertEquals(ALIVE, ALIVE.update(aliveNeighbors));

        // Test with two alive neighbors, should be ALIVE
        List<State<GameOfLifeState>> twoAliveNeighbors =
                List.of(ALIVE, DEAD, ALIVE, DEAD, DEAD);
        assertEquals(ALIVE, ALIVE.update(twoAliveNeighbors));

        // Test with four alive neighbors, should be DEAD
        List<State<GameOfLifeState>> fourAliveNeighbors =
                List.of(ALIVE, ALIVE, DEAD, ALIVE, ALIVE);
        assertEquals(DEAD, ALIVE.update(fourAliveNeighbors));

        // Test with zero alive neighbors, should be DEAD
        List<State<GameOfLifeState>> zeroAliveNeighbors =
                List.of(DEAD, DEAD, DEAD, DEAD);
        assertEquals(DEAD, ALIVE.update(zeroAliveNeighbors));
    }

    @Test
    public void testDeadUpdate() {
        // Test with three alive neighbors, should be ALIVE
        List<State<GameOfLifeState>> aliveNeighbors =
                List.of(ALIVE, DEAD, ALIVE, DEAD, ALIVE);
        assertEquals(ALIVE, DEAD.update(aliveNeighbors));

        // Test with two alive neighbors, should be DEAD
        List<State<GameOfLifeState>> twoAliveNeighbors =
                List.of(ALIVE, DEAD, ALIVE, DEAD, DEAD);
        assertEquals(DEAD, DEAD.update(twoAliveNeighbors));

        // Test with four alive neighbors, should be DEAD
        List<State<GameOfLifeState>> fourAliveNeighbors =
                List.of(ALIVE, ALIVE, DEAD, ALIVE, ALIVE);
        assertEquals(DEAD, DEAD.update(fourAliveNeighbors));

        // Test with zero alive neighbors, should be DEAD
        List<State<GameOfLifeState>> zeroAliveNeighbors =
                List.of(DEAD, DEAD, DEAD, DEAD);
        assertEquals(DEAD, DEAD.update(zeroAliveNeighbors));
    }
}