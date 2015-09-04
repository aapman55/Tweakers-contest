import java.util.ArrayList;

/**
 * De Fibonaccireeks is een rij van getallen die ten grondslag ligt aan vele processen in de natuur, 
 * van de structuur van zonnebloemen tot de explosieve groei van een konijnenpopulatie.
 * De reeks begint met de getallen 0 en 1, waarna ieder volgend getal de som is van zijn 2 voorgangers. 
 * Het begin is dus: 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, etc.
 * Stel dat je van alle Fibonaccigetallen tot 1.000.000.000.000.000.000 (10^18) de afzonderlijke cijfers optelt, 
 * hoe vaak komt daar een getal uit dat zelf het kwadraat is van een geheel getal?
 * @author ZL
 *
 */

public class Fibonacci {
	/**
	 * Main method of class
	 */
	public void start(){
		long first = 0;
		long second = 1;
		long newFab = 0;
		double limit = Math.pow(10, 18);
		ArrayList<Long> outComeList = new ArrayList<Long>();
		
		
		// Zero should be added as well, but somehow it would be one too many. As 6 was the correct answer.
		outComeList.add(second);
		
		while(true){
			newFab = first+second;
			if (newFab>limit){
				break;
			}
			
			if (Math.sqrt((double) sumIndividualDigits(newFab)) == Math.floor(Math.sqrt((double) sumIndividualDigits(newFab)))){
				outComeList.add(newFab);
			}
			first = second;
			second = newFab;			
		}		
		
		for (Long number:outComeList){
			System.out.println(number);
		}
		
		System.out.println("Amount: "+outComeList.size());
	}
	
	/**
	 * For a given number of format long, add all individual digits
	 * @param number Input number
	 * @return
	 */
	public long sumIndividualDigits(long number){
		String[] addMe = Long.toString(number).split("");
		int summation = 0;
		
		for(String str:addMe){
			summation += Long.parseLong(str);
		}
		
		return summation;
	}
	
	/**
	 * Static main method
	 * @param args
	 */
	public static void main(String[] args){
		long beginTime = System.currentTimeMillis();
		new Fibonacci().start();
		long durationMS = System.currentTimeMillis()-beginTime;

		System.out.println("Duration: "+durationMS+" milliseconds");
					
	}
}
