package com.design.tic.tac.toe.tictactoe.exceptions;

public class InvalidMoveException extends RuntimeException {

    public InvalidMoveException(String message) {
        super(message);
    }
}
