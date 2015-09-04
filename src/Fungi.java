
/**
 * De schimmel F. ellipsoidea wordt erg groot. 
 * De fibonacci reeks bepaald het aantal centimeters dat de schimmel dagelijks in diameter toeneemt.
 * Bereken de omtrek van de schimmel na 1000 dagen groeien.
 * 
 * @author ZL
 *
 */

public class Fungi {
	public static void main(String[] args){
		
		long beginTime = System.currentTimeMillis();
		
		int totalDays = 1000;
		
		double[] fibonacci = new double[totalDays];
		fibonacci[0] = 0;
		fibonacci[1] = 1;
		
		for (int i = 2 ; i < totalDays ; ++i){
			fibonacci[i] = fibonacci[i-2] + fibonacci[i-1];
		}
		
		double summation = 0;
		
		for(double fib:fibonacci){
			summation += fib;
		}
		
		System.out.println("Total growth in diameter (cm) : "+ summation);
		
		// circumference = 2*pi*r or pi*d
		
		System.out.println(Math.PI*summation);
		
		System.out.println("Total duration in milleseconds: "+(System.currentTimeMillis()-beginTime));
		
	}
}
