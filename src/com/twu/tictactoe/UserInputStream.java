package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Created by kprakobk on 4/30/15.
 */
public class UserInputStream {
    private PrintStream printStream;

    public UserInputStream(PrintStream printStream) {
        this.printStream = printStream;
    }

    public Integer askForCellPosition() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String userInput = "";
        try {
            userInput = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return Integer.parseInt(userInput);
    }
}
