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
            Integer validCell = validateCell(userInputStream.askForCell());

            board.updateCell(currentPlayer.getMark(), validCell);

            if(board.hasWinningCombination()) {
                view.printWinner(currentPlayer.getName());
                break;
            }

            view.printBoardWithInstructions();

            switchCurrentPlayer();
        }
    }

    private Integer validateCell(Integer cell) {
        while(!board.isAValidCell(cell)) {
            view.printInvalidPositionPrompt();
            cell = userInputStream.askForCell();
        }

        return cell;
    }

    private void switchCurrentPlayer() {
        currentPlayer = currentPlayer.equals(playerOne) ? playerTwo : playerOne;
    }
}
