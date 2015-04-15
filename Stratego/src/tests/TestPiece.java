package tests;

import game.AbstractPiece;
import game.IPiece;
import game.Soldier;

import java.awt.Point;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestPiece {

	AbstractPiece piece = new Soldier(0);
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
	
	
	public void testProcessPressOnSelectedPiece() {
		Assert.assertFalse(observer.selectButtonPressed);
		piece.setSelected(true);
		piece.actionPerformed(null);
		Assert.assertTrue(observer.selectButtonPressed);
		
	}
	
	
	public void testProcessPressOnNonSelectedPiece() {
		Assert.assertFalse(observer.selectButtonPressed);
		piece.setSelected(false);
		piece.actionPerformed(null);
		Assert.assertTrue(observer.nonSelectButtonPressed);
	}
	
	@Test
	public void testUserForPiece() {
		piece.setUser(User.Player1);
		assertEquals(piece.getUser(), User.Player1);
	}
	
	@After
	public void tearDown() {
		piece = null;
		observer = null;
	}
}
