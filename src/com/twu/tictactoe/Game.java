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
        view.printBoardWithInstructions();

        playUntilDone();

        view.printDrawGamePrompt();
    }

    private void playUntilDone() {
        while(!board.isFull()) {

            currentPlayer.makeAMove();

            if(board.hasWinningCombination()) {
                view.printWinner(currentPlayer.getName());
                break;
            }

            view.printBoardWithInstructions();

            switchCurrentPlayer();
        }
    }

    private void switchCurrentPlayer() {
        currentPlayer = currentPlayer.equals(playerOne) ? playerTwo : playerOne;
    }
}
