package com.twu.tictactoe;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kprakobk on 5/1/15.
 */
public class PlayerTest {

    @Test
    public void shouldGetMark() {
        String mark = "X";
        Player player = new Player(mark);

        assertEquals("X", player.getMark());
    }
}