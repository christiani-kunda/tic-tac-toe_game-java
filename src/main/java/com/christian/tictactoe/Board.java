package com.christian.tictactoe;

/**
 * The Class Board.
 *
 * @author Christian Iradukunda
 */
public class Board {

	private String [][] boardValues = {};

	private String  winner;

	/**
	 * Gets position from a 2d array given the number of columns and the coordinates.
	 *
	 * @param rowNumber       the row number
	 * @param columnNumber    the column number
	 * @param numberOfColumns the number of columns
	 * @return the position
	 */
	public int getBoardPosition(int rowNumber, int columnNumber, int numberOfColumns) {
		if(columnNumber<numberOfColumns){
			return rowNumber*numberOfColumns + columnNumber + 1;
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
	public boolean hasWins(final String computerPlayer) {
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
		boolean thereIsWin = true;
		String value = boardValues[0][0];
		for(int i=0; i<boardValues.length; i++){
			for(int j=0; j<boardValues.length; j++){
				if( i == j && !value.equalsIgnoreCase(boardValues[i][j])) {
					thereIsWin = false;
					break;
				}
			}
		}
		if (thereIsWin) {
			this.winner = boardValues[0][0];
			if (winner.equalsIgnoreCase(computerPlayer)) {
				return 10;
			} else {
				return -10;
			}
		}


		thereIsWin = true;
		value = boardValues[boardValues.length-1][0];
		for(int i=0; i<boardValues.length; i++){
			for(int j=0; j<boardValues.length; j++){
				if( ((i+j) == boardValues.length-1) && !value.equalsIgnoreCase(boardValues[i][j])) {
					thereIsWin = false;
					break;
				}
			}
		}
		if (thereIsWin) {
			this.winner = value;
			if (winner.equalsIgnoreCase(computerPlayer)) {
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
		for (int j = 0; j < boardValues.length; j++) {
			boolean thereIsWin = true;
			String value = boardValues[0][j];
			for (String[] boardValue : boardValues) {
				if (!boardValue[j].equals(value)) {
					thereIsWin = false;
					break;
				}
			}
			if (thereIsWin) {
				this.winner = boardValues[0][j];
				if (winner.equalsIgnoreCase(computerPlayer)) {
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
		for (String[] boardValue : boardValues) {
			boolean thereIsWin = true;
			String value = boardValue[0];
			for (int j = 0; j < boardValues.length; j++) {
				if (!boardValue[j].equals(value)) {
					thereIsWin = false;
					break;
				}
			}
			if (thereIsWin) {
				this.winner = boardValue[0];
				if (winner.equalsIgnoreCase(computerPlayer)) {
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
	 * Gets the winner.
	 *
	 * @return the winner
	 */
	public String getWinner() {
		return winner;
	}


	/**
	 * inserting player's moves into the board.
	 *
	 * @param position the position
	 * @param player   the player
	 */
	public void putDataInTheBoard(Integer position, String player){
		for(int i=0; i<boardValues.length; i++){
			for(int j=0; j<boardValues.length; j++){
				String value = boardValues[i][j];
				if(value.equalsIgnoreCase(String.valueOf(position))) {
					boardValues[i][j] = player;
				}
			}
		}
	}
}
