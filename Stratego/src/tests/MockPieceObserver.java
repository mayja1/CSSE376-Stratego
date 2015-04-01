package tests;
import java.awt.Point;

import game.IPieceObserver;

public class MockPieceObserver implements IPieceObserver {

	public boolean selectButtonPressed;
	public boolean nonSelectButtonPressed;
	
	public MockPieceObserver() {
		selectButtonPressed = false;
		nonSelectButtonPressed = false;
	}
	
	@Override
	public void selectedButtonPressed(Point gridLocation) {
		selectButtonPressed = true;
		
	}

	@Override
	public void nonSelectedButtonPressed(Point gridLocation) {
		nonSelectButtonPressed = true;
		
	}

}
