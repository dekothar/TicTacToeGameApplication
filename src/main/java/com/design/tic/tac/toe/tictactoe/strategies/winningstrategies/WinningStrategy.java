package com.design.tic.tac.toe.tictactoe.strategies.winningstrategies;

import com.design.tic.tac.toe.tictactoe.models.Board;
import com.design.tic.tac.toe.tictactoe.models.Move;

public interface WinningStrategy {

    boolean checkWinner(Board board, Move move);
}
