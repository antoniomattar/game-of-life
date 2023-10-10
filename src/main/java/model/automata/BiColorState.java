package model.automata;

import javafx.scene.paint.Color;
import model.State;

import java.util.List;
import java.util.Random;

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
        int countBlue = 0;
        int countRed = 0;
        for (State<BiColorState> neighbour : neighbours) {
            if (neighbour == RED) {
                countRed++;
            }
            if (neighbour == BLUE) {
                countBlue++;
            }
        }
        if (this == DEAD) {
            return (countBlue + countRed != 3)? DEAD:
                    countBlue > countRed? BLUE:
                            RED;
        }
        return 2 <= countBlue + countRed && countBlue + countRed <= 3? this:
                DEAD;
    }

}
