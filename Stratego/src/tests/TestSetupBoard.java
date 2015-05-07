package tests;

import java.awt.Point;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JPanel;

import org.hamcrest.Factory;
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
	private SetupBoard testBoard;
	MockPieceObserver observer;
	
	@Before
	public void setup() {
		testBoard = new SetupBoardNoGui(User.PLAYER1);
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
	
	@Test
	public void testSelectedButtonPressedClearPiece() {
		testBoard.selectedButtonPressed(new Point(0, 0));
		Assert.assertTrue(((SetupBoardNoGui) testBoard).paneShown);
	}
	
	@Test
	public void testNonSelectedButtonPressed() {	
		AbstractPiece piece = PieceFactory.createScout();
		testBoard.remove(testBoard.getPieces()[1][1]);
		testBoard.addPiece(1, 1, piece);
		
		testBoard.nonSelectedButtonPressed(new Point(1, 1));
		
		Assert.assertTrue(testBoard.getPieces()[1][1] instanceof ClearPiece);
		Assert.assertTrue(testBoard.getPieces()[1][1].isSelected());
	}
	
	@Test
	public void testNonSelectedButtonPressedSpecialPeice() {
		AbstractPiece piece = PieceFactory.createBomb();
		testBoard.remove(testBoard.getPieces()[5][0]);
		testBoard.addPiece(5, 0, piece);
		
		testBoard.nonSelectedButtonPressed(new Point(5, 0));
		
		Assert.assertTrue(testBoard.getPieces()[5][0] instanceof ClearPiece);
		Assert.assertTrue(testBoard.getPieces()[5][0].isSelected());
	}
	
	private class SetupBoardNoGui extends SetupBoard {
		boolean paneShown;
		public SetupBoardNoGui(User owner) {
			super(owner);
			paneShown = false;
		}
		
		@Override
		protected void showJOptionPane(Point gridLocation, JPanel panel,
				JComboBox<AbstractPiece> comboBox) {
			paneShown = true;
		}
		
	}
}
