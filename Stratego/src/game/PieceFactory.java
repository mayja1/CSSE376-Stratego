package game;

public class PieceFactory {
	
	public static IPiece createBomb() {
		AbstractPiece bomb = new Bomb();
		bomb.setName("bomb");
		return bomb;
	}

}
