package com.twu.tictactoe;

/**
 * Created by kprakobk on 4/30/15.
 */
public class Game {
    private Board board;
    private GameHelper gameHelper;
    private String currentPlayer = "1";

    public Game(Board board, GameHelper gameHelper) {
        this.board = board;
        this.gameHelper = gameHelper;
    }

    public void start() {
        board.printBoard();
        String userInput = gameHelper.askForUserInput(currentPlayer);
        board.redraw(currentPlayer, userInput);
    }
}
