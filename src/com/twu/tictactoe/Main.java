package com.twu.tictactoe;

import java.io.PrintStream;

/**
 * Created by kprakobk on 4/30/15.
 */
public class Main {
    public static void main(String[] args) {
        PrintStream out = System.out;
        PlayerPosition playerPosition = new PlayerPosition();
        Board board = new Board(playerPosition);
        GameHelper gameHelper = new GameHelper(out);
        View view = new View(out, board);
        Game game = new Game(board, gameHelper, view);

        game.start();
    }
}