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
	@Override
	public boolean equals(Object v) {
        boolean retVal = false;
        if (v!=null && v instanceof Spot){
            Spot p = (Spot) v;
            retVal = 
         		(p.getPosition() == this.getPosition());
        }

     return retVal;
	}
}
