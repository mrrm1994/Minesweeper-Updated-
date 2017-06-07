import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;



public class Main {

	public static void main(String[] args) {

		JFrame myFrame = new JFrame("Minesweeper");
		myFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		myFrame.setLocation(700, 350);
		myFrame.setSize(400, 400);

		MyPanel myPanel = new MyPanel();

		myFrame.add(myPanel);

		MyMouseAdapter myMouseAdapter = new MyMouseAdapter();
		myFrame.addMouseListener(myMouseAdapter);

		myMouseAdapter.startGame();

		myFrame.setVisible(true);
		
		window();
	}

	//  "Legend window" was made with the help of Luis Gerardo Rivera 
	public static void window(){
		//JLabel
		JLabel info = new JLabel("<html> Color Legend: <br><br> "
				+ "CYAN         - 1 Adjecent Mine <br>"
				+ "BLUE         - 2 Adjecent Mines <br>"
				+ "YELLOW       - 3 Adjecent Mines <br>"
				+ "Pink         - 4 Adjecent Mines <br>"
				+ "GREEN        - 5 Adjecent Mines <br>"
				+ "ORANGE       - 6 Adjecent Mines <br>"
				+ "MAGENTA      - 7 Adjecent Mines <br>"
				+ "Violet       - 8 Adjecent Mines <br>"
				+ "Black        - Bomb <br>"
				+ "Red          - Flag <br>"
				+ "Gray         - No adjecent mines <br>"
				+ "<br>"
				+ "<br>"
				+ "Look at the image ''Color References (Minesweeper).png'' for a visual aid"
				+ "</html>", JLabel.CENTER);
				


		JScrollPane scroller = new JScrollPane(info, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		//JFrame
		JFrame legendFrame = new JFrame("Legend");
		legendFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		legendFrame.setLocation(400, 150);
		legendFrame.setSize(280, 400);
		legendFrame.setLocation(400, 350);
		legendFrame.add(scroller);
		legendFrame.setVisible(true);
	}
}
