import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class Primal {
	public static void main(String[] args) throws FileNotFoundException{
		Scanner sc = new Scanner(new File("resources/numbers.txt"));
		int[] numbers = new int[50000];
		int counter = 0;
		int primeAmount = 0;
		
		while(sc.hasNextInt()){
			numbers[counter] = sc.nextInt();
			counter++;
		}
		
		sc.close();
		
		for (int integer:numbers){
			if(isPrime(integer)){
				primeAmount++;
			}
		}
		
		System.out.println(primeAmount);
		
	}
	
	public static boolean isPrime(int num) {
        if (num == 2 ) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
}
}
