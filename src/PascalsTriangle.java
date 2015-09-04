/**
 * Pascals driehoek is een bekende piramide waarbij het bovenste getal 1 is en de opvolgende rijen de som zijn van de 
 * 2 bovenliggende aangrenzende getallen. Zie hieronder een voorbeeld :
 *       1
 *      1 1
 *     1 2 1
 *    1 3 3 1
 *   1 4 6 4 1
 * 1 5 10 10 5 1
 * 
 * 
 * Bereken de som van de onderste rij van een Pascal-driehoek met duizend rijen. De top van de driehoek telt niet mee als rij.
 * 
 * 
 * @author ZL
 *
 */
public class PascalsTriangle {
	public static void main(String[] args){
		// Initial time stamp
		long beginTime = System.currentTimeMillis();
		// Amount of rows (the peak row with only 1 does not count as a row)
		int amountOfRows = 1000;
		// Create matrix
		double[][] pascal = new double[amountOfRows+1][amountOfRows+1];
		// Initialise summation variable
		double TotalSum = 0;
		
		// Loop over all rows
		for(int i = 1; i < amountOfRows+1; ++i){
			// Loop over columns
			for(int j = 0; j<i+1; ++j){
				if (j==0){
					// Most left one is always 1
					pascal[i][j]=1;					
				}else if (j==i){
					// Most right one is always 1
					pascal[i][j] = 1;					
				}else{
					// Sum of the above 2. Since the first one was filled, you take the number from the previous column and the current column.
					pascal[i][j] = pascal[i-1][j-1] + pascal[i-1][j];					
				}				
			}
		}
		
		// Sum the last row
		for(int i = 0 ; i < amountOfRows+1 ; ++i){
			TotalSum += pascal[amountOfRows][i];
		}
		// Show the total Sum
		System.out.println(TotalSum);
		// Log the total duration
		System.out.println("Total duration in ms: "+(System.currentTimeMillis()-beginTime));
	}
}
