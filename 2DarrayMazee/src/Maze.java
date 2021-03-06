
public class Maze {
	public static void main(String[] args) {
		char[][] array = new char[21][21];
		// for horizontal hall [][i];
		// for vertical hall [i][];
		for (int i = 0; i < 8; i++) {
			array[1][i] = ' ';
		}
		for (int i = 2; i < 12; i++) {
			array[i][3] = ' ';
		}
		for (int i = 4; i < 7; i++) {
			array[5][i] = ' ';
		}
		for (int i = 3; i < 10; i++) {
			array[i][6] = ' ';
		}
		for (int i = 4; i < 17; i++) {
			array[6][i] = ' ';
		}
		for (int i = 7; i < 11; i++) {
			array[i][13] = ' ';
		}
		for (int i = 4; i < 18; i++) {
			array[15][i] = ' ';
		}
		for (int i = 2; i < 21; i++) {
			array[i][13] = ' ';
		}

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (array[i][j] != ' ') {
					array[i][j] = '*';
				}
			}
		}

		printArray(array);
	}
	private static void printArray(char[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
	}
}