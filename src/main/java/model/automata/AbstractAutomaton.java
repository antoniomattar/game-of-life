package model.automata;

import model.CellularAutomaton;
import model.State;

public abstract class AbstractAutomaton<S extends State<S>> implements CellularAutomaton<S> {

    private final int numberOfColumns;
    private final int numberOfRows;


    protected AbstractAutomaton(int numberOfColumns, int numberOfRows) {
        this.numberOfColumns = numberOfColumns;
        this.numberOfRows = numberOfRows;
    }

    public int numberOfColumns() {
        return numberOfColumns;
    }

    public int numberOfRows() {
        return numberOfRows;
    }
}
