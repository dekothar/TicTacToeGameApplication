package com.design.tic.tac.toe.tictactoe.models;

import com.design.tic.tac.toe.tictactoe.enums.PlayerTypeEnum;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Getter @Setter
public class Player {

    private String name;
    private PlayerTypeEnum playerType;
    private Symbol symbol;
    private static Scanner scanner = new Scanner(System.in);

    public Player(String name, PlayerTypeEnum playerType, Symbol symbol) {
        this.name = name;
        this.playerType = playerType;
        this.symbol = symbol;
    }

    public Move makeMove(Board board){
        System.out.println("Enter the row index where u want to make ur move");
        int row=scanner.nextInt();
        System.out.println("Row Entered is" + row);
        System.out.println("Enter the column index where u want to make ur move");
        int column=scanner.nextInt();
        System.out.println("Column Entered is" + column);
        return new Move(this,new Cell(row,column));
    }
}
