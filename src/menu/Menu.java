package menu;

import module1_trip_planner.TripPlanner;
import module2_odds_and_evens.OddsAndEvens;
import module3_crypto.Crypto;
import module4_maze_runner.MazeRunner;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Menu {

	public static void main (String[] args) throws InterruptedException {
		Scanner inputMenu = new Scanner(System.in);
		int option = 0;
		
		do {
			System.out.println("Microsoft's DEV276: Learn to Program in Java");
			System.out.println();
			System.out.println("Choose a project:");
			System.out.println();
			System.out.println("1.- Trip planner.");
			System.out.println("2.- Odds and evens.");
			System.out.println("3.- Crypto.");
			System.out.println("4.- Maze Runner.");
			System.out.println("5.- Exit.");
			option = inputMenu.nextInt();
			System.out.println("\n");
			
			switch (option) {
				case 1:
					TripPlanner.main(args);
					break;
				case 2:
					OddsAndEvens.main(args);
					break;
				case 3:
					Crypto.main(args);
					break;
				case 4:
					MazeRunner.main(args);
					break;
				case 5:
					System.out.println("Bye!");
					TimeUnit.SECONDS.sleep(2);
					break;
				default:
					System.out.println("Invalid option.");
					break;
			}
			System.out.println("\n\n");
		} while (option != 5);
		
		inputMenu.close();
	}
	
}
