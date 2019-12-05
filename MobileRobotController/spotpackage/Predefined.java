package spotpackage;

import basic.Point;

public class Predefined extends Spot{
	private boolean visited;
	public Predefined(int x, int y){
		super(x,y);
		character = 'P';
		visited = false;
	}
	public Predefined(Point p) {
		super(p.getx(), p.gety());
		character = 'P';
		visited = false;
	}
	public void setVisited(boolean value) {
		visited = value;
	}
	public boolean getVisited() {
		return visited;
	}

}
