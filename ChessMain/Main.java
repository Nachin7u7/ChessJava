package ChessMain;

public class Main {
	private static Piece[][] board;

	public static void main(String[] args) {
		board = new Piece[8][8];
		initializeBoard();

		// Prueba de conversiones
		System.out.println("Coordenadas (6, 4) -> Notación ajedrez: " + ChessPosition.toChessNotation(6, 4)); // e2
		System.out.println("Notación ajedrez 'e2' -> Coordenadas: "
				+ java.util.Arrays.toString(ChessPosition.toMatrixCoordinates("e2"))); // [6, 4]

		printBoard();

		// Movimiento usando notación de ajedrez
		String start = "e2";
		String end = "e4";
		int[] startPos = ChessPosition.toMatrixCoordinates(start);
		int[] endPos = ChessPosition.toMatrixCoordinates(end);

		if (movePiece(startPos[0], startPos[1], endPos[0], endPos[1])) {
			System.out.println("Movimiento exitoso de " + start + " a " + end);
		} else {
			System.out.println("Movimiento inválido de " + start + " a " + end);
		}

		printBoard();
	}

	private static void initializeBoard() {
		// Initialize black pieces
		board[0][0] = new Rook(0, 0, "black");
		board[0][1] = new Knight(0, 1, "black");
		board[0][2] = new Bishop(0, 2, "black");
		board[0][3] = new Queen(0, 3, "black");
		board[0][4] = new King(0, 4, "black");
		board[0][5] = new Bishop(0, 5, "black");
		board[0][6] = new Knight(0, 6, "black");
		board[0][7] = new Rook(0, 7, "black");

		for (int i = 0; i < 8; i++) {
			board[1][i] = new Pawn(1, i, "black");
			board[6][i] = new Pawn(6, i, "white");
		}

		// Initialize white pieces
		board[7][0] = new Rook(7, 0, "white");
		board[7][1] = new Knight(7, 1, "white");
		board[7][2] = new Bishop(7, 2, "white");
		board[7][3] = new Queen(7, 3, "white");
		board[7][4] = new King(7, 4, "white");
		board[7][5] = new Bishop(7, 5, "white");
		board[7][6] = new Knight(7, 6, "white");
		board[7][7] = new Rook(7, 7, "white");
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
		if (piece instanceof Rook)
			return piece.getColor().equals("white") ? "R" : "r";
		if (piece instanceof Knight)
			return piece.getColor().equals("white") ? "N" : "n";
		if (piece instanceof Bishop)
			return piece.getColor().equals("white") ? "B" : "b";
		if (piece instanceof Queen)
			return piece.getColor().equals("white") ? "Q" : "q";
		if (piece instanceof King)
			return piece.getColor().equals("white") ? "K" : "k";
		if (piece instanceof Pawn)
			return piece.getColor().equals("white") ? "P" : "p";
		return "?";
	}

	private static boolean movePiece(int startX, int startY, int endX, int endY) {
		Piece piece = board[startX][startY];
		if (piece != null && piece.isValidMove(endX, endY, board)) {
			board[endX][endY] = piece;
			board[startX][startY] = null;
			piece.setPosition(endX, endY);
			return true;
		}
		return false;
	}
}
