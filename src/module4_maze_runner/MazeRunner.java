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
		
		intro();
				
		do {
			userMove();
		} while ( ( !direction.equals("X") ) || ( myMap.didIWin() ) );

		System.out.println("Bye!");

	}
	
	
	public static void intro() {
		int keyboardLayout = 0;
		
		System.out.println("Welcome to Maze Runner!");
		System.out.println();
		System.out.println("You can move up, down, left or right.");
		System.out.println("Choose a set of keys to control the game:");
		System.out.println("1.- U (up), D (down), L (left), R (right)");
		System.out.println("2.- W (up), S (down), A (left), D (right)");
		
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
		
		System.out.println("Direction: " + direction + " Up: " + up + " Down: " + down + " Left: " + left + " Right: " + right);
		
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
	
	
}
