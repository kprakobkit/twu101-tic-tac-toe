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

        verify(view, atLeast(1)).printBoardWithInstructions();
    }

    @Test
    public void shouldPrintNewBoardAfterValidCell() {
        playGameOneTimeThrough();

        game.start();

        verify(board, times(1)).updateCell("O", 1);
    }

    @Test
    public void shouldPromptUserToReenterPositionUntilValid() {
        playGameOneTimeThroughWithOneInvalidPosition();

        game.start();

        verify(view, times(1)).printInvalidPositionPrompt();
    }

    @Test
    public void shouldLetPlayersFillBoardUntilFull() {
        when(board.isFull()).thenReturn(true);

        game.start();

        verify(view).printDrawGamePrompt();
    }

    @Test
    public void shouldPrintTheCorrectWinner() {
        playGameOneTimeThrough();
        when(board.hasWinningCombination()).thenReturn(true);

        game.start();

        verify(view).printWinner(playerOne.getName());
    }

    private void playGameOneTimeThrough() {
        when(board.isFull()).thenReturn(false).thenReturn(true);
        when(board.isAValidCell(1)).thenReturn(true);
        when(playerOne.getMark()).thenReturn("O");
        when(userInputStream.askForCell()).thenReturn(1);
    }

    private void playGameOneTimeThroughWithOneInvalidPosition() {
        when(board.isFull()).thenReturn(false, true);
        when(board.isAValidCell(1)).thenReturn(false, true);
        when(userInputStream.askForCell()).thenReturn(1,1);
    }
}