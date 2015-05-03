package com.twu.tictactoe;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;

/**
 * Created by kprakobk on 4/30/15.
 */
public class Main {
    public static void main(String[] args) {
        PrintStream out = System.out;

        // Initialize board
        String[] cells = new String[9];
        Board board = new Board(cells);

        UserInputStream userInputStream = new UserInputStream(new BufferedReader(new InputStreamReader(System.in)));
        View view = new View(out, board);

        // Initialize players
        Player playerOne = new Player("X", "Player 1", board, userInputStream, view);
        Player playerTwo = new Player("O", "Player 2", board, userInputStream, view);


        Game game = new Game(board, userInputStream, view, playerOne, playerTwo);

        game.start();
    }
}