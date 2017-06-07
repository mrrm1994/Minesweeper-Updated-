import java.awt.Color;
import java.util.Random;

public class ZoneScanner {

	public void zoneIdentifier(int zoneArray[][]){
		for (int coorX =1; coorX<=9; coorX++){
			for(int coorY=1; coorY <= 9; coorY++){
				if(zoneArray[coorX][coorY] == 1){
					if(zoneArray[coorX-1][coorY-1] == 1){		//top left	
						zoneArray[coorX-1][coorY-1] = 1;
					}else zoneArray[coorX-1][coorY-1] = 5; 

					if(zoneArray[coorX-1][coorY+1] == 1){		//top right
						zoneArray[coorX-1][coorY+1] = 1;
					}else zoneArray[coorX-1][coorY+1] = 5; 

					if(zoneArray[coorX][coorY-1] == 1){		//middle bottom
						zoneArray[coorX][coorY-1] = 1;
					}else zoneArray[coorX][coorY-1] = 5;

					if(zoneArray[coorX][coorY+1] == 1){		//middle top
						zoneArray[coorX][coorY+1] = 1;
					}else zoneArray[coorX][coorY+1] = 5; 

					if(zoneArray[coorX+1][coorY-1] == 1){		//bottom left
						zoneArray[coorX+1][coorY-1] = 1;
					}else zoneArray[coorX+1][coorY-1] = 5; 

					if(zoneArray[coorX+1][coorY+1] == 1){		//bottom right
						zoneArray[coorX+1][coorY+1] = 1;
					}else zoneArray[coorX+1][coorY+1] = 5; 

					if(zoneArray[coorX-1][coorY] == 1){		//middle left
						zoneArray[coorX-1][coorY] = 1;
					}else zoneArray[coorX-1][coorY] = 5; 

					if(zoneArray[coorX+1][coorY] == 1){		//middle right
						zoneArray[coorX+1][coorY] = 1;
					}else zoneArray[coorX+1][coorY] = 5; 
				}
			}
		}
	}public int zoneAssigmnet(int zoneArray[][]){
		int adjacentBombLocator = 5;
		for (int coorX =1; coorX<=9; coorX++){
			for(int coorY=1; coorY <= 9; coorY++){
				if(zoneArray[coorX][coorY] == 5){
					if(zoneArray[coorX-1][coorY-1] == 1){		//top left	
						adjacentBombLocator++;				
					}else; 								//else do nothing		

					if(zoneArray[coorX-1][coorY+1] == 1){		//top right
						adjacentBombLocator++;
					}else; 

					if(zoneArray[coorX][coorY-1] == 1){		//middle bottom
						adjacentBombLocator++;
					}else;

					if(zoneArray[coorX][coorY+1] == 1){		//middle top
						adjacentBombLocator++;
					}else; 

					if(zoneArray[coorX+1][coorY-1] == 1){		//bottom left
						adjacentBombLocator++;
					}else; 

					if(zoneArray[coorX+1][coorY+1] == 1){		//bottom right
						adjacentBombLocator++;
					}else; 

					if(zoneArray[coorX-1][coorY] == 1){		//middle left
						adjacentBombLocator++;
					}else; 

					if(zoneArray[coorX+1][coorY] == 1){		//middle right
						adjacentBombLocator++;
					}else;

					zoneArray[coorX][coorY] = adjacentBombLocator; //assign the adjacent bomb to the zone
					adjacentBombLocator = 5;
				}	
			}
		}
		for (int coorX = 0; coorX<=10; coorX++){			//set all the border columns and rows to 0 
			zoneArray[coorX][0] = 2;
			zoneArray[coorX][10] = 2;
		}
		for(int coorY=1; coorY <= 9; coorY++){
			zoneArray[0][coorY] = 2;
			zoneArray[10][coorY] = 2;
		}
		return adjacentBombLocator;
	}
	public void zonePainter(int zoneArray[][], Color arrayColor[][], int coorX, int coorY){
		switch(zoneArray[coorX][coorY]){
		case 0:
			arrayColor[coorX][coorY] = Color.GRAY;
			break;
		case 1:
			arrayColor[coorX][coorY] = Color.BLACK;
			break;
		case 6:
			arrayColor[coorX][coorY] = Color.CYAN;
			break;
		case 7:
			arrayColor[coorX][coorY] = Color.BLUE;
			break;
		case 8:
			arrayColor[coorX][coorY] = Color.YELLOW;
			break;
		case 9:
			arrayColor[coorX][coorY] = Color.PINK;
			break;
		case 10:
			arrayColor[coorX][coorY] = Color.GREEN;
			break;
		case 11:
			arrayColor[coorX][coorY] = Color.ORANGE;
			break;
		case 12:
			arrayColor[coorX][coorY] = Color.MAGENTA;
			break;
		case 13:
			arrayColor[coorX][coorY] = new Color(0xB57EDC);
			break;
		default: 
			//do nothing
		}
	}
	public void zoneExpansion(int zoneArray[][], Color arrayColor[][], int coorX, int coorY){ 

		if (coorX < 0 || coorX > 10 || coorY < 0 || coorY > 10) return; // check for bounds  (dead code)

		else if ( zoneArray[coorX][coorY] == 0  && arrayColor[coorX][coorY].equals(Color.WHITE)) {
			zonePainter(zoneArray, arrayColor, coorX, coorY); 

			zoneExpansion(zoneArray, arrayColor, coorX+1, coorY );

			zoneExpansion(zoneArray, arrayColor, coorX-1, coorY ); 

			zoneExpansion(zoneArray, arrayColor, coorX, coorY-1 );

			zoneExpansion(zoneArray, arrayColor, coorX, coorY+1 );

			if(zoneArray[coorX][coorY+1] > 5  && zoneArray[coorX+1][coorY] > 5 && arrayColor[coorX+1][coorY+1].equals(Color.WHITE)){
				if(zoneArray[coorX+1][coorY+1] != 1 && zoneArray[coorX+1][coorY+1] != 0){
					zonePainter(zoneArray, arrayColor, coorX+1, coorY+1);
				}else;
			}
			if(zoneArray[coorX][coorY-1] > 5  && zoneArray[coorX-1][coorY] > 5 && arrayColor[coorX-1][coorY-1].equals(Color.WHITE)){
				if(zoneArray[coorX-1][coorY-1] != 1 && zoneArray[coorX-1][coorY-1] != 0){
					zonePainter(zoneArray, arrayColor, coorX-1, coorY-1);
				}else;
			}
			if(zoneArray[coorX+1][coorY] > 5  && zoneArray[coorX][coorY-1] > 5 && arrayColor[coorX+1][coorY-1].equals(Color.WHITE)){
				if(zoneArray[coorX+1][coorY-1] != 1 && zoneArray[coorX+1][coorY-1] != 0){
					zonePainter(zoneArray, arrayColor, coorX+1, coorY-1);
				}else;
			}
			if(zoneArray[coorX][coorY+1] > 5  && zoneArray[coorX-1][coorY] > 5 && arrayColor[coorX-1][coorY+1].equals(Color.WHITE)){
				if(zoneArray[coorX-1][coorY+1] != 1 && zoneArray[coorX-1][coorY+1] != 0){
					zonePainter(zoneArray, arrayColor, coorX-1, coorY+1);
				}
			}
		}
		else if(zoneArray[coorX][coorY] > 5){
			zonePainter(zoneArray, arrayColor, coorX, coorY); 
		}
		return;
	}
	public boolean playerWon(int zoneArray[][], Color arrayColor[][]){
		int openZoneNumber = 0; 
		for (int coorX = 1; coorX < 10; coorX++){
			for (int coorY = 1; coorY < 10; coorY++){
				if(zoneArray[coorX][coorY] != 1 && !arrayColor[coorX][coorY].equals(Color.WHITE)){
					openZoneNumber++; 
				}
				else continue; 
			}
		}
		return (openZoneNumber == 71);

	}
	public boolean playerLost(int zones[][], Color arrayColor[][]){
		int openZoneNumber = 0; 
		for (int coorX = 1; coorX < 10; coorX++){
			for (int coorY = 1; coorY < 10; coorY++){
				if(arrayColor[coorX][coorY].equals(Color.BLACK)){
					openZoneNumber++; 
				}
				else continue; 
			}
		}
		if(openZoneNumber >= 1){
			return true; 
		}
		else return false;	
	}
	public void restartGameZones(int zoneArray[][]){
		for(int i = 1; i<11; i++){
			for(int j = 1; j<11; j++){
				zoneArray[i][j]=0;
			}
		}
		bombGenerator(zoneArray);
		zoneIdentifier(zoneArray);
		zoneAssigmnet(zoneArray);
		showZoneArrayConsole(zoneArray);
	}
	public void restartGameColor(Color colorArray[][]){
		for(int i = 1; i<10; i++){
			for(int j = 1; j<10; j++){
				colorArray[i][j]=Color.WHITE;
			}
		}
	}
	public void bombGenerator(int zoneArray[][]){
		Random generator = new Random(); 
		int amountOfBombs = 0; 
		while(amountOfBombs!=10){
			int randX= generator.nextInt(9)+1;
			int randY = generator.nextInt(9)+1;
			if(zoneArray[randX][randY] != 1){
				zoneArray[randX][randY] = 1;
				amountOfBombs++;
			}
		}
	}

	public void showZoneArrayConsole(int zoneArray[][]){  
		for(int coorY = 1 ; coorY<10 ; coorY++){
			for(int coorX = 1 ; coorX<10 ; coorX++){
				System.out.print(zoneArray[coorX][coorY]);
			}
			System.out.println();
		}
	} 

	public void showBombZones(int zoneArray[][], Color colorArray[][]){
		for(int coorX = 0 ; coorX<10 ; coorX++){
			for(int coorY = 0 ; coorY<10 ; coorY++){
				if(zoneArray[coorX][coorY] == 1 && colorArray.equals(Color.RED)){
					colorArray[coorX][coorY] = Color.RED;
				}
				else if(zoneArray[coorX][coorY] == 1){
					colorArray[coorX][coorY] = Color.BLACK;
				}
			}
		}
	}

}
