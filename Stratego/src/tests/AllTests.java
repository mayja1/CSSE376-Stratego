package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
		{
			TestGameBoardFrame.class,
			TestBombPiece.class,
			TestClearPiece.class,
			TestFlagPiece.class,
			TestObstaclePiece.class,
			TestAttacking.class,
			TestPieceFactory.class,
			TestPiece.class,
			TestGameBoard.class,
			TestPlayerBoard.class,
			TestBoardObserver.class,
			TestTurnObserver.class,
			TestSetupBoard.class,
			TestHelpPanel.class
		})
public class AllTests {
	
}
