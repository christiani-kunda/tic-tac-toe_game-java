package tests;

import com.christian.Board;
import com.christian.MinMax;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.BlockJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

@RunWith(BlockJUnit4ClassRunner.class)
public class MinMaxTest {

	@Test
	public void findingBestMove() {
		Board board = new Board();
		String [][] boardValues= {{"1","2","O"},{"4","X","O"},{"7","8","9"}};
		board.setBoard(boardValues);
		MinMax minMax = new MinMax();
		int bestMove = minMax.findingBestMove(board,"X","O");
		assertEquals(bestMove,9);
	}
}