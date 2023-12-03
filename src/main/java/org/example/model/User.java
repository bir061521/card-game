package org.example.model;


import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.example.view.InputView.*;


public class User {

    public static void validateInputNum(){
        String[] userInput = userInput();

        validateInputLength(userInput);
        validateInputRange(userInput);
        validateInputDuplicated(userInput);

        List<Integer> convertedInput = changeStrToList(userInput);
//        changeStrToList(userInput);
    }

    private static  List<Integer> changeStrToList(String[] input) {
        return Arrays.stream(input) // 문자열 배열을 스트림으로 변환
                .map(String::trim) // 앞뒤 공백 제거
                .map(Integer::parseInt) // 문자열을 정수로 변환
                .collect(Collectors.toList()); // 결과를 List<Integer>로 수집
    }

    public static void validateInputLength(String[] userInput){
        if (userInput.length != 2 ){
            throw new IllegalArgumentException(INPUT_LENGTH_EXCEPTION);
        }
    }


    public static boolean distinctCount(String[] userInput){
        long distinctCount = Arrays.stream(userInput).distinct().count();
        return distinctCount == userInput().length;
    }


    public static void validateInputRange(String[] userInput){

        try{
            int x = Integer.parseInt(userInput[0].trim());
            int y = Integer.parseInt(userInput[1].trim());

            if(x <=  1 || x >=  8 || y <= 1 || y>= 8){
                throw new IllegalArgumentException("변경예정");   //  시도 남은카드 출력
            }
        }catch (NumberFormatException e){
            throw new IllegalArgumentException(INPUT_RANGE_EXCEPTION);
        }

    }



    public static void validateInputDuplicated(String[] userInput){
        if(!distinctCount(userInput)){
            throw new IllegalArgumentException(INPUT_DUPLICATE_EXCEPTION);
        }
    }

}
