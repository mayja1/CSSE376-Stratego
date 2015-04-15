package tests;

import java.awt.Point;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import game.AbstractPiece;
import game.IPiece;
import game.Obstacle;
import game.GameBoard.User;

//Test that this piece doesn't do anything
public class TestObstaclePiece {

	AbstractPiece piece = new Obstacle();
	MockPieceObserver observer;
	@Before
	public void setup() {
		observer = new MockPieceObserver();
		piece.setObserver(observer);
	}
	
	@Test
	public void testSetSelectedTrue() {
		piece.setSelected(true);
		Assert.assertFalse(piece.isSelected());
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
		Assert.assertFalse(observer.selectButtonPressed);
		
	}
	
	@Test
	public void testProcessPressOnNonSelectedPiece() {
		Assert.assertFalse(observer.nonSelectButtonPressed);
		piece.setSelected(false);
		piece.actionPerformed(null);
		Assert.assertFalse(observer.nonSelectButtonPressed);
	}
	
	@Test
	public void testOwnerIsNullForObstaclePiece() {
		Assert.assertNull(piece.getOwner());
		piece.setOwner(User.PLAYER1);
		Assert.assertNull(piece.getOwner());
	}
	
	@After
	public void tearDown() {
		piece = null;
		observer = null;
	}
}
