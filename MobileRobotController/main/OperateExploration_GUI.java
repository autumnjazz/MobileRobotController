package main;

import guipackage.MainFrame;
import guipackage.alert.SetMapSize;
import mappackage.RealMap;
import repositorypackage.Repository;
import robotpackage.Robot;

public class OperateExploration_GUI {
	MainFrame main;
	
	public Repository repo = new Repository();
	RealMap rm;
	public Robot robot = new Robot(repo);
	
	public OperateExploration_GUI() {
		main = new MainFrame();
        repo.m.initBoard(main.row, main.col);
		main.showFrame();
//		//TODO: while();
//		repo.m.setHazard(
//				main.settingCard.blobPanel.hazardset);
//		repo.m.setPredefined(
//				main.settingCard.blobPanel.predefinedset);
		
	}
	
	
	
	
	public static void main(String[] args) {
		new OperateExploration_GUI();
		
	}
}
