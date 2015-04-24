package tests;

import static org.junit.Assert.*;
import game.AbstractPiece;
import game.Bomb;
import game.ClearPiece;
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
		assertEquals(0, spy.getRank());
	}
	
	@Test
	public void testCreateMarshall() {
		AbstractPiece soldier = (AbstractPiece) PieceFactory.createMarshall();
		assertTrue(soldier instanceof Soldier);
		assertEquals("Marsh", soldier.getName());
		assertEquals(9, soldier.getRank());
	}
	
	@Test
	public void testCreateGeneral() {
		AbstractPiece soldier = (AbstractPiece) PieceFactory.createGeneral();
		assertTrue(soldier instanceof Soldier);
		assertEquals("General", soldier.getName());
		assertEquals(8, soldier.getRank());
	}
	
	@Test
	public void testCreateColonel() {
		AbstractPiece soldier = (AbstractPiece) PieceFactory.createColonel();
		assertTrue(soldier instanceof Soldier);
		assertEquals("Colonel", soldier.getName());
		assertEquals(7, soldier.getRank());
	}
	
	@Test
	public void testCreateMajor() {
		AbstractPiece soldier = (AbstractPiece) PieceFactory.createMajor();
		assertTrue(soldier instanceof Soldier);
		assertEquals("Major", soldier.getName());
		assertEquals(6, soldier.getRank());
	}
	
	@Test
	public void testCreateCaptain() {
		AbstractPiece soldier = (AbstractPiece) PieceFactory.createCaptain();
		assertTrue(soldier instanceof Soldier);
		assertEquals("Captain", soldier.getName());
		assertEquals(5, soldier.getRank());
	}
	
	@Test
	public void testCreateLieutenant() {
		AbstractPiece soldier = (AbstractPiece) PieceFactory.createLieutenant();
		assertTrue(soldier instanceof Soldier);
		assertEquals("Lieut", soldier.getName());
		assertEquals(4, soldier.getRank());
	}
	
	@Test
	public void testCreateSergeant() {
		AbstractPiece soldier = (AbstractPiece) PieceFactory.createSergeant();
		assertTrue(soldier instanceof Soldier);
		assertEquals("Sergeant", soldier.getName());
		assertEquals(3, soldier.getRank());
	}
	
	@Test
	public void testCreateMiner() {
		AbstractPiece soldier = (AbstractPiece) PieceFactory.createMiner();
		assertTrue(soldier instanceof Soldier);
		assertEquals("Miner", soldier.getName());
		assertEquals(2, soldier.getRank());
	}
	
	@Test
	public void testCreateScout() {
		AbstractPiece soldier = (AbstractPiece) PieceFactory.createScout();
		assertTrue(soldier instanceof Soldier);
		assertEquals("Scout", soldier.getName());
		assertEquals(1, soldier.getRank());
	}
	
	@Test
	public void testCreateClearPiece() {
		AbstractPiece soldier = (AbstractPiece) PieceFactory.createClearPiece();
		assertTrue(soldier instanceof ClearPiece);
		assertEquals(null, soldier.getName());
		assertEquals(0, soldier.getRank());
	}

}
