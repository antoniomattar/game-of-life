package model.automata;

import model.CellularAutomaton;

import java.util.Random;

public class GameOfLifeAutomaton extends AbstractAutomaton<GameOfLifeState> {

    protected GameOfLifeAutomaton(int numberOfColumns, int numberOfRows) {
        super(numberOfColumns, numberOfRows);
    }

    @Override
    public GameOfLifeState defaultState() {
        return GameOfLifeState.DEAD;
    }

    @Override
    public GameOfLifeState randomState(Random generator) {
        return generator.nextBoolean()?
                 GameOfLifeState.ALIVE:
                 GameOfLifeState.DEAD;
    }
}
