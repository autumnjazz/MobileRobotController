package sensorpackage;

import basic.Point;
import mappackage.RealMap;
import repositorypackage.Repository;

public class ColorBlobSensor extends Sensor{
	PositionSensor ps = new PositionSensor() ;
	RealMap rm;

	public void setRM(RealMap rm) {
		this.rm = rm;
	}
	
	public Point location(Repository repo, int idx) {
		Point current = ps.location(repo);
		Point result = new Point();
		int x = current.getx();
		int y = current.gety();
		switch(idx) {
		case 0: //up
			x--;
			if(x<0) break;
			result.setPoint(x, y);
			break;
		case 1: //down
			x++;
			if(x>=rm.row) break;
			result.setPoint(x, y);
			break;
		case 2: //left
			y--;
			if(y<0) break;
			result.setPoint(x, y);
			break;
		case 3: //right
			y++;
			if(y>=rm.col) break;
			result.setPoint(x, y);
			break;
		default:
			break;
		}
		if(result.getx() == -1) result = null;
		return result;
	}

	public boolean checksensor(Point p) {
		return rm.board[p.getx()][p.gety()] == 'C';
	}
	
	public boolean[] checksensorAll(Repository repo) {
		boolean[] result = {false, false, false, false};
		for(int i = 0; i<4; i++) {
			Point p = location(repo, i);
			if(p!=null) result[i] = checksensor(p);
		}
		return result;
	}

}
