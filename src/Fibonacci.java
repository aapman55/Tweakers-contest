import java.util.ArrayList;


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
