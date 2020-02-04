package com.christian.tictactoe;

import java.io.InputStream;
import java.util.Scanner;

/**
 * The type Tic tac toe.
 *
 * @author Christian Iradukunda
 */
public class TicTacToe {

    /**
     * The entry point of application.
     */
    public void init(InputStream in) {

        /* Create player holders */
        String humanPlayerValue;
        String computerPlayerValue;

        /* Initialize the board */
        Board board = new Board();
        String [][] boardValues= {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
        board.setBoard(boardValues);
        /* printing the board*/
        this.printBoard(board);

        /* Getting the user's choice of player */
        System.out.print("Choose between 0 and X players the you are going to use: ");
        Scanner scan = new Scanner(in);
        humanPlayerValue = scan.next().toUpperCase();
        while(humanPlayerValue.isEmpty() || (!humanPlayerValue.equalsIgnoreCase("O") && !humanPlayerValue.equalsIgnoreCase("X"))){
            System.out.print("Choose properly between 0 and X players the you are going to use: ");
            humanPlayerValue = scan.next().toUpperCase();
        }
        if(humanPlayerValue.equalsIgnoreCase("O")){
            System.out.print("You are going to play with: " + humanPlayerValue);
            computerPlayerValue = "X";
        } else {
            System.out.print("You are going to play with: X");
            computerPlayerValue = "O";
        }

        /* mocking playing - making moves */
        while (!board.hasWins(computerPlayerValue) && board.stillHasMoves()) {
            play(board, humanPlayerValue, computerPlayerValue, in);
            this.printBoard(board);
        }
        if(board.hasWins(computerPlayerValue)){
            System.out.printf("payer %s won", board.getWinner());
        } else {
            System.out.print("DRAW");
        }
    }

    /**
     * Play.
     *
     * @param board          the board
     * @param humanPlayer    the human player
     * @param computerPlayer the computer player
     */
    public void play(Board board, String humanPlayer, String computerPlayer, InputStream in){
        System.out.print("\nPick a position to play at: ");
        Scanner scan = new Scanner(in);
        int humanChoice = scan.nextInt();
        while(!board.checkIfSpotIsAvailable(humanChoice)) {
            System.out.println("The chosen position has been taken or does not exist");
            this.printBoard(board);
            scan = new Scanner(System.in);
            humanChoice = scan.nextInt();
        }

        /* put the human choice in the board */
        board.putDataInTheBoard(humanChoice,humanPlayer);

        /* Check if there is no win and there still moves */
        if(!board.hasWins(computerPlayer) && board.stillHasMoves()) {
            MinMax minMax = new MinMax();
            // make the computation and play -- the ai will pick the first position available starting from 1.
            Integer computerChoice = minMax.findingBestMove(board, computerPlayer, humanPlayer);

            /* putting the computer choice in the board*/
            board.putDataInTheBoard(computerChoice, computerPlayer);
        }
    }

    /* A method that prints the board */
    public void printBoard(Board board){
        String [][] boardValues = board.getBoard();
        /* Checking if the board has been initialized*/
        if(boardValues == null || boardValues.length == 0) {
            boardValues = new String[][]{{"1","2","3"},{"4","5","6"},{"7","8","9"}};
        }

        /* Looping through the board positions printing the content. If there no plays it should display position
        numbers */
        for (String[] boardValue : boardValues) {
            for (int j = 0; j < boardValues.length; j++) {
                System.out.print(boardValue[j] + "  |  ");
            }
            System.out.print("\n-  -  -  -  -  -\n");
        }
    }
}