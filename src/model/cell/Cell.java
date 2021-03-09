package model.cell;

public class Cell {
    private State state;
    private Content content;
    private Status status;

    public Cell(Content content) {
        this.state = State.CLOSE;
        this.content = content;
        this.status = Status.EMPTY;
    }
}

