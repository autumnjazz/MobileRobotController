package spotpackage;
import basic.*;

public class Spot {
	Point p = new Point();
	protected char character;
	public Spot(){
		character = '.';
	}
	public void setPosition(int x, int y) {
		p.setPoint(x, y);
	}
	public Point getPosition() { return p;}
	public char getCharacter() {return character;}
	
}
