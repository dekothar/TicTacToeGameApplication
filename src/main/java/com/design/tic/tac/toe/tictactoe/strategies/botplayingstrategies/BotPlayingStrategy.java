package com.design.tic.tac.toe.tictactoe.strategies.botplayingstrategies;

import com.design.tic.tac.toe.tictactoe.models.Board;
import com.design.tic.tac.toe.tictactoe.models.Move;

public interface BotPlayingStrategy {
  Move makeMove(Board board);
}
