package org.example.util;

import org.example.model.Card;
import org.example.view.OutputView;


import static org.example.view.OutputView.COMPLETE_GAME;

public class Game {

        static int attempts = 0;
       static int remainPairs = 12;
        
        
        //카드 체크해서 없애고,상태 확인하는 메서ㅁ
        public static boolean checkCard(int row1, int col1, int row2, int col2) {
            // 카드가 뒤집힌 상태인지 확인
            if (!Card.isFlipped(row1, col1) || !Card.isFlipped(row2, col2)) {
                return false;
            }
            attempts++;


            // 두 카드가 같은지 확인
            if (Card.getCardValue(row1, col1) == Card.getCardValue(row2, col2)) {
                // 두 카드가 같으면 매치 처리
                Card.removeMatchedCards(row1, col1, row2, col2);
                remainPairs--;
                return true;
            }



            return false;
        }


        

    public static void completeGame() {
        if (remainPairs == 0) {
            System.out.println(COMPLETE_GAME);
        }
    }

    public static void updateGameState() {
        // 현재까지의 시도 횟수와 남은 카드 쌍의 수를 출력
        OutputView.printGameState(attempts, remainPairs);
        OutputView.printBoard();

    }

    // 게임이 종료되었는지 확인하는 메소드
    public static boolean isGameOver() {
        // 모든 카드 쌍이 매치되었거나 다른 종료 조건이 충족되었는지 확인
        return remainPairs == 0;
    }
}

