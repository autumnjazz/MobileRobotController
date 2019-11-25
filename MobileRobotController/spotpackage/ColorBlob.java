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
}
