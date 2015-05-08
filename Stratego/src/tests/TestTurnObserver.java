package tests;

import static org.junit.Assert.*;

import java.awt.Point;
import java.lang.reflect.Field;

import game.AbstractPiece;
import game.GameBoard;
import game.GameBoardFrame;
import game.ITurnObserver;
import game.PieceFactory;
import game.PlayerBoard;
import game.TurnObserver;
import game.GameBoard.User;

import javax.swing.JFrame;

import org.junit.Before;
import org.junit.Test;

public class TestTurnObserver {
	
	private GameBoardMock gameBoard2;
	private AbstractPiece[][] pieces;
	private TurnObserver observer;
	@Before
	public void setup() {
		observer = new TurnObserver();
		pieces = new AbstractPiece[10][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				pieces[j][i] = PieceFactory.createClearPiece();
			}
		}
		observer.addBoard(User.PLAYER1, new GameBoardMock(User.PLAYER1, pieces, pieces));
		gameBoard2 = new GameBoardMock(User.PLAYER2, pieces, pieces);
		observer.addBoard(User.PLAYER2, gameBoard2);
	}

	@Test
	public void testCreateTurnObserver() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		GameBoard board = new GameBoard(User.PLAYER1, pieces, pieces);
		board.setObserver(observer);
		Field privateObserverField = GameBoard.class.
		            getDeclaredField("observer");
		privateObserverField.setAccessible(true);
		ITurnObserver fieldValue = (ITurnObserver) privateObserverField.get(board);
		
		assertTrue(fieldValue != null);
	}
	
	@Test
	public void testEndTurn() {
		assertTrue(observer.isTurn(User.PLAYER1));
		observer.endTurn(null, null);
		assertTrue(observer.isTurn(User.PLAYER2));
	}
	
	@Test
	public void testUpdateOccurred() {
		assertTrue(observer.isTurn(User.PLAYER1));
		observer.endTurn(null, null);
		assertTrue(gameBoard2.updated);
	}
	@Test
	public void testIsTurn() {
		assertTrue(observer.isTurn(User.PLAYER1));
	}

	private class GameBoardMock extends GameBoard {
		boolean updated;
		public GameBoardMock(User owner, AbstractPiece[][] pieces, AbstractPiece[][] opponentPieces) {
			super(owner, pieces, opponentPieces);
			updated = false;
		}
		
		@Override
		public void updateBoard(Point p1, Point p2) {
			updated = true;
		}
	}
}
