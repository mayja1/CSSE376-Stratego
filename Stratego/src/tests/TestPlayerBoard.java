package tests;

import static org.junit.Assert.assertEquals;

import java.awt.Point;

import org.junit.Assert;

import game.GameBoard.User;
import game.AbstractPiece;
import game.Flag;
import game.GameBoard;
import game.PieceFactory;
import game.PlayerBoard;
import game.Soldier;
import game.TurnObserver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPlayerBoard {

	PlayerBoard testBoard;
	private GameBoardMock gameBoard2;
	private AbstractPiece[][] pieces;
	
	@Before
	public void setup() {
		testBoard = new PlayerBoard(User.PLAYER1, new TurnObserver(), null);
		pieces = new AbstractPiece[10][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				pieces[j][i] = PieceFactory.createClearPiece();
			}
		}
		gameBoard2 = new GameBoardMock(User.PLAYER2, pieces, pieces);
		gameBoard2.setObserver(null, testBoard);
	}
	
	@After
	public void tearDown() {
		testBoard = null;
	}
	
	@Test
	public void testConstruction() {
		Assert.assertEquals(User.PLAYER1, testBoard.getOwner());
		Assert.assertNotNull(testBoard.getBoard());
	}
	
	@Test
	public void testCloseGameBoardAfterEndGame() {
		AbstractPiece miner = new Soldier(2, "Miner");
		miner.setLocation(new Point(0,1));
		miner.setOwner(User.PLAYER1);
		
		AbstractPiece flag = new Flag();
		flag.setLocation(new Point(0,0));
		flag.setOwner(User.PLAYER2);
		
		gameBoard2.attack(miner, flag);
		assertEquals(testBoard.getBoard(), null);
	}
	
	private class GameBoardMock extends GameBoard {
		boolean updated;
		public GameBoardMock(User owner, AbstractPiece[][] pieces, AbstractPiece[][] opponentPieces) {
			super(owner, pieces, opponentPieces);
			updated = false;
		}
		
		@Override
		public void updateBoard(Point p1, Point p2) {
			updated = true;
		}
	}
}
