package tests;

import static org.junit.Assert.*;
import game.AbstractPiece;
import game.GameBoard;
import game.PieceFactory;
import game.PlayerBoard;
import game.GameBoard.User;
import game.SetupBoard;
import game.TurnObserver;

import org.junit.Before;
import org.junit.Test;

public class TestBoardObserver {
	
	private PlayerBoard testBoard;
	private AbstractPiece[][] pieces;
	
	@Before
	public void setup() {
		testBoard = new PlayerBoard(User.PLAYER1, new TurnObserver());
		pieces = new AbstractPiece[10][4];
		for (int i = 0; i < 4; i++) {
			for (int j = 0; j < 10; j++) {
				pieces[j][i] = PieceFactory.createClearPiece();
			}
		}
	}

	@Test
	public void testIsDone() {
		testBoard.isDone(pieces);
		assertFalse(testBoard.getBoard() instanceof SetupBoard);
		assertTrue(testBoard.getBoard() instanceof GameBoard);
	}

}
