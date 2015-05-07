package game;
import game.GameBoard.User;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class GameBoardFrame extends JFrame implements IBoardObserver {

	private PlayerBoard board;
	private IBoardObserver otherGameBoard;
	private User owner;
	public GameBoardFrame(User owner, ITurnObserver observer) {
		this.owner = owner;
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize.width/2, screenSize.height);

		board = new PlayerBoard(owner, observer, this);
		this.add(board);
		this.setVisible(true);
		this.validate();
	}
	
	public void setObserver(IBoardObserver observer) {
		this.otherGameBoard = observer;
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
