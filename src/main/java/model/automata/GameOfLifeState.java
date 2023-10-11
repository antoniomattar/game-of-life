package model.automata;

import javafx.scene.paint.Color;
import model.State;

import java.util.List;

/**
 * {@link GameOfLifeState} instances represent the possible states of a {@link GameOfLifeState}.
 */
public enum GameOfLifeState implements State<GameOfLifeState> {
    ALIVE, DEAD;


    @Override
    public Color getColor() {
        //TODO: à compléter
        return Color.BLACK;
    }

    @Override
    public GameOfLifeState next() {
        //TODO: à compléter
        return null;
    }

    @Override
    public GameOfLifeState update(List<GameOfLifeState> neighbours) {
        //TODO: à compléter
        return null;
    }

}
