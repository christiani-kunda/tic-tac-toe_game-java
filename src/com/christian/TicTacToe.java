package com.christian;

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
    public void init() {

        /* Create player holders */
        String humanPlayer;
        String computerPlayer;

        /* Initialize the board */
        Board board = new Board();
        String [][] boardValues= {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
        board.setBoard(boardValues);
        /* printing the board*/
        board.printBoard();

        /* Getting the user's choice of player */
        System.out.print("Choose between 0 and X players the you are going to use: ");
        Scanner scan = new Scanner(System.in);
        humanPlayer = scan.next().toUpperCase();
        while(humanPlayer.isEmpty() || (!humanPlayer.equalsIgnoreCase("O") && !humanPlayer.equalsIgnoreCase("X"))){
            System.out.print("Choose properly between 0 and X players the you are going to use: ");
            humanPlayer = scan.next().toUpperCase();
        }
        if(humanPlayer.equalsIgnoreCase("O")){
            System.out.print("You are going to play with: " + humanPlayer);
            computerPlayer = "X";
        } else {
            System.out.print("You are going to play with: X");
            computerPlayer = "O";
        }

        /* mocking playing - making moves */
        while (!board.checkWins(computerPlayer) && board.stillHasMoves()) {
            play(board, humanPlayer, computerPlayer);
            board.printBoard();
        }
        if(board.checkWins(computerPlayer)){
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
    private void play(Board board, String humanPlayer, String computerPlayer){
        System.out.print("\nPick a position to play at: ");
        Scanner scan = new Scanner(System.in);
        int humanChoice = scan.nextInt();
        while(!board.checkIfSpotIsAvailable(humanChoice)) {
            System.out.println("The chosen position has been taken or does not exist");
            board.printBoard();
            scan = new Scanner(System.in);
            humanChoice = scan.nextInt();
        }

        /* put the human choice in the board */
        putDataInTheBoard(board,humanChoice,humanPlayer);

        /* Check if there is no win and there still moves */
        if(!board.checkWins(computerPlayer) && board.stillHasMoves()) {
            MinMax minMax = new MinMax();
            // make the computation and play -- the ai will pick the first position available starting from 1.
            Integer computerChoice = minMax.findingBestMove(board, computerPlayer, humanPlayer);

            /* putting the computer choice in the board*/
            putDataInTheBoard(board, computerChoice, computerPlayer);
        }
    }

    /**
     * inserting player's moves into the board. since the board is small, i decided to not make a loop.
     *
     * @param board    the board
     * @param position the position
     * @param player   the player
     */
    private void putDataInTheBoard(Board board, Integer position, String player){
        switch (position){
            case 1:
                board.getBoard()[0][0] = player;
                break;
            case 2:
                board.getBoard()[0][1] = player;
                break;
            case 3:
                board.getBoard()[0][2] = player;
                break;
            case 4:
                board.getBoard()[1][0] = player;
                break;
            case 5:
                board.getBoard()[1][1] = player;
                break;
            case 6:
                board.getBoard()[1][2] = player;
                break;
            case 7:
                board.getBoard()[2][0] = player;
                break;
            case 8:
                board.getBoard()[2][1] = player;
                break;
            case 9:
                board.getBoard()[2][2] = player;
                break;
            default:
                break;
        }
    }
}