package model.automata;

import java.util.Random;

public class BiColorAutomaton extends AbstractAutomaton<BiColorState> {

    public BiColorAutomaton(int numberOfColumns, int numberOfRows) {
        super(numberOfColumns, numberOfRows);
    }

    @Override
    public BiColorState defaultState() {
        return BiColorState.DEAD;
    }

    @Override
    public BiColorState randomState(Random generator) {
        return generator.nextBoolean()? BiColorState.DEAD:
                generator.nextBoolean()? BiColorState.RED:
                        BiColorState.BLUE;
    }

}
