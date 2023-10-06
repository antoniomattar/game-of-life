package model;

import javafx.scene.paint.Color;

import java.util.List;
import java.util.Random;

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
    public GameOfLifeState update(List<State<GameOfLifeState>> neighbours) {
        int countAlive = 0;
        for (State<GameOfLifeState> state : neighbours) {
            if (state.equals(ALIVE)) {
                countAlive++;
            }
        }
        boolean isAlive =
                (this == DEAD && 3 == countAlive)
                || (this == ALIVE && 2 <= countAlive && countAlive <= 3);
        return isAlive ? ALIVE : DEAD;
    }

    private static final Random randomGen = new Random();
    public static GameOfLifeState random() {
        return randomGen.nextBoolean() ? ALIVE : DEAD;
    }
}
