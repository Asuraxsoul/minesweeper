package model.field;

import model.cell.Cell;
import model.cell.Content;

public class MineField {
    private Cell[][] mineField;
    private int size;

    public MineField(int size) {
        this.size= size;
        mineField = new Cell[this.size][this.size];
    }

    public void setMine(int row, int column) {
        this.mineField[row][column] = new Cell(Content.BOMB);
    }
}
