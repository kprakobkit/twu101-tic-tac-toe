package com.twu.tictactoe;

import java.io.PrintStream;
import java.util.Arrays;

/**
 * Created by kprakobk on 4/30/15.
 */
public class Board {
    private String[] playerPositions = new String[9];

    private String boardString;

    public Board(PlayerPosition playerPosition) {
        initializePlayerPositions();
    }

    private void initializePlayerPositions() {
        Arrays.fill(playerPositions, "   ");
    }

    public void updatePlayerPosition(String currentUser, String positionOnBoard) {
        String mark = currentUser.equals("1") ? " X " : " O ";
        playerPositions[Integer.parseInt(positionOnBoard) - 1] = mark;
    }

    public boolean isAValidPosition(String position) {
        return !playerPositions[Integer.parseInt(position) - 1].equals(" X ") && !playerPositions[Integer.parseInt(position) - 1].equals(" O ");
    };

    public boolean isFull() {
        Boolean isFull = true;

        for (String playerPosition : playerPositions) {
            if (playerPosition.equals("   ")) {
                isFull = false;
            }
        }

        return isFull;
    }

    @Override
    public String toString() {
        return  playerPositions[0] + "|" +  playerPositions[1] + "|" + playerPositions[2] + "\n" +
                "-----------\n" +
                playerPositions[3] + "|" +  playerPositions[4] + "|" + playerPositions[5] + "\n" +
                "-----------\n" +
                playerPositions[6] + "|" +  playerPositions[7] + "|" + playerPositions[8];
    }
}
