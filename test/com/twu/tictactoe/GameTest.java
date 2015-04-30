package com.twu.tictactoe;

import org.junit.Before;
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

        game.start();

        verify(board, atLeast(1)).printBoard();
    }

    @Test
    public void shouldRedrawBoardAfterReceivingPositionFromUser() {
        playGameOneTimeThroughWithTwoUsers();

        game.start();

        verify(board, times(1)).redraw("1", "1");
        verify(board, times(1)).redraw("2", "2");
    }

    @Test
    public void shouldPromptUserToReenterPositionUntilValid() {
        playGameOneTimeThroughWithOneInvalidPosition();

        game.start();

        verify(printStream, times(1)).println("The position is taken. Please enter another position.");
    }

    @Test
    public void shouldLetPlayersFillBooardUntilFull() {
        playGameUntilBoardIsFull();

        game.start();

        verify(printStream).println("Game is a draw");
    }

    private void playGameOneTimeThroughWithTwoUsers() {
        when(board.isFull()).thenReturn(false).thenReturn(false).thenReturn(true);
        when(board.isAValidPosition("1")).thenReturn(true);
        when(board.isAValidPosition("2")).thenReturn(true);
        when(gameHelper.askForUserInput("1")).thenReturn("1");
        when(gameHelper.askForUserInput("2")).thenReturn("2");
    }

    private void playGameOneTimeThroughWithOneInvalidPosition() {
        when(board.isFull()).thenReturn(false).thenReturn(true);
        when(board.isAValidPosition("1")).thenReturn(false);
        when(board.isAValidPosition("2")).thenReturn(true);
        when(gameHelper.askForUserInput("1")).thenReturn("1").thenReturn("2");
        when(gameHelper.askForUserInput("2")).thenReturn("3");
    }

    private void playGameUntilBoardIsFull() {
        when(board.isFull()).thenReturn(false).thenReturn(false).thenReturn(true);
        when(board.isAValidPosition("1")).thenReturn(true);
        when(board.isAValidPosition("2")).thenReturn(true);
        when(board.isAValidPosition("3")).thenReturn(true);
        when(board.isAValidPosition("4")).thenReturn(true);
        when(gameHelper.askForUserInput("1")).thenReturn("1").thenReturn("2");
        when(gameHelper.askForUserInput("2")).thenReturn("3").thenReturn("4");
    }
}