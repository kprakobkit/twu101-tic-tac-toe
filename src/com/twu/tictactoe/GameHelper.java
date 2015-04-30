package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Created by kprakobk on 4/30/15.
 */
public class GameHelper {
    private PrintStream printStream;

    public GameHelper(PrintStream printStream) {
        this.printStream = printStream;
    }

    public String askForUserInput(String currentPlayer) {
        printStream.println("Player " + currentPlayer + " - Please select a position by entering a number between 1 and 9:");

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = "";
        try {
            userInput = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userInput;
    }
}
