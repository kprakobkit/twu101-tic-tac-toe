package com.twu.tictactoe;

import java.io.PrintStream;

/**
 * Created by kprakobk on 4/30/15.
 */
public class View {
    private PrintStream printStream;

    public View(PrintStream printStream) {
        this.printStream = printStream;
    }

    void printDrawGamePrompt() {
        printStream.println("Game is a draw");
    }

    void printInvalidPositionPrompt() {
        printStream.println("The position is taken. Please enter another position.");
    }
}
