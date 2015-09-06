import java.util.HashSet;
import java.util.Set;

/**
 * 
 * Je bent bezig met een kassasysteem voor de horeca. De afnemer heeft een speciale vraag: 
 * om te voorkomen dat de klanten continu met stapels muntgeld in hun broekzakken moeten rondlopen wil hij zo min 
 * mogelijk munten teruggeven. Concreet wil hij na 1 aankoop nooit meer dan 5 muntstukken teruggeven.
 * Stel nu dat er in je kasla de volgende muntstukken liggen:
 *     4 * � 2,-
 *     2 * � 1,-
 *     8 * � 0,50
 *     1 * � 0,20
 *     4 * � 0,10
 *     3 * � 0,05
 *     
 *     Hoeveel unieke bedragen kun je teruggeven met minimaal 1 en maximaal 5 munten?
 * 
 * @author ZL
 *
 */

public class LessMetal {
	public double[] coinValues;
	
	
	/**
	 * start class
	 */
	public void start(){
		Set<Double> amounts = new HashSet<>();
	
		fillCoinValues(	4, // 2 Euros
						2, // 1 Euros
						8, // 50 cents
						1, // 20 cents
						4, // 10 cents
						3);// 5 cents				
		
		for(int a = 0; a < coinValues.length; ++a){
			for(int b = 0; b < coinValues.length; ++b){
				for(int c = 0; c < coinValues.length; ++c){
					for(int d = 0; d < coinValues.length; ++d){
						for(int e = 0; e < coinValues.length; ++e){
							double[] coinChoice = new double[coinValues.length];
							coinChoice[a] = 1;
							coinChoice[b] = 1;
							coinChoice[c] = 1;
							coinChoice[d] = 1;
							coinChoice[e] = 1;
							
							amounts.add(roundWithPrecision(dotProduct(coinChoice, coinValues), 2));
						}
					}	
				}
			}
		}
		
		for (double dbl:amounts){
			System.out.println(dbl);
		}
		
		System.out.println("");
		System.out.println("Total amount of different amounts: "+amounts.size());

	}
	/**
	 * Rounding off with desired precision
	 * @param input
	 * @param precision
	 * @return
	 */
	public double roundWithPrecision(double input, int precision){
		return Math.round(Math.pow(10, precision)*input)/((double) Math.pow(10, precision));
	}
	
	/**
	 * Given 2 arrays, calculate the dotProduct
	 * @param n1
	 * @param n2
	 * @return
	 */
	public double dotProduct(double[] n1, double[] n2){
		double sum = 0;
		if(n1.length!=n2.length){
			System.err.println("length of the arrays should be the same!");
		}
		
		for(int i = 0 ; i < n1.length; ++i){
			sum += n1[i]*n2[i];
		}
		
		return sum;				
	}
	
	/**
	 * Fill the coinValues array with the right coins
	 * @param Two
	 * @param One
	 * @param Fifty
	 * @param Twenty
	 * @param Ten
	 * @param Five
	 */
	public void fillCoinValues(int Two, int One,int Fifty,int Twenty,int Ten,int Five){
		coinValues = new double[Two+One+Fifty+Twenty+Ten+Five];
		int index = 0;		
		
		for(int i = 0; i < Two; ++i){
			coinValues[index] = 2;
			index++;
		}
		
		for(int i = 0; i < One; ++i){
			coinValues[index] = 1;
			index++;
		}
		
		for(int i = 0; i < Fifty; ++i){
			coinValues[index] = 0.50;
			index++;
		}
		
		for(int i = 0; i < Twenty; ++i){
			coinValues[index] = 0.20;
			index++;
		}
		
		for(int i = 0; i < Ten; ++i){
			coinValues[index] = 0.10;
			index++;
		}
		
		for(int i = 0; i < Five; ++i){
			coinValues[index] = 0.05;
			index++;
		}
		
	}
	
	/**
	 * Static main method
	 * @param args
	 */
	public static void main(String[] args){
		long beginTime = System.currentTimeMillis();
		new LessMetal().start();
		System.out.println("Total duration in ms: "+(System.currentTimeMillis()-beginTime));
	}
}
