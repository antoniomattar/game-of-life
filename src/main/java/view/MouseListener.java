package view;

import javafx.event.EventType;
import javafx.scene.input.MouseEvent;
import model.Cell;

interface MouseListener {

    default void onMousePressed(MouseEvent event, Cell cell) {}
    default void onMouseReleased(MouseEvent event, Cell cell) {}
    default void onMouseEntered(MouseEvent event, Cell cell) {};

}
