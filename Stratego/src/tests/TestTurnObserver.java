package tests;

import static org.junit.Assert.*;

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
	
	private AbstractPiece[][] pieces;
	
	@Before
	public void setup() {
		pieces = new AbstractPiece[10][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				pieces[j][i] = PieceFactory.createClearPiece();
			}
		}
	}

	@Test
	public void testCreateTurnObserver() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		ITurnObserver observer = new TurnObserver();
		GameBoard board = new GameBoard(User.PLAYER1, pieces);
		board.setObserver(observer);
		Field privateObserverField = GameBoard.class.
		            getDeclaredField("observer");
		privateObserverField.setAccessible(true);
		ITurnObserver fieldValue = (ITurnObserver) privateObserverField.get(board);
		
		assertTrue(fieldValue != null);
	}
	
	@Test
	public void testEndTurn() {
		ITurnObserver observer = new TurnObserver();
		assertTrue(observer.isTurn(User.PLAYER1));
		observer.endTurn();
		assertTrue(observer.isTurn(User.PLAYER2));
	}
	
	@Test
	public void testIsTurn() {
		ITurnObserver observer = new TurnObserver();
		assertTrue(observer.isTurn(User.PLAYER1));
	}

}
