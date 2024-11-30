package com.design.tic.tac.toe.tictactoe.models;

import com.design.tic.tac.toe.tictactoe.enums.BotLevelEnum;
import com.design.tic.tac.toe.tictactoe.enums.PlayerTypeEnum;
import com.design.tic.tac.toe.tictactoe.factory.BotPlayingStrategyFactory;
import com.design.tic.tac.toe.tictactoe.strategies.botplayingstrategies.BotPlayingStrategy;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Bot extends Player{

    private BotLevelEnum botDifficultyLevel;
    private BotPlayingStrategy botPlayingStrategy;

    public Bot(String name, BotLevelEnum botDifficultyLevel, Symbol symbol) {
        super(name, PlayerTypeEnum.BOT, symbol);
        this.botDifficultyLevel = botDifficultyLevel;
        this.botPlayingStrategy = BotPlayingStrategyFactory.getBotPlayingStrategy(botDifficultyLevel);
    }

    public Move makeMove(Board board) {
        Move move = botPlayingStrategy.makeMove(board);
        move.setPlayer(this);

        return move;
    }
}
