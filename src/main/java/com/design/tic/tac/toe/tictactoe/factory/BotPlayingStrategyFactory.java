package com.design.tic.tac.toe.tictactoe.factory;

import com.design.tic.tac.toe.tictactoe.enums.BotLevelEnum;
import com.design.tic.tac.toe.tictactoe.strategies.botplayingstrategies.BotPlayingStrategy;
import com.design.tic.tac.toe.tictactoe.strategies.botplayingstrategies.EasyBotPlayingStrategy;
import com.design.tic.tac.toe.tictactoe.strategies.botplayingstrategies.HardBotPlayingStrategy;
import com.design.tic.tac.toe.tictactoe.strategies.botplayingstrategies.MediumBotPlayingStrategy;

public class BotPlayingStrategyFactory {

    public static BotPlayingStrategy getBotPlayingStrategy(BotLevelEnum botLevelEnum) {
        if(botLevelEnum.equals(BotLevelEnum.EASY)){
            return new EasyBotPlayingStrategy();
        }
        else if(botLevelEnum.equals(BotLevelEnum.MEDIUM)){
            return new MediumBotPlayingStrategy();
        }
        else {
            return new HardBotPlayingStrategy();
        }
    }
}
