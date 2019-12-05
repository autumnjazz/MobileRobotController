package spotpackage;
import basic.*;

public class Spot {
	public Point p;
	protected char character;
	public Spot(int x, int y){
		character = '.';
		p =  new Point(x,y);
	}
	public Spot(Point p) {
		character = '.';
		this.p =  p;
	}
	public void setPosition(int x, int y) {
		p.setPoint(x, y);
	}
	public Point getPosition() { return p;}
	public char getCharacter() {return character;}
	@Override
	public boolean equals(Object obj) {
        if (obj !=null && obj instanceof Spot){
            Spot s = (Spot) obj;
         	return (s.p.equals(this.p));
        }

     return false;
	}
}
