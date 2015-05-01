package com.twu.tictactoe;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by kprakobk on 4/30/15.
 */
public class BoardTest {
    private Board board;
    private String[] playerPosition;

    @Before
    public void setUp() {
        playerPosition = new String[9];
        board = new Board(playerPosition);
    }

    @Test
    public void shouldBeFalseWhenBoardIsNotFull() {
        assertFalse(board.isFull());
    }

    @Test
    public void shouldBeTrueWhenBoardIsFull() {
        fillBoard();
        assertTrue(board.isFull());
    }

    @Test
    public void shouldBeFalseWhenInvalidPosition() {
        board.updatePlayerPosition("1", "2");

        assertFalse(board.isAValidPosition("2"));
    }

    @Test
    public void shouldBeTrueWhenValidPosition() {
        assertTrue(board.isAValidPosition("1"));
    }

    private void fillBoard() {
        for (int i = 0; i < playerPosition.length; i++) {
            board.updatePlayerPosition("1", String.valueOf(i + 1));
        }
    }
}