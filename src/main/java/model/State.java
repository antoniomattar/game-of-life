package model;

import javafx.scene.paint.Color;

import java.util.List;

public interface State<S> {

    Color getColor();

    S next();

    S update(List<State<S>> neighbours);

}
