package mappackage;
import java.util.ArrayList;

import basic.Point;
import spotpackage.*;
import robotpackage.Robot;

public class DynamicMap {
	Map m;
	private char board[][];
	public Point current;
	
	public void setDM(Map m, Point current) { 
		//실제지도 정보를 받아서 dynamic map에 그대로 그림으로써 초기화
		this.m = m; this.current = current;
		board = new char[m.row][m.col];
		for (int i = 0; i < m.row; i++) {
			for (int j = 0; j< m.col; j++) {
				board[i][j] = m.board[i][j].getCharacter();
			}
		}
		board[current.getx()][current.gety()] = '*'; //현재위치 표시
	}
	public void printBoard() {
		for (int i = 0; i < m.row; i++) {
			for (int j = 0; j< m.col; j++) {
				System.out.print(board[i][j]);
			}
			System.out.println();
		}
	}
	public void updateVisited(Point p) {
		int x = p.getx();
		int y = p.gety();
		board[x][y] = '-';
	}
	public void updateRobot(Point pre, Point p) {
		updateVisited(pre);
		int x = p.getx(); int y = p.gety();
		board[x][y] = '*';
		current = p;
	}
	public void updateHazard(Point p) {
		int x = p.getx();
		int y = p.gety();
		board[x][y] = 'H';
	}
	public void updateColorblob(Point p) {
		int x = p.getx();
		int y = p.gety();
		board[x][y] = 'C';
	}
}
