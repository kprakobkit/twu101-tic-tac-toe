package com.twu.tictactoe;

/**
 * Created by kprakobk on 4/30/15.
 */
public class Game {
    private Board board;
    private UserInputStream userInputStream;
    private View view;
    private String currentPlayer = "1";

    public Game(Board board, UserInputStream userInputStream, View view) {
        this.board = board;
        this.userInputStream = userInputStream;
        this.view = view;
    }

    public void start() {
        view.printBoard();

        playUntilDone();

        view.printDrawGamePrompt();
    }

    private void playUntilDone() {
        while(!board.isFull()) {
            Integer validPosition = validateUserInput(userInputStream.askForCellPosition());

            board.updatePlayerPosition(currentPlayer, validPosition);
            view.printBoard();

            switchCurrentPlayer();
        }
    }

    private Integer validateUserInput(Integer userInput) {
        while(!board.isAValidCell(userInput)) {
            view.printInvalidPositionPrompt();
            userInput = userInputStream.askForCellPosition();
        }

        return userInput;
    }

    private void switchCurrentPlayer() {
        currentPlayer = currentPlayer.equals("1") ? "2" : "1";
    }
}
