import java.util.Random;

public class RandomBombGenerator { 

	public void bombGenerator(int bombBox[][]){
		Random generator = new Random(); 
		int i = 0; 
		while(i<10){
			if(bombBox[generator.nextInt(9)+1][generator.nextInt(9)+1] != 1){
				bombBox[generator.nextInt(9)+1][generator.nextInt(9)+1] = 1;
				i++;
			}
		}
	}
	
	public void showBombs(int bombBox[][]){
		for(int i = 0 ; i<10 ; i++){
			for(int j = 0 ; j<10 ; j++){
				System.out.print(bombBox[j][i]);
			}
			System.out.println();
		}
	}
}
