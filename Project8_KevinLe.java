import java.util.Scanner;
import java.util.Random;

public class Project8_KevinLe // With help from Katherine Yut
{
	public static void main(String[] args) // Main method
	{
		Scanner keyboard = new Scanner(System.in);
		int tokenCount = 20;  // Player starts off with 20 tokens
		int output1;  // outputs1 - output3 are what appears on the wheel
		int output2;
		int output3;
		int currentWinnings = 0;
		int lowestNum = 1;
		int highestNum = 10;
		
		
		System.out.println("You have " + tokenCount + " tokens");  // Player starts off with 20 tokens, prompting the user
		System.out.println("Would you like to play? Yes/No");		
		String wantToPlay = keyboard.nextLine();		// Starts the program
		while (wantToPlay.equalsIgnoreCase("Yes") && tokenCount !=0)  // if out of tokens, game ends
			{	
				System.out.println("Your spin was: ");
				output1 = playTheGame(keyboard); // Call method playTheGame()
				System.out.print(output1);
				output2 = playTheGame(keyboard);
				System.out.print(" " + output2);
				output3 = findRandom(lowestNum ,highestNum); // Call method findRandom
				System.out.println(" " + output3);
				int[] wheelArray = {output1,output2,output3};
				
				
				currentWinnings = calculateWin(wheelArray); // Call method calculateWin()
				System.out.println("You earned " + currentWinnings + " points"); // Show winnings for that match
				tokenCount = tokenCount+currentWinnings;
				System.out.println("You now have " + tokenCount + " tokens"); // Accumulates total tokens
				System.out.println("Would you like to play again? Yes/No"); // Start of gambling habit
				wantToPlay = keyboard.nextLine();
			}
		System.out.println("You either have no more tokens or you requested to quit. Goodbye."); // user has opted out of the game
		
	}
	
	public static int playTheGame(Scanner keyboard)  //Method 1, randomizes number for wheel
	{
		Random rand = new Random();
		int randomOutput = rand.nextInt(11);
		if (randomOutput == 0)  // Does not let 0 be an output
		{
			randomOutput = randomOutput + 1;
		}
		int output = (int) randomOutput;
		return output;			
	}
	public static int calculateWin(int[] scores) // Method 2, determines what the winnings are
	{
		int winnings=0;
		if ((scores[0] ==7 &&  scores[1] == 7 && scores[2] == 7)) // Display of logical operators
		{
			winnings = winnings + 750; // Winnings if all three outputs are 7
		}
		else if ((scores[0] == scores[1]) && (scores[0] == scores[2])) //Winnings if all three outputs are the same but not 7
		{
			winnings = winnings + 75;
		}
		else if ((scores[0]==7 && scores[1]==7) || (scores[1] == 7 && scores[2] == 7) || (scores[0] == 7 && scores[2] == 7))
		{
			winnings = winnings + 20; //Winnings if a pair of 7's are achieved
		}
		else if ((scores[0] == scores[1]) || (scores[0] == scores[2]) || (scores[1] == scores[2]))
		{
			winnings = winnings + 5; // Winnings if a simple pair is achieved
		}
		else // Overall, loses money for turn since no money is earned.
		{
			winnings = -1;
		}
		return winnings;	
	}
	public static int findRandom(int low, int high) // Method 3, a variation of method 1, 
	{
		int output;
		output =(int) Math.ceil(Math.random() * 10);
		return output;
	}
	
}
