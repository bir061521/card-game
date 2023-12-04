package org.example.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {


    User user = new User();


    @Test
    void validateInputLength() {
        String[] userInput = {"2,3", "4,5"};
        assertDoesNotThrow(() -> User.validateInputLength(userInput));
    }

    @Test
    public void InvalidateInputLength() {
        String[] userInput = {"2,3"};
        assertThrows(IllegalArgumentException.class, () -> User.validateInputLength(userInput));
    }


    @Test
    public void validateInputRange() {
        String[] userInput = {"2", "3"};
        assertDoesNotThrow(() -> User.validateInputRange(userInput));
    }

    @Test
    public void InvalidateInputRange() {
        String[] userInput = {"0,3", "10,5"};
        assertThrows(IllegalArgumentException.class, () -> User.validateInputRange(userInput));

    }

    @Test
    public void validateInputDuplicated() {
        String[] userInput = {"2,3", "4,5"};
        assertDoesNotThrow(() -> User.validateInputDuplicated(userInput));
    }

    @Test
    public void InvalidateInputDuplicated() {
        String[] userInput = {"2,3", "4,5"};
        assertThrows(IllegalArgumentException.class, () -> User.validateInputDuplicated(userInput));
    }

    @Test
    void validateInputNum() {
        String[] inputs = {"1", "2", "3", "4"}; // 가정: 유효한 입력
        assertTrue(User.validateInputNum(inputs));
    }
}