package tests;

import java.awt.GridBagLayout;
import java.awt.Point;

import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import game.AbstractPiece;
import game.Bomb;
import game.ClearPiece;
import game.GameBoard;
import game.GameBoard.User;
import game.PieceFactory;
import game.Soldier;

public class TestGameBoard {

	private GameBoard testBoard;
	MockPieceObserver observer;
	private AbstractPiece[][] pieces;
	
	@Before
	public void setup() {
		pieces = new AbstractPiece[10][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				pieces[j][i] = PieceFactory.createClearPiece();
			}
		}
		testBoard = new NoneGuiGameBoard(User.PLAYER1, pieces);
	}
	
	@After
	public void tearDown() {
		testBoard = null;
	}
	
	@Test
	public void testAddPieceMethod() {
		NoneGuiGameBoard board = (NoneGuiGameBoard) testBoard;
		for(int i= 0; i<10; i++) {
			for (int j = 0; j<10; j++) {
				Assert.assertTrue(board.getPieces()[i][j] instanceof ClearPiece);
			}
		}
		board.remove(board.getPieces()[0][0]);
		board.addPiece(0, 0, (AbstractPiece)PieceFactory.createBomb());
		Assert.assertTrue(board.getPieces()[0][0] instanceof Bomb);
	}
	
	@Test
	public void testScoutCanMoveMultipleSpaces() {
		AbstractPiece piece = PieceFactory.createScout();
		NoneGuiGameBoard board = (NoneGuiGameBoard) testBoard;
		board.remove(board.getPieces()[0][0]);
		board.addPiece(0, 0, piece);
		piece.setOwner(User.PLAYER1);
		board.nonSelectedButtonPressed(new Point(0, 0));
		Assert.assertTrue(board.getPieces()[0][0].isSelected());
		
		for (int j = 1; j < 10; j++) {
			Assert.assertTrue(board.getPieces()[0][j].isSelected());
			Assert.assertTrue(board.getPieces()[j][0].isSelected());
		}
	}
	
	@Test
	public void testScoutCannotMovePastOccupiedSpaces() {
		AbstractPiece piece = PieceFactory.createScout();
		NoneGuiGameBoard board = (NoneGuiGameBoard) testBoard;
		board.remove(board.getPieces()[0][0]);
		board.addPiece(0, 0, piece);
		piece.setOwner(User.PLAYER1);
		
		AbstractPiece otherXPiece = PieceFactory.createScout();
		board.remove(board.getPieces()[5][0]);
		board.addPiece(5, 0, otherXPiece);
		piece.setOwner(User.PLAYER1);
		
		AbstractPiece otherYPiece = PieceFactory.createScout();
		board.remove(board.getPieces()[0][5]);
		board.addPiece(0, 5, otherYPiece);
		piece.setOwner(User.PLAYER1);
		
		board.nonSelectedButtonPressed(new Point(0, 0));
		Assert.assertFalse(board.getPieces()[6][0].isSelected());
		Assert.assertFalse(board.getPieces()[0][6].isSelected());
		
		
	}
	public void testSelectedButtonPressedNoSelectedPiece() {
		NoneGuiGameBoard board = (NoneGuiGameBoard) testBoard;
		board.remove(board.getPieces()[0][0]);
		AbstractPiece piece = (AbstractPiece)PieceFactory.createLieutenant();
		board.addPiece(0, 0, piece);
		piece.setSelected(true);
		board.selectedButtonPressed(new Point(0, 0));
		Assert.assertFalse(piece.isSelected());
	}
	
	@Test
	public void testSelectedButtonPressedSameSelectedPiecePressed() {
		NoneGuiGameBoard board = (NoneGuiGameBoard) testBoard;
		board.remove(board.getPieces()[0][0]);
		AbstractPiece piece = (AbstractPiece)PieceFactory.createLieutenant();
		board.addPiece(0, 0, piece);
		piece.setSelected(true);
		board.setSelectedPiece(piece);
		board.selectedButtonPressed(new Point(0, 0));
		Assert.assertFalse(piece.isSelected());
	}
	
	@Test
	public void testSelectedButtonPressedClearPiecePressed() {
		NoneGuiGameBoard board = (NoneGuiGameBoard) testBoard;
		board.remove(board.getPieces()[0][0]);
		AbstractPiece piece = (AbstractPiece)PieceFactory.createLieutenant();
		board.addPiece(0, 0, piece);
		piece.setSelected(true);
		board.setSelectedPiece(piece);
		board.selectedButtonPressed(new Point(0, 1));
		Assert.assertFalse(piece.isSelected());
		Assert.assertTrue(piece.getLocation().getX()== 0);
		Assert.assertTrue(piece.getLocation().getY()== 1);
	}
	
	@Test
	public void testSelectedButtonPressedEnemyPiecePressed() {
		NoneGuiGameBoard board = (NoneGuiGameBoard) testBoard;
		AbstractPiece piece = (AbstractPiece)PieceFactory.createLieutenant();
		AbstractPiece enemyPiece=(AbstractPiece) PieceFactory.createScout();
		piece.setOwner(User.PLAYER1);
		enemyPiece.setOwner(User.PLAYER2);
		board.remove(board.getPieces()[0][0]);
		board.addPiece(0, 0, piece);
		board.remove(board.getPieces()[0][1]);
		board.addPiece(0, 1, enemyPiece);
		piece.setSelected(true);
		board.setSelectedPiece(piece);
		board.selectedButtonPressed(new Point(0, 1));
		Assert.assertFalse(piece.isSelected());
		Assert.assertTrue(piece.getLocation().getX()== 0);
		Assert.assertTrue(piece.getLocation().getY()== 1);
		Assert.assertTrue(board.getPieces()[0][0] instanceof ClearPiece);
	}
	
	@Test
	public void testNonSelectedButtonPressedClearPiecePressed() {
		NoneGuiGameBoard board = (NoneGuiGameBoard) testBoard;
		board.remove(board.getPieces()[0][0]);
		AbstractPiece piece = (AbstractPiece)PieceFactory.createClearPiece();
		board.addPiece(0, 0, piece);
		board.nonSelectedButtonPressed(new Point(0, 0));
		Assert.assertFalse(piece.isSelected());
		Assert.assertNull(board.getSelectedPiece());
	}
	
	@Test
	public void testNonSelectedButtonPressedYourPiecePressedNonEdge() {
		NoneGuiGameBoard board = (NoneGuiGameBoard) testBoard;
		board.remove(board.getPieces()[0][0]);
		AbstractPiece piece = (AbstractPiece)PieceFactory.createMiner();
		piece.setOwner(User.PLAYER1);
		board.addPiece(1, 1, piece);
		board.nonSelectedButtonPressed(new Point(1, 1));
		Assert.assertTrue(piece.isSelected());
		Assert.assertEquals(board.getSelectedPiece(), piece);
		Assert.assertTrue(board.getPieces()[1][0].isSelected());
		Assert.assertTrue(board.getPieces()[0][1].isSelected());
		Assert.assertTrue(board.getPieces()[1][2].isSelected());
		Assert.assertTrue(board.getPieces()[2][1].isSelected());
	}
	
	@Test
	public void testNonSelectedButtonPressedYourPiecePressedNonEdgeSurroundedByFriends() {
		NoneGuiGameBoard board = (NoneGuiGameBoard) testBoard;
		board.remove(board.getPieces()[0][0]);
		AbstractPiece piece = (AbstractPiece)PieceFactory.createMiner();
		piece.setOwner(User.PLAYER1);
		board.addPiece(1, 1, piece);
		Assert.assertFalse(testOneFriendlyNeighborPiece((AbstractPiece)PieceFactory.createMiner(), new Point(1, 0)));
		Assert.assertFalse(testOneFriendlyNeighborPiece((AbstractPiece)PieceFactory.createMiner(), new Point(1, 2)));
		Assert.assertFalse(testOneFriendlyNeighborPiece((AbstractPiece)PieceFactory.createMiner(), new Point(0, 1)));
		Assert.assertFalse(testOneFriendlyNeighborPiece((AbstractPiece)PieceFactory.createMiner(), new Point(2, 1)));
		
		board.nonSelectedButtonPressed(new Point(1, 1));
		Assert.assertTrue(piece.isSelected());
		Assert.assertEquals(board.getSelectedPiece(), piece);
	}
	
	@Test
	public void testNonSelectedButtonPressedYourPiecePressedTopLeftCorner() {
		NoneGuiGameBoard board = (NoneGuiGameBoard) testBoard;
		board.remove(board.getPieces()[0][0]);
		AbstractPiece piece = (AbstractPiece)PieceFactory.createMiner();
		piece.setOwner(User.PLAYER1);
		board.addPiece(0, 0, piece);
		board.nonSelectedButtonPressed(new Point(0, 0));
		Assert.assertTrue(piece.isSelected());
		Assert.assertEquals(board.getSelectedPiece(), piece);
		Assert.assertTrue(board.getPieces()[0][1].isSelected());
		Assert.assertTrue(board.getPieces()[1][0].isSelected());
	}
	
	@Test
	public void testNonSelectedButtonPressedYourPiecePressedBottomRightCorner() {
		NoneGuiGameBoard board = (NoneGuiGameBoard) testBoard;
		board.remove(board.getPieces()[9][9]);
		AbstractPiece piece = (AbstractPiece)PieceFactory.createMiner();
		piece.setOwner(User.PLAYER1);
		board.addPiece(9, 9, piece);
		board.nonSelectedButtonPressed(new Point(9, 9));
		Assert.assertTrue(piece.isSelected());
		Assert.assertEquals(board.getSelectedPiece(), piece);
		Assert.assertTrue(board.getPieces()[8][9].isSelected());
		Assert.assertTrue(board.getPieces()[9][8].isSelected());
	}
	
	private boolean testOneFriendlyNeighborPiece(AbstractPiece piece, Point location) {
		NoneGuiGameBoard board = (NoneGuiGameBoard) testBoard;
		board.remove(board.getPieces()[location.x][location.y]);
		board.addPiece(location.x, location.y, piece);
		piece.setOwner(User.PLAYER1);
		board.nonSelectedButtonPressed(new Point(1, 1));
		return board.getPieces()[location.x][location.y].isSelected();
	}
	private class NoneGuiGameBoard extends GameBoard {
		public NoneGuiGameBoard(User owner, AbstractPiece[][] pieces) {
			super(owner, pieces);		
		}
		
		@Override
		protected void instantiateBoard() {
			for(int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					this.addPiece(i, j, (AbstractPiece) PieceFactory.createClearPiece());
				}
			}
		}
		
		public AbstractPiece[][] getPieces() {
			return pieces;
		}
		
		public AbstractPiece getSelectedPiece() {
			return selectedPiece;
		}
		
		public void setSelectedPiece(AbstractPiece piece) {
			selectedPiece = piece;
		}
	}
	
}
