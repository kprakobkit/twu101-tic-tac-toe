package com.twu.tictactoe;

import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * Created by kprakobk on 4/30/15.
 */
public class BoardTest {
    private Board board;
    private String[] cells;

    @Before
    public void setUp() {
        cells = new String[9];
        board = new Board(cells);
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
        board.updateCell("X", 2);

        assertFalse(board.isAValidCell(2));
    }

    @Test
    public void shouldBeTrueWhenValidPosition() {
        assertTrue(board.isAValidCell(1));
    }

    private void fillBoard() {
        for (int i = 0; i < cells.length; i++) {
            board.updateCell("1", i + 1);
        }
    }
}