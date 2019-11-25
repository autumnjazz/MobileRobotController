package pathpackage;

import java.util.ArrayList;
import basic.Point;
import mappackage.Map;

public class Path implements CheckMotion{
	public ArrayList<Point> pathlist = new ArrayList();
	
	public void calculatePath(Map m, Point p) {		//Map �� ���� ��� ���
		int x= p.getx(); int y= p.gety();
		for(int i = 1; ; i++) {
			pathlist.add(p);
			if(i%2 !=0) x++;
			else if (i%2 ==0) y++;
			if(x >= m.row || y >= m.col) break;
		}
		
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