package view;

import javafx.scene.input.MouseEvent;
import model.Cell;
import model.CellState;

public class FillingMouseListener implements MouseListener {
    private final MatrixPane matrix;
    private final CellState cellState;

    public FillingMouseListener(MatrixPane matrix, CellState cellState) {
        this.matrix = matrix;
        this.cellState = cellState;
    }

    @Override
    public void onMouseReleased(MouseEvent event, Cell cell) {
        System.out.println("Filling Release");
        this.matrix.resetWaitingListener();
    }

    @Override
    public void onMouseEntered(MouseEvent event, Cell cell) {
        System.out.println("Filling Enter");
        if (!event.isPrimaryButtonDown()) {
            this.matrix.resetWaitingListener();
            return;
        }
        while (!cellState.equals(cell.getState())) {
            cell.toggleState();
        }
    }

    @Override
    public void onMousePressed(MouseEvent event, Cell cell) {
        System.out.println("Filling Pressed");
        cell.toggleState();
        CellState state = cell.getState();
        this.matrix.setMouseListener(new FillingMouseListener(this.matrix, state));
    }
}
