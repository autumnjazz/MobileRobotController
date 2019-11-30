package spotpackage;

import basic.Point;

public class Predefined extends Spot{
	private boolean visited;
	public Predefined(int x, int y){
		character = 'P';
		visited = false;
		setPosition(x,y);
	}
	public Predefined(Point p) {
		// TODO Auto-generated constructor stub
		character = 'P';
		visited = false;
		setPosition(p.getx(),p.gety());
	}
	public void setVisited(boolean value) {
		visited = value;
	}
	public boolean getVisited() {
		return visited;
	}
}
