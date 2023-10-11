package model;

import controller.Simulation;
import datastruct.Coordinate;
import model.automata.GameOfLifeAutomaton;
import model.automata.GameOfLifeState;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Random;

import static model.automata.GameOfLifeState.ALIVE;
import static model.automata.GameOfLifeState.DEAD;
import static org.junit.jupiter.api.Assertions.*;

class NextGenerationInitializerTest {

    private final CellularAutomatonSimulation<GameOfLifeState> simulation =
            new CellularAutomatonSimulation<>(
                    new GameOfLifeAutomaton(4,3),
                    new Random()
                    );
    private final NextGenerationInitializer<GameOfLifeState> initializer =
            new NextGenerationInitializer<>(this.simulation);

    @BeforeEach
    public void prepareSimulation() {
        GameOfLifeState[][] state =
                { { DEAD, DEAD, DEAD, DEAD }
                , { ALIVE, ALIVE, DEAD, DEAD }
                , { DEAD, DEAD, ALIVE, DEAD }
                };
        for (Coordinate coordinate : this.simulation) {
            this.simulation.at(coordinate).set(state[coordinate.y()][coordinate.x()]);
        }
    }

    @Test
    void initialValueAt() {
        assertEquals(DEAD, initializer.initialValueAt(Coordinate.of(0,1)));
        assertEquals(ALIVE, initializer.initialValueAt(Coordinate.of(1,0)));
        assertEquals(ALIVE, initializer.initialValueAt(Coordinate.of(1,1)));
        assertEquals(ALIVE, initializer.initialValueAt(Coordinate.of(1,2)));
        assertEquals(DEAD, initializer.initialValueAt(Coordinate.of(2,2)));
    }

    @Test
    public void testWrapCoordinateInsideGrid() {
        Coordinate coordinate = Coordinate.of(1, 1);
        Coordinate wrapped = initializer.wrap(coordinate);
        assertEquals(coordinate, wrapped);
    }

    @Test
    public void testWrapCoordinateOutsideGrid() {
        assertEquals(
                Coordinate.of(0, 1),
                initializer.wrap(Coordinate.of(4, 4))
        );
        assertEquals(
                Coordinate.of(3, 2),
                initializer.wrap(Coordinate.of(-1, 2))
        );
         assertEquals(
                Coordinate.of(3, 2),
                initializer.wrap(Coordinate.of(-1, -1))
        );   }

    @Test
    public void testModuloPositive() {
        int result = NextGenerationInitializer.modulo(7, 4);
        assertEquals(3, result);
    }

    @Test
    public void testModuloNegative() {
        int result = NextGenerationInitializer.modulo(-7, 4);
        assertEquals(1, result);
    }


}