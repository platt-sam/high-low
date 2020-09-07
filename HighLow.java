//	Sam Platt
//	CS 257 Lab 1A
// 	Written Jan 9, 2020

import java.util.Random;
import java.util.Scanner;

public class HighLow {
	
	public static void main(String[] args) {
		int num;
		int lowerBound;
		int upperBound;
		String s;
		
		// Get a lower bound from the user...
		Scanner scan = new Scanner(System.in);
		do {
			System.out.print("Enter a positive lower bound: ");
		
			s = scan.nextLine();
		
			num = Integer.parseInt(s);
		} while(num <= 0);
		lowerBound = num;
		
		// Get an upper bound from the user...
		do {
			System.out.print("Enter a positive upper bound: ");
		
			s = scan.nextLine();
			num = Integer.parseInt(s);
		
		} while(num <= lowerBound);
		upperBound = num;
		
		// Tell the user what the lower bound and upper bound is...
		System.out.println("Your lower bound is " + lowerBound + " and your upper bound is " + upperBound + ".");
		
		// Generate a random integer...
		Random randNum = new Random();
		
		int rnd = randNum.nextInt(upperBound - lowerBound) + lowerBound;
		
		// Have the user guess a number...
		int guesses = 0; // number of guesses begins at 0
		
		do {
			System.out.println("Guess a number between " + lowerBound + " and " + upperBound + " inclusive.");
			
			s = scan.nextLine();
			num = Integer.parseInt(s);
			
			guesses++; // guesses increases by 1
			
			// Tell the user their guess was incorrect...
			if(num != rnd)
			{
				System.out.print("Your guess of " + num + " was too ");
				if(num < rnd) {
					System.out.print("low");
					if(num < lowerBound) {
						System.out.print(" and was lower than the lower boundary of " + lowerBound);
					}
				}
				if(num > rnd) {
					System.out.print("high");
					if(num > upperBound) {
						System.out.print(" and was higher than the upper boundary of " + upperBound);
					}
				}
				System.out.println(".");
			}
		} while(num != rnd);
		
		// Tell the user that their guess was correct. Tell the user how many guesses it took them...
		System.out.print("Your guess of " + num + " was correct, the random number is " + rnd + ". It took you " + guesses);
		if(guesses == 1) {
			System.out.print(" guess");
		} else {
			System.out.print(" guesses");
		}
		System.out.print(" to guess the number correctly.");
	}
}
