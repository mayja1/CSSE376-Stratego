package tests;

import static org.junit.Assert.*;
import game.AbstractPiece;
import game.Bomb;
import game.PieceFactory;

import org.junit.Test;

public class TestPieceFactory {

	@Test
	public void testCreateBomb() {
		AbstractPiece bomb = (AbstractPiece) PieceFactory.createBomb();
		assertTrue(bomb instanceof Bomb);
		assertEquals("Bomb", bomb.getName());
	}
	
	@Test
	public void testCreateFlag() {
		AbstractPiece flag = (AbstractPiece) PieceFactory.createFlag();
		assertTrue(flag instanceof AbstractPiece);
		assertEquals("Flag", flag.getName());
	}
	
	@Test
	public void testCreateSpy() {
		AbstractPiece spy = (AbstractPiece) PieceFactory.createSpy();
		assertTrue(spy instanceof AbstractPiece);
		assertEquals("Spy", spy.getName());
	}
	
	@Test
	public void testCreateMarshall() {
		AbstractPiece soldier = (AbstractPiece) PieceFactory.createMarshall();
		assertTrue(soldier instanceof AbstractPiece);
		assertEquals("Marshall", soldier.getName());
		assertEquals(10, soldier.getRank());
	}

}
