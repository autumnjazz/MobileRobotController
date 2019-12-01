package spotpackage;

import basic.Point;

public class Hazard extends Spot{

	public Hazard(int x, int y) {
		character = 'H';
		setPosition(x,y);
	}
	public Hazard(Point p) {
		character = 'H';
		setPosition(p.getx(),p.gety());
	}
	
	@Override
	public boolean equals(Object v) {
        boolean retVal = false;
        if (v!=null && v instanceof Hazard){
            Hazard p = (Hazard) v;
            retVal = 
         		(p.getPosition() == this.getPosition());
        }

     return retVal;
	}
}
