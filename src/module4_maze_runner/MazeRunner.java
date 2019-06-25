package module4_maze_runner;
import java.util.Scanner;

public class MazeRunner {

public static Scanner input = new Scanner(System.in);
public static Maze myMap = new Maze();
public static String controls = "";
public static String move = "";
public static String up = "";
public static String down = "";
public static String left = "";
public static String right = "";
public static String direction = "";
public static boolean wall = false;


	public static void main (String[] args) {
		int moves = 0;
		boolean gameOver = false;
		
		intro();
				
		do {
			userMove();
			System.out.println("----------------------------------------");
								
			if (!gameOver) {
				++moves;
				System.out.println(movesMessage(moves));
			}
			
			gameOver = ( direction.equals("X") || (myMap.didIWin()) || (moves == 100) );
			
		} while ( !gameOver );

		if (direction.equals("X")) {
			System.out.println();
			System.out.println("You have cancelled the game.");
			System.out.println("Bye.");
			System.out.println();
		}
		
		if (myMap.didIWin()) {
			System.out.println();
			System.out.println("*******************************************");
			System.out.println("  Congratulations, you made it out alive! ");
			System.out.println("       And you did it in " + moves + " moves.");
			System.out.println("*******************************************");
			System.out.println();
		}
		
		if (moves == 100) {
			System.out.println();
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Sorry, but you didn't escape in time- you lose!");
			System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println();
			System.out.println(" GAME OVER");
			System.out.println();
		}
			
		

	}
	
	
	public static void intro() {
		int keyboardLayout = 0;
		
		System.out.println("Welcome to Maze Runner!");
		System.out.println();
		System.out.println("You have 100 moves to escape the maze.");
		System.out.println();
		System.out.println("You can move up, down, left or right.");
		System.out.println("Choose a set of keys to control the game:");
		System.out.println("1.- U (up), D (down), L (left), R (right)");
		System.out.println("2.- W (up), S (down), A (left), D (right)");
		System.out.println();
		
		do {
			System.out.print("Enter your choice (1/2): ");
			keyboardLayout = input.nextInt();
		} while ( keyboardLayout != 1 && keyboardLayout != 2);
		
		if (keyboardLayout == 1) {
			controls = "UDLRX";
			up = "U";
			down = "D";
			left = "L";
			right = "R";
		} else {
			controls = "WSADX";
			up = "W";
			down = "S";
			left = "A";
			right = "D";
		}
		
		System.out.println("Here is your current position:");
		System.out.println();
		myMap.printMap();
	}
	
	
	public static String userMove() {
		
		
		do {
			System.out.print("Where would you like to move? (" + controls + ")? ");
			direction = input.next().toUpperCase();
		} while (!controls.contains(direction) );
		
		if ( direction.equals(up) ) {
			if (myMap.canIMoveUp()) {
				myMap.moveUp();
			} else {
				if (myMap.isThereAPit("U")) {
					navigatePit("U");
				} else {
					wall = true;
				}
			}
		} else if (direction.equals(down) ) {
			if (myMap.canIMoveDown()) {
				myMap.moveDown();
			} else {
				if (myMap.isThereAPit("D")) {
					navigatePit("D");
				} else {
					wall = true;
				}
			}
		} else if (direction.equals(left) ) {
			if (myMap.canIMoveLeft()) {
				myMap.moveLeft();
			} else {
				if (myMap.isThereAPit("L")) {
					navigatePit("L");
				} else {
					wall = true;
				}
			}
		} else if (direction.equals(right) ) {
			if (myMap.canIMoveRight()) {
				myMap.moveRight();
			} else {
				if (myMap.isThereAPit("R")) {
					navigatePit("R");
				} else {
					wall = true;
				}
			}
		} 
		
		System.out.println();
		
		if (wall) {
			System.out.println("Sorry, you've hit a wall.");
		}
		
		myMap.printMap();
		wall = false;
		return direction;
	}

	public static void navigatePit(String dir) {
		String jump = "";
		
		System.out.print("Watch out! There's a pit ahead. Jump it?: ");
		jump = input.next().toUpperCase();
		
		if (jump.startsWith("Y")) {
			if (direction.equals(up)) {
				myMap.jumpOverPit("U");
			} else if (direction.equals(down)) {
				myMap.jumpOverPit("D");
			} else if (direction.equals(left)) {
				myMap.jumpOverPit("L");
			} else if (direction.equals(right)) {
				myMap.jumpOverPit("R");
			}
		}
	}
	
	
	public static String movesMessage(int moves) {
		String message = "";
		
		switch (moves) {
			case 50:
				message = "\nWarning: You have made 50 moves, you have 50 remaining before the maze exit closes.\n";
				break;
			case 75:
				message = "\nAlert! You have made 75 moves, you only have 25 moves left to escape.\n";
				break;				
			case 90:
				message = "\nDANGER! You have made 90 moves, you only have 10 moves left to escape!!\n";
				break;				
			case 100:
				message = "\nOh no! You took too long to escape, and now the maze exit is closed FOREVER >:[\n";
				break;				
			default:
				message = "";
				break;				
		}
		
		return message;
	}
	
}
