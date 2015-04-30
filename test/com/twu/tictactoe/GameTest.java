package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by kprakobk on 4/30/15.
 */
public class GameTest {

    private Board board;
    private Game game;
    private GameHelper gameHelper;

    @Before
    public void setUp() throws Exception {
        board = mock(Board.class);
        gameHelper = mock(GameHelper.class);
        game = new Game(board, gameHelper);
    }

    @Test
    public void shouldDisplayBoardWhenStarting() {
        game.start();

        verify(board).printBoard();
    }

    @Test
    public void shouldAskPlayerOneForInputWhenItIsPlayerOnesTurn() {
        game.start();

        verify(gameHelper).askForUserInput("1");
    }

    @Test
    public void shouldRedrawBoardAfterReceivingPositionFromUser() {
        String position = "1";
        String currentPlayer = "1";

        when(gameHelper.askForUserInput(currentPlayer)).thenReturn(position);

        game.start();

        verify(board).redraw(currentPlayer, position);
    }

    @Test
    public void shouldBePlayersTwoTurnAfterPlayerOneEntersAPosition() {
        String playerOneInput = "1";
        String currentPlayer = "1";
        String playerTwoInput = "2";

        when(gameHelper.askForUserInput(currentPlayer)).thenReturn(playerOneInput);

        game.start();

        verify(gameHelper).askForUserInput("2");
    }
}