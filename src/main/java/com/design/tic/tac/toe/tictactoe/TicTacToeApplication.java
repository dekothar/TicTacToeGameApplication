package com.design.tic.tac.toe.tictactoe;

import com.design.tic.tac.toe.tictactoe.controllers.TicTacToeController;
import com.design.tic.tac.toe.tictactoe.enums.BotLevelEnum;
import com.design.tic.tac.toe.tictactoe.enums.GameStateEnum;
import com.design.tic.tac.toe.tictactoe.enums.PlayerTypeEnum;
import com.design.tic.tac.toe.tictactoe.models.Bot;
import com.design.tic.tac.toe.tictactoe.models.Game;
import com.design.tic.tac.toe.tictactoe.models.Player;
import com.design.tic.tac.toe.tictactoe.models.Symbol;
import com.design.tic.tac.toe.tictactoe.strategies.winningstrategies.ColumnWinningStrategy;
import com.design.tic.tac.toe.tictactoe.strategies.winningstrategies.DiagonalWinningStrategy;
import com.design.tic.tac.toe.tictactoe.strategies.winningstrategies.RowWinningStrategy;
import com.design.tic.tac.toe.tictactoe.strategies.winningstrategies.WinningStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class TicTacToeApplication {

    public static void main(String[] args) {
        int dimension = 3;
        List<Player> players = new ArrayList<>();
        players.add(new Player("Sasi", PlayerTypeEnum.HUMAN,new Symbol('X')));
        players.add(new Bot("Scaler", BotLevelEnum.EASY,new Symbol('O')));

        List<WinningStrategy> winningStrategies = List.of(
                new RowWinningStrategy(),
                new ColumnWinningStrategy(),
                new DiagonalWinningStrategy()
        );

        TicTacToeController gameController = new TicTacToeController();
        Game game = gameController.startGame(
                dimension,
                players,
                winningStrategies
        );

        while (game.getGameState().equals(GameStateEnum.IN_PROGRESS)) {
            //1. Print the board.
            //2. Ask user to choose where they want to make the move.
            gameController.printBoard(game);

            gameController.makeMove(game);
        }

        if (game.getGameState().equals(GameStateEnum.COMPLETED)) {
            gameController.printBoard(game);
            System.out.println(gameController.getWinner(game).getName() + " has WON the game");
        } else {
            System.out.println("Game draw");
        }
        SpringApplication.run(TicTacToeApplication.class, args);
    }

}
