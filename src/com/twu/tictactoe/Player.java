package com.twu.tictactoe;

/**
 * Created by kprakobk on 5/1/15.
 */
public class Player {
    private String mark;
    private String name;

    public Player(String mark, String name) {
        this.mark = mark;
        this.name = name;
    }

    public String getMark() {
        return mark;
    }

    public String getName() {
        return name;
    }
}
