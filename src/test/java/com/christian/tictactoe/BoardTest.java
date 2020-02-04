package com.christian.tictactoe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * The type Board test.
 *
 * @author Christian
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class BoardTest {

	@Test
	public void testGetPositionFromBoard() {

		Board board = new Board();
		int position = board.getBoardPosition(0, 1,3);
		assertEquals(2, position);
	}

	@Test
	public void testGetPositionWithColumnCoordinatesGreaterThanColumnNumber() {

		Board board = new Board();
		int position = board.getBoardPosition(0, 3,3);
		assertEquals(position,-1);
	}

	@Test
	public void testStillHasMoves() {
		Board board = new Board();
		String [][] boardValues= {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
		board.setBoard(boardValues);
		boolean hasMoves = board.stillHasMoves();
		assertTrue(hasMoves);
	}

	@Test
	public void testStillHasMovesNegative() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","X"},{"X","X","O"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean hasMoves = board.stillHasMoves();
		assertFalse(hasMoves);
	}

	@Test
	public void testCheckHorizontalWinsWhenTheComputerIsX() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","X"},{"X","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean won = board.hasWins("X");
		assertTrue(won);
	}

	@Test
	public void testCheckHorizontalWinsWhenTheComputerIsO() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","X"},{"X","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean won = board.hasWins("O");
		assertTrue(won);
	}

	@Test
	public void testCheckVerticalWinsWhenTheComputerIsX() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","X"},{"X","O","X"},{"O","X","X"}};
		board.setBoard(boardValues);
		boolean won = board.hasWins("X");
		assertTrue(won);
	}

	@Test
	public void testCheckVerticalWinsWhenTheComputerIsO() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","X"},{"X","O","X"},{"O","X","X"}};
		board.setBoard(boardValues);
		boolean won = board.hasWins("O");
		assertTrue(won);
	}

	@Test
	public void testCheckDiagonalWinsWhenPlayerIsX() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","X"},{"O","X","X"},{"X","O","O"}};
		board.setBoard(boardValues);
		boolean won = board.hasWins("X");
		assertTrue(won);
	}

	@Test
	public void testCheckDiagonalWinsWhenPlayerIsO() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","X"},{"O","X","X"},{"X","O","O"}};
		board.setBoard(boardValues);
		boolean won = board.hasWins("O");
		assertTrue(won);
	}

	@Test
	public void testCheckReverseDiagonalWinsWhenPlayerIsX() {
		Board board = new Board();
		String [][] boardValues= {{"X","O","O"},{"O","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean won = board.hasWins("X");
		assertTrue(won);
	}

	@Test
	public void testCheckReverseDiagonalWinsWhenPlayerIsO() {
		Board board = new Board();
		String [][] boardValues= {{"X","O","O"},{"O","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean won = board.hasWins("O");
		assertTrue(won);
	}

	@Test
	public void testCheckDraw() {
		Board board = new Board();
		String [][] boardValues= {{"O","X","X"},{"X","X","O"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean won = board.hasWins("X");
		assertFalse(won);
	}

	@Test
	public void testCheckWinsNegative() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","3"},{"X","X","O"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean won = board.hasWins("O");
		assertFalse(won);
	}

	@Test
	public void testCheckIfSpotIsAvailable() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","3"},{"X","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean positionIsAvailable = board.checkIfSpotIsAvailable(3);
		assertTrue(positionIsAvailable);
	}

	@Test
	public void testCheckIfSpotIsAvailableNegative() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","3"},{"X","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean positionIsAvailable = board.checkIfSpotIsAvailable(5);
		assertFalse(positionIsAvailable);
	}

	@Test
	public void testComputeTheScore() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","3"},{"X","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		int score = board.computeTheScore("X");
		assertEquals(10, score);
	}

	@Test
	public void testPuttingDataInTheBoard() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","3"},{"X","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		board.putDataInTheBoard(3,"X");
		assertEquals("X", board.getBoard()[0][2]);
	}
}