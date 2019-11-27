package mappackage;
import java.util.ArrayList;

import basic.Point;
import spotpackage.*;

public class Map {
	public Spot board[][];
	 
	public Boolean visited[][]; // false:방문 X, true:방문
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
	
	public void printVisited() {
		for (int i = 0; i < row; i++) {
			for (int j = 0; j< col; j++) {
				if (visited[i][j]) {
					System.out.print(1+" ");
				}
				else {
					System.out.print(0+" ");
				}
				
			}
			System.out.println();
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
	public void setHazard(int x, int y) {
		Hazard h = new Hazard(x, y);
		hlist.add(h);
		board[x][y]  = h;
	}
	public void setHazard(Point p) {
		Hazard h = new Hazard(p);
		hlist.add(h);
		board[p.getx()][p.gety()]  = h;
	}
	public void printHazard() {
		for(Hazard obj:hlist) {
			System.out.print(obj.getPosition() + " ");
		}
		System.out.println();
	}
	
	//colorblob
	public void setColorblob(int x, int y) {
		ColorBlob c = new ColorBlob(x, y);
		clist.add(c);
		board[x][y]  = c;
	}
	public void setColorblob(Point p) {
		ColorBlob c = new ColorBlob(p);
		clist.add(c);
		board[p.getx()][p.gety()]  = c;
	}
	public void printColorblob() {
		for(ColorBlob obj:clist) {
			System.out.print(obj.getPosition()+" ");
		}
		System.out.println();
	}
	
	//predefined
	public void setPredefined(int x, int y) {
		Predefined p = new Predefined(x,y);
		plist.add(p);
		board[x][y] = p;
	}
	public void printPredefined() {
		for(Predefined obj:plist) {
			System.out.print(obj.getPosition()+ " ");
		}
		System.out.println();
	}
	
}
