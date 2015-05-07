package tests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import game.AbstractPiece;
import game.Bomb;
import game.GameBoardFrame;
import game.GameBoard.User;
import game.PieceFactory;

public class TestGameBoardFrame {

	GameBoardFrame frame;
	
	@Before
	public void setup() {
		frame = new GameBoardFrame(User.PLAYER1, null) {
			@Override
			public void showGui() {
				this.setVisible(false);
			}
		};
	}
	
	@Test
	public void testCopyPiece() {
		AbstractPiece piece = PieceFactory.createBomb();
		assertTrue(frame.copyInstanceOfPiece(piece) instanceof Bomb);
	}
}
