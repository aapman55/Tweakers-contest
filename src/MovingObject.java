/**
 * Een object zweeft met een vaste snelheid van 20 punten p/s door de ruimte. Op het moment van schrijven bevindt 
 * het object zich op positie x: 30, y: 50 en z: 90. Het object beweegt naar x: 46, y: 48 en z: 9.
 * Wat zijn de coördinaten van het object na 25 minuten. Afgerond op 2 decimalen 
 * 
 * @author ZL
 *
 */
public class MovingObject {
	public static void main(String[] args){
		double velocity = 20;
		double duration = 25*60;
		double totalDistance = velocity*duration;
		
		Vector beginpoint = new Vector(30, 50, 90);
		Vector towards = new Vector(Math.pow(4, 6), Math.pow(4, 8), 9);
		
		Vector direction = towards.copy().add(beginpoint.copy().scale(-1)).normalise();
		
		Vector endpoint = beginpoint.copy().add(direction.copy().scale(totalDistance));
		
		System.out.println(direction);
		System.out.println(endpoint.toString());
	}
}
