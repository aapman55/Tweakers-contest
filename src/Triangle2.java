import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Triangle2 {
	public static void main(String[] args) throws FileNotFoundException{
		// Scanner to scan over each line of the triangle file
		Scanner input = new Scanner(new File("resources/"+"vraag_10_triangle.txt"));
		// ArrayList to put all integers
		ArrayList<Integer> lijstMetNummers = new ArrayList<>();
		
		// 2D integer matrix to store the triangle in its real shape
		int[][] triangle;
		// Counter to keep the count of the total amount of lines
		int amountOfLines = 0;	
		// Counter used to keep track of the line number while building the triangle in matrix form
		int counter = 0;
		
		// Read file
		// Check if it is not EOF and there are still integers
		while(input.hasNextLine() && input.hasNextInt()){
			amountOfLines++;
			
			for(int i = 0 ; i < amountOfLines; ++i){
					int temp = input.nextInt();
					lijstMetNummers.add(temp);
			}			
		}		
		// close the input stream
		input.close();
		
		// Build triangle matrix
		triangle = new int[amountOfLines][amountOfLines];		
		
		// Make the triangle in 2D
		for (int i = 0 ; i < amountOfLines ; ++i){
			for (int j = 0 ; j <= i ; ++j){				
				triangle[i][j] = lijstMetNummers.get(counter);
				counter++;
			}
		}	
		
		/*
		 * Going from bottom to top
		 * For each row, make pairs of 2 numbers.
		 * Then for each pair get the maximum
		 * Add the maximum to the row above
		 */
		for (int i = amountOfLines-1 ; i > 0; --i){
			for(int j = 0 ; j < amountOfLines-1; j++){
				triangle[i-1][j] += Math.max(triangle[i][j], triangle[i][j+1]);
			}
		}
		
		// The maximum sum is in the top left corner
		System.out.println(triangle[0][0]);

	}
}
