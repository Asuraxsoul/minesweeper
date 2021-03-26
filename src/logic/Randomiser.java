package logic;

import static model.field.Difficulty.EASY;
import static model.field.Difficulty.INTERMEDIATE;

import model.Position;
import model.field.Difficulty;

public class Randomiser {
    public static Position[] getBombs(int size, Difficulty difficultyLevel) {
        int bombNum;
        Position[] positions;

        if (difficultyLevel == EASY) {
            bombNum = (size * size) / 5;

        } else if (difficultyLevel == INTERMEDIATE) {
            bombNum = (size * size) / 4;

        } else {
            bombNum = (size * size) / 3;
        }

        positions = new Position[bombNum];
        for (int i = 0; i < bombNum; i++) {
            int row = (int) (Math.random() * size);
            int col = (int) (Math.random() * size);
            positions[i] = new Position(row, col);
        }

        return positions;
    }
}
