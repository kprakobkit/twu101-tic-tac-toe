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

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        userInputStream = mock(UserInputStream.class);
        view = mock(View.class);
        game = new Game(board, userInputStream, view);
    }

    @Test
    public void shouldDisplayBoardWhenStarting() {
        when(board.isFull()).thenReturn(true);

        game.start();

        verify(view, atLeast(1)).printBoard();
    }

    @Test
    public void shouldPrintNewBoardAfterValidPosition() {
        playGameOneTimeThrough();

        game.start();

        verify(board, times(1)).updatePlayerPosition("1", 1);
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

    private void playGameOneTimeThrough() {
        when(board.isFull()).thenReturn(false).thenReturn(true);
        when(board.isAValidCell(1)).thenReturn(true);
        when(userInputStream.askForCellPosition()).thenReturn(1);
    }

    private void playGameOneTimeThroughWithOneInvalidPosition() {
        when(board.isFull()).thenReturn(false, true);
        when(board.isAValidCell(1)).thenReturn(false, true);
        when(userInputStream.askForCellPosition()).thenReturn(1,1);
    }
}