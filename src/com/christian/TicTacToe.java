package com.christian;

import java.util.Scanner;

public class TicTacToe {

    public static void main(String[] args) {

        /* Initialize the board */
        String [][] board= {{"1","2","3"},{"4","5","6"},{"7","8","9"}};

        /* printing the board*/
        printBoard(board);

        /* Getting the user's choice of player */
        System.out.print("Choose between 0 and X players the you are going to use: ");
        Scanner scan = new Scanner(System.in);
        String humanPlayer = scan.next().toUpperCase();
        String computerPlayer;
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
        play(board,humanPlayer,computerPlayer);
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


    private static void play(String [][] board, String humanPlayer, String computerPlayer){
        System.out.print("\nPick a position to play at: ");
        Scanner scan = new Scanner(System.in);
        Integer humanChoice = scan.nextInt();
        while(humanChoice<1 || humanChoice > 9) {
            System.out.println("The choosen position does not exist. please choose between 1 and 9");
            scan = new Scanner(System.in);
            humanChoice = scan.nextInt();
        }

        /* put the human choice in the board */
        putDataInTheBoard(board,humanChoice,humanPlayer);

        // make the computation and play -- for now let's use five
        Integer computerChoice = 5;

        /* putting the computer choice in the board*/
        putDataInTheBoard(board, computerChoice, computerPlayer);
    }

    /* inserting player's moves into the board. since the board is small, i decided to not make a loop */
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

    /* This method if there are still possible moves in the board */
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
}
