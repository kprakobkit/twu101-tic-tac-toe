package com.twu.tictactoe;

import java.io.PrintStream;

/**
 * Created by kprakobk on 4/30/15.
 */
public class View {
    private PrintStream printStream;
    private Board board;

    public View(PrintStream printStream, Board board) {
        this.printStream = printStream;
        this.board = board;
    }

    void printDrawGamePrompt() {
        printStream.println("Game is a draw");
    }

    void printInvalidPositionPrompt() {
        printStream.println("The position is taken. Please enter another position.");
    }

    public void printBoard() {
        printStream.println(board);
    }
}
