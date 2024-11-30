package com.design.tic.tac.toe.tictactoe.models;

import com.design.tic.tac.toe.tictactoe.enums.CellStateEnum;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Board {

    private int size;
    private List<List<Cell>> cells;

    public Board(int size) {
        this.size = size;
        this.cells=new ArrayList<>();

        for(int i=0; i<size; i++) {
            cells.add(new ArrayList<>());
            for(int j=0; j<size; j++) {
                cells.get(i).add(new Cell(i, j));
            }
        }
    }
    public void printBoard() {
        for(List<Cell> row : cells) {
            for(Cell cell : row) {
                if(cell.getCellState() == CellStateEnum.EMPTY) {
                    System.out.print("|   |");
                }
                else {
                    System.out.print("| " + cell.getPlayer().getSymbol().getMark() + " |") ;
                }
            }
            System.out.println();
        }

    }
}
