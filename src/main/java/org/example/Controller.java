package org.example;

import org.example.model.Card;
import org.example.model.FlipCard;
import org.example.model.User;
import org.example.util.Game;
import org.example.view.InputView;
import org.example.view.OutputView;


public class Controller {

    public static void startGame() {
        createBoard();
        while (!isGameOver()) {
            playTurn();
        }
        endGame();
    }

    private static void createBoard() {
        // 게임 보드 초기화

        Card.initializeBoard();
        OutputView.printBoard();

    }



    private static void playTurn() {
        try {
            String[] inputs = OutputView.userInput(); // 사용자 입력 받기

            // 입력한 좌표의 유효성 검사
            if (!User.validateInputNum(inputs)) {
                OutputView.printInvalidInput();
                return; // 유효하지 않은 입력 처리
            }

            // 선택한 카드 뒤집기
            FlipCard.flipCard(inputs); // inputs 파라미터 추가

            // 카드 매치 확인
            int row1 = Integer.parseInt(inputs[0]) - 1;
            int col1 = Integer.parseInt(inputs[1]) - 1;
            int row2 = Integer.parseInt(inputs[2]) - 1;
            int col2 = Integer.parseInt(inputs[3]) - 1;



            if (Game.checkCard(row1, col1, row2, col2)) {
               Game.updateGameState();

            } else {
                Game.updateGameState();
            }
            // 게임 상태 업데이트
            Game.updateGameState();

            // 현재 게임 보드 상태 출력
            OutputView.printBoard();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage()); // 예외 메시지 출력
            playTurn(); // 재귀 호출로 다시 사용자 입력 받기
        }
    }

    private static boolean isGameOver() {
        // 게임 종료 조건 확인
        return Game.isGameOver();
    }

    private static void endGame() {
        // 게임 종료 처리
        OutputView.printGameOver();
    }
}