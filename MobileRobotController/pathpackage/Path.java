package pathpackage;

import java.util.ArrayList;
import java.util.LinkedList;

import basic.Point;
import mappackage.Map;
import robotpackage.Robot;
import spotpackage.Predefined;

public class Path {
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
			m.setVisited(now_x, now_y, true);
			
			
			for (Predefined obj:m.plist) {
				if (!obj.getVisited()) {
					if (now_x == obj.getPosition().getx() && now_y == obj.getPosition().gety()) {
						int listSize = pathlist.size();
						System.out.println("listSize: "+listSize);
						
						while (true) {

							pathlist.add(listSize,p);
							if (p.getPrev_p() == null) {
								//처음을 제외한 나머지 추가의 경우, 앞선 경로의 마지막과 새로 추가하는 첫번쨰 경로가 이어져 있지않기 때문에 별도로 이어주자.
								if (listSize > 0) {
									p.setPrev_p(pathlist.get(listSize-1));
									System.out.println("경로를 잇기 위해서 "+p+ " 의 이전으로 "+pathlist.get(listSize-1));	
								}
								
								break;
							}
							p = p.getPrev_p();
						}
						m.clearVisited();
						queue.clear();
						queue.add(new Point(now_x,now_y));
						System.out.println("queue에 넣어주는 값:"+now_x+","+now_y);
						System.out.println(queue.size());
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
	
	public Point getPath(Point p) { //���� ��ǥ���� �Ķ����
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
	
	public Point getPath(int idx) { //���� ��ǥ���� �Ķ����
		Point next = new Point();
		if(idx == pathlist.size()-1) return null; //no more path
		next = pathlist.get(idx+1);
		if(next.getx() == -1) next = null;
		return next;
	}
	
	public void clearPath() {
		pathlist.clear();
	}
	
	public void printPath() {
		for(Point obj:pathlist) {
			System.out.print(obj +" -> ");
		}
		System.out.println("end");
	}
	
	
	public boolean checkmotion(Robot robot) {
		Point current = robot.getCurrent();
		Point prev = current.getPrev_p();
		
		double distance = calculateDistance(current, prev);
		
		if (distance == 1) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public double calculateDistance(Point p1, Point p2) {
		int disX = p1.getx() - p2.getx();
		int disY = p1.gety() - p2.gety();
		double distance = Math.pow((Math.pow(disX,2)+ Math.pow(disY,2)),1/2); 
		return distance;
	}
	
}

