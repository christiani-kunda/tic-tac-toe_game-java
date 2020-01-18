package com.christian;

/**
 * The Class MinMax.
 *
 * @author Christian Iradukunda
 */
public class MinMax {

	/**
	 * Finding best move available starting with the first one..
	 *
	 * @param board the board
	 * @return the int
	 */
	public int findingBestMove(Board board, String computerPlayer, String humanPlayer) {
		int x = 0;
		int y = 0;
		int bestScore = -10000;
		for(int i=0; i<=2; i++){
			for(int j=0; j<=2; j++){
				String value = board.getBoard()[i][j];
				/* Checking if the spot is available */
				if(!value.equalsIgnoreCase("O") && !value.equalsIgnoreCase("X")) {
					board.getBoard()[i][j] = computerPlayer;
					int score = minMaxPosition(board,false, computerPlayer, humanPlayer);
					if(bestScore < score){
						bestScore = score;
						x=i;
						y=j;
					}
					board.getBoard()[i][j] = value;
				}
			}
		}
		return board.getPosition(x,y,board.getBoard().length);
	}

	/**
	 * Implementing the min max algorithm to find the optimum position for the ai
	 *
	 * @param board        the board
	 * @param isMaximizing the is maximizing
	 * @return the int
	 */
	/* .*/
	private int minMaxPosition(Board board, boolean isMaximizing, String computerPlayer, String humanPlayer) {
		if(board.checkWins(computerPlayer) || !board.stillHasMoves()){
			return board.computeTheScore(computerPlayer);
		}

		if(isMaximizing) {
			int bestScore = -10000;
			for (int i = 0; i <= 2; i++) {
				for (int j = 0; j <= 2; j++) {
					String value = board.getBoard()[i][j];
					/* Checking if the spot is available */
					if (!value.equalsIgnoreCase("O") && !value.equalsIgnoreCase("X")) {
						board.getBoard()[i][j] = computerPlayer;
						int score = minMaxPosition(board,false, computerPlayer,humanPlayer);
						bestScore = Math.max(bestScore,score);
						board.getBoard()[i][j] = value;
					}
				}
			}
			return bestScore;
		} else {
			int bestScore = 10000;
			for (int i = 0; i <= 2; i++) {
				for (int j = 0; j <= 2; j++) {
					String value = board.getBoard()[i][j];
					/* Checking if the spot is available */
					if (!value.equalsIgnoreCase("O") && !value.equalsIgnoreCase("X")) {
						board.getBoard()[i][j] = humanPlayer;
						int score = minMaxPosition(board,true, computerPlayer, humanPlayer);
						bestScore = Math.min(bestScore,score);
						board.getBoard()[i][j] = value;
					}
				}
			}
			return bestScore;
		}
	}
}
