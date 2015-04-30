package com.twu.tictactoe;

/**
 * Created by kprakobk on 4/30/15.
 */
public class Game {
    private Board board;
    private GameHelper gameHelper;
    private String currentPlayer = "1";
    private Boolean over = false;

    public Game(Board board, GameHelper gameHelper) {
        this.board = board;
        this.gameHelper = gameHelper;
    }

    public void start() {
        board.printBoard();
        String userInput = gameHelper.askForUserInput(currentPlayer);
        if (board.isAValidPosition(userInput)) {
            board.redraw(currentPlayer, userInput);
        }
        currentPlayer = currentPlayer.equals("1") ? "2" : "1";
        userInput = gameHelper.askForUserInput(currentPlayer);
        if (board.isAValidPosition(userInput)) {
            board.redraw(currentPlayer, userInput);
        }
    }
}
