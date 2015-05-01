package com.twu.tictactoe;

import java.io.PrintStream;
import java.util.Arrays;

/**
 * Created by kprakobk on 4/30/15.
 */
public class Board {
    private PrintStream printStream;
    private String[] playerPositions = new String[9];

    private String boardString;

    public Board(PrintStream printStream) {
        this.printStream = printStream;
        initializePlayerPositions();
    }

    private void initializePlayerPositions() {
        Arrays.fill(playerPositions, "   ");
    }

    public void printBoard() {
        boardString = playerPositions[0] + "|" +  playerPositions[1] + "|" + playerPositions[2] + "\n" +
                      "-----------\n" +
                      playerPositions[3] + "|" +  playerPositions[4] + "|" + playerPositions[5] + "\n" +
                      "-----------\n" +
                      playerPositions[6] + "|" +  playerPositions[7] + "|" + playerPositions[8];

        printStream.println(boardString);
    }

    public void redraw(String currentUser, String positionOnBoard) {
        updatePlayerPosition(currentUser, positionOnBoard);
        printBoard();
    }

    public boolean isAValidPosition(String position) {
        return !(playerPositions[Integer.parseInt(position) - 1].equals("  "));
    };

    private void updatePlayerPosition(String currentUser, String positionOnBoard) {
        String mark = currentUser.equals("1") ? " X " : " O ";
        playerPositions[Integer.parseInt(positionOnBoard) - 1] = mark;
    }

    public boolean isFull() {
        Boolean isFull = true;

        for (int i = 0; i < playerPositions.length; i++) {
            if(playerPositions[i].equals("   ")) {
                isFull = false;
            }
        }

        return isFull;
    }
}
