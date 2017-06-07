import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyMouseAdapter extends MouseAdapter  {

	public int zoneArray[][] = new int[11][11];
	ZoneScanner scanArea = new ZoneScanner();
	public void startGame(){ 
		scanArea.bombGenerator(zoneArray);
		scanArea.zoneIdentifier(zoneArray);
		scanArea.zoneAssigmnet(zoneArray);
		scanArea.showZoneArrayConsole(zoneArray);
	}
	public void gameLost(){
		ZoneScanner scanArea = new ZoneScanner();
		int confirmation = JOptionPane.showConfirmDialog(null, "You lost! Want to play again?", null, JOptionPane.YES_NO_OPTION);
		if(confirmation == JOptionPane.YES_OPTION){
			scanArea.restartGameZones(zoneArray);
		}
		else{
			JOptionPane.showMessageDialog(null, "Thank You for playing!");
			System.exit(0);
		}
	}
	public void gameWon(){
		ZoneScanner scanArea = new ZoneScanner();
		int buttonPressed = JOptionPane.showConfirmDialog(null, "You win! Want to play again?", null, JOptionPane.YES_NO_OPTION);
		if(buttonPressed == JOptionPane.YES_OPTION){
			JOptionPane.showMessageDialog(null, "Let's get started");
			scanArea.restartGameZones(zoneArray);
		}
		else{
			JOptionPane.showMessageDialog(null, "Thank You for playing!");
			System.exit(0);
		}
	}
	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {

		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame) c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			myPanel.mouseDownGridX = myPanel.getGridX(x, y);
			myPanel.mouseDownGridY = myPanel.getGridY(x, y);
			myPanel.repaint();
			break;

		case 3:		//Right mouse button

			c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			myFrame = (JFrame) c;
			myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
			myInsets = myFrame.getInsets();
			x1 = myInsets.left;
			y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			x = e.getX();
			y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			myPanel.mouseDownGridX = myPanel.getGridX(x, y);
			myPanel.mouseDownGridY = myPanel.getGridY(x, y);
			myPanel.repaint();
			break;

		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}

	public void mouseReleased(MouseEvent e) {
		switch (e.getButton()) {

		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame)c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			int gridX = myPanel.getGridX(x, y);
			int gridY = myPanel.getGridY(x, y);
			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridX == -1) || (gridY == -1)) {
					//Is releasing outside
					//Do nothing
				} else {
					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					} else {
						//Released the mouse button on the same cell where it was pressed
						if ((gridX == 0) || (gridY == 0)|| (gridX == 10) || (gridY == 10)) {
							//On the left column and on the top row... do nothing
						} else {
							//On the grid other than on the left column and on the top row:					
							if(zoneArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] == 1 && !myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY].equals(Color.RED)){
								scanArea.showBombZones(zoneArray, myPanel.colorArray);
								myPanel.repaint();
								if(scanArea.playerLost(zoneArray, myPanel.colorArray)){
									System.out.println("You Lost!");
									gameLost();
									scanArea.restartGameColor(myPanel.colorArray);
								}
							}

							else if(zoneArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] == 0 && !myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY].equals(Color.RED)){
								scanArea.zoneExpansion(zoneArray, myPanel.colorArray, myPanel.mouseDownGridX, myPanel.mouseDownGridY);
								if(scanArea.playerWon(zoneArray, myPanel.colorArray)){
									System.out.println("You win!");
									gameWon();
									scanArea.restartGameColor(myPanel.colorArray);
								}else;
							}
							else{
								if(zoneArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] > 5 && !myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY].equals(Color.RED)){
									scanArea.zonePainter(zoneArray, myPanel.colorArray, myPanel.mouseDownGridX, myPanel.mouseDownGridY);
									if(scanArea.playerWon(zoneArray, myPanel.colorArray)){
										scanArea.showBombZones(zoneArray, myPanel.colorArray);
										myPanel.repaint();
										System.out.println("You win!");
										gameWon();
										scanArea.restartGameColor(myPanel.colorArray);
									}else;
								}
							}

						}
					}
				}
			}
			myPanel.repaint();
			break;

		case 3:		//Right mouse button (Flag)
			c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}

			myFrame = (JFrame) c;
			myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
			myInsets = myFrame.getInsets();
			x1 = myInsets.left;
			y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			x = e.getX();
			y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			myPanel.mouseDownGridX = myPanel.getGridX(x, y);
			myPanel.mouseDownGridY = myPanel.getGridY(x, y);
			gridX = myPanel.getGridX(x, y);
			gridY = myPanel.getGridY(x, y);

			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridX == -1) || (gridY == -1)) {
					//Is releasing outside
					//Do nothing
				} else {
					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					} else {
						//Released the mouse button on the same cell where it was pressed
						if ((gridX == 0) || (gridY == 0)) {
							//On the left column and on the top row... do nothing
						} else {
							//On the grid other than on the left column and on the top row:

							if(myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY].equals(Color.WHITE)){

								myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = Color.RED;
							}
							else {
								if(myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY].equals(Color.RED)){
									myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = Color.WHITE;	
								}
								myPanel.repaint();
							}
						}
					}
				}
			}
			myPanel.repaint();
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}	
	}
}
