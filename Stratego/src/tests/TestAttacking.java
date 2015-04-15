package tests;

import static org.junit.Assert.*;

import java.awt.Point;

import game.AbstractPiece;
import game.GameBoard;
import game.Soldier;

import org.junit.Test;

public class TestAttacking {
	
	private GameBoard game = new GameBoard();

	@Test
	public void TestAttackLowerRank() {
		AbstractPiece s1 = new Soldier(5);
		AbstractPiece s2 = new Soldier(6);
		assertEquals(-1, game.attack(s1, s2));
	}
	
	@Test
	public void TestAttackHigherRank() {
		AbstractPiece s1 = new Soldier(6);
		AbstractPiece s2 = new Soldier(5);
		assertEquals(1, game.attack(s1, s2));
	}
	
	@Test
	public void TestAttackSameRank() {
		AbstractPiece s1 = new Soldier(5);
		AbstractPiece s2 = new Soldier(5);
		assertEquals(0, game.attack(s1, s2));
	}

}
