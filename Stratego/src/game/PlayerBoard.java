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
	private JLabel status;
	private AbstractPiece[][] myPieces;
	private AbstractPiece[][] opponentPieces;
	private IBoardObserver containerObserver;
	public PlayerBoard(User owner, ITurnObserver turnObserver, IBoardObserver observer) {
		this.setOwner(owner);
		this.turnObserver = turnObserver;
		this.containerObserver = observer;
		BorderLayout layout = new BorderLayout();
		this.setLayout(layout);
		status = new JLabel("Test Label");
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
	public void doneWithMyBoard(AbstractPiece[][] pieces) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void opponentDoneWithThisBoard(AbstractPiece[][] completedBoard) {
		// TODO Auto-generated method stub
		
	}
}
