package model.automata;

import java.util.Random;

public class BriansBrainAutomaton extends AbstractAutomaton<BriansBrainState> {

    public BriansBrainAutomaton(int numberOfColumns, int numberOfRows) {
        super(numberOfColumns, numberOfRows);
    }

    @Override
    public BriansBrainState defaultState() {
        return BriansBrainState.OFF;
    }

    @Override
    public BriansBrainState randomState(Random generator) {
        return generator.nextInt(10) == 0 ?
                 BriansBrainState.ON:
                 BriansBrainState.OFF;
    }
}
