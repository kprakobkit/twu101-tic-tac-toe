package com.twu.tictactoe;

import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created by kprakobk on 4/30/15.
 */
public class GameTest {


    private Board board;

    @Test
    public void shouldDisplayBoardWhenStarting() {
        board = mock(Board.class);
        Game game = new Game(board);

        game.start();

        verify(board).printBoard();
    }
}