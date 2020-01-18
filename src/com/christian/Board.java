package com.christian;

/**
 * The Class Board.
 *
 * @author Christian Iradukunda
 */
public class Board {

	/**
	 * The Board.
	 */
	private String [][] boardValues = {};

	/**
	 * The Winner.
	 */
	private String  winner;

	/**
	 * Gets position from a 2d array given the number of columns and the coordinates.
	 *
	 * @param i               the
	 * @param j               the j
	 * @param numberOfColumns the number of columns
	 * @return the position
	 */
	public int getPosition(int i, int j, int numberOfColumns) {
		if(j<numberOfColumns){
			return i*numberOfColumns + j + 1;
		}
		return -1;
	}

	/**
	 * his method if there are still possible moves in the board.
	 *
	 * @return the boolean
	 */
	public boolean stillHasMoves(){

		for(int i=0; i<boardValues.length; i++){
			for(int j=0; j<boardValues.length; j++){
				String value = boardValues[i][j];
				if(!value.equalsIgnoreCase("O") && !value.equalsIgnoreCase("X")) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * Check wins boolean.
	 *
	 * @param computerPlayer the computer player
	 * @return the boolean
	 */
	public boolean checkWins(final String computerPlayer) {
		return computeTheScore(computerPlayer) == 10 || computeTheScore(computerPlayer) == -10;
	}


	/**
	 * Check if spot is available boolean.
	 *
	 * @param position the position
	 * @return the boolean
	 */
	public boolean checkIfSpotIsAvailable(int position) {
		for(int i=0; i<boardValues.length; i++){
			for(int j=0; j<boardValues.length; j++){
				String value = boardValues[i][j];
				if(value.equalsIgnoreCase(String.valueOf(position))) {
					return true;
				}
			}
		}
		return false;
	}

	/**
	 * This function checks if there is a win in the board.
	 *
	 * @param computerPlayer the computer player
	 * @return the boolean
	 */
	public int computeTheScore(final String computerPlayer){

		/* checking through rows */
		Integer rowWin = checkRowWins(computerPlayer);
		if (rowWin != -1) {
			return rowWin;
		}

		/* checking through columns */
		Integer columnWin = checkColumnWins(computerPlayer);
		if (columnWin != -1) {
			return columnWin;
		}
		/* checking through diagonal */
		Integer diagonalWin = checkDiagonalWins(computerPlayer);
		if (diagonalWin != -1) {
			return diagonalWin;
		}

		if(!stillHasMoves()){
			return 0;
		}
		return -10000000;
	}

	/**
	 * Check diagonal wins integer.
	 *
	 * @param computerPlayer the computer player
	 * @return the integer
	 */
	private Integer checkDiagonalWins(String computerPlayer) {
		if((boardValues[0][0].equals(boardValues[1][1])) && (boardValues[1][1].equals(boardValues[2][2]))){
			this.winner = boardValues[0][0];
			if(winner.equalsIgnoreCase(computerPlayer)) {
				return 10;
			} else {
				return -10;
			}
		} else if((boardValues[2][0].equals(boardValues[1][1])) && (boardValues[1][1].equals(boardValues[0][2]))) {
			this.winner = boardValues[1][1];
			if(winner.equalsIgnoreCase(computerPlayer)) {
				return 10;
			} else {
				return -10;
			}
		}
		return -1;
	}

	/**
	 * Check column wins integer.
	 *
	 * @param computerPlayer the computer player
	 * @return the integer
	 */
	private Integer checkColumnWins(String computerPlayer) {
		for(int j=0; j<boardValues.length; j++) {
			if ((boardValues[0][j].equals(boardValues[1][j])) && (boardValues[1][j].equals(boardValues[2][j]))) {
				this.winner = boardValues[0][j];
				if(winner.equalsIgnoreCase(computerPlayer)) {
					return 10;
				} else {
					return -10;
				}
			}
		}
		return -1;
	}

	/**
	 * Check row wins integer.
	 *
	 * @param computerPlayer the computer player
	 * @return the integer
	 */
	private Integer checkRowWins(String computerPlayer) {
		for(int i=0; i<boardValues.length; i++){
			if((boardValues[i][0].equals(boardValues[i][1])) && (boardValues[i][1].equals(boardValues[i][2]))){
				this.winner = boardValues[i][0];
				if(winner.equalsIgnoreCase(computerPlayer)) {
					return 10;
				} else {
					return -10;
				}
			}
		}
		return -1;
	}


	/**
	 * Gets the board.
	 *
	 * @return the board
	 */
	public String[][] getBoard() {
		return boardValues;
	}

	/**
	 * Sets the board.
	 *
	 * @param board the board
	 */
	public void setBoard(String[][] board) {
		this.boardValues = board;
	}

	/**
	 * Print board.
	 */
	/* A method that prints the board */
	public void printBoard(){
		/* Checking if the board has been initialized*/
		if(boardValues == null || boardValues.length == 0) {
			this.boardValues = new String[][]{{"1","2","3"},{"4","5","6"},{"7","8","9"}};
		}

        /* Looping through the board positions printing the content. If there no plays it should display position
        numbers */
		for(int i=0; i<boardValues.length; i++){
			for(int j=0; j<boardValues.length; j++){
				System.out.print(boardValues[i][j] + "  |  ");
			}
			System.out.print("\n-  -  -  -  -  -\n");
		}
	}

	/**
	 * Gets the winner.
	 *
	 * @return the winner
	 */
	public String getWinner() {
		return winner;
	}
}
