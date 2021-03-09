package logic;

import model.Position;
import model.field.Difficulty;
import model.field.MineField;

public class MineFieldManager {
    private Difficulty difficultyLevel;
    private int size;

    public MineFieldManager() {

    }

    public MineField setupMines(int size, Difficulty difficultyLevel) {
        this.size = size;
        this.difficultyLevel = difficultyLevel;

        MineField mineField = new MineField(size);
        Position[] minePositions = Randomiser.getBombs(size, difficultyLevel);

        int bombNum = minePositions.length;
        for (Position minePos : minePositions) {
            mineField.setMine(minePos.getRow(), minePos.getColumn());
        }

        return mineField;
    }

    public void play(MineField minefield) {

    }

}
