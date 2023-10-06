package datastruct;

import java.util.ArrayList;
import java.util.List;

public record Coordinate(int x, int y) {

    public static Coordinate of(int x, int y) {
        return new Coordinate(x,y);
    }

    public Coordinate left() {
        return new Coordinate(x-1,y);
    }

    public Coordinate right() {
        return new Coordinate(x+1,y);
    }

    public Coordinate above() {
        return new Coordinate(x,y+1);
    }

    public Coordinate below() {
        return new Coordinate(x, y-1);
    }

    public List<Coordinate> orthogonalNeighbours() {
        return List.of(
                this.right(),
                this.left(),
                this.above(),
                this.below()
        );
    }

    public List<Coordinate> diagonalNeighbours() {
        return List.of(
                this.right().above(),
                this.left().above(),
                this.left().below(),
                this.right().below()
        );
    }

    public List<Coordinate> orthodiagonalNeighbours() {
        List<Coordinate> neighbours = new ArrayList<>(this.orthogonalNeighbours());
        neighbours.addAll(this.diagonalNeighbours());
        return neighbours;
    }
}
