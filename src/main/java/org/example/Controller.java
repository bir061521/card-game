package org.example;

import org.example.model.Card;

import org.example.util.Game;
import org.example.view.InputView;
import org.example.view.OutputView;
import org.example.model.User;

import static org.example.view.OutputView.COMPLETE_GAME;
//### Controller
//        1. 게임 보드 초기화
//        2. 사용자로부터 카드 좌표 입력받기
//        3. 입력한 좌표의 유효성 검사
//        4. 선택한 카드 뒤집기
//        5. 카드의 일치 여부 검사 및 처리
//        6. 게임 상태(시도 횟수, 남은 카드 수 )업데이트
//        7. 게임 종료조건 및 처리

public class Controller {

    public static void startGame(){
        createCard();
        playUser();

    }

    public static void createCard(){
        OutputView.cardInit();
        Card.card();
        OutputView.printBoard();
    }

    public static void playUser(){
        String[] inputs = InputView.userInput(); // 사용자 입력 받기

        if (User.validateInputNum(inputs)) {
            Game.playGame();
            OutputView.printBoard();

        }
    }

}


