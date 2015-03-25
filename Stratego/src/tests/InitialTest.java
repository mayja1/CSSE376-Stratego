package tests;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import game.Card;
import game.GameBoard;

public class InitialTest {

	@Test
	public void testGetPlayerNumber() {
		Card player = new Card();
		assertEquals(5, player.getNumber());
	}
	
	@Test
	public void testAddPlayer() {
		GameBoard newBoard = new GameBoard();
		newBoard.addPlayer(new Card());
		assertEquals(Card.class, newBoard.getPlayer());
	}
	
	@Test
	public void testCreateGameBoard() {
		GameBoard newBoard = new GameBoard();
		assertEquals(GameBoard.class, newBoard);
	}
	
	@Test
	public void testAttackEnemy() {
		assertEquals(false, true);
	}
	
	@Test
	public void testGetTileNumber() {
		assertEquals(1, 0);
	}
}
