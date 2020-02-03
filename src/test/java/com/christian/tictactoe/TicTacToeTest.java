package com.christian.tictactoe;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import java.io.ByteArrayInputStream;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertEquals;

/**
 * The type Tic tac toe test.
 */
@RunWith(BlockJUnit4ClassRunner.class)
public class TicTacToeTest {

	/**
	 * Test init.
	 */
	@Test(expected = NoSuchElementException.class)
	public void testInit() {
		TicTacToe ticTacToe = new TicTacToe();
		ticTacToe.init(new ByteArrayInputStream("X".getBytes()));
	}

	/**
	 * Test play.
	 */
	@Test
	public void testPlay() {
		TicTacToe ticTacToe = new TicTacToe();
		Board board = new Board();
		String [][] boardValues= {{"O","O","3"},{"X","X","0"},{"O","O","X"}};
		board.setBoard(boardValues);
		ticTacToe.play(board,"X","O",new ByteArrayInputStream("3".getBytes()));
		assertEquals(board.getBoard()[0][2],"X");
	}

	/**
	 * Print board.
	 */
	@Test
	public void testPrintBoard() {
		Board board = new Board();
		String [][] boardValues= {{"O","O","3"},{"X","X","X"},{"O","O","X"}};
		board.setBoard(boardValues);
		TicTacToe ticTacToe = new TicTacToe();
		ticTacToe.printBoard(board);
	}

	/**
	 * Print board negative.
	 */
	@Test
	public void testPrintBoardNegative() {
		Board board = new Board();
		TicTacToe ticTacToe = new TicTacToe();
		ticTacToe.printBoard(board);
	}
}