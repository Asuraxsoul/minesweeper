package model.field;

import model.cell.Cell;
import model.cell.Content;

public class MineField {
    private Cell[][] mineField;
    private int size;

    public MineField(int size) {
        this.size= size;
        mineField = new Cell[this.size][this.size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                mineField[i][j] = new Cell(Content.NOBOMB);
            }
        }
    }

    public void setMine(int row, int column) {
        this.mineField[row][column] = new Cell(Content.BOMB);
    }

    public void setCell(Cell cell, int row, int column) {
        this.mineField[row][column] = cell;
    }

    public Cell[][] getMineField() {
        return this.mineField;
    }

    @Override
    public String toString() {
        String toPrint = "";
        for (int i = 0; i < size; i++) {
            toPrint = toPrint + "|";
            for (int j = 0; j < size; j++) {
                toPrint = toPrint + mineField[i][j].toString() + "|";
            }
            toPrint = toPrint + "\n";
        }
        return toPrint;
    }
}
