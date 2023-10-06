package model;

import datastruct.Lens;

public class CellLens<S extends State<S>> implements Lens<S> {

    private final Cell<S> cell;

    public CellLens(Cell<S> cell) {
        this.cell = cell;
    }

    @Override
    public S get() {
        return cell.getState();
    }

    @Override
    public void set(S value) {
        cell.setState(value);
    }
}
