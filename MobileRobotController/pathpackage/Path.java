package pathpackage;

import java.util.ArrayList;
import java.util.LinkedList;

import basic.Point;
import mappackage.Map;
import spotpackage.Predefined;

public class Path implements CheckMotion{
	public ArrayList<Point> pathlist = new ArrayList();
	
	
	
	public void calculatePath(Map m, Point p) {	
		
		System.out.println("calculatePath 실행");
		int robot_x= p.getx();
		int robot_y= p.gety();
		
		System.out.println("robot의 위치 : "+"("+robot_x+","+robot_y+")");
		
		for (int i=0;i<m.row;i++) {
			for (int j=0;j<m.col;j++) {
				System.out.print(m.board[i][j].getCharacter());
			}
			System.out.println();
		}
		
		bfs(p,m);
		System.out.println("pathlist 배열:");
		for (Point obj:pathlist) {
			System.out.println(obj.getx()+","+obj.gety());
		}
//		System.out.println("visited 배열:");
//		m.printVisited();
//		for(int i = 1; ; i++) {
//			pathlist.add(p);
//			if(i%2 !=0) x++;
//			else if (i%2 ==0) y++;
//			if(x >= m.row || y >= m.col) break;
//		}
		
	}
	
	public void bfs(Point robot_p, Map m) {
		LinkedList <Point> queue = new LinkedList <Point>();
		queue.add(robot_p);
		
		
		
		while(!queue.isEmpty()) {
			
			Boolean end_flag = true;
			// predefined 에 전부 방문 했으면 종료
			for (Predefined obj:m.plist) {
				// 아직 방문하지 않은 predefined 가 하나라도 있으면 끝내지 않는다.
				if (!obj.getVisited()) {
					end_flag = false;
				}	
			}
			
			if (end_flag) break;
			
			//해당 큐의 맨 앞에 있는(제일 먼저 저장된) 요소를 반환하고, 해당 요소를 큐에서 제거함.
			//만약 큐가 비어있으면 null을 반환함.
			Point p = (Point) queue.poll();
			int now_x = p.getx();
			int now_y = p.gety();
			System.out.println("로봇이 밟는 땅:" + now_x + " "+ now_y);
			m.visited[now_x][now_y] = true;
			
			
			
			System.out.println("predefined 지점:");
			for (Predefined obj:m.plist) {
				if (!obj.getVisited()) {
					if (now_x == obj.getPosition().getx() && now_y == obj.getPosition().gety()) {
						int listSize = pathlist.size();
						while (true) {
							if (p==null) break;
							pathlist.add(listSize,p);
							p = p.prev_p;
						}
						m.printVisited();
						// 하나의 predefined 를 찾았으니 전체적으로 초기화하고 다음 predefined 찾
						m.clearVisited();
						queue.clear();
						queue.add(new Point(obj.getPosition().getx(),obj.getPosition().gety() ));
						obj.setVisited(true);
						break;
					}	
					System.out.println(obj.getPosition().getx()+","+obj.getPosition().gety());
				}
				System.out.println();
			}

			
			
			// 위
			if (now_x-1>=0 && m.visited[now_x-1][now_y] == false) {
				char temp = m.board[now_x-1][now_y].getCharacter();
				if (temp == '.' || temp == 'P') {
					queue.add(new Point(now_x-1, now_y,p));
				}
			}
			// 아래
			if (now_x+1<m.row && m.visited[now_x+1][now_y] == false) {
				char temp = m.board[now_x+1][now_y].getCharacter();
				if (temp == '.' || temp == 'P') {
					queue.add(new Point(now_x+1, now_y,p));
				}
			}
			// 왼쪽
			if (now_y-1>=0 && m.visited[now_x][now_y-1] == false) {
				char temp = m.board[now_x][now_y-1].getCharacter();
				if (temp == '.' || temp == 'P') {
					queue.add(new Point(now_x, now_y-1,p));
				}
			}
			// 오른쪽
			if (now_y+1<m.col && m.visited[now_x][now_y+1] == false) {
				char temp = m.board[now_x][now_y+1].getCharacter();
				if (temp == '.' || temp == 'P') {
					queue.add(new Point(now_x, now_y+1,p));	
				}
			}
		}
		
		queue.clear();
	}
	
	public Point getPath(Point p) {
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
		//���� �ʿ�
		return false;
	}
	
}
