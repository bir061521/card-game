package org.example.util;

//✅두 카드가 일치하는지 확인 -> 일치한다면 제거


import org.example.model.Card;
import org.example.model.FlipCard;
import org.example.model.RemoveCard;
import org.example.model.User;
import org.example.view.InputView;
import org.example.view.OutputView;

import java.util.List;

import static org.example.view.OutputView.COMPLETE_GAME;

//✅ 게임 종료 조건 확인
//
//        모든 카드를 맞추거나 더 이상 남은 짝이 없을 경우 축하메세지 출력과 종료
//
// ✅ 반복하기
//
//        게임이 끝나지 않았을 경우 1부터 반복
//
//✅ 게임 상태 업데이트
//
//        게임 상태(시도 횟수, 남은 칻 수 )업데이트
public class Game {

    public static void playGame(){
        compareCard();
        completeGame();
    }

    static int attempts = 0;
    static int remainingsPairs = 12;
    public static void compareCard() {
        Card.initializeBoard();


        while (remainingsPairs >0){
            String[] inputs = InputView.userInput();


// 입력된 좌표를 정수로 변환
            int row1 = Integer.parseInt(inputs[0]) - 1;
            int col1 = Integer.parseInt(inputs[1]) - 1;
            int row2 = Integer.parseInt(inputs[2]) - 1;
            int col2 = Integer.parseInt(inputs[3]) - 1;

// 입력된 좌표가 유효한지 검사
            boolean isValidInput = User.validateInputNum(new String[] {
                    inputs[0], inputs[1], inputs[2], inputs[3]
            });

            String card1 = FlipCard.flipCard(row1, col1);
            String card2 = FlipCard.flipCard(row2, col2);
            if (isValidInput) {
                RemoveCard.removeMatchedCards(row1,col1,row2,col2);
                remainingsPairs--;

                OutputView.printBoard();
            } else {
                Card.initializeBoard();
            }

            attempts++;
        }
    }
    public static void completeGame()
    {
        if(remainingsPairs == 0){
            System.out.println(COMPLETE_GAME);

        }
    }

}
