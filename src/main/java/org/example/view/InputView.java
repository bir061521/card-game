package org.example.view;

import java.util.Scanner;


public class InputView {
    private static final int initAttempt = 0;
    private static final int initRemainCard = 18;

    public static final String INPUT_LENGTH_EXCEPTION = "잘못 입력하셨습니다. 길이가 초과되지 않았는지 다시 확인해주세요";
    public static final String INPUT_RANGE_EXCEPTION = "잘못입력하셨습니다. 입력하신 숫자의 범위를 확인해주세요";

   public static final int INPUT_LENGTH = 2;
    public static final String INPUT_DUPLICATE_EXCEPTION = "중복된 입력값이 있습니다.";



    public static String[] userInput(){
        Scanner sc = new Scanner(System.in);
        System.out.println("<시도" + initAttempt + ", 남은 카드: " + initRemainCard +  ">  좌표를 두 번 입력하세요.");

        System.out.println("입력 1" + "? " );
        String input1 = sc.nextLine();
        System.out.println("입력 2" + "? " );
        String input2 = sc.nextLine();

        return new String[]{input1,input2};
    }




}
