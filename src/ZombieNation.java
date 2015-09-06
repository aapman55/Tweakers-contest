
public class ZombieNation {
	public static void main(String[] args){
		long zombieCount = 1;
		long healthyCount =  7000000000l;
		long timeInHours = 0;
		
		while(true){
			long attacksPerZombie = (timeInHours%24>=8 && timeInHours%24<22)?2:1;
			long attackedPersons = zombieCount*attacksPerZombie;			
			long unsuccesfulAttacks = (timeInHours >= 8)? attackedPersons/3:0;
			attackedPersons -= unsuccesfulAttacks;
			long collapsedHealthyPerson = attackedPersons/5;
			
			if(timeInHours==0)
			System.out.println("Time: "+timeInHours+" HealthyCount: "+healthyCount+" Zombies: "+zombieCount+" attacksPerZombie: "+attacksPerZombie);
			
			zombieCount = zombieCount - unsuccesfulAttacks + attackedPersons - collapsedHealthyPerson;
			healthyCount -= attackedPersons;	
			
			if(timeInHours>0)
				System.out.println("Time: "+timeInHours+" HealthyCount: "+healthyCount+" Zombies: "+zombieCount+" attacksPerZombie: "+attacksPerZombie);

			if(healthyCount<=0){
				break;				
			}
			
			
			timeInHours++;
		}
		
	}
}
