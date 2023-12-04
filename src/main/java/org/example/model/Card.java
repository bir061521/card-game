package org.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card {
    public static int[][] board;
    public static boolean[][] flipped;


    public static List<Integer> cardCreate(){//1 ~24 개의 카드 구현
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <=8 ; i++) {
            for (int j = 0; j < 3; j++) {
                numbers.add(i);
            }
        }
        Collections.shuffle(numbers);


        return numbers;
    }
    public static void initializeBoard() {
        List<Integer> shuffledNumbers = cardCreate();
        board = new int[3][6];
         flipped = new boolean[3][6];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                board[i][j] = shuffledNumbers.get(i * 6 + j);
                flipped[i][j] = false;
            }
        }
    }




    // 주어진 좌표의 카드가 뒤집혔는지 여부를 반환하는 메소드
    public static boolean isFlipped(int row, int col) {
        // 좌표의 유효성을 확인하고, 유효한 경우 flipped 상태를 반환
        if (row >= 0 && row < board.length && col >= 0 && col < board[row].length) {
            return flipped[row][col];
        }
        return false; // 유효하지 않은 좌표인 경우 false 반환
    }

    // 주어진 좌표의 카드 값(숫자)을 반환하는 메소드
    public static int getCardValue(int row, int col) {
        // 좌표의 유효성을 확인하고, 유효한 경우 카드 값 반환
        if (row >= 0 && row < board.length && col >= 0 && col < board[row].length) {
            return board[row][col];
        }
        return -1; // 유효하지 않은 좌표인 경우 -1 반환
    }


    public static boolean removeMatchedCards(int row1, int col1, int row2, int col2) {
        if (isWithinRange(row1, col1) && isWithinRange(row2, col2)) {
            if (getCardValue(row1, col1) == getCardValue(row2, col2)) {
                // 두 카드가 같으면 뒤집힌 상태를 false로 설정
                flipped[row1][col1] = false;
                flipped[row2][col2] = false;
            }
        }
        return false;
    }


    // 좌표가 유효한 범위 내에 있는지 확인하는 메소드
    private static boolean isWithinRange(int row, int col) {
        return row >= 0 && row < board.length && col >= 0 && col < board[row].length;
    }






}
