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
	public String errorMsg;
	public HelpPanel(String file) {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader(file));
			
			String line;
			while((line = in.readLine()) != null)
			{
			    this.add(new JLabel(line));
			}
			in.close();
			
		} catch (IOException e) {
//			e.printStackTrace();
			this.errorMsg = "Cannot read from file";
			System.out.println(errorMsg);
		}
	}
}
