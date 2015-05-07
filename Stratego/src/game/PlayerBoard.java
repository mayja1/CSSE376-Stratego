package game;
import game.GameBoard.User;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class PlayerBoard extends JPanel implements IBoardObserver {
	private User owner;
	private JPanel board;
	private ITurnObserver turnObserver;
	
	public PlayerBoard(User owner, ITurnObserver turnObserver) {
		this.setOwner(owner);
		this.turnObserver = turnObserver;
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		JLabel status = new JLabel("Test Label");
		this.add(status, BorderLayout.NORTH);		
		SetupBoard init = new SetupBoard(owner);
		init.setObserver(this);
		this.setBoard(init);
		this.add(init, BorderLayout.CENTER);
	}
	
	public User getOwner() {
		return owner;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}
	
	public JPanel getBoard() {
		return board;
	}
	public void setBoard(JPanel board) {
		this.board = board;
	}

	@Override
	public void isDone(AbstractPiece[][] pieces) {
		// Not implemented
		GameBoard gameBoard = new GameBoard(owner, pieces);
		this.remove(board);
		this.add(gameBoard);
		this.validate();
		this.repaint();
		this.setBoard(gameBoard);
	}
}
