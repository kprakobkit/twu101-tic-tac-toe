package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 * Created by kprakobk on 5/1/15.
 */
public class PlayerTest {

    private Player player;
    private Board board;
    private UserInputStream userInputStream;
    private String name;
    private String mark;
    private View view;

    @Before
    public void setUp() throws Exception {
        mark = "X";
        name = "Player 1";
        board = mock(Board.class);
        view = mock(View.class);
        userInputStream = mock(UserInputStream.class);

        player = new Player(mark, name, board, userInputStream, view);
    }

    @Test
    public void shouldUpdateTheBoardAfterUserInput() {
        when(userInputStream.getInput()).thenReturn("1");
        when(board.isAValidCell(1)).thenReturn(true);

        player.makeAMove();

        verify(board).updateCell(mark, 1);
    }

    @Test
    public void shouldPromptUserToReenterPositionUntilValid() {
        when(userInputStream.getInput()).thenReturn("1");
        when(board.isAValidCell(1)).thenReturn(false, true);

        player.makeAMove();

        verify(view, times(1)).printInvalidPositionPrompt();
    }
}