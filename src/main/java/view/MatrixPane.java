package view;

import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.shape.Rectangle;
import model.Cell;
import model.CellState;
import model.Grid;

/**
 * Created by Arnaud Labourel on 22/11/2018.
 */
public class MatrixPane extends GridPane{
    private static final double CELL_SIZE = 14;

    public void initialize(Grid grid) {
        for (int rowIndex = 0; rowIndex < grid.getNumberOfRows(); rowIndex++) {
            for (int columnIndex = 0; columnIndex < grid.getNumberOfColumns(); columnIndex++) {
                addCellRectangle(grid.getCell(rowIndex,columnIndex), rowIndex, columnIndex);
            }
        }
    }

    private void addCellRectangle(Cell cell, int rowIndex, int columnIndex) {
        Rectangle rectangleCell = new Rectangle(CELL_SIZE, CELL_SIZE);
        addStatePropertyListener(cell, rectangleCell);
        updateFill(rectangleCell, cell.getState());
        addEventHandler(cell, rectangleCell);
        add(rectangleCell, columnIndex, rowIndex);
    }

    private void addStatePropertyListener(Cell cell, Rectangle cellRectangle) {
        cell.getStateProperty().addListener((observable, oldValue, newValue) ->
                updateFill(cellRectangle, newValue));
    }

    private void updateFill(Rectangle cellRectangle, CellState newCellState) {
        cellRectangle.setFill(newCellState.color);
    }

    private void addEventHandler(Cell cell, Rectangle cellRectangle) {
        cellRectangle.addEventHandler(
                MouseEvent.MOUSE_PRESSED,
                event -> mouseListener.onMousePressed(event, cell)
        );
        cellRectangle.addEventHandler(
                MouseEvent.DRAG_DETECTED,
                event -> {
                    System.out.println("Full drag start");
                    this.startFullDrag();
                }
        );
        cellRectangle.addEventHandler(
                MouseDragEvent.MOUSE_DRAG_RELEASED,
                event -> mouseListener.onMouseReleased(event, cell)
        );
        cellRectangle.addEventHandler(
                MouseDragEvent.MOUSE_DRAG_ENTERED,
                event -> mouseListener.onMouseEntered(event, cell)
        );
    }

    private MouseListener mouseListener = new WaitingMouseListener(this);

    void setMouseListener(MouseListener mouseListener) {
        System.out.println("Change listener");
        this.mouseListener = mouseListener;
    }

    void resetWaitingListener() {
        System.out.println("Reset listener");
        this.mouseListener = new WaitingMouseListener(this);
    }
}
