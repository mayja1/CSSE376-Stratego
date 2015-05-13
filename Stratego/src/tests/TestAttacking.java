package tests;

import static org.junit.Assert.*;

import java.awt.Point;

import javax.swing.JPanel;

import game.AbstractPiece;
import game.Bomb;
import game.Flag;
import game.GameBoard;
import game.IBoardObserver;
import game.PieceFactory;
import game.GameBoard.User;
import game.Soldier;

import org.junit.Before;
import org.junit.Test;

public class TestAttacking {
	
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
		game.setObserver(null, new MockPlayerBoard());
	}

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
		game.attack(s1, s2);
		assertEquals(null, s1.getLocation());
		assertEquals(null, s2.getLocation());
	}
	
	@Test
	public void TestMinorDefuseEnemyBomb() {
		AbstractPiece s1 = new Soldier(2);
		s1.setOwner(User.PLAYER1);
		s1.setLocation(new Point (0, 1));
		AbstractPiece s2 = new Bomb();
		s2.setOwner(User.PLAYER2);
		s2.setLocation(new Point (1, 1));
		game.attack(s1, s2);
		assertEquals(new Point(1, 1), s1.getLocation());
		assertEquals(null, s2.getLocation());
	}
	
	@Test
	public void TestAttackFlag() {
		AbstractPiece s1 = new Soldier(5);
		s1.setOwner(User.PLAYER1);
		s1.setLocation(new Point (0, 1));
		AbstractPiece s2 = new Flag();
		s2.setOwner(User.PLAYER2);
		s2.setLocation(new Point (1, 1));
		game.attack(s1, s2);
		assertEquals(new Point(1, 1), s1.getLocation());
		assertEquals(null, s2.getLocation());
	}
	
	@Test
	public void TestSpyAttackMarshall() {
		AbstractPiece s1 = new Soldier(0);
		s1.setOwner(User.PLAYER1);
		s1.setLocation(new Point(0, 1));
		AbstractPiece s2 = new Soldier(9);
		s2.setOwner(User.PLAYER2);
		s2.setLocation(new Point(1, 1));
		game.attack(s1, s2);
		assertEquals(new Point(1, 1), s1.getLocation());
		assertEquals(null, s2.getLocation());
	}
	
	@Test
	public void TestMarshallAttackSpy() {
		AbstractPiece s1 = new Soldier(9);
		s1.setOwner(User.PLAYER1);
		s1.setLocation(new Point(0, 1));
		AbstractPiece s2 = new Soldier(0);
		s2.setOwner(User.PLAYER2);
		s2.setLocation(new Point(1, 1));
		game.attack(s1, s2);
		assertEquals(new Point(1, 1), s1.getLocation());
		assertEquals(null, s2.getLocation());
	}
	
	@Test
	public void TestVisibilityOnBasicAttack() {
		AbstractPiece s1 = new Soldier(3);
		s1.setOwner(User.PLAYER1);
		s1.setLocation(new Point(0, 1));
		AbstractPiece s2 = new Soldier(2);
		s2.setOwner(User.PLAYER2);
		s2.setLocation(new Point(1, 1));
		game.attack(s1, s2);
		assertEquals(true, s1.getVisiblity());
	}
	
	@Test
	public void TestVisibilityOnSpecialAttack() {
		AbstractPiece s1 = new Soldier(2);
		s1.setOwner(User.PLAYER1);
		s1.setLocation(new Point (0, 1));
		AbstractPiece s2 = new Bomb();
		s2.setOwner(User.PLAYER2);
		s2.setLocation(new Point (1, 1));
		game.attack(s1, s2);
		assertEquals(true, s1.getVisiblity());
	}
	
	private class MockPlayerBoard extends JPanel implements IBoardObserver {

		@Override
		public void doneWithMyBoard(AbstractPiece[][] pieces) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void opponentDoneWithThisBoard(AbstractPiece[][] completedBoard) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void endGame(User player) {
			// TODO Auto-generated method stub
		}
	}
	
}
