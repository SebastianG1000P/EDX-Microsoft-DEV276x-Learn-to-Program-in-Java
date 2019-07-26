package module1_trip_planner;
import java.util.Scanner;

public class TripPlanner {
	public static Scanner input = new Scanner(System.in);
	
	public static void main (String[] args) {
		greeting();
		timeAndBudget();
		timeDifference();
		countryArea();
		System.out.println();
		System.out.println("Have a nice trip!");
	}

	public static void greeting() {
		String name;
		String destination;
		
		System.out.println("Welcome to Vacation Planner!");
		System.out.println();
		System.out.print("What is your name? ");
		name = input.nextLine();
		System.out.print("Nice to meet you, " + name + ". Where are you travelling to? ");
		destination = input.nextLine();
		System.out.println("Great! " + destination + " sounds like a great trip!");
	}
	
	
	public static void timeAndBudget() {
		int days;
		Double money;
		String currency;
		Double convertionRate;
		Double dailyBudgetUSD;
		Double totalBudgetCurrency;
		Double dailyBudgetCurrency;
		
		System.out.print("How many days are you going to spend traveling? ");
		days = input.nextInt();
		System.out.print("How much money, in USD, are you planning to spend on your trip? ");
		money = input.nextDouble();
		System.out.print("What is the three letter currency symbol for your travel destination? ");
		currency = input.next().toUpperCase();
		System.out.print("How many " + currency + " are there in 1 USD? ");
		convertionRate = input.nextDouble();
		System.out.print("");
		
		// Truncate values to 2 decimals.
		totalBudgetCurrency = (double)((int)((money * convertionRate)*100))/100;
		dailyBudgetCurrency = (double)((int)((money * convertionRate / days)*100))/100;
		dailyBudgetUSD = (double)((int)((money / days)*100))/100;
		
		System.out.println("If you are travelling for " + days + " days that is the same as " 
							+ days * 24 + " hours or " + days * 24 * 60 + " minutes.");
		System.out.println("If you are going to spend $" + money + " USD, that means per day " 
							+ "you can spend up to $" + dailyBudgetUSD + " USD.");
		System.out.println("Your total budget in " + currency + " is " 
							+ totalBudgetCurrency + " " + currency 
							+ ", which per day is " + dailyBudgetCurrency + " " + currency);
		System.out.println();
		System.out.println("***********");
	}
	
	
	public static void timeDifference() {
		int difference;
		int localTimeAtMidnight;
		int localTimeAtNoon;
		
		System.out.println("");
		System.out.print("What is the time difference, in hours, between your home and your destination? ");
		difference = input.nextInt();
		
		localTimeAtMidnight = (0 + difference) % 24;
		localTimeAtNoon = (12 + difference) % 24;
		System.out.println("That means that when it is midnight at home, it will be "
						+ localTimeAtMidnight + ":00 in your travel destination, "
						+ "and when it is noon at home it will be " + localTimeAtNoon + ":00.");
		System.out.println();
		System.out.println("***********");
	}
		
	
	public static void countryArea() {
		double area;
		double areaMiles;
		
		System.out.println("");
		System.out.print("What is the square area of your destination country in km2? ");
		area = input.nextDouble();
		
		areaMiles = (double)((int)(area * 0.386102159 * 100))/100;  // Round value to 2 decimals.
		System.out.println("In miles2 that is " + areaMiles + ".");
	}

}
