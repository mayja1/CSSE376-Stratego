package tests;

import game.AbstractPiece;
import game.ClearPiece;
import game.IPiece;

import java.awt.Point;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestClearPiece {

	AbstractPiece piece;
	MockPieceObserver observer;
	@Before
	public void setup() {
		piece = new ClearPiece();
		observer = new MockPieceObserver();
		piece.setObserver(observer);
	}
	
	public void testSetSelectedTrue() {
		piece.setSelected(true);
		Assert.assertTrue(piece.isSelected());
	}
	
	public void testSetSelectedFalse() {
		piece.setSelected(false);
		Assert.assertFalse(piece.isSelected());
	}
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
		Assert.assertTrue(observer.selectButtonPressed);
		
	}
	
	@Test
	public void testProcessPressOnNonSelectedPiece() {
		Assert.assertFalse(observer.nonSelectButtonPressed);
		piece.setSelected(false);
		piece.actionPerformed(null);
		Assert.assertFalse(observer.nonSelectButtonPressed);
	}
	@After
	public void tearDown() {
		piece = null;
		observer = null;
	}
}
