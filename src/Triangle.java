import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class Triangle {
	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner input = new Scanner(new File("resources/"+"vraag_10_triangle.txt"));
		ArrayList<Integer> lijstMetNummers = new ArrayList<>();
		
		int[][] triangle;
		int amountOfLines = 0;
		int temp = 0;
		int counter = 0;
		
		// Read file
		while(input.hasNextLine() && input.hasNextInt()){
			amountOfLines++;
			
			for(int i = 0 ; i < amountOfLines; ++i){
					temp = input.nextInt();
					lijstMetNummers.add(temp);
			}			
		}		
		input.close();
		
		// Build triangle matrix
		triangle = new int[amountOfLines][amountOfLines];		
		
		for (int i = 0 ; i < amountOfLines ; ++i){
			for (int j = 0 ; j <= i ; ++j){				
				triangle[i][j] = lijstMetNummers.get(counter);
				counter++;
			}
		}
		
		// Vector to store all sums
		int[] pathSums = new int[amountOfLines];
		int currentX;
		int goToX;
		
		//For each bottom number
		for (int i = 0 ; i < amountOfLines ; ++i){
			currentX = i;
			// Go from bottom to top
			for(int j = amountOfLines ; j >0 ; --j){
				// Case for most left
				if(currentX == 0){
					goToX = argMax(triangle[j-1][currentX], triangle[j-1][currentX+1]);
				}
				// Case for most right
				else if(currentX == amountOfLines-1){
					goToX = argMax(triangle[j-1][currentX-1], triangle[j-1][currentX])-1;
				}
				// Normal case
				else{
					goToX = argMax(triangle[j-1][currentX-1], triangle[j-1][currentX], triangle[j-1][currentX+1]);
				}
				
				if (j==amountOfLines){
					goToX = 0;
				}
				currentX += goToX;
				pathSums[i] += triangle[j-1][currentX];					
			}
		}
		
		
		int maximum = 0;
		for(int integer:pathSums){
			System.out.println(integer);
			maximum = (integer>maximum)?integer:maximum;
		}
		
		System.out.println("");
		System.out.println("Maximum sum: "+maximum);
	}
	
	public static int argMax(int nr1, int nr2){
		if(nr1>nr2){
			return 0;
		}		
		return 1;
	}
	
	public static int argMax(int nr1, int nr2, int nr3){
		if(nr1>nr2){
			if(nr1>nr3){
				return -1;
			}
			return 1;
		}
		
		if(nr2>nr3){
			return 0;
		}
		
		return 1;
	}
}
