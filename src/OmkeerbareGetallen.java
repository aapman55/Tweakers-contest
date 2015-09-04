import java.util.ArrayList;

/**
 * Sommige positieve getallen n hebben de eigenschap dat de som [ n + reverse(n) ] 
 * volledig bestaat uit oneven nummers. Bijvoorbeeld, 36 + 63 = 99 en 409 + 904 = 1313. Deze getallen noemen we omkeerbaar; 
 * dus 36, 63, 409, en 904 zijn omkeerbaar. Voorlopende nullen in n or reverse(n) zijn niet toegestaan.
 * 
 * Er zijn 120 omkeerbare getallen onder 1000.
 * 
 * Hoeveel omkeerbare getallen zijn er onder 100 miljoen (10^8)?
 * 
 * 
 * @author ZL
 *
 */

public class OmkeerbareGetallen {
	/**
	 * Main method
	 */
	public void start(){
		int begin = 0;
		int end = 100000000;
		ArrayList<Integer> lijst = new ArrayList<>();
		
		
		for (int i = begin; i <= end; ++i){
			if(i%10!=0 && isAllOdd(i+reverseInt(i))){
				lijst.add(i);				
			}
		}
		
		System.out.println(lijst.size());
		
	}
	
	/**
	 * Checks if all individual numbers are odd numbers
	 * @param number Number to check for
	 * @return
	 */
	public boolean isAllOdd(int number){
		
		String[] stringNum = Integer.toString(number).split("");
		
		for(String str:stringNum){			
			if(Integer.parseInt(str)%2==0){
				return false;
			}
		}
		
		return true;
	}
	
	/**
	 * Reverse an integer number. 1234 becomes 4321
	 * @param number The number to be reversed
	 * @return
	 */
	public int reverseInt(int number){		
		return (int) Integer.parseInt(new StringBuilder(Integer.toString(number)).reverse().toString());
	}
	
	/**
	 * Static Main method
	 * @param args
	 */
	public static void main(String[] args){
		new OmkeerbareGetallen().start();
	}
}
