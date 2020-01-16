package com.christian;

import java.util.Scanner;

/**
 * The type Tic tac toe.
 *
 * @author Christian Iradukunda
 */
public class TicTacToe {

    /**
     * The constant winner.
     */
    private static String winner;

    /**
     * The constant humanPlayer.
     */
    private static String humanPlayer;

    /**
     * The constant computerPlayer.
     */
    private static String computerPlayer;

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     */
    public static void main(String[] args) {

        /* Initialize the board */
        String [][] board= {{"1","2","3"},{"4","5","6"},{"7","8","9"}};

        /* printing the board*/
        printBoard(board);

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
        while (!checkWins(board) && stillHasMoves(board)) {
            play(board, humanPlayer, computerPlayer);
            printBoard(board);
        }
        if(checkWins(board)){
            System.out.printf("payer %s won", winner);
        } else {
            System.out.print("DRAW");
        }
    }

    /**
     * Print board.
     *
     * @param board the board
     */
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


    /**
     * Play.
     *
     * @param board          the board
     * @param humanPlayer    the human player
     * @param computerPlayer the computer player
     */
    private static void play(String [][] board, String humanPlayer, String computerPlayer){
        System.out.print("\nPick a position to play at: ");
        Scanner scan = new Scanner(System.in);
        int humanChoice = scan.nextInt();
        while(humanChoice<1 || humanChoice > 9) {
            System.out.println("The chosen position does not exist. please choose between 1 and 9");
            scan = new Scanner(System.in);
            humanChoice = scan.nextInt();
        }

        /* put the human choice in the board */
        putDataInTheBoard(board,humanChoice,humanPlayer);

        /* Check if there is no win and there still moves */
        if(!checkWins(board) && stillHasMoves(board)) {
            // make the computation and play -- the ai will pick the first position available starting from 1.
            Integer computerChoice = findingBestMove(board);

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
    private static void putDataInTheBoard(String [][] board, Integer position, String player){
        switch (position){
            case 1:
                board[0][0] = player;
                break;
            case 2:
                board[0][1] = player;
                break;
            case 3:
                board[0][2] = player;
                break;
            case 4:
                board[1][0] = player;
                break;
            case 5:
                board[1][1] = player;
                break;
            case 6:
                board[1][2] = player;
                break;
            case 7:
                board[2][0] = player;
                break;
            case 8:
                board[2][1] = player;
                break;
            case 9:
                board[2][2] = player;
                break;
            default:
                break;
        }
    }

    /**
     * his method if there are still possible moves in the board.
     *
     * @param board the board
     * @return the boolean
     */
    private static boolean stillHasMoves(String [][] board){

        for(int i=0; i<=2; i++){
            for(int j=0; j<=2; j++){
                String value = board[i][j];
                if(!value.equalsIgnoreCase("O") && !value.equalsIgnoreCase("X")) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * This function checks if there is a win in the board.
     *
     * @param board the board
     * @return the boolean
     */
    private static int computeTheScore(String [][] board){

        /* checking through rows */
        for(int i=0; i<=2; i++){
            if((board[i][0].equals(board[i][1])) && (board[i][1].equals(board[i][2]))){
                winner = board[i][0];
                if(winner.equalsIgnoreCase(computerPlayer)) {
                    return 10;
                } else {
                    return -10;
                }
            }
        }

        /* checking through columns */
        for(int j=0; j<=2; j++) {
            if ((board[0][j].equals(board[1][j])) && (board[1][j].equals(board[2][j]))) {
                winner = board[0][j];
                if(winner.equalsIgnoreCase(computerPlayer)) {
                    return 10;
                } else {
                    return -10;
                }
            }
        }
        /* checking through diagonal */
        if((board[0][0].equals(board[1][1])) && (board[1][1].equals(board[2][2]))){
            winner = board[0][0];
            if(winner.equalsIgnoreCase(computerPlayer)) {
                return 10;
            } else {
                return -10;
            }
        } else if((board[2][0].equals(board[1][1])) && (board[1][1].equals(board[0][2]))) {
            winner = board[1][1];
            if(winner.equalsIgnoreCase(computerPlayer)) {
                return 10;
            } else {
                return -10;
            }
        }
        if(!stillHasMoves(board)){
            return 0;
        }
        return -10000000;
    }

    /**
     * Gets position from a 2d array given the number of columns and the coordinates.
     *
     * @param i               the
     * @param j               the j
     * @param numberOfColumns the number of columns
     * @return the position
     */
    private static int getPosition(int i, int j, int numberOfColumns) {
        if(j<numberOfColumns){
            return i*numberOfColumns + j + 1;
        }
        return -1;
    }

    /**
     * Finding best move available starting with the first one..
     *
     * @param board the board
     * @return the int
     */
    private static int findingBestMove(String [][] board) {
        int x = 0;
        int y = 0;
        int bestScore = -10000;
        for(int i=0; i<=2; i++){
            for(int j=0; j<=2; j++){
                String value = board[i][j];
                /* Checking if the spot is available */
                if(!value.equalsIgnoreCase("O") && !value.equalsIgnoreCase("X")) {
                    board[i][j] = computerPlayer;
                    int score = minMaxPosition(board,false);
                    if(bestScore < score){
                        bestScore = score;
                        x=i;
                        y=j;
                    }
                    board[i][j] = value;
                }
            }
        }
        return getPosition(x,y,board.length);
    }

    /**
     * Implementing the min max algorithm to find the optimum position for the ai
     *
     * @param board        the board
     * @param isMaximizing the is maximizing
     * @return the int
     */
    /* .*/
    private static int minMaxPosition(String [][] board, boolean isMaximizing) {
        if(checkWins(board) || !stillHasMoves(board)){
            return computeTheScore(board);
        }

        if(isMaximizing) {
            int bestScore = -10000;
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    String value = board[i][j];
                    /* Checking if the spot is available */
                    if (!value.equalsIgnoreCase("O") && !value.equalsIgnoreCase("X")) {
                        board[i][j] = computerPlayer;
                        int score = minMaxPosition(board,false);
                        bestScore = Math.max(bestScore,score);
                        board[i][j] = value;
                    }
                }
            }
            return bestScore;
        } else {
            int bestScore = 10000;
            for (int i = 0; i <= 2; i++) {
                for (int j = 0; j <= 2; j++) {
                    String value = board[i][j];
                    /* Checking if the spot is available */
                    if (!value.equalsIgnoreCase("O") && !value.equalsIgnoreCase("X")) {
                        board[i][j] = humanPlayer;
                        int score = minMaxPosition(board,true);
                        bestScore = Math.min(bestScore,score);
                        board[i][j] = value;
                    }
                }
            }
            return bestScore;
        }
    }

    /**
     * Check wins boolean.
     *
     * @param board the board
     * @return the boolean
     */
    private static boolean checkWins(String [][] board) {
        return computeTheScore(board) == 10 || computeTheScore(board) == -10;
    }
}