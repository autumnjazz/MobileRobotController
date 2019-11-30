package spotpackage;

import basic.Point;

public class VisitedSpot extends Spot{

	public VisitedSpot(int x, int y) {
		character = '-';
		setPosition(x,y);
	}
	public VisitedSpot(Point p) {
		character = '-';
		setPosition(p.getx(),p.gety());
	}
}
