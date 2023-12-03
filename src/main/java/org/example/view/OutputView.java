package org.example.view;

import static org.example.model.Card.board;
import static org.example.model.Card.flipped;
import static org.example.model.RemoveCard.matched;

public class OutputView {
    public static void cardInit(){
        System.out.println( "X X X X X X  \n X X X X X X \n X X X X X X");
    }

    // 보드 출력 메서드
    public static void printBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 6; j++) {
                if (matched[i][j]) {
                    System.out.print("   "); // 일치한 카드는 공백으로 표시
                } else {
                    System.out.print(flipped[i][j] ? board[i][j] + " " : "X ");
                }
            }
            System.out.println();
        }
    }

    public static final String  COMPLETE_GAME = "축하합니다~ 게임을 종료하겠습니다.";


}
