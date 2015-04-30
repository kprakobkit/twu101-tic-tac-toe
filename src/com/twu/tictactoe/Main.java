package com.twu.tictactoe;

/**
 * Created by kprakobk on 4/30/15.
 */
public class Main {
    public static void main(String[] args) {
        Board board = new Board(System.out);
        Game game = new Game(board);
        game.start();
    }

}