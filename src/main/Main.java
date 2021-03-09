package main;

import java.util.Scanner;

import logic.MineFieldManager;
import model.field.Difficulty;
import model.field.MineField;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        sc.close();

        String[] fieldSetting = userInput.split(" ");
        int fieldSize = Integer.parseInt(fieldSetting[0]);
        Difficulty difficultyLevel = Enum.valueOf(Difficulty.class, fieldSetting[1]);

        MineFieldManager mineFieldManager = new MineFieldManager();

        MineField newMineField = mineFieldManager.setupMines(fieldSize, difficultyLevel);

        mineFieldManager.play(newMineField);
    }
}
