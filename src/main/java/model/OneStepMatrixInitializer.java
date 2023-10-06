package model;

import datastruct.Coordinate;
import datastruct.MatrixInitializer;

import java.util.ArrayList;
import java.util.List;

public class OneStepMatrixInitializer<S extends State<S>> implements MatrixInitializer<S> {

    private final CellGrid<S> grid;

    public OneStepMatrixInitializer(CellGrid<S> grid) {
        this.grid = grid;
    }

    @Override
    public S initialValueAt(Coordinate coordinate) {
        List<State<S>> neighbours = new ArrayList<>();
        for (Coordinate neighbourCoord : coordinate.orthodiagonalNeighbours()) {
            neighbours.add(this.grid.cellAtWrapped(neighbourCoord).getState());
        }
        S state = this.grid.cellAt(coordinate).getState();
        return state.update(neighbours);
    }
}
