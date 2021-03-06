import java.io.IOException;
import java.util.ArrayList;

public class Game {

	private static ArrayList<String> code = new ArrayList<>();
	private static ArrayList<String> decoded = new ArrayList<>();
	private static int amountCorrect = 0;
	private static int guesses = 0;
	private static boolean redMarkerOne = false;
	private static boolean whiteMarkerOne = false;
	private static boolean redMarkerTwo = false;
	private static boolean whiteMarkerTwo = false;
	private static boolean redMarkerThree = false;
	private static boolean whiteMarkerThree = false;
	private static boolean redMarkerFour = false;
	private static boolean whiteMarkerFour = false;

	public static void main(String[] args) throws IOException {
		System.out.println("Enter your code");
		String[] options = new String[] { "Pink", "Yellow", "Green", "Purple", "Orange", "White" };
		do {
			int colorSelect = ConsoleUI.promptForMenuSelection(options, false);
			if (colorSelect == 1) {
				code.add(options[0]);
			} else if (colorSelect == 2) {
				code.add(options[1]);
			} else if (colorSelect == 3) {
				code.add(options[2]);
			} else if (colorSelect == 4) {
				code.add(options[3]);
			} else if (colorSelect == 5) {
				code.add(options[4]);
			} else if (colorSelect == 6) {
				code.add(options[5]);
			}
		} while (code.size() < 4);
		do {
			decoded.clear();
			redMarkerOne = false;
			whiteMarkerOne = false;
			redMarkerTwo = false;
			whiteMarkerTwo = false;
			redMarkerThree = false;
			whiteMarkerThree = false;
			redMarkerFour = false;
			whiteMarkerFour = false;
			do {
				System.out.println("Enter your guess");
				int guesserColorSelect = ConsoleUI.promptForMenuSelection(options, false);
				if (guesserColorSelect == 1) {
					decoded.add(options[0]);
					checkingForCorrectSpot(options[0]);
				} else if (guesserColorSelect == 2) {
					decoded.add(options[1]);
					checkingForCorrectSpot(options[1]);
				} else if (guesserColorSelect == 3) {
					decoded.add(options[2]);
					checkingForCorrectSpot(options[2]);
				} else if (guesserColorSelect == 4) {
					decoded.add(options[3]);
					checkingForCorrectSpot(options[3]);
				} else if (guesserColorSelect == 5) {
					decoded.add(options[4]);
					checkingForCorrectSpot(options[4]);
				} else if (guesserColorSelect == 6) {
					decoded.add(options[5]);
					checkingForCorrectSpot(options[5]);
				}
			} while (decoded.size() < 4);
			checkingForRightColorWrongSpot(decoded.get(0));
			checkingForRightColorWrongSpot(decoded.get(1));
			checkingForRightColorWrongSpot(decoded.get(2));
			checkingForRightColorWrongSpot(decoded.get(3));
			guesses++;
			if (amountCorrect == 4) {
				System.out.println("You won!! The code was: " + code.toString());
				return;
			} else {
				if (redMarkerOne) {
					System.out
							.println("The code does contain " + decoded.get(0) + ", and you have it in the right spot");
				} else if (whiteMarkerOne) {
					System.out
							.println("The code does contain " + decoded.get(0) + ", but you have it in the wrong spot");
				}
				if (redMarkerTwo) {
					System.out
							.println("The code does contain " + decoded.get(1) + ", and you have it in the right spot");
				} else if (whiteMarkerTwo) {
					System.out
							.println("The code does contain " + decoded.get(1) + ", but you have it in the wrong spot");
				}
				if (redMarkerThree) {
					System.out
							.println("The code does contain " + decoded.get(2) + ", and you have it in the right spot");
				} else if (whiteMarkerThree) {
					System.out
							.println("The code does contain " + decoded.get(2) + ", but you have it in the wrong spot");
				}
				if (redMarkerFour) {
					System.out
							.println("The code does contain " + decoded.get(3) + ", and you have it in the right spot");
				} else if (whiteMarkerFour) {
					System.out
							.println("The code does contain " + decoded.get(3) + ", but you have it in the wrong spot");
				}
				System.out.println("Your guess is wrong. You have " + (10 - guesses) + " left.");
				System.out.println("Your guess was: " + decoded.toString());
			}
			amountCorrect = 0;
		} while (guesses < 10);
		System.out.println("You lost. Hopefully you were close!");
	}

	public static void checkingForCorrectSpot(String color) {
		if (code.get(decoded.size() - 1).equals(color)) {
			if (decoded.size() == 1) {
				redMarkerOne = true;
			} else if (decoded.size() == 2) {
				redMarkerTwo = true;
			} else if (decoded.size() == 3) {
				redMarkerThree = true;
			} else if (decoded.size() == 4) {
				redMarkerFour = true;
			}
			amountCorrect++;
		}
	}

	public static void checkingForRightColorWrongSpot(String color) {
		if (code.contains(color)) {
			if (decoded.get(0) == color) {
				if (!redMarkerOne)
					whiteMarkerOne = true;
			} else if (decoded.get(1) == color) {
				if (!redMarkerTwo)
					whiteMarkerTwo = true;
			} else if (decoded.get(2) == color) {
				if (!redMarkerThree)
					whiteMarkerThree = true;
			} else if (decoded.get(3) == color) {
				if (!redMarkerFour)
					whiteMarkerFour = true;
			}
		}
	}
}