package mappackage;

import java.util.Random;

import basic.Point;
import robotpackage.Robot;
import spotpackage.*;

public class RealMap {
	Map m;
	public char board[][];
	public int col; public int row;
	
	public RealMap(Map m) {
		this.m = m;
		this.col = m.col; this.row = m.row;

		board = new char[m.row][m.col];
		for (int i = 0; i < m.row; i++) {
			for (int j = 0; j< m.col; j++) {
				board[i][j] = m.board[i][j].getCharacter();
			}
		}
		int mapsize = (col * row);
		
		//랜덤으로 hazard blob & color blob 추가! 주석 ㄴㄴ
		for(int i =0; i<mapsize/5; i++) {
			if(i%2==0) addHazard();
			else addColorblob();
		}
	}
	
	Point randomPoint() {
		Random random = new Random();
		int x = random.nextInt(row);
		int y = random.nextInt(col);
		return new Point(x,y);
	}
	
	void addHazard() {
		Point hp = randomPoint();
		if(!m.checkcontains(hp)) {
			board[hp.getx()][hp.gety()] = 'H';	
		}
	}
	void addColorblob() {
		Point cp = randomPoint();
		if(!m.checkcontains(cp)) {
		board[cp.getx()][cp.gety()] = 'C';
		}
	}
	
	//Only for Test!
	public void printBoard() {
		System.out.println("\n#Real Map Board: ");
		for (int i = 0; i < row; i++) {
			for (int j = 0; j< col; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
}
