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
        when(board.isAValidPosition("1")).thenReturn(true);
        when(gameHelper.askForUserInput("1")).thenReturn("1").thenReturn("1");

        game.start();

        verify(board).printBoard();
    }

    @Test
    public void shouldAskPlayerOneForInputWhenItIsPlayerOnesTurn() {
        when(board.isAValidPosition("1")).thenReturn(true);
        when(gameHelper.askForUserInput("1")).thenReturn("1").thenReturn("1");

        game.start();

        verify(gameHelper).askForUserInput("1");
    }

    @Test
    public void shouldRedrawBoardAfterReceivingPositionFromUser() {
        String position = "1";
        String currentPlayer = "1";

        when(gameHelper.askForUserInput(currentPlayer)).thenReturn(position);
        when(board.isAValidPosition(position)).thenReturn(true);

        game.start();

        verify(board).redraw(currentPlayer, position);
    }

    @Test
    public void shouldBePlayerTwosTurnAfterPlayerOneEntersAPosition() {
        String playerOnePosition = "1";
        String currentPlayer = "1";
        String nextPlayer = "2";

        when(board.isAValidPosition(playerOnePosition)).thenReturn(true);
        when(gameHelper.askForUserInput(currentPlayer)).thenReturn(playerOnePosition);

        game.start();

        verify(gameHelper).askForUserInput(nextPlayer);
    }


    @Test
    public void shouldPromptUserToRenterPositionUntilValid() {
        when(board.isAValidPosition("1")).thenReturn(false).thenReturn(false).thenReturn(true);
        when(gameHelper.askForUserInput("1")).thenReturn("1").thenReturn("1");

        game.start();

        verify(printStream, times(2)).println("The position is taken. Please enter another position.");
    }
}