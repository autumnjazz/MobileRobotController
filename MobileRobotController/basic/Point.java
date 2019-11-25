package basic;

public class Point {
	private int x;
	private int y;
	public Point() {
		x = -1; y = -1;
	}
	public Point(int x, int y) {
		this.x = x; this.y = y;
	}
	public void setPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getx() {
		return x;
	}
	public int gety() {
		return y;
	}
	
	public String toString() {
		return "("+x+","+y+")";
	}
	
	public boolean equals(Point p) {
		return this.toString().equals(p.toString());
	}
}
