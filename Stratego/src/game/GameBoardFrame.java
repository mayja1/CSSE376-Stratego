package game;
import game.GameBoard.User;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameBoardFrame extends JFrame {

	private PlayerBoard board;
	
	public GameBoardFrame(User owner, ITurnObserver observer) {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize.width/2, screenSize.height);
		board = new PlayerBoard(owner, observer);
		this.add(board);
		this.setVisible(true);
		this.validate();
	}
}
