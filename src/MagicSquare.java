import java.text.DecimalFormat;

public class MagicSquare {

	private int size;
	private int matrix[][];

	
	public MagicSquare(int size) {
		this.size = size;
		matrix = new int[size][size];
	}

	public void computeMagicSquare() {

		int row = 0;
		int col = size / 2;
		matrix[row][col] = 1;

		for (int k = 2; k < size * size + 1; k++) {
			if (matrix[(row + size - 1) % size][(col + 1) % size] == 0) {
				row = (row + size - 1) % size;
				col = (col + 1) % size;
			} else {
				row = (row + 1) % size;
			}
			matrix[row][col] = k;

		}

	}

	public void displayMagicSquare() {
		// Decimal Format
		DecimalFormat three = new DecimalFormat("000");

		// Outputs heading
		System.out.println(size + "x" + size + "Magic Square");
		System.out.println("=======================");

		// Goes through each index and outputs
		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix.length; col++) {
				System.out.print(three.format(matrix[row][col]) + " ");
			}
			System.out.println();
		}
	}

	public void checkRows() {
		System.out.println();
		System.out.println("Checking Rows");
		System.out.println("================");
		int sum = 0;


		for (int row = 0; row < matrix.length; row++) {
			for (int col = 0; col < matrix.length; col++) {
				sum += matrix[row][col];

			}
			System.out.print(sum + " ");
			sum = 0;
		}

	}

	public void checkColumns() {

		System.out.println();
		System.out.println();
		System.out.println("Checking Columns");
		System.out.println("===================");
		int sum = 0;


		for (int col = 0; col < matrix.length; col++) {
			for (int row = 0; row < matrix.length; row++) {
				sum += matrix[row][col];
			}

			System.out.print(sum + " ");
			sum = 0;
		}

	}

	public void checkDiagonals() {

		DecimalFormat input = new DecimalFormat("000");
		System.out.println();
		System.out.println();
		System.out.println("Checking Diagonals");
		System.out.println("===================");
		int sum = 0;

		for (int k = 0; k < matrix.length; k++) {
			sum += matrix[k][k];
		}

		System.out.print(sum + " ");
		sum = 0;

		for (int k = 0; k < matrix.length; k++) {
			sum += matrix[k][k];
		}
		System.out.print(sum);

	}

}
