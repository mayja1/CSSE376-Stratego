package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.AbstractPiece;
import game.Bomb;
import game.ClearPiece;
import game.Flag;
import game.GameBoardFrame;
import game.GameBoard.User;
import game.IBoardObserver;
import game.PieceFactory;
import game.Soldier;

public class TestGameBoardFrame {

	GameBoardFrame frame;
	
	@Before
	public void setup() {
		frame = new GameBoardFrame(User.PLAYER1, null) {
			@Override
			public void showGui() {
				this.setVisible(false);
			}
		};
	}
	
	@Test
	public void testCopyBombPiece() {
		AbstractPiece piece = PieceFactory.createBomb();
		assertTrue(frame.copyInstanceOfPiece(piece) instanceof Bomb);
	}
	
	@Test
	public void testCopyFlagPiece() {
		AbstractPiece piece = PieceFactory.createFlag();
		assertTrue(frame.copyInstanceOfPiece(piece) instanceof Flag);
	}
	
	@Test
	public void testCopySpyPiece() {
		AbstractPiece piece = PieceFactory.createSpy();
		assertTrue(frame.copyInstanceOfPiece(piece).getRank() == 0);
	}
	@Test
	public void testCopyScoutPiece() {
		AbstractPiece piece = PieceFactory.createScout();
		assertTrue(frame.copyInstanceOfPiece(piece).getRank() == 1);
	}
	@Test
	public void testCopyMinerPiece() {
		AbstractPiece piece = PieceFactory.createMiner();
		assertTrue(frame.copyInstanceOfPiece(piece).getRank() == 2);
	}
	@Test
	public void testCopySergeantPiece() {
		AbstractPiece piece = PieceFactory.createSergeant();
		assertTrue(frame.copyInstanceOfPiece(piece).getRank()==3);
	}
	@Test
	public void testCopyLieutenantPiece() {
		AbstractPiece piece = PieceFactory.createLieutenant();
		assertTrue(frame.copyInstanceOfPiece(piece).getRank() == 4);
	}
	@Test
	public void testCopyCaptainPiece() {
		AbstractPiece piece = PieceFactory.createCaptain();
		assertTrue(frame.copyInstanceOfPiece(piece).getRank() == 5);
	}
	@Test
	public void testCopyMajorPiece() {
		AbstractPiece piece = PieceFactory.createMajor();
		assertTrue(frame.copyInstanceOfPiece(piece).getRank() == 6);
	}
	@Test
	public void testCopyColonelPiece() {
		AbstractPiece piece = PieceFactory.createColonel();
		assertTrue(frame.copyInstanceOfPiece(piece).getRank() == 7);
	}
	@Test
	public void testCopyGeneralPiece() {
		AbstractPiece piece = PieceFactory.createGeneral();
		assertTrue(frame.copyInstanceOfPiece(piece).getRank() == 8);
	}
	@Test
	public void testCopyMarshallPiece() {
		AbstractPiece piece = PieceFactory.createMarshall();
		assertTrue(frame.copyInstanceOfPiece(piece).getRank() == 9);
	}
	
	@Test
	public void testDoneWithMyBoard() {
		FakeIBoardObserver observer = new FakeIBoardObserver();
		frame.setObserver(observer);
		frame.doneWithMyBoard(null);
		assertTrue(observer.opponentDoneWithThisBoardCalled);
	}
	
	private class FakeIBoardObserver implements IBoardObserver {
		boolean doneWithMyBoardCalled;
		boolean opponentDoneWithThisBoardCalled;
		boolean endGameCalled;
		
		public FakeIBoardObserver() {
			doneWithMyBoardCalled = false;
			opponentDoneWithThisBoardCalled = false;
			endGameCalled = false;
		}
		@Override
		public void doneWithMyBoard(AbstractPiece[][] pieces) {
			doneWithMyBoardCalled = true;
			
		}

		@Override
		public void opponentDoneWithThisBoard(AbstractPiece[][] completedBoard) {
			opponentDoneWithThisBoardCalled = true;
			
		}

		@Override
		public void endGame(User player) {
			endGameCalled = true;
			
		}
		
	}
	
}
