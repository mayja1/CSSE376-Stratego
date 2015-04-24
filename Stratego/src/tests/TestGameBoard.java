package tests;

import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import game.AbstractPiece;
import game.GameBoard;
import game.GameBoard.User;
import game.PieceFactory;
import game.Soldier;

public class TestGameBoard {

	private GameBoard testBoard;
	
	@Before
	public void setup() {
		testBoard = new NoneGuiGameBoard(User.PLAYER1);
	}
	
	@After
	public void tearDown() {
		testBoard = null;
	}
	
	public class NoneGuiGameBoard extends GameBoard {
		
		public NoneGuiGameBoard(User owner) {
			super(owner);
		}
		
		@Override
		protected void instantiateBoard() {
			for(int i = 0; i < 10; i++) {
				for (int j = 0; j < 10; j++) {
					this.addPiece(i, j, (AbstractPiece) PieceFactory.createClearPiece());
				}
			}
		}
	}
	
}
