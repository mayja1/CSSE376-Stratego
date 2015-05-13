package tests;

import static org.junit.Assert.*;
import game.AbstractPiece;
import game.GameBoard;
import game.IBoardObserver;
import game.PieceFactory;
import game.PlayerBoard;
import game.GameBoard.User;
import game.SetupBoard;
import game.TurnObserver;

import org.junit.Before;
import org.junit.Test;

public class TestBoardObserver {
	
	private PlayerBoard testBoard;
	private MockBoardObserver observer;
	private AbstractPiece[][] pieces;
	
	@Before
	public void setup() {
		observer = new MockBoardObserver();
		testBoard = new PlayerBoard(User.PLAYER1, new TurnObserver(), observer);
		pieces = new AbstractPiece[10][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				pieces[j][i] = PieceFactory.createClearPiece();
			}
		}
	}

	@Test
	public void testDoneWithBoard() {
		testBoard.doneWithMyBoard(pieces);
		assertTrue(observer.doneWithBoard);
	}
	@Test
	public void testOpponentDoneWithBoard() {
		testBoard.doneWithMyBoard(pieces);
		testBoard.opponentDoneWithThisBoard(pieces);
		assertFalse(testBoard.getBoard() instanceof SetupBoard);
		assertTrue(testBoard.getBoard() instanceof GameBoard);
	}
	
	private class MockBoardObserver implements IBoardObserver {

		boolean doneWithBoard;
		boolean opponentDone;
		
		public MockBoardObserver () {
			doneWithBoard = false;
			opponentDone = false;
		}
		@Override
		public void doneWithMyBoard(AbstractPiece[][] pieces) {
			doneWithBoard = true;
			
		}

		@Override
		public void opponentDoneWithThisBoard(AbstractPiece[][] completedBoard) {
			
		}
		
		@Override
		public User endGame(User player) {
			return null;
		}
		
		
	}
}
