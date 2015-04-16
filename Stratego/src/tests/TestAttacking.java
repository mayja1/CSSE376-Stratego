package tests;

import static org.junit.Assert.*;

import java.awt.Point;

import game.AbstractPiece;
import game.Bomb;
import game.GameBoard;
import game.GameBoard.User;
import game.Soldier;

import org.junit.Test;

public class TestAttacking {
	
	private GameBoard game = new GameBoard();

	@Test
	public void TestAttackLowerRank() {
		AbstractPiece s1 = new Soldier(5);
		s1.setOwner(User.PLAYER1);
		AbstractPiece s2 = new Soldier(6);
		s2.setOwner(User.PLAYER2);
		assertEquals("PLAYER2 beat PLAYER1", game.attack(s1, s2));
	}
	
	@Test
	public void TestAttackHigherRank() {
		AbstractPiece s1 = new Soldier(6);
		s1.setOwner(User.PLAYER1);
		AbstractPiece s2 = new Soldier(5);
		s2.setOwner(User.PLAYER2);
		assertEquals("PLAYER1 beat PLAYER2", game.attack(s1, s2));
	}
	
	@Test
	public void TestAttackSameRank() {
		AbstractPiece s1 = new Soldier(5);
		s1.setOwner(User.PLAYER1);
		AbstractPiece s2 = new Soldier(5);
		s2.setOwner(User.PLAYER2);
		assertEquals("PLAYER1 tied PLAYER2", game.attack(s1, s2));
	}
	
	@Test
	public void TestGetNewLocationAfterWin() {
		AbstractPiece s1 = new Soldier(6);
		s1.setOwner(User.PLAYER1);
		s1.setLocation(new Point(0, 1));
		AbstractPiece s2 = new Soldier(5);
		s2.setOwner(User.PLAYER2);
		s2.setLocation(new Point(1, 1));
		game.attack(s1, s2);
		assertEquals(new Point(1, 1), s1.getLocation());
	}
	
	@Test
	public void TestRemovePieceAfterLosing() {
		AbstractPiece s1 = new Soldier(5);
		s1.setOwner(User.PLAYER1);
		s1.setLocation(new Point(0, 1));
		AbstractPiece s2 = new Soldier(6);
		s2.setOwner(User.PLAYER2);
		s2.setLocation(new Point(1, 1));
		game.attack(s1, s2);
		assertEquals(null, s1.getLocation());
		assertEquals(new Point(1, 1), s2.getLocation());
	}
	
	@Test
	public void TestRemoveBothPiecesAfterTie() {
		AbstractPiece s1 = new Soldier(5);
		s1.setOwner(User.PLAYER1);
		s1.setLocation(new Point(0, 1));
		AbstractPiece s2 = new Soldier(5);
		s2.setOwner(User.PLAYER2);
		s2.setLocation(new Point(1, 1));
		game.attack(s1, s2);
		assertEquals(null, s1.getLocation());
		assertEquals(null, s2.getLocation());
	}
	
	@Test
	public void TestRemovePieceAttackingBomb() {
		AbstractPiece s1 = new Soldier(5);
		s1.setOwner(User.PLAYER1);
		s1.setLocation(new Point (0, 1));
		AbstractPiece s2 = new Bomb();
		s2.setOwner(User.PLAYER2);
		s2.setLocation(new Point (1, 1));
		game.attack(s2, s1);
		assertEquals(null, s1.getLocation());
		assertEquals(null, s2.getLocation());
	}
	
	@Test
	public void TestRemovePieceOnlyAttackingEnemyBomb() {
		AbstractPiece s1 = new Soldier(5);
		s1.setOwner(User.PLAYER1);
		s1.setLocation(new Point (0, 1));
		AbstractPiece s2 = new Bomb();
		s2.setOwner(User.PLAYER2);
		s2.setLocation(new Point (1, 1));
		game.attack(s1, s2);
		assertEquals(null, s1.getLocation());
		assertEquals(null, s2.getLocation());
	}

}
