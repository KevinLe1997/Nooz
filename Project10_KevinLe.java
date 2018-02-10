import java.util.Scanner;
import java.util.Arrays;

public class Project10_KevinLe // Partners with Katherine Yut
{
	
	public static void main( String[] args)    // Start of the main method
	{
		int [] array = {(int) (Math.random()*100),(int) (Math.random()*100), (int) (Math.random()*100), (int) (Math.random()*100),
				(int) (Math.random()*100), (int) (Math.random()*100), (int) (Math.random()*100), (int) (Math.random()*100),
				(int) (Math.random()*100)};   // This is my array example, it is filled with random numbers every run
		System.out.println("Example Array:");
		System.out.println(Arrays.toString(array));
		System.out.println();					
		
		shuffle(array);									// the array is shuffled and printed out to read
		System.out.println("Shuffled Array:");
		System.out.println(Arrays.toString(array));
		System.out.println();
		
		System.out.println("Sorted Array:");
		sort(array);								//The sort method is then called
		System.out.println(Arrays.toString(array)); // The now sorted array is printed
	}
	
	// shuffle method
	public static void shuffle(int [] array ) // this method takes given array and shuffles it into a random number
	{
		int j = array.length;
		int i;
		
		for (i = array.length - 1; i >= 0; --i)
		{
			int rand = ((int) (Math.random()*(j)));
			if (i != rand && array[i] != array[rand])
				{
					int temp = array[i];
					array[i] = array[rand];
					array[rand] = temp;
				}
			j = j-1;
			
		}
	}
	
	public static int findMin(int [] array, int size) // this method finds the index of the smallest number in array
	{
		int smallestIndex = size;
		
		for (int i = size + 1; i < array.length; ++i)
		{
		    if (array[i] < array[smallestIndex])
		    {
		        smallestIndex = i;
		        
		    }
		}
		return smallestIndex;
	}
	
	public static void sort(int [] array)	// this method sorts the array into ascending order, it is void since it just changes the array
	{
		
		for (int i= 0; i < array.length; ++i)
        {
			int smallestIndex = findMin(array,i);	// this method is special since it also calls on another method as well
			int variable = array[i];
			array[i] = array[smallestIndex];
			array[smallestIndex]= variable;
			
        }
	}
	
}
