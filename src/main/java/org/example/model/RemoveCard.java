package org.example.model;

public class RemoveCard {

    public static boolean [][] matched;

    public static void removeMatchedCards(int row1, int col1, int row2, int col2){
        if(isWithinRange(row1,col1) && isWithinRange(row2, col2)){
            matched[row1][col1] = true;
            matched[row2][col2] = true;
        }
    }
    private static boolean isWithinRange(int row, int col) {
        return row >= 0 && row < 3 && col >= 0 && col < 6;
    }

}
