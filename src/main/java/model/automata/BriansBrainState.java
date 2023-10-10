package model.automata;

import javafx.scene.paint.Color;
import model.State;

import java.util.List;

public enum BriansBrainState implements State<BriansBrainState> {
    ON, OFF, DYING;

    @Override
    public Color getColor() {
        return switch (this) {
            case ON -> Color.WHITE;
            case OFF -> Color.BLACK;
            case DYING -> Color.BLUE;
        };
    }

    @Override
    public BriansBrainState next() {
        return switch (this) {
            case ON -> DYING;
            case OFF -> ON;
            case DYING -> OFF;
        };
    }

    @Override
    public BriansBrainState update(List<State<BriansBrainState>> neighbours) {
        return switch (this) {
            case ON -> DYING;
            case DYING -> OFF;
            case OFF -> {
                int count = State.count(ON, neighbours);
                yield count==2 ? ON : OFF;
            }
        };
    }


}
