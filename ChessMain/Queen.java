package ChessMain;

public class Queen extends Piece {

	public Queen(int x, int y, String color) {
		super(x, y, color);
	}

	@Override
	public boolean isValidMove(int newX, int newY, Piece[][] board) {
		int dx = Math.abs(newX - x);
		int dy = Math.abs(newY - y);

		// Movimiento como torre (horizontal o vertical)
		if (x == newX || y == newY) {
			int xDirection = Integer.compare(newX, x);
			int yDirection = Integer.compare(newY, y);

			int currX = x + xDirection;
			int currY = y + yDirection;

			// Verificar que el camino esté despejado
			while (currX != newX || currY != newY) {
				if (board[currX][currY] != null) {
					return false; // Hay una pieza bloqueando
				}
				currX += xDirection;
				currY += yDirection;
			}

			// Verificar que no hay una pieza del mismo color en el destino
			return board[newX][newY] == null || !board[newX][newY].getColor().equals(color);
		}

		// Movimiento como alfil (diagonal)
		if (dx == dy) {
			int xDirection = Integer.compare(newX, x);
			int yDirection = Integer.compare(newY, y);

			int currX = x + xDirection;
			int currY = y + yDirection;

			// Verificar que el camino esté despejado
			while (currX != newX && currY != newY) {
				if (board[currX][currY] != null) {
					return false; // Hay una pieza bloqueando
				}
				currX += xDirection;
				currY += yDirection;
			}

			// Verificar que no hay una pieza del mismo color en el destino
			return board[newX][newY] == null || !board[newX][newY].getColor().equals(color);
		}

		return false; // Movimiento no válido
	}
}
