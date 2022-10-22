package aplication;

import java.util.InputMismatchException;
import java.util.Scanner;

import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;
import Chess.Color;

public class UI {
	
	// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";

	public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
	public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
	public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
	public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
	public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
	public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
	public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
	public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
	
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}
	
	public static ChessPosition readChessPosition(Scanner sc) {
		try {
			String s = sc.nextLine();
			char column = s.charAt(0);
			int row = Integer.parseInt(s.substring(1));
			return new ChessPosition(column, row);
		}
		catch(RuntimeException e){
			throw new InputMismatchException("Erro, insira um valor valido do tabuleiro de a1 - h8.");
		}

	}
	
	public static void printMach(ChessMatch chessMatch) {
		printBoard(chessMatch.getPieces());
		System.out.println();
		System.out.println("Turn: " + chessMatch.getTurn());
		System.out.println("Waiting player: " + chessMatch.getCurrentPlayer());
	}
	
	public static void printBoard(ChessPiece[][] pieces) {
		for(int i=0; i<pieces.length; i++) {
			System.out.print((8-i) + " ");
			for(int k=0; k< pieces.length; k++) {
				printPiece(pieces[i][k], false);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
	}
	//imprimir uma pe�a
	private static void printPiece(ChessPiece piece, boolean backGround) {
		
		if(backGround) {
			System.out.print(ANSI_BLUE_BACKGROUND);
		}
		if (piece == null) {
            System.out.print("-" + ANSI_RESET);
        }
        else {
            if (piece.getColor() == Color.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            }
            else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
	}

	public static void printBoard(ChessPiece[][] pieces, boolean[][] possibleMoves) {
		for(int i=0; i<pieces.length; i++) {
			System.out.print((8-i) + " ");
			for(int k=0; k< pieces.length; k++) {
				printPiece(pieces[i][k], possibleMoves[i][k]);
			}
			System.out.println();
		}
		System.out.println("  a b c d e f g h");
		
	}
}

