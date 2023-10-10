package model.automata;

import javafx.scene.paint.Color;
import model.State;

import java.util.List;


public enum SeedsState implements State<SeedsState> {
    ON, OFF;
    @Override
    public Color getColor() {
        return switch (this) {
            case ON -> Color.GOLD;
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
            case OFF -> State.count(ON,neighbours) == 2 ? ON: OFF;
        };
    }

}
