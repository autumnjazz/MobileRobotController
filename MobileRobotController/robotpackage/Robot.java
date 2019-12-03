package robotpackage;

import basic.Point;
import mappackage.DynamicMap;
import repositorypackage.Repository;
import sensorpackage.*;

public class Robot implements SIM{
	Point current = new Point();
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
		Point loc = hs.location(repo);
		boolean hresult = hs.checksensor(loc);
		if(hresult) {
			repo.dm.updateHazard(loc);
			repo.m.setHazard(loc);
			repo.p.avoidHarzard(loc);
			// 
		}
		//detect and update colorblob
		boolean[] cresult = cs.checksensorAll(repo);
		for(int i = 0; i<4; i++) {
			if(cresult[i]) {
				Point loc2 = cs.location(repo, i);
				System.out.println("C: "+loc);
				repo.dm.updateColorblob(loc2);
				repo.m.setColorblob(loc2);
			}
		}
	}
	
	public Point readpath() {
		return repo.p.getPath(current);
	}
	
	public void move() { 
		Point next = readpath();
		if(next != null) {
			repo.dm.updateRobot(current, next);
		}
		current = next;
	}
	

	
}

