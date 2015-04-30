package com.twu.tictactoe;

import java.io.PrintStream;

/**
 * Created by kprakobk on 4/30/15.
 */
public class Main {
    public static void main(String[] args) {
        PrintStream out = System.out;
        Board board = new Board(out);
        GameHelper gameHelper = new GameHelper(out);
        Game game = new Game(board, gameHelper, out);
        game.start();
    }
}