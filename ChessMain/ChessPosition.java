package ChessMain;

public class ChessPosition {

	// Convierte coordenadas (x, y) a notación de ajedrez ("e5", etc.)
	public static String toChessNotation(int x, int y) {
		char file = (char) ('a' + y); // 'a' para la columna 0, 'b' para la columna 1, etc.
		int rank = 8 - x; // Filas invertidas, ya que en ajedrez 8 está arriba
		return "" + file + rank;
	}

	// Convierte notación de ajedrez ("e5", etc.) a coordenadas (x, y)
	public static int[] toMatrixCoordinates(String chessNotation) {
		char file = chessNotation.charAt(0); // Letra como 'e'
		int rank = Character.getNumericValue(chessNotation.charAt(1)); // Número como 5

		int x = 8 - rank; // Convertir fila de ajedrez a índice de matriz
		int y = file - 'a'; // Convertir columna de letra a índice numérico
		return new int[] { x, y };
	}
}
