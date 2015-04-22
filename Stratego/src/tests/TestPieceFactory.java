package tests;

import static org.junit.Assert.*;
import game.AbstractPiece;
import game.Bomb;
import game.Flag;
import game.PieceFactory;
import game.Soldier;

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
		assertTrue(flag instanceof Flag);
		assertEquals("Flag", flag.getName());
	}
	
	@Test
	public void testCreateSpy() {
		AbstractPiece spy = (AbstractPiece) PieceFactory.createSpy();
		assertTrue(spy instanceof Soldier);
		assertEquals("Spy", spy.getName());
		assertEquals(1, spy.getRank());
	}
	
	@Test
	public void testCreateMarshall() {
		AbstractPiece soldier = (AbstractPiece) PieceFactory.createMarshall();
		assertTrue(soldier instanceof Soldier);
		assertEquals("Marshall", soldier.getName());
		assertEquals(10, soldier.getRank());
	}

}
