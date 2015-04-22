package game;

public class PieceFactory {
	
	public static IPiece createBomb() {
		AbstractPiece bomb = new Bomb();
		bomb.setName("Bomb");
		return bomb;
	}
	
	public static IPiece createFlag() {
		AbstractPiece flag = new Flag();
		flag.setName("Flag");
		return flag;
	}
	
	public static IPiece createSpy() {
		AbstractPiece spy = new Soldier(1);
		spy.setName("Spy");
		return spy;
	}
	
	public static IPiece createMarshall() {
		AbstractPiece soldier = new Soldier(10);
		soldier.setName("Marshall");
		return soldier;
	}
	
	public static IPiece createGeneral() {
		AbstractPiece soldier = new Soldier(9);
		soldier.setName("General");
		return soldier;
	}
	
	public static IPiece createColonel() {
		return null;
	}
	
	public static IPiece createMajor() {
		return null;
	}

}
