package com.twu.tictactoe;


import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by kprakobk on 4/30/15.
 */
public class GameHelperTest {
    @Test
    public void shouldPromptPlayerOneForInputBetweenOneAndNine() {
        PrintStream printStream = mock(PrintStream.class);

        GameHelper gameHelper = new GameHelper(printStream);

        gameHelper.askForUserInput("1");

        verify(printStream).println("Player 1 - Please select a position by entering a number between 1 and 9:");
    }
}