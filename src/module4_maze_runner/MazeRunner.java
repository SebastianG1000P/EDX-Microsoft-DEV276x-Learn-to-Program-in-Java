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
		myMap.printMap();
		
		do {
			userMove();
		} while ( direction != "X");
		System.out.println("Bye!");

/*
		System.out.println("TEST");
		myMap.printMap();
		myMap.moveRight();
		myMap.printMap();
//		myMap.moveRight();
//		myMap.moveDown();
//		myMap.moveUp();
		myMap.moveLeft();
		myMap.printMap();
		//myMap.moveDown();
		myMap.moveUp();
		myMap.printMap();
*/		
	}
	
	
	public static void intro() {
		int choice = 0;
		
		System.out.println("Welcome to Maze Runner!");
		System.out.println();
		System.out.println("You can move up, down, left or right.");
		System.out.println("Choose a set of keys to control the game:");
		System.out.println("1.- U (up), D (down), L (left), R (right)");
		System.out.println("2.- W (up), S (down), A (left), D (right)");
		do {
			System.out.print("Enter your choice (1/2): ");
			choice = input.nextInt();
		} while ( choice != 1 && choice != 2);
		
		if (choice == 1) {
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
	}
	
	
	public static String userMove() {
		
		
		do {
			System.out.print("Where would you like to move? (" + controls + ")? ");
			direction = input.next().toUpperCase();
		} while (!controls.contains(direction) );
		
		System.out.println("Direction: " + direction + " Up: " + up + " Down: " + down + " Left: " + left + " Right: " + right);
		

		if ( direction.equals(up) ) {
			if (myMap.canIMoveUp()) {
				myMap.moveUp();
			} else {
				wall = true;
			}
		} else if (direction.equals(down) ) {
			if (myMap.canIMoveDown()) {
				myMap.moveDown();
			} else {
				wall = true;
			}
		} else if (direction.equals(left) ) {
			if (myMap.canIMoveLeft()) {
				myMap.moveLeft();
			} else {
				wall = true;
			}
		} else if (direction.equals(right) ) {
			if (myMap.canIMoveRight()) {
				myMap.moveRight();
				myMap.jumpOverPit("R");
			} else {
				wall = true;
			}
		} 
		
		if (wall) {
			System.out.println("Sorry, you've hit a wall.");
			wall = false;
		}
		
		myMap.printMap();
		
		return direction;
	}
	
}
