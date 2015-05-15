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
		showGui();
	}
	
	public void showGui() {
		this.setVisible(true);
		this.validate();
	}
	
	public void setObserver(IBoardObserver observer) {
		this.otherGameBoard = observer;
	}

	@Override
	public void opponentDoneWithThisBoard(AbstractPiece[][] completedBoard) {
		AbstractPiece[][] copyBoard = new AbstractPiece[10][4];
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 4; j++) {
				copyBoard[i][j] = copyInstanceOfPiece(completedBoard[i][j]);
			}
		}
		board.opponentDoneWithThisBoard(copyBoard);
		
	}

	@Override
	public void doneWithMyBoard(AbstractPiece[][] pieces) {
		otherGameBoard.opponentDoneWithThisBoard(pieces);
	}
	
	public AbstractPiece copyInstanceOfPiece(AbstractPiece piece) {
		AbstractPiece pieceCopy = null;
		if(piece instanceof Bomb) {
			pieceCopy = PieceFactory.createBomb();
		}		
		else if(piece instanceof Flag)
			pieceCopy = PieceFactory.createFlag();
		else {
		pieceCopy = new Soldier(piece.getRank(), piece.getName());
		}
		pieceCopy.setOwner(piece.owner);
		pieceCopy.setLocation(piece.getLocation());
		return pieceCopy;
	}

	@Override
	public void endGame(User player) {
		// Un-implemented
	}
}
