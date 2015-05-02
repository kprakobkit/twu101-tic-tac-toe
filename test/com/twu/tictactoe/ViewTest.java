package com.twu.tictactoe;


import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

/**
 * Created by kprakobk on 4/30/15.
 */
public class ViewTest {
    private PrintStream printStream;
    private Board board;
    private View view;
    private String[] playerPosition;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        playerPosition = new String[9];
        board = new Board(playerPosition);
        view = new View(printStream, board);
    }

    @Test
    public void shouldPrintAValidBoardWhenStarting() {
        String boardString = "   |   |   \n" +
                             "-----------\n" +
                             "   |   |   \n" +
                             "-----------\n" +
                             "   |   |   ";

        assertEquals(boardString, board.toString());
    }

    @Test
    public void shouldPrintBoardWithCorrectPositionAndSymbolForCorrectUserWhenReceiveUserInput() {
        String boardString = " O | X |   \n" +
                                "-----------\n" +
                                "   |   |   \n" +
                                "-----------\n" +
                                "   |   |   ";

        board.updateCell("X", 2);
        board.updateCell("O", 1);

        view.printBoard();

        assertEquals(boardString, board.toString());
    }
}