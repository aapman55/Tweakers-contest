import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 
 * Neem het getal 5^128
 * Hoeveel enen komen er voor in de binaire representatie van dit getal?
 * 
 * @author ZL
 *
 */

public class Binary {
	public static void main(String[] args){
		BigInteger getal = new BigInteger("1");
		int power = 128;
		BigInteger base = new BigInteger("5");
		
		
		for(int i = 0 ; i < power; ++i){
			getal = getal.multiply(base);
		}
		
		System.out.println(sumAllDigits(getal.toString(2)));
		
	}
	
	public static int sumAllDigits(String input){
		String[] addMe = input.split("");
		int summation = 0;
		
		for (String str:addMe){
			summation += Integer.parseInt(str);
		}
		
		return summation;
	}
}
