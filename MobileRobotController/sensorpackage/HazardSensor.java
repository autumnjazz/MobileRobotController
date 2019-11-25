package sensorpackage;

import basic.Point;
import mappackage.RealMap;
import repositorypackage.Repository;
import spotpackage.Spot;

public class HazardSensor extends Sensor{
	PositionSensor ps = new PositionSensor();
	RealMap rm;
	
	
	public void setRM(RealMap rm) {
		this.rm = rm;
	}
	
	
	public Point location(Repository repo) {
		Point current = ps.location(repo);
		Point next = repo.p.getPath(current);
		return next;
	}

	public boolean checksensor(Point p) {
		return rm.board[p.getx()][p.gety()] == 'H'; 
	}

}
