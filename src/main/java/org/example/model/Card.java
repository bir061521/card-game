package org.example.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Card {
    public static int[][] board;
    public static boolean[][] flipped;

    public static void card(){
        cardCreate();
        initializeBoard();;
    }
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


}
