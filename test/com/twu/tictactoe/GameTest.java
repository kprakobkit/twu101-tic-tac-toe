package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.*;

/**
 * Created by kprakobk on 4/30/15.
 */
public class GameTest {

    private Board board;
    private Game game;
    private UserInputStream userInputStream;
    private View view;
    private Player playerOne;
    private Player playerTwo;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        userInputStream = mock(UserInputStream.class);
        view = mock(View.class);
        playerOne = mock(Player.class);
        playerTwo = mock(Player.class);
        game = new Game(board, userInputStream, view, playerOne, playerTwo);
    }

    @Test
    public void shouldDisplayBoardWhenStarting() {
        when(board.isFull()).thenReturn(true);

        game.start();

        verify(view, atLeast(1)).printBoard();
    }

    @Test
    public void shouldPrintDrawGameWhenBoardIsFull() {
        when(board.isFull()).thenReturn(true);

        game.start();

        verify(view).printDrawGamePrompt();
    }

    @Test
    public void shouldPrintTheCorrectWinner() {
        when(board.hasWinningCombination()).thenReturn(true);

        game.start();

        verify(view).printWinner(playerOne.getName());
    }
}