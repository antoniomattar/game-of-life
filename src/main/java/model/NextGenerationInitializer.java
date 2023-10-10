package model;

import datastruct.Coordinate;
import datastruct.Matrix;
import datastruct.MatrixInitializer;

import java.util.ArrayList;
import java.util.List;

public class NextGenerationInitializer<S extends State<S>> implements MatrixInitializer<S> {

    private final CellularAutomatonSimulation<S> simulation;

    public NextGenerationInitializer(CellularAutomatonSimulation<S> simulation) {
        this.simulation = simulation;
    }

    @Override
    public S initialValueAt(Coordinate coordinate) {
        List<State<S>> neighbours = new ArrayList<>();
        for (Coordinate neighbourCoord : coordinate.orthodiagonalNeighbours()) {
            Coordinate wrapped = wrap(neighbourCoord);
            neighbours.add(this.simulation.at(wrapped).get());
        }
        S state = this.simulation.at(coordinate).get();
        return state.update(neighbours);
    }

    private Coordinate wrap(Coordinate coordinate) {
        return new Coordinate(
                modulo(coordinate.x(),this.simulation.numberOfColumns()),
                modulo(coordinate.y(),this.simulation.numberOfRows())
        );
    }

    /** The non-negative remainder of n divided by d.
     *
     * @param n an arbitrary integer.
     * @param d a non-zero integer.
     * @return the remainder of {@code n/d}, between {@code 0} and {@code n-1}.
     */
    private static int modulo(int n, int d) {
        int result = n % d;
        return n < 0 ? result + d : result;
    }
}
