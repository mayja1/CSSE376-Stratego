package game;

import java.awt.BorderLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class HelpPanel extends JPanel {

	
	public HelpPanel() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader("./docs/StrategoHelpMenu.txt"));
			StringBuilder string = new StringBuilder();
			
			String line;
			while((line = in.readLine()) != null)
			{
			    this.add(new JLabel(line));
			}
			in.close();
//			textPane.setPreferredSize(new Dimension(1000,100));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
