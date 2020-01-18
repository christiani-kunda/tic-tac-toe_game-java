package tests;

import com.christian.Board;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@RunWith(BlockJUnit4ClassRunner.class)
public class BoardTest {

	@Test
	public void getPosition() {

		Board board = new Board();
		int position = board.getPosition(0, 1,3);
		assertEquals(position,2);
	}

	@Test
	public void getPositionWithColumnCoordinatesGreaterThanColumnNumber() {

		Board board = new Board();
		int position = board.getPosition(0, 3,3);
		assertEquals(position,-1);
	}

	@Test
	public void stillHasMoves() {
		Board board = new Board();
		String [][] boardValues= {{"1","2","3"},{"4","5","6"},{"7","8","9"}};
		board.setBoard(boardValues);
		boolean hasMoves = board.stillHasMoves();
		assertTrue(hasMoves);
	}

	@Test
	public void stillHasMovesNegative() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","X"},{"X","X","O"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean hasMoves = board.stillHasMoves();
		assertFalse(hasMoves);
	}

	@Test
	public void checkHorizontalWinsWhenTheComputerIsX() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","X"},{"X","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean won = board.checkWins("X");
		assertTrue(won);
	}

	@Test
	public void checkHorizontalWinsWhenTheComputerIsO() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","X"},{"X","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean won = board.checkWins("O");
		assertTrue(won);
	}

	@Test
	public void checkVerticalWinsWhenTheComputerIsX() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","X"},{"X","O","X"},{"O","X","X"}};
		board.setBoard(boardValues);
		boolean won = board.checkWins("X");
		assertTrue(won);
	}

	@Test
	public void checkVerticalWinsWhenTheComputerIsO() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","X"},{"X","O","X"},{"O","X","X"}};
		board.setBoard(boardValues);
		boolean won = board.checkWins("O");
		assertTrue(won);
	}

	@Test
	public void checkDiagonalWinsWhenPlayerIsX() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","X"},{"O","X","X"},{"X","O","O"}};
		board.setBoard(boardValues);
		boolean won = board.checkWins("X");
		assertTrue(won);
	}

	@Test
	public void checkDiagonalWinsWhenPlayerIsO() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","X"},{"O","X","X"},{"X","O","O"}};
		board.setBoard(boardValues);
		boolean won = board.checkWins("O");
		assertTrue(won);
	}

	@Test
	public void checkReverseDiagonalWinsWhenPlayerIsX() {
		Board board = new Board();
		String [][] boardValues= {{"X","O","O"},{"O","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean won = board.checkWins("X");
		assertTrue(won);
	}

	@Test
	public void checkReverseDiagonalWinsWhenPlayerIsO() {
		Board board = new Board();
		String [][] boardValues= {{"X","O","O"},{"O","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean won = board.checkWins("O");
		assertTrue(won);
	}

	@Test
	public void checkDraw() {
		Board board = new Board();
		String [][] boardValues= {{"O","X","X"},{"X","X","O"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean won = board.checkWins("X");
		assertFalse(won);
	}

	@Test
	public void checkWinsNegative() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","3"},{"X","X","O"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean won = board.checkWins("O");
		assertFalse(won);
	}

	@Test
	public void checkIfSpotIsAvailable() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","3"},{"X","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean positionIsAvailable = board.checkIfSpotIsAvailable(3);
		assertTrue(positionIsAvailable);
	}

	@Test
	public void checkIfSpotIsAvailableNidegative() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","3"},{"X","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		boolean positionIsAvailable = board.checkIfSpotIsAvailable(5);
		assertFalse(positionIsAvailable);
	}

	@Test
	public void computeTheScore() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","3"},{"X","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		int score = board.computeTheScore("X");
		assertEquals(score,10);
	}

	@Test
	public void getBoard() {
	}

	@Test
	public void setBoard() {
	}

	@Test
	public void printBoard() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","3"},{"X","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		board.printBoard();
	}

	@Test
	public void printBoardNegative() {
		Board board = new Board();
		board.printBoard();
	}

	@Test
	public void getWinner() {
	}
}