package model.automata;

import java.util.Random;

public class SeedsAutomaton extends AbstractAutomaton<SeedsState> {
    public SeedsAutomaton(int numberOfColumns, int numberOfRows) {
        super(numberOfColumns, numberOfRows);
    }

    @Override
    public SeedsState defaultState() {
        return SeedsState.OFF;
    }

    @Override
    public SeedsState randomState(Random generator) {
        return generator.nextInt(10) == 0?
                SeedsState.ON:
                SeedsState.OFF;
    }
}
