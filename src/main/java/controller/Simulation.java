package controller;

import datastruct.Coordinate;
import javafx.beans.property.ReadOnlyLongProperty;
import javafx.scene.paint.Color;

public interface Simulation extends Iterable<Coordinate> {

    int numberOfColumns();
    int numberOfRows();

    void updateToNextGeneration();

    void next(Coordinate coordinate);

    void copy(Coordinate source, Coordinate destination);

    Color getColor(Coordinate coordinate);

    void setChangeListener(Coordinate coordinate, Runnable run);

    ReadOnlyLongProperty generationNumberProperty();

    void reset();

    void clear();
}
