package repositorypackage;
import basic.Point;
import mappackage.*;
import pathpackage.Path;

public class Repository {
	public Map m = new Map();
	public Path p = new Path();
	public DynamicMap dm = new DynamicMap();
	
	public void setMap(Map m) {
		this.m = m;
	}
	public void setPath(Path p) {
		this.p = p;
	}
	public void setDM(Point current) {
		dm.setDM(m, current);
	}
	
	public void printMap() {
		System.out.println("\nMap Board:");
		m.printBoard();
//		System.out.println("\nHazard: ");
//		m.printHazard();
//		System.out.println("\nColorblob: ");
//		m.printColorblob();
	}

	public void printDMap() {
		System.out.println("\nDynamic Map Board:");
		dm.printBoard();
	}
	
	public void printPath() {
		System.out.println("\nPath: ");
		p.printPath();
	}
	
	
}
