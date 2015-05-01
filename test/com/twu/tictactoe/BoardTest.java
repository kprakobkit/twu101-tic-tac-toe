package com.twu.tictactoe;


import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by kprakobk on 4/30/15.
 */
public class BoardTest {
    private PrintStream printStream;
    private Board board;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        board = new Board(printStream);
    }

    @Test
    public void shouldPrintAValidBoard() {
        String boardString = "   |   |   \n" +
                             "-----------\n" +
                             "   |   |   \n" +
                             "-----------\n" +
                             "   |   |   ";

        board.printBoard();

        verify(printStream).println(boardString);
    }

    @Test
    public void shouldRedrawBoardWithCorrectPositionAndSymbolForCorrectUserWhenReceiveUserInput() {
        String newBoardString = "   | X |   \n" +
                                "-----------\n" +
                                "   |   |   \n" +
                                "-----------\n" +
                                "   |   |   ";

        board.updatePlayerPosition("1", "2");
        board.printBoard();

        verify(printStream).println(newBoardString);
    }
}