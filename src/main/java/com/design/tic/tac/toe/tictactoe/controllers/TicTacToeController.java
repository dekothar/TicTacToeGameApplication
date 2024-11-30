package com.design.tic.tac.toe.tictactoe.controllers;

import com.design.tic.tac.toe.tictactoe.enums.GameStateEnum;
import com.design.tic.tac.toe.tictactoe.exceptions.InvalidMoveException;
import com.design.tic.tac.toe.tictactoe.models.Game;
import com.design.tic.tac.toe.tictactoe.models.Player;
import com.design.tic.tac.toe.tictactoe.strategies.winningstrategies.WinningStrategy;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


public class TicTacToeController {

    public Game startGame(int dimension, List<Player> players, List<WinningStrategy> winningStrategies){
        return Game.getBuilder()
                .setDimension(dimension)
                .setPlayers(players)
                .setWinningStrategies(winningStrategies)
                .build();
    }

    public void makeMove(Game game) throws InvalidMoveException {
        game.makeMove();
    }

    public GameStateEnum getGameState(Game game) {
        return game.getGameState();
    }

    public void printBoard(Game game) {
        game.printBoard();
    }

    public Player getWinner(Game game) {
        return game.getWinner();
    }




}
