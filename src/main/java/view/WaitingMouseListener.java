package view;

import datastruct.Coordinate;
import javafx.scene.input.MouseEvent;

class WaitingMouseListener implements MouseListener {


    private final MatrixPane matrix;

    WaitingMouseListener(MatrixPane matrix) {
        this.matrix = matrix;
    }

    @Override
    public void onMousePressed(MouseEvent event, Coordinate coord) {
       this.matrix.getController().getSimulation().next(coord);
        matrix.setMouseListener(new FillingMouseListener(this.matrix, coord));
    }
}
