package com.design.tic.tac.toe.tictactoe.strategies.winningstrategies;

import com.design.tic.tac.toe.tictactoe.models.Board;
import com.design.tic.tac.toe.tictactoe.models.Move;
import com.design.tic.tac.toe.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class ColumnWinningStrategy implements WinningStrategy {
   //(key->columnIndex,(key,value)->(Symbol,count of symbol on that particular column)
    private Map<Integer, Map<Symbol,Integer>> columnsCount=new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int column=move.getCell().getCol();
        if(columnsCount.get(column)==null){
            columnsCount.put(column, new HashMap<>());
        }
        Map<Symbol,Integer> columnCount=columnsCount.get(column);
        if(columnCount.get(move.getPlayer().getSymbol())==null){
            columnCount.put(move.getPlayer().getSymbol(), 0);
        }
        columnCount.put(move.getPlayer().getSymbol(), columnCount.get(move.getPlayer().getSymbol())+1);
        return columnCount.get(move.getPlayer().getSymbol()).equals(board.getSize());
    }
}
