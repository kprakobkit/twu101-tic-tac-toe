package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Created by kprakobk on 4/30/15.
 */
public class UserInputStream {

    private BufferedReader bufferedReader;

    public UserInputStream(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public String getInput() {
        String userInput = "";
        try {
            userInput = bufferedReader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return userInput;
    }
}
