package com.design.tic.tac.toe.tictactoe.models;

import com.design.tic.tac.toe.tictactoe.enums.CellStateEnum;
import com.design.tic.tac.toe.tictactoe.enums.GameStateEnum;
import com.design.tic.tac.toe.tictactoe.enums.PlayerTypeEnum;
import com.design.tic.tac.toe.tictactoe.exceptions.InvalidBotCountException;
import com.design.tic.tac.toe.tictactoe.exceptions.InvalidMoveException;
import com.design.tic.tac.toe.tictactoe.exceptions.InvalidPlayerCountException;
import com.design.tic.tac.toe.tictactoe.strategies.winningstrategies.WinningStrategy;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class Game {

    private List<Player> players;
    private int nextPlayerMoveIndex;
    private Player winner;
    private GameStateEnum gameState;
    private List<Move> moves;
    private List<WinningStrategy> winningStrategies;
    private Board board;
    private Game(int dimension,List<Player> players,List<WinningStrategy> winningStrategies) {
        this.board = new Board(dimension);
        this.players = players;
        this.nextPlayerMoveIndex = 0;
        this.gameState = GameStateEnum.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.winningStrategies = winningStrategies;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public void printBoard() {
        board.printBoard();
    }

    private boolean validateMove(Move move) {
        Player currPlayer=move.getPlayer();
        Cell cell = move.getCell();
        int row = cell.getRow();
        int col = cell.getCol();
        if(row<0 || row>= board.getSize() || col<0 || col>= board.getSize() || !board.getCells().get(row).get(col).equals(CellStateEnum.EMPTY)) {
            return false;
        }
        return true;
    }

    public void makeMove() {
        Player currPlayer=players.get(nextPlayerMoveIndex);
        System.out.println("It is " + currPlayer.getName() + "'s move");
        Move move=currPlayer.makeMove(board);
        if(!validateMove(move)) {
         throw new InvalidMoveException("This move is Invalid pls try again");
        }
        int row = move.getCell().getRow();
        int col = move.getCell().getCol();
        Cell cell = board.getCells().get(row).get(col);
        cell.setPlayer(currPlayer);
        cell.setCellState(CellStateEnum.OCCUPIED);
        Move finalMove=new Move(currPlayer,cell);
        moves.add(finalMove);
        nextPlayerMoveIndex=(nextPlayerMoveIndex+1)%players.size();
        if(checkWinner(finalMove)){
            winner=currPlayer;
            gameState=GameStateEnum.COMPLETED;
        }
        else if(moves.size()==board.getSize()*board.getSize()){
            gameState=GameStateEnum.DRAW;
        }

    }

    public boolean checkWinner(Move move) {
        for(WinningStrategy winningStrategy : winningStrategies) {
            if(winningStrategy.checkWinner(board, move)) {
                return true;
            }
        }
        return false;
    }

    public static class Builder {
        private List<Player> players;
        private int dimension;
        private List<WinningStrategy> winningStrategies;

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setDimension(int dimension) {
            this.dimension = dimension;
            return this;
        }

        public Builder setWinningStrategies(List<WinningStrategy> winningStrategies) {
            this.winningStrategies = winningStrategies;
            return this;
        }

        private void validateBotCount() throws InvalidBotCountException {
            int botCount = 0;
            for (Player player : players) {
                if (player.getPlayerType().equals(PlayerTypeEnum.BOT)) {
                    botCount += 1;
                }
            }

            if (botCount > 1) {
                throw new InvalidBotCountException("Only 1 bot is allowed per game.");
            }
        }

        private void validatePlayerCount() throws InvalidPlayerCountException {
            if (players.size() != dimension - 1) {
                throw new InvalidPlayerCountException("Number of players should be 1 less than the dimension");
            }
        }

        private void validate() throws InvalidBotCountException, InvalidPlayerCountException {
            validateBotCount();
            validatePlayerCount();

        }

        public Game build() throws InvalidBotCountException, InvalidPlayerCountException {
            //Before building the game we should first validate the game object.
            validate();

            return new Game(
                    dimension,
                    players,
                    winningStrategies
            );
        }
    }

}
