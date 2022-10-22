package boardGame;

public abstract class Piece {
	protected Position position;// com protected a classe fica visivel apenas para classes do mesmo pacote e subclasses
	private Board board;
	
	public Piece(Board board) {
		//super();
		this.board = board;
		position = null; // opcional o java ja atribui null.
	}

	protected Board getBoard() {
		return board;
	}
	
	public abstract boolean[][] possibleMoves();
		
	public boolean possibleMove(Position position) {
		return possibleMoves()[position.getRow()][position.getColumn()];
	}
	
	public boolean isThereAnyPossibleMoves() {
		boolean[][] mat = possibleMoves();
		
		for(int i=0; i< mat.length; i++) {
			for(int k=0; k< mat.length; k++) {
				if(mat[i][k]) {
					return true;
				}
			}
		}
		return false;
	}
}
