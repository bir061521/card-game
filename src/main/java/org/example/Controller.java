package org.example;

import org.example.model.Card;

import org.example.view.OutputView;
import org.example.model.User;



public class Controller {

    public static void startGame(){
       createCard();

    }

    public static void createCard(){
        Card.cardBoard();
        OutputView.cardInit();
        User.validateInputNum();

    }

}
