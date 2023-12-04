package org.example.model;

import static org.example.model.Card.*;

public class FlipCard {

    public static String flipCard(String[] inputs) {
        int row1 = Integer.parseInt(inputs[0]) - 1;
        int col1 = Integer.parseInt(inputs[1]) - 1;
        int row2 = Integer.parseInt(inputs[2]) - 1;
        int col2 = Integer.parseInt(inputs[3]) - 1;

        // 각 좌표의 범위 검사
        if (row1 < 0 || row1 >= 3 || col1 < 0 || col1 >= 6 || row2 < 0 || row2 >= 3 || col2 < 0 || col2 >= 6) {
            return "잘못된 좌표입니다.";
        }

        // 첫 번째 카드 뒤집기
        flipped[row1][col1] = !flipped[row1][col1];
        String result1 = flipped[row1][col1] ? Integer.toString(board[row1][col1]) : "X";

        // 두 번째 카드 뒤집기
        flipped[row2][col2] = !flipped[row2][col2];
        String result2 = flipped[row2][col2] ? Integer.toString(board[row2][col2]) : "X";

        // 두 카드의 결과 반환
        return result1 + ", " + result2;
    }

}
