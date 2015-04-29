package tests;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import game.AbstractPiece;
import game.Bomb;
import game.ClearPiece;
import game.GameBoard;
import game.PieceFactory;
import game.GameBoard.User;
import game.SetupBoard;

public class TestSetupBoard {
//	private SetupBoard testBoard;
	private SetupBoard testBoard;
	MockPieceObserver observer;
	
	@Before
	public void setup() {
		testBoard = new SetupBoard(User.PLAYER1);
	}
	
	@After
	public void tearDown() {
		testBoard = null;
	}
	
	@Test
	public void testAddPieceMethod() {
		for(int i= 0; i<10; i++) {
			for (int j = 0; j<4; j++) {
				Assert.assertTrue(testBoard.getPieces()[i][j] instanceof ClearPiece);
			}
		}
		testBoard.remove(testBoard.getPieces()[0][0]);
		testBoard.addPiece(0, 0, (AbstractPiece)PieceFactory.createBomb());
		Assert.assertTrue(testBoard.getPieces()[0][0] instanceof Bomb);
	}
}
