package com.twu.tictactoe;

/**
 * Created by kprakobk on 4/30/15.
 */
public class Game {
    private Board board;
    private GameHelper gameHelper;
    private View view;
    private String currentPlayer = "1";

    public Game(Board board, GameHelper gameHelper, View view) {
        this.board = board;
        this.gameHelper = gameHelper;
        this.view = view;
    }

    public void start() {
        view.printBoard();

        play();

        view.printDrawGamePrompt();
    }

    private void play() {
        while(!board.isFull()) {
            String userInput = gameHelper.askForUserInput(currentPlayer);

            userInput = validateUserInput(userInput);
            board.updatePlayerPosition(currentPlayer, userInput);
            view.printBoard();

            switchCurrentPlayer();
        }
    }

    private String validateUserInput(String userInput) {
        while(!board.isAValidPosition(userInput)) {
            view.printInvalidPositionPrompt();
            userInput = gameHelper.askForUserInput(currentPlayer);
        }

        return userInput;
    }

    private void switchCurrentPlayer() {
        currentPlayer = currentPlayer.equals("1") ? "2" : "1";
    }
}
