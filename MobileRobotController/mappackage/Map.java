package mappackage;
import java.util.ArrayList;
import java.util.HashSet;

import basic.Point;
import spotpackage.*;

public class Map {
	public Spot board[][];
	 
	public Boolean visited[][]; // false:
	public int col; public int row;
	
	public ArrayList<Hazard> hlist = new ArrayList();
	public ArrayList<ColorBlob> clist = new ArrayList();
	public ArrayList<Predefined> plist = new ArrayList();
	
	//board
	public void initBoard(int row, int col) {
		this.row = row; this.col = col;
		board = new Spot[row][col];
		visited = new Boolean [row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j< col; j++) {
				Spot s = new Spot();
				board[i][j] = s;
				visited[i][j] = false;
			}
		}
		
	}
	
	
	public void clearVisited() {
		for (int i=0;i<row;i++){
			for (int j=0;j<col;j++) {
				visited[i][j] = false;
			}
		}
	}
	public void printBoard() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j< col; j++) {
				System.out.print(board[i][j].getCharacter());
			}
			System.out.println();
		}
	}
	public void updateBoard(Point p, Spot s) {
		board[p.getx()][p.gety()] = s;
	}
	
	//hazard
	public void setHazard(HashSet<Point> hash) {
		for(Point p: hash) {
			setHazard(p);
		}
	}
	
	public void setHazard(int x, int y) {
		if(!checkcontains(new Point(x,y))) {
			Hazard h = new Hazard(x, y);
			hlist.add(h);
			board[x][y]  = h;
		}
		else {
			System.out.println("this point already belongs to other lists");
		}
	}
	public void setHazard(Point p) {
		if(!checkcontains(p)) {
			Hazard h = new Hazard(p);
		hlist.add(h);
		board[p.getx()][p.gety()]  = h;
		}else {
			System.out.println("this point already belongs to other lists");
		}
	}
	public void printHazard() {
		for(Hazard obj:hlist) {
			System.out.print(obj.getPosition() + " ");
		}
		System.out.println();
	}
	
	//colorblob
	public void setColorblob(int x, int y) {
		if(!checkcontains(new Point(x,y))) {
			ColorBlob c = new ColorBlob(x, y);
		clist.add(c);
		board[x][y]  = c;
		}else {
			System.out.println("this point already belongs to other lists");
		}
	}
	public void setColorblob(Point p) {
		if(!checkcontains(p)) {
			ColorBlob c = new ColorBlob(p);
		clist.add(c);
		board[p.getx()][p.gety()]  = c;
		}else {
			System.out.println("this point already belongs to other lists");
		}
	}
	public void printColorblob() {
		for(ColorBlob obj:clist) {
			System.out.print(obj.getPosition()+" ");
		}
		System.out.println();
	}
	
	//predefined
	public void setPredefined(HashSet<Point> hash) {
		for(Point p: hash) {
			setPredefined(p);
		}
	}
	public void setPredefined(int x, int y) {
		if(!checkcontains(new Point(x,y))) {
			Predefined p = new Predefined(x,y);
		plist.add(p);
		board[x][y] = p;
		}else {
			System.out.println("this point already belongs to other lists");
		}
	}
	public void setPredefined(Point p) {
		if(!checkcontains(p)) {
			Predefined d = new Predefined(p);
		plist.add(d);
		board[p.getx()][p.gety()]  = d;
		}else {
			System.out.println("this point already belongs to other lists");
		}
	}
	public void printPredefined() {
		for(Predefined obj:plist) {
			System.out.print(obj.getPosition()+ " ");
		}
		System.out.println();
	}
	
	//before setblobs
	public boolean checkcontains(Point p) {
		if(board[p.getx()][p.gety()].getCharacter() == '.')
			return false;
		return true;
	}
	
	public void setVisited(int x, int y, Boolean bool) {
		visited[x][y] = bool;
	}
	
	public Boolean getVisited(int x, int y) {
		return visited[x][y];
	}
	
	
}
