package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import java.io.PrintStream;

import static org.mockito.Mockito.*;

/**
 * Created by kprakobk on 4/30/15.
 */
public class GameTest {

    private Board board;
    private Game game;
    private GameHelper gameHelper;
    private PrintStream printStream;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        gameHelper = mock(GameHelper.class);
        printStream = mock(PrintStream.class);
        game = new Game(board, gameHelper, printStream);
    }

    @Test
    public void shouldDisplayBoardWhenStarting() {
        when(board.isFull()).thenReturn(true);
        when(board.isAValidPosition("1")).thenReturn(true);
        when(board.isAValidPosition("2")).thenReturn(true);
        when(gameHelper.askForUserInput("1")).thenReturn("1");
        when(gameHelper.askForUserInput("2")).thenReturn("2");

        game.start();

        verify(board).printBoard();
    }

    @Test
    public void shouldRedrawBoardAfterReceivingPositionFromUser() {
        when(board.isFull()).thenReturn(false).thenReturn(true);
        when(board.isAValidPosition("1")).thenReturn(true);
        when(board.isAValidPosition("2")).thenReturn(true);
        when(gameHelper.askForUserInput("1")).thenReturn("1");
        when(gameHelper.askForUserInput("2")).thenReturn("2");

        game.start();

        verify(board).redraw("1", "1");
        verify(board).redraw("2", "2");
    }

    @Test
    public void shouldBePlayerTwosTurnAfterPlayerOneEntersAPosition() {
        when(board.isFull()).thenReturn(true);
        when(board.isAValidPosition("1")).thenReturn(true);
        when(gameHelper.askForUserInput("1")).thenReturn("1");

        game.start();

        verify(gameHelper, times(1)).askForUserInput("2");
    }


    @Test
    public void shouldPromptUserToReenterPositionUntilValid() {
        when(board.isFull()).thenReturn(true);
        when(board.isAValidPosition("1")).thenReturn(false);
        when(board.isAValidPosition("2")).thenReturn(true);
        when(gameHelper.askForUserInput("1")).thenReturn("1").thenReturn("2");
        when(gameHelper.askForUserInput("2")).thenReturn("3");

        game.start();

        verify(printStream, times(1)).println("The position is taken. Please enter another position.");
    }

    @Test
    public void shouldLetPlayersFillUntilBoardIsFull() {
        when(board.isFull()).thenReturn(false).thenReturn(true);
        when(board.isAValidPosition("1")).thenReturn(true);
        when(board.isAValidPosition("2")).thenReturn(true);
        when(board.isAValidPosition("3")).thenReturn(true);
        when(board.isAValidPosition("4")).thenReturn(true);
        when(gameHelper.askForUserInput("1")).thenReturn("1").thenReturn("2");
        when(gameHelper.askForUserInput("2")).thenReturn("3").thenReturn("4");

        game.start();

        verify(printStream).println("Game is a draw");
    }
}