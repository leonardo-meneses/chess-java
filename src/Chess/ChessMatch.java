package Chess;

import Chess.pieces.KING;
import Chess.pieces.Rook;
import boardGame.Board;
import boardGame.Position;

public class ChessMatch {
	
	private Board board;
	
	public ChessMatch() {
		board = new Board(8, 8);
		initialSetup();
	}
	
	public ChessPiece[][] getPieces(){
		ChessPiece[][] mat = new ChessPiece[board.getRows()][board.getColumns()];
		
		for(int i=0; i<board.getRows(); i++) {
			for(int k=0; k<board.getColumns(); k++) {
				mat[i][k] = (ChessPiece) board.piece(i, k); 
			}
		}
		return mat;
	}
	
	private void initialSetup() {
		board.placePiece(new Rook(board, Color.WHITE), new Position(2, 1));
		board.placePiece(new KING(board, Color.BLACK), new Position(0,4));
		board.placePiece(new KING(board, Color.WHITE), new Position(7,4));
	}
}
