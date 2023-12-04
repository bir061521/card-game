package org.example.model;


import org.example.view.InputView;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.example.view.InputView.*;


public class User {


    public static boolean validateInputNum(String[] userInput){

        try {
            validateInputLength(userInput);
            validateInputRange(userInput);
            validateInputDuplicated(userInput);

            // 모든 유효성 검사가 성공했으므로 true 반환
            return true;
        } catch (IllegalArgumentException e) {
            // 유효성 검사 중 하나라도 실패하면 false 반환
            return false;
        }

    }


    public static void validateInputLength(String[] userInput){
        if (userInput.length != 2 ){
            throw new IllegalArgumentException("입력된 길이가 올바르지 않습니다");
        }
    }





    public static void validateInputRange(String[] userInput){

        try{
            int x = Integer.parseInt(userInput[0].trim());
            int y = Integer.parseInt(userInput[1].trim());

            if(x < 1 || x > 8 || y < 1 || y > 8){
                throw new IllegalArgumentException("좌표는 1과 8 사이의 숫자여야 합니다.");  //  시도 남은카드 출력
            }
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("입력된 숫자의 범위를 벗어났습니다.");
        }

    }

    public static boolean distinctCount(String[] userInput){


        Set<String> uniqueCoordinates = Arrays.stream(userInput)
                .collect(Collectors.toSet());
        return uniqueCoordinates.size() == userInput.length;
    }



    public static void validateInputDuplicated(String[] userInput){
        if(!distinctCount(userInput)){
            throw new IllegalArgumentException("중복된 입력입니다");
        }
    }

}
