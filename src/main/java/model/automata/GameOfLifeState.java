package model.automata;

import javafx.scene.paint.Color;
import model.State;

import java.util.List;

/**
 * {@link GameOfLifeState} instances represent the possible states of a {@link GameOfLifeState}.
 */
public enum GameOfLifeState implements State<GameOfLifeState> {
    ALIVE(Color.RED),
    DEAD(Color.WHITE);

    public final Color color;

    GameOfLifeState(Color color) {
        this.color = color;
    }

    @Override
    public Color getColor() {
        return this.color;
    }

    @Override
    public GameOfLifeState next() {
        return GameOfLifeState.values()[1 - this.ordinal()];
    }

    @Override
    public GameOfLifeState update(List<GameOfLifeState> neighbours) {
        int countAlive = State.count(ALIVE, neighbours);
        return (countAlive == 3 || this == ALIVE && countAlive == 2)?
                 ALIVE:
                 DEAD;
    }

}
