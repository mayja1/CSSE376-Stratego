import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class PlayerBoard extends JPanel {

	public PlayerBoard() {
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		JLabel status = new JLabel("Test Label");
		this.add(status, BorderLayout.NORTH);
		this.add(new GameBoard(), BorderLayout.CENTER);
	}
}
