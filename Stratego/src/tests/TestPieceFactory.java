package tests;

import static org.junit.Assert.*;
import game.AbstractPiece;
import game.PieceFactory;

import org.junit.Test;

public class TestPieceFactory {

	@Test
	public void testCreateBomb() {
		AbstractPiece bomb = (AbstractPiece) PieceFactory.createBomb();
		assertTrue(bomb instanceof AbstractPiece);
		assertEquals("bomb", bomb.getName());
	}

}
