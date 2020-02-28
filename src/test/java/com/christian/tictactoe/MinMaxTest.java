package com.christian.tictactoe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * The type Min max test.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class MinMaxTest {

	@Test
	public void testTheAIBlockMove() {
		Board board = new Board();
		String [][] boardValues= {{"1","2","O"},{"4","X","O"},{"7","8","9"}};
		board.setBoard(boardValues);
		MinMax minMax = new MinMax();
		int bestMove = minMax.findingBestMove(board,"X","O");
		assertEquals(9, bestMove);
	}

	@Test
	public void testFindingTheBestMove() {
		Board board = new Board();
		String [][] boardValues= {{"O","2","3"},{"4","5","6"},{"7","8","9"}};
		board.setBoard(boardValues);
		MinMax minMax = new MinMax();
		int bestMove = minMax.findingBestMove(board,"X","O");
		assertEquals(5, bestMove);
	}


	@Test
	public void testTheAIWinning() {
		Board board = new Board();
		String [][] boardValues= {{"1","O","X"},{"X","5","O"},{"X","8","0"}};
		board.setBoard(boardValues);
		MinMax minMax = new MinMax();
		int bestMove = minMax.findingBestMove(board,"X","O");
		assertEquals(1, bestMove);
	}

	@Test
	public void testTheAIBlockMoveTwo() {
		Board board = new Board();
		String [][] boardValues= {{"X","O","3"},{"4","O","6"},{"7","8","9"}};
		board.setBoard(boardValues);
		MinMax minMax = new MinMax();
		int bestMove = minMax.findingBestMove(board,"X","O");
		assertEquals(8, bestMove);
	}
}