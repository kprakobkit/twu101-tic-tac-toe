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
         createBoard();
    }

    private void createBoard() {
        boardString = playerPositions[0] + "|" +  playerPositions[1] + "|" + playerPositions[2] + "\n" +
                "-----------\n" +
                playerPositions[3] + "|" +  playerPositions[4] + "|" + playerPositions[5] + "\n" +
                "-----------\n" +
                playerPositions[6] + "|" +  playerPositions[7] + "|" + playerPositions[8];
    }

    public void printBoard() {
        printStream.println(boardString);
    }

    public void redraw(String currentUser, String positionOnBoard) {
        String mark = currentUser.equals("1") ? " X " : " O ";
        playerPositions[Integer.parseInt(positionOnBoard) - 1] = mark;
        createBoard();
        printBoard();
    }
}
