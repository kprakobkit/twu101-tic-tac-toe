package com.twu.tictactoe;


import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by kprakobk on 4/30/15.
 */
public class ViewTest {
    private PrintStream printStream;
    private Board board;
    private View view;
    private PlayerPosition playerPosition;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        playerPosition = new PlayerPosition();
        board = new Board(playerPosition);
        view = new View(printStream, board);
    }

    @Test
    public void shouldPrintAValidBoard() {
        String boardString = "   |   |   \n" +
                             "-----------\n" +
                             "   |   |   \n" +
                             "-----------\n" +
                             "   |   |   ";

        view.printBoard();

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

        view.printBoard();

        verify(printStream).println(newBoardString);
    }
}