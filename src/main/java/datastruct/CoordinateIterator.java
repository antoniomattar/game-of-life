package datastruct;

import java.util.Iterator;
import java.util.NoSuchElementException;

class CoordinateIterator implements Iterator<Coordinate> {
    private final int width;
    private final int height;
    private int x = 0;
    private int y = 0;

    public CoordinateIterator(int width, int height) {
        this.width = width;
        this.height = height;
    }

    @Override
    public boolean hasNext() {
        return y < this.height;
    }

    @Override
    public Coordinate next() {
        if (!this.hasNext()) {
            throw new NoSuchElementException();
        }
        Coordinate coord = new Coordinate(this.x, this.y);
        this.x = this.x + 1;
        if (this.x == this.width) {
            this.x = 0;
            this.y = this.y + 1;
        }
        return coord;
    }
}
