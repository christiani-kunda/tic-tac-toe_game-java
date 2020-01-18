package tests;

import com.christian.TicTacToe;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class TicTacToeTest {

	@Test
	public void init() {
		TicTacToe ticTacToe = new TicTacToe();
		System.setIn(new ByteArrayInputStream("X".getBytes()));
		ticTacToe.init();
		System.setIn(new ByteArrayInputStream("1".getBytes()));
	}
}