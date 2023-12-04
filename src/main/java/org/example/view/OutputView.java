package org.example.view;

import org.example.model.Card;


import java.util.Scanner;



public class OutputView  {

    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                // 만약 카드가 뒤집혔고 매치되지 않았다면 숫자 표시, 그렇지 않다면 'X'로 표시
                System.out.print(Card.flipped[i][j] && !Card.removeMatchedCards(i ,j ,i ,j) ? Card.board[i][j] + " " : "X ");
            }
            System.out.println();
        }
    }




    public static final String  COMPLETE_GAME = "축하합니다~ 게임을 종료하겠습니다.";


    public static void printInvalidInput() {
        System.out.println("입력값을 다시 확인해주세요");
    }

    public static void printGameOver() {
        System.out.println("게임오버");
    }

    public static void printGameState (int attempts, int remainPairs) {
        System.out.println("시도 횟수: " + attempts + ", 남은 카드 쌍: " + remainPairs);
    }


    public static String[] userInput() {
        Scanner sc = new Scanner(System.in);
        System.out.print("입력 1? ");
        String input1 = sc.nextLine();
        System.out.print("입력 2? ");
        String input2 = sc.nextLine();

        return new String[]{input1, input2};
    }

}
