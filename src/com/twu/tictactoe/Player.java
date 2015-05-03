package com.twu.tictactoe;

/**
 * Created by kprakobk on 5/1/15.
 */
public class Player {
    private Board board;
    private UserInputStream userInputStream;
    private View view;
    private String mark;
    private String name;

    public Player(String mark, String name, Board board, UserInputStream userInputStream, View view) {
        this.mark = mark;
        this.name = name;
        this.board = board;
        this.userInputStream = userInputStream;
        this.view = view;
    }

    public String getName() {
        return name;
    }

    public void makeAMove() {
        Integer cell = askForCell();
        board.updateCell(mark, cell);
    }

    private Integer askForCell() {
        Integer validCell = validateCell(Integer.parseInt(userInputStream.getInput()));

        return validCell;
    }

    private Integer validateCell(Integer cell) {
        while(!board.isAValidCell(cell)) {
            view.printInvalidPositionPrompt();
            cell = Integer.parseInt(userInputStream.getInput());
        }

        return cell;
    }
}
