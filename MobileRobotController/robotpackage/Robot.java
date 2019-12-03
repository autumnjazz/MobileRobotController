package robotpackage;

import basic.Point;
import mappackage.DynamicMap;
import repositorypackage.Repository;
import sensorpackage.*;

public class Robot implements SIM{
	Point current = new Point();
	int currentidx = 0;
	public ColorBlobSensor cs = new ColorBlobSensor();
	public HazardSensor hs = new HazardSensor();
	public PositionSensor ps = new PositionSensor();
	Repository repo;
	
	public Robot (Repository repo) {
		this.repo = repo;
	}
	
	public Point getCurrent() {
		current = ps.location(repo);
		return current;
	}
	
	public void setCurrent(int x, int y) {
		current.setPoint(x, y);
	}
	
	public void detectSpot() {
		//detect and update hazard
		Point loc = hs.location(repo); //�ٷ� ���� path �� ����
		boolean hresult = hs.checksensor(loc);
		if(hresult) {
			System.out.println("H: "+loc);
			repo.dm.updateHazard(loc);
			repo.m.setHazard(loc);
			//repo.p.avoidHarzard(loc);
			// 
		}
		//detect and update colorblob
		boolean[] cresult = cs.checksensorAll(repo);
		for(int i = 0; i<4; i++) { //�����¿�
			if(cresult[i]) {
				Point loc2 = cs.location(repo, i);
				System.out.println("C: "+loc2);
				repo.dm.updateColorblob(loc2);
				repo.m.setColorblob(loc2);
			}
		}
	}
	
	public Point readpath() {
		return repo.p.getPath(currentidx);
	}
	
	public void move() {
		Point next = readpath();
		
		int randomNum = (int)(Math.random()*100)+1;
		if (randomNum < 10) {
			next = move_error(next);
		}
		
		if(next != null) {
			repo.dm.updateRobot(current, next);
		}
		current = next;
		currentidx +=1;
	}
	
	public Point move_error(Point next) {
		System.out.println("move_error");
		// 별다른 변화가 없으면 next 를 그대로 반
		Point newNext = next;
		Point current = next.getPrev_p();
		if (next.getx()==current.getx()) {
			// 아래
			if (next.gety()-current.gety() == 1) {
				// 아래 쪽으로 한 칸 더 가도 칸을 벗어나지 않는다면
				if (point_val(next.getx(),next.gety()+1)) {
					newNext.setPoint(next.getx(),next.gety()+1,current);
				}
			}
			// 위
			else if (next.gety()-current.gety() == -1) {
				// 위쪽으로 한 칸 더 가도 칸을 벗어나지 않는다면
				if (point_val(next.getx(),next.gety()-1)) {
					newNext.setPoint(next.getx(),next.gety()-1,current);
				}
			}
		}
		else {
			// 오른
			if (next.getx()-current.getx() == 1) {
				// 아래 쪽으로 한 칸 더 가도 칸을 벗어나지 않는다면
				if (point_val(next.getx()+1,next.gety())) {
					newNext.setPoint(next.getx()+1,next.gety(),current);
				}
			}
			// 왼
			// 오른
			if (next.getx()-current.getx() == -1) {
				// 아래 쪽으로 한 칸 더 가도 칸을 벗어나지 않는다면
				if (point_val(next.getx()-1,next.gety())) {
					newNext.setPoint(next.getx()-1,next.gety(),current);
				}
			}
		}
		return newNext;
	}
	
	public Boolean point_val(int x, int y) {
		int row = repo.m.row;
		int col = repo.m.col;
		
		if (0<= x && x < col && 0<=y && y < row) {
			return true;
		}
		else {
			return false;
		}
		
	}
	
//	Point randommove() {
//		Point rand;		
//		return rand;
//	}
	
}

