import java.io.IOException;

public class Sheets {

	public static void main(String[] args) throws IOException {
		int[][] array = new int[4][4];
		boolean isAdding = true;
		printArray(array);
		while (isAdding) {
			int row = ConsoleUI.promptForInt("Enter row", 0, array.length - 1);
			int col = ConsoleUI.promptForInt("Enter Column", 0, array[row].length - 1);
			int value = ConsoleUI.promptForInt("Enter value", 0, 9);
			array[row][col] = value;
			isAdding = ConsoleUI.promptForBool("Keep Adding? (Y/N)?", "Y", "N");
			printArray(array);
		}
	}

	private static void printArray(int[][] array) {
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				System.out.print(array[i][j] + " ");
			}
			System.out.println();
		}
		for (int i = 0; i < array.length; i++) {
			System.out.print("--");
		}
		System.out.println();
		int sum = 0;
		for (int i = 0; i < array[0].length; i++) {
			for (int j = 0; j < array.length; j++) {
				sum += array[j][i];
			}
			System.out.print(sum + " ");
			sum = 0;
		}
		System.out.println();
		for (int i = 0; i < array.length; i++) {
			System.out.print("--");
		}
		System.out.println();
		int avg = 0;
		for (int i = 0; i < array[0].length; i++) {
			for (int j = 0; j < array.length; j++) {
				avg += array[j][i];
			}

			System.out.print(((double) (avg)) / array.length + " ");
			avg = 0;
		}
		System.out.println();
	}

}
