package logic;

import model.Position;
import model.cell.Cell;
import model.cell.Content;
import model.field.Difficulty;
import model.field.MineField;

public class MineFieldManager {
    private Difficulty difficultyLevel;
    private int size;

    public MineFieldManager() {

    }

    private static int getSurroundingBombNum(MineField mineField, int i, int j, int size) {
        int bombNum = 0;

        if (i == 0) {
            if (j == 0) {
                if (mineField.getMineField()[i + 1][j].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
                if (mineField.getMineField()[i][j + 1].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
            } else if (j == size - 1) {
                if (mineField.getMineField()[i + 1][j].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
                if (mineField.getMineField()[i][j - 1].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
            } else {
                if (mineField.getMineField()[i + 1][j].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
                if (mineField.getMineField()[i][j + 1].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
                if (mineField.getMineField()[i][j - 1].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
            }

        } else if (i == size - 1) {
            if (j == 0) {
                if (mineField.getMineField()[i][j + 1].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
                if (mineField.getMineField()[i - 1][j].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
            } else if (j == size - 1) {
                if (mineField.getMineField()[i - 1][j].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
                if (mineField.getMineField()[i][j - 1].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
            } else {
                if (mineField.getMineField()[i][j + 1].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
                if (mineField.getMineField()[i - 1][j].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
                if (mineField.getMineField()[i][j - 1].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
            }

        } else if (j == 0) {
            if (i == 0) {
                if (mineField.getMineField()[i + 1][j].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
                if (mineField.getMineField()[i][j + 1].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
            } else if (i == size - 1) {
                if (mineField.getMineField()[i][j + 1].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
                if (mineField.getMineField()[i - 1][j].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
            } else {
                if (mineField.getMineField()[i + 1][j].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
                if (mineField.getMineField()[i][j + 1].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
                if (mineField.getMineField()[i - 1][j].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
            }

        } else if (j == size - 1) {
            if (i == 0) {
                if (mineField.getMineField()[i + 1][j].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
                if (mineField.getMineField()[i][j - 1].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
            } else if (i == size - 1) {
                if (mineField.getMineField()[i - 1][j].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
                if (mineField.getMineField()[i][j - 1].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
            } else {
                if (mineField.getMineField()[i + 1][j].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
                if (mineField.getMineField()[i - 1][j].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
                if (mineField.getMineField()[i][j - 1].getContent() == Content.BOMB) {
                    bombNum += 1;
                }
            }

        } else {
            if (mineField.getMineField()[i + 1][j].getContent() == Content.BOMB) {
                bombNum += 1;
            }
            if (mineField.getMineField()[i][j + 1].getContent() == Content.BOMB) {
                bombNum += 1;
            }
            if (mineField.getMineField()[i - 1][j].getContent() == Content.BOMB) {
                bombNum += 1;
            }
            if (mineField.getMineField()[i][j - 1].getContent() == Content.BOMB) {
                bombNum += 1;
            }
        }

        return bombNum;
    }

    public MineField setupMines(int size, Difficulty difficultyLevel) {
        this.size = size;
        this.difficultyLevel = difficultyLevel;

        MineField mineField = new MineField(size);
        Position[] minePositions = Randomiser.getBombs(size, difficultyLevel);

        for (Position minePos : minePositions) {
            System.out.println(minePos);
            mineField.setMine(minePos.getRow(), minePos.getColumn());
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (mineField.getMineField()[i][j].getContent() != Content.BOMB) {
                    int bombNum = getSurroundingBombNum(mineField, i, j, size);

                    Cell newCell;
                    switch (bombNum) {
                    case 1:
                        newCell = new Cell(Content.ONEBOMB);
                        break;
                    case 2:
                        newCell = new Cell(Content.TWOBOMB);
                        break;
                    case 3:
                        newCell = new Cell(Content.THREEBOMB);
                        break;
                    case 4:
                        newCell = new Cell(Content.FOURBOMB);
                        break;
                    default:
                        newCell = new Cell(Content.NOBOMB);
                        break;
                    }

                    mineField.setCell(newCell, i, j);
                }
            }
        }

        return mineField;
    }

    public void play(MineField minefield) {
        System.out.println(minefield);
    }

}
