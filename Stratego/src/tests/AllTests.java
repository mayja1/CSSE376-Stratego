package tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses(
		{
			TestBombPiece.class,
			TestClearPiece.class,
			TestFlagPiece.class,
			TestObstaclePiece.class,
			TestAttacking.class,
			TestPiece.class
		})
public class AllTests {
	
}
