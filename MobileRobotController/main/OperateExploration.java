package main;
import java.util.Random;
import java.util.Scanner;

import basic.Point;
import mappackage.*;
import pathpackage.Path;
import repositorypackage.Repository;
import robotpackage.Robot;
import spotpackage.*;

public class OperateExploration {
	
	public Repository repo = new Repository();
	RealMap rm; //repo에 저장 안됨
	public Robot robot = new Robot(repo);
	
	Scanner sc = new Scanner(System.in);
	
	public void inputmapinfo() {
		
		System.out.print("Map Size: ");
        int a,b,c,d;
        a = sc.nextInt();
        b = sc.nextInt();
        repo.m.initBoard(a, b);
        
        System.out.println("\nEnter -1 to quit");
        do {
	        System.out.print("Set Hazard: ");
	        c = sc.nextInt();
	        if(c==-1) break;
	        if(c >= a) System.out.println("index out of bound");
	        d = sc.nextInt();
	        if(d==-1) break;
	        if(d >= b) System.out.println("index out of bound");
	        repo.m.setHazard(c, d);
        }while(true);
        
        System.out.println("\nEnter -1 to quit");
        do {
	        System.out.print("Set Predefined: ");
	        c = sc.nextInt();
	        if(c==-1) break;
	        if(c >= a) System.out.println("index out of bound");
	        d = sc.nextInt();
	        if(d==-1) break;
	        if(d >= b) System.out.println("index out of bound");
	        repo.m.setPredefined(c, d);
        }while(true);
        
	}
	
	public void setreal() {
        rm = new RealMap(repo.m); //repository 의 map 으로 실제 지도 생성
        robot.hs.setRM(rm); //로봇의 hazard sensor 에 실제 지도 정보
        robot.cs.setRM(rm); //로봇의 colorblob sensor에 실제 지도 정보
	}
	
	public void inputrobotinfo() {
		System.out.print("\nStart coordinate: ");
        int x,y;
        x = sc.nextInt();
        y = sc.nextInt();
        robot.setCurrent(x, y); //첫 시작 위치 받기
        Point p = new Point(x,y); 
        repo.setDM(p); //dynamic map(실제 보여지는 부분)에 현재 위치 표시
        
	}
	
	public void createpath() { 
		repo.p.calculatePath(repo.m, robot.getCurrent());
	}

	
	public void printall() {
		repo.printMap();
		repo.printDMap();
		rm.printBoard();
		repo.printPath();
	}
	
	public void explore() {
		char c;
		do {
			System.out.println("\n#######EXPLORING....#######");
			if(robot.readpath() == null) {
				System.out.println("finished exploring!");
				break;
			}
			repo.printDMap();
			System.out.print("Next path before detecting: ");
			System.out.println(robot.readpath());
			robot.detectSpot();
			createpath();
			System.out.print("Path after detecting: ");
			System.out.println(robot.readpath());
			robot.move();
			System.out.println("continue exploring? (y/n) : ");
			
			c = sc.next().charAt(0);
		}while(c != 'n');
		
		
	}
	
	public static void main(String[] args) {
		OperateExploration oe = new OperateExploration();
		
		//준비
		oe.inputmapinfo();
		oe.inputrobotinfo();
		oe.createpath();
		oe.setreal();
		oe.printall();
		
		//시작
		System.out.println("Start Exploring? (y/n): ");
		Scanner sc = new Scanner(System.in); char c;
		if(sc.next().charAt(0) == 'y') {
			oe.explore();
			oe.printall();
		}
		

	}

}
