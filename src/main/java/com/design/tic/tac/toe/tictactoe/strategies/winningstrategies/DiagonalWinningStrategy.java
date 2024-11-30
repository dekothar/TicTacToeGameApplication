package com.design.tic.tac.toe.tictactoe.strategies.winningstrategies;

import com.design.tic.tac.toe.tictactoe.models.Board;
import com.design.tic.tac.toe.tictactoe.models.Move;
import com.design.tic.tac.toe.tictactoe.models.Symbol;

import java.util.HashMap;
import java.util.Map;

public class DiagonalWinningStrategy implements WinningStrategy {

    private Map<Symbol, Integer> leftDiagonal = new HashMap<>();
    private Map<Symbol, Integer> rightDiagonal = new HashMap<>();

    @Override
    public boolean checkWinner(Board board, Move move) {
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Symbol symbol = move.getPlayer().getSymbol();

        //left Diagonal => row == col
        if (row == col) {
            if (!leftDiagonal.containsKey(symbol)) {
                leftDiagonal.put(symbol, 0);
            }

            leftDiagonal.put(symbol, leftDiagonal.get(symbol) + 1);

            return leftDiagonal.get(symbol).equals(board.getSize());
        }

        //right Diagonal => row + col == dimension - 1
        if (row + col == board.getSize() - 1) {
            if (!rightDiagonal.containsKey(symbol)) {
                rightDiagonal.put(symbol, 0);
            }

            rightDiagonal.put(symbol, rightDiagonal.get(symbol) + 1);

            return rightDiagonal.get(symbol).equals(board.getSize());
        }

        return false;
    }
}
