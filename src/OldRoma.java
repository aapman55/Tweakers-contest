/**
 * 
 * In het oude Rome stond een sterk staaltje architectuur genaamd het 'Ominesium'. 
 * Op de gevel van het gebouw was met mozaïek aangegeven hoe oud het gebouw was in jaren. 
 * Uiteraard gaven de oude Romeinen dit aan met Romeinse cijfers. 
 * Deze Romeinen waren erg bij de tijd en gebruikten de moderne notatie voor Romeinse cijfers: 49 = XLIX, 4 = IV.
 * 
 * Het gebouw is net na een stevige aardbeving voltooid, en het eerste mozaïek werd na een jaar aangebracht. 
 * Onze jaartelling begint bij 0, dus het eerste mozaïek werd geplaatst in het jaar 1.
 * Het aantal mozaïksteentjes benodigd voor een symbool is 250. Het jaartal IV kostte dus 500 steentjes om op de muur aan te brengen.
 * Om kleurverschil tegen te gaan werd bij elke plaatsing van een nieuw jaartal de complete mozaïek opnieuw geplaatst.
 * Het was een regio met veel seismische activiteit; om de 43 jaar werd de regio getroffen door een zware aardbeving waarbij 
 * 15% van de voorraad steentjes verloren ging, per aardbeving afgerond naar boven op gehele steentjes. 
 * De eerste beving sinds de voltooiing van het gebouw vond plaats na 43 jaar.
 * 
 * Aardbevingen vonden door een enorm toeval telkens plaats voordat het nieuwe mozaïek werd aangebracht.
 * Na de voltooiing van het 'Ominesium' (en dus ook ná de aardbeving in het jaar 0) was er nog een voorraad van 12.500.000 
 * mozaïeksteentjes beschikbaar voor de jaarlijkse renovatie van het mozaïek.

 * 
 * @author ZL
 *
 */
public class OldRoma {
	public static void main(String[] args){
		// Initial timestamp
		long beginTime = System.currentTimeMillis();
		// Initial stack of stones
		int initialAmountOfStones = 12500000;
		// Cost per roman number
		int stonesPerNumber = 250;
		// Year counter (skip 0 to prevent code from smashing the stones)
		int counter = 1;
		
		// Counter for the stones
		int numberOfStones = initialAmountOfStones;
		
		// Loop till the stones run out
		while(true){
			// Earthquake! Happens every 43 years. Years are counting from 0, making it pretty easy.
			if(counter%43==0){
				// Because it is an integer, it is automatically floored (which is good)
				numberOfStones *=0.85;	
				// log
				System.out.println("Earthquake!");
				System.out.println("Year (arabic): "+counter+" Year (Roman): "+RomanNumber.toRoman(counter)+" StonesLeft: "+numberOfStones);
			}
			// Use stones to build the roman numbers
			numberOfStones -= RomanNumber.toRoman(counter).length()*stonesPerNumber;
			
			// log the year and stones
			System.out.println("Year (arabic): "+counter+" Year (Roman): "+RomanNumber.toRoman(counter)+" StonesLeft: "+numberOfStones);
			
			// Go to next year
			counter++;
			
			// Check if the stack of stones are depleted
			if (numberOfStones < 0){
				break;
			}
		}
		
		// Log performance
		System.out.println("Total duration in ms: "+(System.currentTimeMillis()-beginTime));
		
	}
}
