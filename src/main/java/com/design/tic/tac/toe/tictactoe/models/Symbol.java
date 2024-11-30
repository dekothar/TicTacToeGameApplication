package com.design.tic.tac.toe.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Symbol {

    private char mark;
    public Symbol(char mark) {
         this.mark = mark;
    }
}
