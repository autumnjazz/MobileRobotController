package basic;
import java.util.ArrayList;

public class Point {
	private int x;
	private int y;
	public Point prev_p;
	
	
	public Point() {
		x = -1; y = -1;
		prev_p = null;
	}
	public Point(int x, int y) {
		this.x = x; this.y = y;
		this.prev_p = null;
	}
	public Point(int x,int y,Point prev_p) {
		this.x = x; this.y = y;
		this.prev_p = prev_p;
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
