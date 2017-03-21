import java.awt.Color;

public class ZoneScanner {


	public void zoneIdentifier(int bombLocator[][], Color colorArray[][], int coorX,int coorY){
		int closeBombCounter = 0;
		if(bombLocator[coorX-1][coorY-1] == 1){     // Top Left Square
			closeBombCounter++;
		}
		if(bombLocator[coorX-1][coorY] == 1){      // Left Square
			closeBombCounter++;
		}
		if(bombLocator[coorX-1][coorY+1] == 1){    // Bottom Left Square
			closeBombCounter++;
		}
		if(bombLocator[coorX][coorY-1] == 1){      // Top Square
			closeBombCounter++;
		}
		if(bombLocator[coorX][coorY+1] == 1){      // Bottom Square
			closeBombCounter++;
		}
		if(bombLocator[coorX+1][coorY-1] == 1){    // Top Right Square
			closeBombCounter++;
		}
		if(bombLocator[coorX+1][coorY] == 1){      // Right Square
			closeBombCounter++;
		}
		if(bombLocator[coorX+1][coorY+1] == 1){    // Bottom Right Square
			closeBombCounter++;
		}
		switch (closeBombCounter) {
		default: colorArray[coorX][coorY] = Color.LIGHT_GRAY ;      // No Close Bombs
		break;
		
		case 1: colorArray[coorX][coorY] = Color.CYAN ;             // One Close Bomb
		break;
		
		case 2: colorArray[coorX][coorY] = Color.BLUE ;              // Two Close Bombs
		break;
		
		case 3: colorArray[coorX][coorY] = Color.MAGENTA ;          // Three Close Bombs
		break;
		
		case 4: colorArray[coorX][coorY] = Color.GREEN ;            // Four Close Bombs
		break;
		
		case 5: colorArray[coorX][coorY] = Color.PINK ;            // Five Close Bombs
		break;
		
		case 6: colorArray[coorX][coorY] = Color.YELLOW ;          // Six Close Bombs
		break;
		
		case 7: colorArray[coorX][coorY] = Color.DARK_GRAY ;       // Seven Close Bombs
		break;
		
		case 8: colorArray[coorX][coorY] = Color.RED ;            // Eight Close Bombs
		break;
		}
	}
}
