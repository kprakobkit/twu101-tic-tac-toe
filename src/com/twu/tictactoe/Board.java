package com.twu.tictactoe;

import java.io.PrintStream;

/**
 * Created by kprakobk on 4/30/15.
 */
public class Board {
    private PrintStream printStream;

    public Board(PrintStream printStream) {

        this.printStream = printStream;
    }

    public void printBoard() {
        String boardString = "   |   |   \n" +
                "-----------\n" +
                "   |   |   \n" +
                "-----------\n" +
                "   |   |   ";

        printStream.println(boardString);
    }

    public void redraw(String userInput) {

    }
}
