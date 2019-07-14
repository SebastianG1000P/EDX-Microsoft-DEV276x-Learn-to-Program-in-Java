package module1_trip_planner;
import java.util.Scanner;

public class TripPlanner {

/*	
 	Edx - Learn to Program in Java
 	https://courses.edx.org/courses/course-v1:Microsoft+DEV276x+3T2018/courseware/af5e9113c16c49d698dd0f95924f663a/f74ffdf01641458a8393aaf2ae585a77/?child=first
 	
 	Module 1: Project - Trip Planner.
 	
 	==========
 	
 	Welcome to Vacation Planner!
	What is your name? Kasey Champion
	Nice to meet you, Kasey Champion. Where are you travelling to? Mexico City
	Great! Mexico City sounds like a great trip!

	----------

	How many days are you going to spend travelling? 14
	How much money, in USD, are you planning to spend on your trip? 2300
	What is the three letter currency symbol for your travel destination? MXC
	How many MXC are there in 1 USD? 19.8

	If you are travelling for 14 days that is the same as 336 hours or 20160 minutes.
	If you are going to spend $2300 USD, that means per day you can spend up to $164.28 USD.
	Your total budget in MXC is 45540.0 MXC, which per day is 3252.85 MXC.

	----------

	What is the time difference, in hours, between your home and your destination? 2
	That means that when it is midnight at home, it will be 2:00 in your travel destination, and when it is noon at home it will be 14:00.

	----------

	What is the square area of your destination country in km2? 1973000
	In miles2 that is 761775.3

	----------*/
	
	
/*	PENDING
 * 
	Part 6 - Hacker Problem - How Far?
			For extra fun, calculate the distance between the user's home and their travel destination using the Haversine formula. https://en.wikipedia.org/wiki/Haversine_formula To do this you'll need to ask the user to enter the longitude and latitude for their home and their travel destination. You'll also need to do some pretty fancy math.

			To do fancy math in Java (cos, sin, squared etc...) you can use the Math Class. Here is the documentation for that: https://docs.oracle.com/javase/7/docs/api/java/lang/Math.html All the code to accomplish the hacker problem should be in its own method.
*/	
	

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
		
		
		
/*		How many days are you going to spend travelling? 14
		How much money, in USD, are you planning to spend on your trip? 2300
		What is the three letter currency symbol for your travel destination? MXC
		How many MXC are there in 1 USD? 19.8

		If you are travelling for 14 days that is the same as 336 hours or 20160 minutes.
		If you are going to spend $2300 USD, that means per day you can spend up to $164.28 USD.
		Your total budget in MXC is 45540.0 MXC, which per day is 3252.85 MXC.*/
		
		System.out.print("How many days are you going to spend travelling? ");
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
		
		System.out.println("If you are travelling for " + days + " days that is the same as " + days * 24 + " hours or " + days * 24 * 60 + " minutes.");
		System.out.println("If you are going to spend $" + money + " USD, that means per day you can spend up to $" + dailyBudgetUSD + " USD.");
		System.out.println("Your total budget in " + currency + " is " + totalBudgetCurrency + " " + currency + ", which per day is " + dailyBudgetCurrency + " " + currency);
		System.out.println();
		System.out.println("***********");
		
		
	}
	
	public static void timeDifference() {

		int difference;
		int localTimeAtMidnight;
		int localTimeAtNoon;
		
		/*What is the time difference, in hours, between your home and your destination? 2
		That means that when it is midnight at home, it will be 2:00 in your travel destination, and when it is noon at home it will be 14:00.*/
		
		System.out.println("");
		System.out.print("What is the time difference, in hours, between your home and your destination? ");
		difference = input.nextInt();
		
		localTimeAtMidnight = (0 + difference) % 24;
		localTimeAtNoon = (12 + difference) % 24;
		System.out.println("That means that when it is midnight at home, it will be " + localTimeAtMidnight + ":00 in your travel destination, and when it is noon at home it will be " + localTimeAtNoon + ":00.");
		System.out.println();
		System.out.println("***********");
	}
		
	public static void countryArea() {
		/*What is the square area of your destination country in km2? 1973000
		In miles2 that is 761775.3*/
		
		double area;
		double areaMiles;
		
		System.out.println("");
		System.out.print("What is the square area of your destination country in km2? ");
		area = input.nextDouble();
		
		areaMiles = (double)((int)(area * 0.386102159 * 100))/100;  // Round value to 2 decimals.
		System.out.println("In miles2 that is " + areaMiles + ".");
		
	}

	public static void PENDING_hackerProblem() {

	/*	PENDING
	 * 
		Part 6 - Hacker Problem - How Far?
				For extra fun, calculate the distance between the user's home and their travel destination using the Haversine formula. https://en.wikipedia.org/wiki/Haversine_formula To do this you'll need to ask the user to enter the longitude and latitude for their home and their travel destination. You'll also need to do some pretty fancy math.

				To do fancy math in Java (cos, sin, squared etc...) you can use the Math Class. Here is the documentation for that: https://docs.oracle.com/javase/7/docs/api/java/lang/Math.html All the code to accomplish the hacker problem should be in its own method.
	*/	
		
	}
}
