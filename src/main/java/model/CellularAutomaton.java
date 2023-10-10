package model;

import java.util.Random;

public interface CellularAutomaton<S extends State<S>> {
    int numberOfColumns();
    int numberOfRows();
    S defaultState();
    S randomState(Random generator);
}
