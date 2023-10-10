package controller;

import datastruct.Coordinate;
import javafx.beans.property.ReadOnlyLongProperty;
import javafx.scene.paint.Color;
import model.OnChangeListener;

public interface Simulation extends Iterable<Coordinate> {

    int numberOfColumns();
    int numberOfRows();

    void updateToNextGeneration();

    void next(Coordinate coordinate);

    void copy(Coordinate source, Coordinate destination);

    Color getColor(Coordinate coordinate);

    void setChangeListener(Coordinate coordinate, Runnable listener);

    ReadOnlyLongProperty generationNumberProperty();

    void reset();

    void clear();
}
