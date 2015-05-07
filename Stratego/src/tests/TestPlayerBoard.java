package tests;

import org.junit.Assert;

import game.GameBoard.User;
import game.PlayerBoard;
import game.TurnObserver;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class TestPlayerBoard {

	PlayerBoard testBoard;
	@Before
	public void setup() {
		testBoard = new PlayerBoard(User.PLAYER1, new TurnObserver());
	}
	
	@After
	public void tearDown() {
		testBoard = null;
	}
	
	@Test
	public void testConstruction() {
		Assert.assertEquals(User.PLAYER1, testBoard.getOwner());
		Assert.assertNotNull(testBoard.getBoard());
	}
}
