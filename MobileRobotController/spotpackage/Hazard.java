package spotpackage;

import basic.Point;

public class Hazard extends Spot{

	public Hazard(int x, int y) {
		super(x,y);
		character = 'H';
	}
	public Hazard(Point p) {
		super(p.getx(),p.gety());
		character = 'H';
	}
	
}
