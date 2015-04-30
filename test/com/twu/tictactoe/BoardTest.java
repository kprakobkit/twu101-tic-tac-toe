package com.twu.tictactoe;


import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by kprakobk on 4/30/15.
 */
public class BoardTest {
    @Test
    public void shouldPrintAValidBoard() {
        PrintStream printStream = mock(PrintStream.class);
        Board board = new Board(printStream);
        String boardString = "   |   |   \n" +
                             "-----------\n" +
                             "   |   |   \n" +
                             "-----------\n" +
                             "   |   |   ";

        board.printBoard();

        verify(printStream).println(boardString);
    }
}