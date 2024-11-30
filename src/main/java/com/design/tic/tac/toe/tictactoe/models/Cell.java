package com.design.tic.tac.toe.tictactoe.models;

import com.design.tic.tac.toe.tictactoe.enums.CellStateEnum;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Cell {

    private int row;
    private int col;
    private CellStateEnum cellState;
    private Player player;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.cellState = CellStateEnum.EMPTY;
    }
}
