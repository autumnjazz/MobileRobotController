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
}