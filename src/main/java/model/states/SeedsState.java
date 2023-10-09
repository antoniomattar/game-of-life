package model.states;

import javafx.scene.paint.Color;
import model.State;

import java.util.List;

import static model.states.BriansBrainState.GENERATOR;
import static model.states.BriansBrainState.countList;

public enum SeedsState implements State<SeedsState> {
    ON, OFF;
    @Override
    public Color getColor() {
        return switch (this) {
            case ON -> Color.WHITE;
            case OFF -> Color.BLACK;
        };
    }

    @Override
    public SeedsState next() {
        return switch (this) {
            case ON -> OFF;
            case OFF -> ON;
        };
    }

    @Override
    public SeedsState update(List<State<SeedsState>> neighbours) {
        return switch (this) {
            case ON -> OFF;
            case OFF -> countList(ON,neighbours) == 2 ? ON: OFF;
        };
    }

    public static SeedsState random() {
        return GENERATOR.nextInt(10)==0? ON: OFF;
    }
}
