package mappackage;
import java.util.ArrayList;
import java.util.HashSet;

import basic.Point;
import spotpackage.*;

public class Map {
	public Spot board[][];
	 
	public Boolean visited[][]; // false:
	public int col; public int row;
	
	public ArrayList<Spot> hlist = new ArrayList();
	public ArrayList<Spot> clist = new ArrayList();
	public ArrayList<Spot> plist = new ArrayList();
	
	//board
	public void initBoard(int row, int col) {
		this.row = row; this.col = col;
		board = new Spot[row][col];
		visited = new Boolean [row][col];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j< col; j++) {
				Spot s = new Spot(i,j);
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

	public void setHazard(Point p) {
		
		Hazard h = new Hazard(p);
		if(!checkcontains(hlist,h)) {
			hlist.add(h);
			board[p.getx()][p.gety()]  = h;
		}
		else if(checkcontains(hlist,h)) {
			hlist.remove(h);
			Spot s = new Spot(p.getx(), p.gety());
			board[p.getx()][p.gety()]  = s;
		}
		else {
			System.out.println("this point already belongs to other lists");
		}
	}
	
	//colorblob
	public void setColorblob(int x, int y) {
		char spot = board[x][y].getCharacter();
		ColorBlob c = new ColorBlob(x,y);
		if(spot == '.') {
			clist.add(c);
			board[x][y]  = c;
		}
	}
	public void setColorblob(Point p) {
		char spot = board[p.getx()][p.gety()].getCharacter();
		ColorBlob c = new ColorBlob(p);
		if(spot == '.') {
			clist.add(c);
			board[p.getx()][p.gety()]  = c;
		}
	}
	
	//predefined
	public void setPredefined(Point p) {
		char spot = board[p.getx()][p.gety()].getCharacter();
		Predefined pd = new Predefined(p);
		if(spot == '.') {
			plist.add(pd);
			board[p.getx()][p.gety()]  = pd;
		}
		else if(spot == 'P') {
			plist.remove(pd);
			board[p.getx()][p.gety()]  = new Spot(p.getx(), p.gety());
		}
		else {
			System.out.println("this point already belongs to other lists");
		}
	}
	
	
	//shared method
	public boolean checkcontains(ArrayList<Spot> spotlist, Spot obj) {
		if(spotlist.contains(obj)) {
			return true;
		}
		return false;
	};
	
	public void printlist(ArrayList<Spot> spotlist) {
		for(Spot obj: spotlist) {
			System.out.print(obj.getPosition()+ " ");
		}
		System.out.println();
	}
}
