package tests;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import game.AbstractPiece;
import game.GameBoard;
import game.Obstacle;
import game.PieceFactory;
import game.Soldier;
import game.GameBoard.User;

//Test that this piece doesn't do anything
public class TestObstaclePiece {
	
private GameBoard game;
	
	@Before
	public void setUp() {
		
		AbstractPiece[][] pieces = new AbstractPiece[10][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				pieces[j][i] = PieceFactory.createClearPiece();
			}
		}
		
		game = new GameBoard(User.PLAYER1, pieces, pieces);
	}

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
	
	@Test
	public void testSelectedButtonPressed() {
		AbstractPiece miner = new Soldier(2, "Miner");
		miner.setLocation(new Point(0,1));
		piece.setOwner(User.PLAYER1);
		
		AbstractPiece obstacle = new Obstacle();
		
		Point obstacleLocation = obstacle.getLocation();
		Point minerLocation = miner.getLocation();
		
		game.selectedButtonPressed(obstacle.getLocation());
		assertFalse(obstacle.isSelected());
	}
	
	
	@After
	public void tearDown() {
		piece = null;
		observer = null;
	}
}
