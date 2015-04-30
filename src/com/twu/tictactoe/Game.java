package com.twu.tictactoe;

import java.io.PrintStream;

/**
 * Created by kprakobk on 4/30/15.
 */
public class Game {
    private Board board;
    private GameHelper gameHelper;
    private PrintStream printStream;
    private String currentPlayer = "1";
    private Boolean over = false;

    public Game(Board board, GameHelper gameHelper, PrintStream printStream) {
        this.board = board;
        this.gameHelper = gameHelper;
        this.printStream = printStream;
    }

    public void start() {
        board.printBoard();
        String userInput = gameHelper.askForUserInput(currentPlayer);

        do {
            while(!board.isAValidPosition(userInput)) {
                printStream.println("The position is taken. Please enter another position.");
                userInput = gameHelper.askForUserInput(currentPlayer);
            }
            board.redraw(currentPlayer, userInput);

            currentPlayer = currentPlayer.equals("1") ? "2" : "1";

            userInput = gameHelper.askForUserInput(currentPlayer);
        } while(!board.isFull());

        printStream.println("Game is a draw");
    }
}
