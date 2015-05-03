package com.twu.tictactoe;

import java.util.Arrays;

/**
 * Created by kprakobk on 4/30/15.
 */
public class Board {
    private String[] cells;
    private final Integer[][] ROW_WINNING_COMB = {{0,1,2},{3,4,5},{6,7,8}};
    private final Integer[][] COLUMN_WINNING_COMB = {{0,3,6},{1,4,7},{2,5,8}};
    private final Integer[][] DIAG_WINNING_COMB = {{0,4,8},{2,4,6}};

    public Board(String[] cells) {
        this.cells = cells;
        initializeCells();
    }

    private void initializeCells() {
        Arrays.fill(cells, " ");
    }

    public void updateCell(String mark, Integer cell) {
        cells[cell-1] = mark;
    }

    public boolean isAValidCell(Integer cell) {
        return !cells[cell-1].equals("X") && !cells[cell-1].equals("O");
    };

    public boolean isFull() {
        for (String cell : cells) {
            if (cell.equals(" ")) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        return  " " + cells[0] + " | " +  cells[1] + " | " + cells[2] + " \n" +
                "-----------\n" +
                " " + cells[3] + " | " +  cells[4] + " | " + cells[5] + " \n" +
                "-----------\n" +
                " " + cells[6] + " | " +  cells[7] + " | " + cells[8] + " ";
    }

    public boolean hasWinningCombination() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private boolean checkRows() {
        return  checkFirstRow() ||
                checkSecondRow() ||
                checkThirdRow();
    }

    private boolean checkColumns() {
        return  checkFirstColumn() ||
                checkSecondColumn() ||
                checkThirdColumn();
    }

    private boolean checkDiagonals() {
        return  checkFirstDiag() ||
                checkSecondDiag();
    }

    private boolean checkFirstRow() {
        return cells[0].equals(cells[1]) && cells[1].equals(cells[2]) && !cells[0].equals(" ");
    }

    private boolean checkSecondRow() {
        return cells[3].equals(cells[4]) && cells[4].equals(cells[5]) && !cells[3].equals(" ");
    }

    private boolean checkThirdRow() {
        return  cells[6].equals(cells[7]) && cells[7].equals(cells[8]) && !cells[6].equals(" ");
    }

    private boolean checkFirstColumn() {
        return cells[0].equals(cells[3]) && cells[3].equals(cells[6]) && !cells[0].equals(" ");
    }

    private boolean checkSecondColumn() {
        return cells[1].equals(cells[4]) && cells[4].equals(cells[7]) && !cells[1].equals(" ");
    }

    private boolean checkThirdColumn() {
        return cells[2].equals(cells[5]) && cells[5].equals(cells[8]) && !cells[2].equals(" ");
    }

    private boolean checkFirstDiag() {
        return cells[0].equals(cells[4]) && cells[4].equals(cells[8]) && !cells[0].equals(" ");
    }

    private boolean checkSecondDiag() {
        return cells[6].equals(cells[4]) && cells[4].equals(cells[2]) && !cells[6].equals(" ");
    }
}
