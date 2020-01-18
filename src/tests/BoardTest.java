package tests;

import com.christian.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


/**
 * The type Board test.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class BoardTest {

	/**
	 * Test get position.
	 */
	@Test
	public void testGetPosition() {

		Board board = new Board();
		int position = board.getPosition(0, 1,3);
		assertEquals(position,2);
	}

	/**
	 * Test get position with column coordinates greater than column number.
	 */
	@Test
	public void testGetPositionWithColumnCoordinatesGreaterThanColumnNumber() {

		Board board = new Board();
		int position = board.getPosition(0, 3,3);
		assertEquals(position,-1);
	}

	/**
	 * Test still has moves.
	 */
	@Test
	public void testStillHasMoves() {
		Board board = new Board();
		String [][] boardValues= {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
		board.setBoard(boardValues);
		boolean hasMoves = board.stillHasMoves();
		assertTrue(hasMoves);
	}

	/**
	 * Test still has moves negative.
	 */
	@Test
	public void testStillHasMovesNegative() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","X"},{"X","X","O"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean hasMoves = board.stillHasMoves();
		assertFalse(hasMoves);
	}

	/**
	 * Test check horizontal wins when the computer is x.
	 */
	@Test
	public void testCheckHorizontalWinsWhenTheComputerIsX() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","X"},{"X","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean won = board.checkWins("X");
		assertTrue(won);
	}

	/**
	 * Test check horizontal wins when the computer is o.
	 */
	@Test
	public void testCheckHorizontalWinsWhenTheComputerIsO() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","X"},{"X","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean won = board.checkWins("O");
		assertTrue(won);
	}

	/**
	 * Test check vertical wins when the computer is x.
	 */
	@Test
	public void testCheckVerticalWinsWhenTheComputerIsX() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","X"},{"X","O","X"},{"O","X","X"}};
		board.setBoard(boardValues);
		boolean won = board.checkWins("X");
		assertTrue(won);
	}

	/**
	 * Test check vertical wins when the computer is o.
	 */
	@Test
	public void testCheckVerticalWinsWhenTheComputerIsO() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","X"},{"X","O","X"},{"O","X","X"}};
		board.setBoard(boardValues);
		boolean won = board.checkWins("O");
		assertTrue(won);
	}

	/**
	 * Test check diagonal wins when player is x.
	 */
	@Test
	public void testCheckDiagonalWinsWhenPlayerIsX() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","X"},{"O","X","X"},{"X","O","O"}};
		board.setBoard(boardValues);
		boolean won = board.checkWins("X");
		assertTrue(won);
	}

	/**
	 * Test check diagonal wins when player is o.
	 */
	@Test
	public void testCheckDiagonalWinsWhenPlayerIsO() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","X"},{"O","X","X"},{"X","O","O"}};
		board.setBoard(boardValues);
		boolean won = board.checkWins("O");
		assertTrue(won);
	}

	/**
	 * Test check reverse diagonal wins when player is x.
	 */
	@Test
	public void testCheckReverseDiagonalWinsWhenPlayerIsX() {
		Board board = new Board();
		String [][] boardValues= {{"X","O","O"},{"O","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean won = board.checkWins("X");
		assertTrue(won);
	}

	/**
	 * Test check reverse diagonal wins when player is o.
	 */
	@Test
	public void testCheckReverseDiagonalWinsWhenPlayerIsO() {
		Board board = new Board();
		String [][] boardValues= {{"X","O","O"},{"O","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean won = board.checkWins("O");
		assertTrue(won);
	}

	/**
	 * Test check draw.
	 */
	@Test
	public void testCheckDraw() {
		Board board = new Board();
		String [][] boardValues= {{"O","X","X"},{"X","X","O"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean won = board.checkWins("X");
		assertFalse(won);
	}

	/**
	 * Test check wins negative.
	 */
	@Test
	public void testCheckWinsNegative() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","3"},{"X","X","O"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean won = board.checkWins("O");
		assertFalse(won);
	}

	/**
	 * Test check if spot is available.
	 */
	@Test
	public void testCheckIfSpotIsAvailable() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","3"},{"X","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean positionIsAvailable = board.checkIfSpotIsAvailable(3);
		assertTrue(positionIsAvailable);
	}

	/**
	 * Test check if spot is available negative.
	 */
	@Test
	public void testCheckIfSpotIsAvailableNegative() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","3"},{"X","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean positionIsAvailable = board.checkIfSpotIsAvailable(5);
		assertFalse(positionIsAvailable);
	}

	/**
	 * Test compute the score.
	 */
	@Test
	public void testComputeTheScore() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","3"},{"X","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		int score = board.computeTheScore("X");
		assertEquals(score,10);
	}

	/**
	 * Print board.
	 */
	@Test
	public void printBoard() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","3"},{"X","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		board.printBoard();
	}

	/**
	 * Print board negative.
	 */
	@Test
	public void printBoardNegative() {
		Board board = new Board();
		board.printBoard();
	}

}