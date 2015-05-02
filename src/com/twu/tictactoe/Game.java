package com.twu.tictactoe;

/**
 * Created by kprakobk on 4/30/15.
 */
public class Game {
    private Board board;
    private UserInputStream userInputStream;
    private View view;
    private Player playerOne;
    private Player playerTwo;
    private Player currentPlayer;

    public Game(Board board, UserInputStream userInputStream, View view, Player playerOne, Player playerTwo) {
        this.board = board;
        this.userInputStream = userInputStream;
        this.view = view;
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.currentPlayer = playerOne;
    }

    public void start() {
        view.printBoard();

        playUntilDone();

        view.printDrawGamePrompt();
    }

    private void playUntilDone() {
        while(!board.isFull()) {
            Integer validPosition = validateUserInput(userInputStream.askForCellPosition());

            board.updateCell(currentPlayer.getMark(), validPosition);
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
        currentPlayer = currentPlayer.equals(playerOne) ? playerTwo : playerOne;
    }
}
