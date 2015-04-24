package game;

public class PieceFactory {
	
	public static AbstractPiece createBomb() {
		AbstractPiece bomb = new Bomb();
		return bomb;
	}
	
	public static AbstractPiece createClearPiece() {
		return new ClearPiece();
	}
	
	public static AbstractPiece createFlag() {
		AbstractPiece flag = new Flag();
		return flag;
	}
	
	public static AbstractPiece createSpy() {
		AbstractPiece spy = new Soldier(0, "Spy");
		return spy;
	}
	
	public static AbstractPiece createMarshall() {
		AbstractPiece soldier = new Soldier(9, "Marsh");
		return soldier;
	}
	
	public static AbstractPiece createGeneral() {
		AbstractPiece soldier = new Soldier(8, "General");
		return soldier;
	}
	
	public static AbstractPiece createColonel() {
		AbstractPiece soldier = new Soldier(7, "Colonel");
		return soldier;
	}
	
	public static AbstractPiece createMajor() {
		AbstractPiece soldier = new Soldier(6, "Major");
		return soldier;
	}

	public static AbstractPiece createCaptain() {
		AbstractPiece soldier = new Soldier(5, "Captain");
		return soldier;
	}

	public static AbstractPiece createLieutenant() {
		AbstractPiece soldier = new Soldier(4, "Lieut");
		return soldier;
	}

	public static AbstractPiece createSergeant() {
		AbstractPiece soldier = new Soldier(3, "Sergeant");
		return soldier;
	}

	public static AbstractPiece createMiner() {
		AbstractPiece soldier = new Soldier(2, "Miner");
		return soldier;
	}

	public static AbstractPiece createScout() {
		AbstractPiece soldier = new Soldier(1, "Scout");
		return soldier;
	}

}
