package com.twu.tictactoe;

import java.util.Arrays;

/**
 * Created by kprakobk on 4/30/15.
 */
public class Board {
    private String[] cells;

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
        Boolean isFull = true;

        for (String cell : cells) {
            if (cell.equals(" ")) {
                return false;
            }
        }

        return isFull;
    }

    @Override
    public String toString() {
        return  " " + cells[0] + " | " +  cells[1] + " | " + cells[2] + " \n" +
                "-----------\n" +
                " " + cells[3] + " | " +  cells[4] + " | " + cells[5] + " \n" +
                "-----------\n" +
                " " + cells[6] + " | " +  cells[7] + " | " + cells[8] + " ";
    }
}
