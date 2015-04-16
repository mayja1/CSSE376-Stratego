package tests;

import static org.junit.Assert.assertEquals;
import game.AbstractPiece;
import game.Bomb;
import game.IPiece;
import game.Soldier;
import game.GameBoard.User;

import java.awt.Point;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBombPiece {

	AbstractPiece piece = new Bomb();
	MockPieceObserver observer;
	@Before
	public void setup() {
		observer = new MockPieceObserver();
		piece.setObserver(observer);
	}
	
	@Test
	public void testSetSelectedTrue() {
		piece.setSelected(true);
		Assert.assertTrue(piece.isSelected());
	}
	
	@Test
	public void testSetSelectedFalse() {
		piece.setSelected(false);
		Assert.assertFalse(piece.isSelected());
	}
	
	@Test
	public void testLocation() {
		Point expected = new Point(2,3);
		piece.setLocation(expected);
		Assert.assertEquals(expected, piece.getLocation());
	}
	
	@Test
	public void testProcessPressOnSelectedPiece() {
		Assert.assertFalse(observer.selectButtonPressed);
		piece.setSelected(true);
		piece.actionPerformed(null);
		observer.selectedButtonPressed(piece.getLocation());
		Assert.assertTrue(observer.selectButtonPressed);
		
	}
	
	@Test
	public void testProcessPressOnNonSelectedPiece() {
		Assert.assertFalse(observer.nonSelectButtonPressed);
		piece.setSelected(false);
		piece.actionPerformed(null);
		Assert.assertFalse(observer.nonSelectButtonPressed);
	}
	
	@Test
	public void testUserForPiece() {
		piece.setOwner(User.PLAYER2);
		assertEquals(piece.getOwner(), User.PLAYER2);
	}
	
	@After
	public void tearDown() {
		piece = null;
		observer = null;
	}
}
