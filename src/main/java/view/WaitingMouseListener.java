package view;

import javafx.scene.input.MouseEvent;
import model.Cell;
import model.CellState;

class WaitingMouseListener implements MouseListener {


    private final MatrixPane matrix;

    WaitingMouseListener(MatrixPane matrix) {
        this.matrix = matrix;
    }

    @Override
    public void onMousePressed(MouseEvent event, Cell cell) {
        cell.toggleState();
        CellState cellState = cell.getState();
        matrix.setMouseListener(new FillingMouseListener(this.matrix, cellState));
    }
}
