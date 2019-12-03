package spotpackage;

import basic.Point;

public class ColorBlob extends Spot{
	public ColorBlob(int x, int y){
		character = 'C';
		setPosition(x,y);
	}
	public ColorBlob(Point p) {
		character = 'C';
		setPosition(p.getx(),p.gety());
	}
	@Override
	public boolean equals(Object v) {
        boolean retVal = false;
        if (v!=null && v instanceof ColorBlob){
        	ColorBlob p = (ColorBlob) v;
            retVal = 
         		(p.getPosition() == this.getPosition());
        }

     return retVal;
	}
}
