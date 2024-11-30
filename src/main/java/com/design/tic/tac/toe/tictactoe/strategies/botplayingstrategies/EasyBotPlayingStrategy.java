package com.design.tic.tac.toe.tictactoe.strategies.botplayingstrategies;

import com.design.tic.tac.toe.tictactoe.enums.CellStateEnum;
import com.design.tic.tac.toe.tictactoe.models.Board;
import com.design.tic.tac.toe.tictactoe.models.Cell;
import com.design.tic.tac.toe.tictactoe.models.Move;

import java.util.List;

public class EasyBotPlayingStrategy implements BotPlayingStrategy {
    @Override
    public Move makeMove(Board board) {
        for(List<Cell> cells : board.getCells()) {
            for(Cell cell : cells) {
                if(cell.getCellState().equals(CellStateEnum.EMPTY)){
                    return new Move(null,cell);
                }
            }
        }
        return null;
    }
}
