package org.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void cardCreate() {
        Card.initializeBoard();
        assertEquals(24, Card.cardCreate().size());
    }

    @Test
    void initializeBoard() {
        Card.initializeBoard();
        assertNotNull(Card.board);
        assertNotNull(Card.flipped);
    }

    @Test
    void isFlipped() {
        Card.initializeBoard();
        assertFalse(Card.isFlipped(0, 0)); // 초기에는 모든 카드가 뒤집혀있지 않아야 함
    }

    @Test
    void getCardValue() {
        Card.initializeBoard();
        assertTrue(Card.getCardValue(0, 0) >= 1 && Card.getCardValue(0, 0) <= 8); // 각 카드 값은 1에서 8 사이의 숫자여야 함
    }

    @Test
    void removeMatchedCards() {
        Card.initializeBoard();
        assertFalse(Card.removeMatchedCards(0, 0, 1, 1)); // 일치하지 않는 카드를 제거하려고 할 때 false 여야 함
    }
}
