package recursion;

public class NQueensProblem {

	public boolean checkValid(int num) {
		if ( num <= 0)
			throw new AssertionError();
		return true;
	}

	/**
	 * display the chess board with queens as 1
	 * @param arr as a array of int type
	 * @param size as a length of chess board
	 */
	public void displayBoard(int[][] arr, int size) {
		for ( int i=0; i<size; i++){
			for ( int j=0; j<size; j++)
				System.out.print(arr[j][i]);
			System.out.println();
		}
	}

	/**
	 *
	 * @param chessBoard as a 2D Matrix of Chess Board
	 * @param col  as a Column Of the Chess Board
	 * @param size as a Length Of Board
	 * @return true if all queens are placed correctly
	 */
	public boolean nQProblem(int[][] chessBoard, int col, int size) {
		if( col >= size ){
			displayBoard(chessBoard, size);
			return true;
		}
		for( int row=0; row<size; row++ ) {
			if( isSafe(chessBoard, row, col, size) ) {
				chessBoard[row][col] = 1;
				if( nQProblem(chessBoard, col+1, size) )
					return true;
				chessBoard[row][col] = 0;
			}
		}
		return false;
	}


	/**
	 *
	 * @param chessBoard as a 2D Matrix of Chess Board
	 * @param row as a current row
	 * @param col as a current column
	 * @param size as a Length Of Board
	 * @return true if current location is safe
	 */
	public boolean isSafe(int[][] chessBoard, int row, int col, int size) {
		int i;
		for( i = 0; i < size; i++) {
			if( chessBoard[i][col] == 1 || chessBoard[row][i] == 1 ) {
				return false;
			}
		}

		for( i = 0; i < size; i++) {
			for( int j = 0; j < size; j++ ) {
				if( i - j == row - col || i + j == row + col ) {
					if( chessBoard[i][j] == 1 ) {
						return false;
					}
				}
			}
		}
		return true;
	}

}
