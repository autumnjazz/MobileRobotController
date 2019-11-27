package guipackage;
import java.awt.*;
import javax.swing.*;
public class MapBoard extends JPanel{
	
	int row; int col;
	int SIZE = 30;
	//TODO: add spot list
	
	public MapBoard(int row, int col) {
		this.row = row; this.col = col;
		setPreferredSize(new Dimension(row*30,col*30));
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		drawMap(g);
	}
	
	public void drawMap(Graphics g) {
		int xpos, ypos;
		for(int y = 0; y < row; y++) {
			for(int x = 0; x < col; x++) {
				xpos = x*SIZE; ypos = y*SIZE;
				g.drawRect(xpos, ypos, SIZE, SIZE);
			}
		}
	}
	
	
}
