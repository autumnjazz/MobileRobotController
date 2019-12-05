package main;

import guipackage.MainFrame;
import guipackage.alert.SetMapSize;
import mappackage.RealMap;
import repositorypackage.Repository;
import robotpackage.Robot;

public class OperateExploration_GUI{
	public static void main(String[] args) {
        Runnable runnable = new RunnableTest();
        Thread thr = new Thread(runnable);
        thr.start();
    }
}


class RunnableTest implements Runnable {
    MainFrame main = new MainFrame();
 
    public void run() {
        main.startexplore();
    }

}
