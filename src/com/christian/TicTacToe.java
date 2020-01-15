package com.christian;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        /* Initialize the board */
        String [][] board= {{"1","2","3"},{"4","5","6"},{"7","8","9"}};

        /* printing the board*/
        printBoard(board);
    }

    /* A method that prints the board */
    private static void printBoard(String [][] board){
        /* Checking if the board has been initialized*/
        if(board == null) {
            System.out.print("The board does not exist");
            System.exit(1);
        }

        /* Looping through the board positions printing the content. If there no plays it should display position
        numbers */
        for(int i=0; i<=2; i++){
            for(int j=0; j<=2; j++){
                System.out.print(board[i][j] + "  |  ");
            }
            System.out.print("\n-  -  -  -  -  -\n");
        }
    }

}
