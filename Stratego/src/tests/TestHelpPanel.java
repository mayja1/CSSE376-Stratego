package tests;

import java.io.IOException;

import game.HelpPanel;

import org.junit.Assert;
import org.junit.Test;

public class TestHelpPanel {
		
	@Test
	public void testHelpGivesErrorOnBadFile() {
		HelpPanel helpPanel = new HelpPanel("./docs/StrategoHelpMen.txt");
		Assert.assertEquals("Cannot read from file", helpPanel.errorMsg);
	}
	
	@Test
	public void testHelpIsMade() {
		HelpPanel helpPanel = new HelpPanel("./docs/StrategoHelpMenu.txt");
		Assert.assertEquals(null, helpPanel.errorMsg);
	}
}

