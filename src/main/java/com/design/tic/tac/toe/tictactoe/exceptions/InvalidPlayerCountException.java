package com.design.tic.tac.toe.tictactoe.exceptions;

public class InvalidPlayerCountException extends RuntimeException{

    public InvalidPlayerCountException(String message) {
        super(message);
    }
}
