import java.util.Random;

public class RandomBombGenerator { 

	public void bombGenerator(int bomb[][]){
		Random generator = new Random(); 
		int i = 0; 
		while(i<10){
			if(bomb[generator.nextInt(9)+1][generator.nextInt(9)+1] != 1){
				bomb[generator.nextInt(9)+1][generator.nextInt(9)+1] = 1;
				i++;
			}
		}
	}
	
	public void showBombs(int bomb[][]){
		for(int i = 0 ; i<10 ; i++){
			for(int j = 0 ; j<10 ; j++){
				System.out.print(bomb[j][i]);
			}
			System.out.println();
		}
	}
}
