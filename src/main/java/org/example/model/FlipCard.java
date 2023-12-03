package org.example.model;

import static org.example.model.Card.*;

public class FlipCard {



    public static String flipCard(int row, int col) {
        if (row < 0 || row >= 3 || col < 0 || col >= 6) {
            return "잘못된 좌표입니다.";
        }

        flipped[row][col] = !flipped[row][col];

        if (flipped[row][col]) {
            return  Integer.toString(board[row][col]);
        } else {
            return "X";
        }
    }



}
