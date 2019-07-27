package module2_odds_and_evens;
import java.util.Scanner;
import java.util.Random;

public class OddsAndEvens {
	private static Scanner input = new Scanner(System.in);
	private static Scanner inputLine = new Scanner(System.in);
	
	public static void main (String[] args) {
		String player;
		String option;
		int fingersPlayer;
		int fingersComputer;
		int fingersTotal;
		boolean totalIsOdds;
		String winner;
		
		System.out.println("Let's play a game called 'Odds and Evens'.");
		System.out.print("What is your name? ");
		player = inputLine.nextLine();
		System.out.print("Hi, " + player + ". ");
		do {
			System.out.print("Which do you choose? (O)dds or (E)vens? ");
			option = input.next();
		} while ( !option.equalsIgnoreCase("O") && !option.equalsIgnoreCase("E") );
			
		if (option.equalsIgnoreCase("O")) {
			System.out.println(player + " has picked odds! The computer will be evens.");
		} else if (option.equalsIgnoreCase("E")) {
			System.out.println(player + " has picked evens! The computer will be odds.");
		}
		
		System.out.println("--------------------------------------------------");
		
		do {
			System.out.print("How many \"fingers\" do you put out? " );
			fingersPlayer = input.nextInt();
			if (fingersPlayer > 5) {
				System.out.println("Hey!");
				System.out.println("How many hands are you using?");
				System.out.println("You can only put out 0 to 5 fingers.");
			}
		} while (fingersPlayer > 5);
		
		
		Random rand = new Random();
		fingersComputer = rand.nextInt(6);
		System.out.println("The computer plays " + fingersComputer + " \"fingers\".");
		System.out.println("--------------------------------------------------");
		
		fingersTotal = fingersPlayer + fingersComputer;
		System.out.println(fingersPlayer + " + " + fingersComputer + " = " + fingersTotal);
		
		totalIsOdds = fingersTotal % 2 == 1;
		
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

