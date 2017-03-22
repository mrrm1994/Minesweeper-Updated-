import java.awt.Color;
import java.util.Random;

import javax.swing.JFrame;

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

	public void showBombsConsole(int bombBox[][]){  
		for(int i = 1 ; i<10 ; i++){
			for(int j = 1 ; j<10 ; j++){
				System.out.print(bombBox[j][i]);
			}
			System.out.println();
		}
	} 

	public void showBombs(int bombBox[][], Color colorArray[][], int coorX, int coorY){
		for(int i = 0 ; i<10 ; i++){
			for(int j = 0 ; j<10 ; j++){
				if(bombBox[i][j] == 1){
					colorArray[i][j] = Color.BLACK;
				}
			}
		}
	}
}
