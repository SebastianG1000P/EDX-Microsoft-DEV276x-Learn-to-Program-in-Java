package module2_odds_and_evens;
import java.util.Scanner;
import java.util.Random;

public class OddsAndEvens {
	public static Scanner input = new Scanner(System.in);
	
	public static void main (String[] args) {
		String player;
		String option;
		int fingersPlayer;
		int fingersComputer;
		int fingersTotal;
		boolean totalIsOdds;
		String winner;
		
		
		// Greet the user and asks them to pick odds or evens.
		
		System.out.println("Let’s play a game called “Odds and Evens”.");
		System.out.print("What is your name? ");
		player = input.nextLine();
		System.out.print("Hi " + player + ", which do you choose? (O)dds or (E)vens? ");
		option = input.next();
		if (option.equalsIgnoreCase("O")) {
			System.out.println(player + " has picked odds! The computer will be evens.");
		} else if (option.equalsIgnoreCase("E")) {
			System.out.println(player + " has picked evens! The computer will be odds.");
		}
		System.out.println("--------------------------------------------------");
		
		
		// Asks the user how many fingers they'll play, and picks a random number of fingers for the computer to play.
		
		System.out.print("How many “fingers” do you put out? " );
		fingersPlayer = input.nextInt();
		Random rand = new Random();		//		Creates object to obtain random numbers.
		fingersComputer = rand.nextInt(6);
		System.out.println("The computer plays " + fingersComputer + " \"fingers\".");
		System.out.println("--------------------------------------------------");
		
		// Determine and report the winner.
		
		fingersTotal = fingersPlayer + fingersComputer;
		System.out.println(fingersPlayer + " + " + fingersComputer + " = " + fingersTotal);
		
		// Determines the winner.
		// totalIsOdds = fingersTotal % 2 = 1? true: false;  // Using ternary operator, not taught yet by the Edx course. Somewhat verbose?.
		
		totalIsOdds = fingersTotal % 2 == 1;		// Method taught at Edx course.
		
		if (totalIsOdds) {
			System.out.println(fingersTotal + " is odds!");
			if (option.equalsIgnoreCase("o")) {
				winner = player;
			} else {
				winner = "Computer";
			}
		} else {
			System.out.println(fingersTotal + " is even!");
			if (option.equalsIgnoreCase("o")) {
				winner = "Computer";
			} else {
				winner = player;
			}
		}
		
		System.out.println("That means " + winner + " wins!");
		
		System.out.println("--------------------------------------------------");
		
	
		
	}
		
		
}

