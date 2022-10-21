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
	
	private void placeNewPiece(char column, int row, ChessPiece piece) {
		board.placePiece(piece, new ChessPosition(column, row).toPosition());
	}
	
	private void initialSetup() {
		placeNewPiece('b' , 6 , new Rook(board, Color.WHITE));
		placeNewPiece('e' , 8 , new KING(board, Color.BLACK));
		placeNewPiece('e' , 1 , new KING(board, Color.WHITE));
	}
}
