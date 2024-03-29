package robotpackage;

import basic.Point;
import mappackage.DynamicMap;
import repositorypackage.Repository;
import sensorpackage.*;

public class Robot implements SIM{
	Point current = new Point();
	int currentidx = 0;
	public String message = "";
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

	public void setCurrent(Point p) {
		current = p;
	}
	public void detectSpot() {
		//detect and update hazard
		Point loc = hs.location(repo); //바로 다음 path 의 위험
		boolean hresult = hs.checksensor(loc);
		if(hresult) {
			message = message+ "H: "+loc + "\n";
			repo.dm.updateHazard(loc);
			repo.m.setHazard(loc);
		}
		//detect and update colorblob
		boolean[] cresult = cs.checksensorAll(repo);
		for(int i = 0; i<4; i++) { //상하좌우
			if(cresult[i]) {
				Point loc2 = cs.location(repo, i);
				message = message+ "C: "+loc2 + "\n";
				repo.dm.updateColorblob(loc2);
				repo.m.setColorblob(loc2);
			}
		}
	}
	
	public Point readpath() {
		return repo.p.getPath(currentidx);
	}
	
	public void move() { //잘못된 이동 구현
		Point next = readpath();
		if(next != null) {
			repo.dm.updateRobot(current, next);
			message = message+ "move from "+ current + " to " + next +"\n";
		}
		current = next;
		currentidx +=1;
	}
	
//	Point randommove() {
//		Point rand;		
//		return rand;
//	}
	
}

