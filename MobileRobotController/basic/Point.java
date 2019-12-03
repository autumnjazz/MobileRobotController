package basic;
import java.util.ArrayList;

public class Point {
	private int x;
	private int y;
	private Point prev_p;
	
	
	public Point() {
		x = -1; y = -1;
		setPrev_p(null);
	}
	public Point(int x, int y) {
		this.x = x; this.y = y;
		this.setPrev_p(null);
	}
	public Point(int x,int y,Point prev_p) {
		this.x = x; this.y = y;
		this.setPrev_p(prev_p);
	}
	public void setPoint(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public void setPoint(int x, int y, Point prev_p) {
		this.x = x;
		this.y = y;
		this.setPrev_p(prev_p);
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
	
	@Override
	public boolean equals(Object v) {
        boolean retVal = false;
        if (v!=null && v instanceof Point){
            Point p = (Point) v;
            retVal = 
         		(p.getx() == this.getx()) 
         		&& (p.gety() == this.gety());
        }

     return retVal;
  }
	public Point getPrev_p() {
		return prev_p;
	}
	public void setPrev_p(Point prev_p) {
		this.prev_p = prev_p;
	}
}
