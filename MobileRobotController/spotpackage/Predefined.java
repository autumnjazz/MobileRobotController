package spotpackage;

public class Predefined extends Spot{
	private boolean visited;
	public Predefined(int x, int y){
		character = 'P';
		visited = false;
		setPosition(x,y);
	}
	public void setVisited(boolean value) {
		visited = value;
	}
	public boolean getVisited() {
		return visited;
	}
}
