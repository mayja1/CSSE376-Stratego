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
	
	@Before
	public void setup() {
		testBoard = new NoneGuiGameBoard(User.PLAYER1);
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
	
	private class NoneGuiGameBoard extends GameBoard {
		public NoneGuiGameBoard(User owner) {
			super(owner);
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
