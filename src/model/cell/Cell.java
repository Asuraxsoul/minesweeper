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

    public Content getContent() {
        return this.content;
    }

    @Override
    public String toString() {
        return this.content.toString();
    }
}

