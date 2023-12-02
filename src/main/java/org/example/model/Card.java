package org.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card {

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
    public static int[][] cardBoard() {//보드 생성
        List<Integer> shuffledNumbers = cardCreate();
        int[][]board = new int[3][6];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                board[i][j] = shuffledNumbers.get(i*6 + j);
            }

        }
        return board;
    }

}
