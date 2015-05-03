package com.twu.tictactoe;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by kprakobk on 5/1/15.
 */
public class PlayerTest {

    private Player player;

    @Test
    public void shouldGetMark() {
        String mark = "X";
        String name = "Player 1";
        player = new Player(mark, name);

        assertEquals("X", player.getMark());
    }
}