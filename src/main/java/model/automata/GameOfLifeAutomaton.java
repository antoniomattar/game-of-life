package model.automata;

import model.CellularAutomaton;

import java.util.Random;

public class GameOfLifeAutomaton implements CellularAutomaton<GameOfLifeState> {

    public GameOfLifeAutomaton(int numberOfColumns, int numberOfRows) {
        //TODO: à compléter
    }

    @Override
    public int numberOfColumns() {
        //TODO: à compléter
        return 0;
    }

    @Override
    public int numberOfRows() {
        //TODO: à compléter
        return 0;
    }

    @Override
    public GameOfLifeState defaultState() {
        //TODO: à compléter
        return null;
    }

    @Override
    public GameOfLifeState randomState(Random generator) {
        //TODO: à compléter
        return null;
    }
}
