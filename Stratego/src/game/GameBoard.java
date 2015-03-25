package game;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;


public class GameBoard extends JPanel {

	public GameBoard() {
		super();
		GridLayout layout = new GridLayout(10, 10);
		this.setLayout(layout);
		for(int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				JButton button = new JButton("Test");
				button.setBackground(Color.WHITE);
				this.add(button, i, j);
				button.validate();
			}
		}
	}

	public Object getPlayer() {
		// TODO Auto-generated method stub
		return null;
	}

	public void addPlayer(Card card) {
		// TODO Auto-generated method stub
		
	}
}
