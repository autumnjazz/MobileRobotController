package spotpackage;

import basic.Point;

public class ColorBlob extends Spot{
	public ColorBlob(int x, int y){
		super(x,y);
		character = 'C';
	}
	public ColorBlob(Point p) {
		super(p.getx(),p.gety());
		character = 'C';
	}
}
