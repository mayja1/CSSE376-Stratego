package game;
import game.GameBoard.User;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class PlayerBoard extends JPanel {
	private User owner;
	private GameBoard board;
	
	public PlayerBoard(User owner) {
		this.setOwner(owner);
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		JLabel status = new JLabel("Test Label");
		this.add(status, BorderLayout.NORTH);
		this.setBoard(new GameBoard(owner));
		this.add(new SetupBoard(owner), BorderLayout.CENTER);
	}
	
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public GameBoard getBoard() {
		return board;
	}
	public void setBoard(GameBoard board) {
		this.board = board;
	}
}
