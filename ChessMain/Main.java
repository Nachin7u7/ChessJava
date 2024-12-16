package ChessMain;

public class Main {
	private static Piece[][] board;

	public static void main(String[] args) {
		board = new Piece[8][8];
		initializeBoard();
		printBoard();
	}

	private static void initializeBoard() {
		// Initialize pieces for demonstration (you can expand this logic)
		board[0][0] = new Rook("black"); // Black Rook
		board[0][1] = new Knight("black"); // Black Knight
		board[0][2] = new Bishop("black"); // Black Bishop
		board[0][3] = new Queen("black"); // Black Queen
		board[0][4] = new King("black"); // Black King
		board[0][5] = new Bishop("black"); // Black Bishop
		board[0][6] = new Knight("black"); // Black Knight
		board[0][7] = new Rook("black"); // Black Rook
		for (int i = 0; i < 8; i++) {
			board[1][i] = new Pawn("black"); // Black Pawns
			board[6][i] = new Pawn("white"); // White Pawns
		}
		board[7][0] = new Rook("white"); // White Rook
		board[7][1] = new Knight("white"); // White Knight
		board[7][2] = new Bishop("white"); // White Bishop
		board[7][3] = new Queen("white"); // White Queen
		board[7][4] = new King("white"); // White King
		board[7][5] = new Bishop("white"); // White Bishop
		board[7][6] = new Knight("white"); // White Knight
		board[7][7] = new Rook("white"); // White Rook
	}

	private static void printBoard() {
		System.out.println("    a   b   c   d   e   f   g   h");
		System.out.println("  +---+---+---+---+---+---+---+---+");
		for (int row = 0; row < 8; row++) {
			System.out.print((8 - row) + " ");
			for (int col = 0; col < 8; col++) {
				Piece piece = board[row][col];
				if (piece == null) {
					if ((row + col) % 2 == 0) {
						System.out.print("|   ");
					} else {
						System.out.print("|###");
					}
				} else {
					System.out.print("| " + getPieceSymbol(piece) + " ");
				}
			}
			System.out.println("| " + (8 - row));
			System.out.println("  +---+---+---+---+---+---+---+---+");
		}
		System.out.println("    a   b   c   d   e   f   g   h");
	}

	private static String getPieceSymbol(Piece piece) {
		// Example logic to return the correct symbol based on the piece type
		if (piece instanceof Rook)
			return "R"; // Rook
		if (piece instanceof Knight)
			return "N"; // Knight
		if (piece instanceof Bishop)
			return "B"; // Bishop
		if (piece instanceof Queen)
			return "Q"; // Queen
		if (piece instanceof King)
			return "K"; // King
		if (piece instanceof Pawn)
			return "P"; // Pawn
		// Add logic for white pieces if necessary (e.g., "p" for white Pawn)
		return "?"; // Unknown piece
	}
}
