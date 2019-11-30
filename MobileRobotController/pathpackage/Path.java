package pathpackage;

import java.util.ArrayList;
import java.util.LinkedList;

import basic.Point;
import mappackage.Map;
import spotpackage.Predefined;

public class Path implements CheckMotion{
	public ArrayList<Point> pathlist = new ArrayList();
	
	public void calculatePath(Map m, Point robot_p) {	
		LinkedList <Point> queue = new LinkedList <Point>();
		queue.add(robot_p);
		
		while(!queue.isEmpty()) {
			Boolean end_flag = true;
			
			for (Predefined obj:m.plist) {
				if (!obj.getVisited()) {
					end_flag = false;
				}	
			}
			
			if (end_flag) break;
			
			Point p =  queue.poll();
			int now_x = p.getx();
			int now_y = p.gety();
			m.visited[now_x][now_y] = true;
			
			for (Predefined obj:m.plist) {
				if (!obj.getVisited()) {
					if (now_x == obj.getPosition().getx() && now_y == obj.getPosition().gety()) {
						int listSize = pathlist.size();
						while (true) {
							if (p==null) break;
							pathlist.add(listSize,p);
							p = p.prev_p;
						}
						m.clearVisited();
						queue.clear();
						queue.add(new Point(now_x,now_y));
						obj.setVisited(true);
						break;
					}	
				}
			}

		
			if (now_x-1>=0 && m.visited[now_x-1][now_y] == false) {
				char temp = m.board[now_x-1][now_y].getCharacter();
				if (temp == '.' || temp == 'P') {
					queue.add(new Point(now_x-1, now_y,p));
				}
			}
			if (now_x+1<m.row && m.visited[now_x+1][now_y] == false) {
				char temp = m.board[now_x+1][now_y].getCharacter();
				if (temp == '.' || temp == 'P') {
					queue.add(new Point(now_x+1, now_y,p));
				}
			}
			if (now_y-1>=0 && m.visited[now_x][now_y-1] == false) {
				char temp = m.board[now_x][now_y-1].getCharacter();
				if (temp == '.' || temp == 'P') {
					queue.add(new Point(now_x, now_y-1,p));
				}
			}
			if (now_y+1<m.col && m.visited[now_x][now_y+1] == false) {
				char temp = m.board[now_x][now_y+1].getCharacter();
				if (temp == '.' || temp == 'P') {
					queue.add(new Point(now_x, now_y+1,p));	
				}
			}
		}
		
		queue.clear();
	}
	
	public Point getPath(Point p) { //현재 좌표값이 파라미터
		Point next = new Point();
		for(Point obj:pathlist) {
			if(obj.equals(p)) {
				int idx = pathlist.indexOf(obj);
				if(idx == pathlist.size()-1) return null; //no more path
				next = pathlist.get(idx+1);
			}
		}
		if(next.getx() == -1) next = null;
		return next;
	}
	
	public void printPath() {
		for(Point obj:pathlist) {
			System.out.print(obj +" -> ");
		}
		System.out.println("end");
	}
	
	
	public boolean checkmotion() {
		//TODO:
		return false;
	}
	
}
