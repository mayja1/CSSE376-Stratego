package game;
import game.GameBoard.User;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;


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

	public void doneWithMyBoard(AbstractPiece[][] pieces) {
		myPieces = pieces;
		containerObserver.doneWithMyBoard(pieces);
		initializeGameBoard();
	}

	@Override
	public void opponentDoneWithThisBoard(AbstractPiece[][] completedBoard) {
		opponentPieces = completedBoard;
		initializeGameBoard();
		
	}

	private void initializeGameBoard() {
		if(myPieces == null) {
			return;
		}
		if(opponentPieces == null) {
			this.remove(board);
			this.status.setText("Waiting on the other player to finish their board");
			this.validate();
			this.repaint();
			return; 
		}
		this.remove(board);
		GameBoard gameBoard = new GameBoard(owner, myPieces, opponentPieces);
		gameBoard.setObserver(turnObserver, this);
		turnObserver.addBoard(owner, gameBoard);
		this.add(gameBoard, BorderLayout.CENTER);
		gameBoard.validate();
		this.validate();
		this.repaint();
		this.setBoard(gameBoard);
		
		BufferedReader in;
		try {
			in = new BufferedReader(new FileReader("./docs/StrategoHelpMenu.txt"));
			StringBuilder string = new StringBuilder();
			
			String line;
			while((line = in.readLine()) != null)
			{
			    string.append(line + "\n");
			}
			in.close();
			JTextPane textPane = new JTextPane();
			JScrollPane scrollPane = new JScrollPane(textPane);
			textPane.setText(string.toString());
//			textPane.setPreferredSize(new Dimension(1000,100));
			
			this.add(scrollPane, BorderLayout.SOUTH);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void endGame(User player) {
		this.remove(board);
		board.validate();
		this.validate();
		this.repaint();
		board = null;
		this.status.setText("Player " + player + " is the winner!");		
	}
}
