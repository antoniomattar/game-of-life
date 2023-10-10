package model.automata;

import javafx.scene.paint.Color;
import model.State;

import java.util.List;

public enum BiColorState implements State<BiColorState> {
    BLUE, RED, DEAD;



    @Override
    public Color getColor() {
        return switch (this) {
            case BLUE -> Color.BLUE;
            case RED -> Color.RED;
            case DEAD -> Color.WHITE;
        };
    }

    @Override
    public BiColorState next() {
        return switch (this) {
            case BLUE -> RED;
            case RED -> DEAD;
            case DEAD -> BLUE;
        };
    }

    @Override
    public BiColorState update(List<State<BiColorState>> neighbours) {
        int countBlue = State.count(BLUE, neighbours);
        int countRed = State.count(RED, neighbours);
        int countAlive = countBlue + countRed;
        if (this == DEAD) {
            return (countAlive != 3)? DEAD:
                    countBlue > countRed? BLUE:
                            RED;
        }
        return 2 <= countAlive && countAlive <= 3? this:
                DEAD;
    }

}
