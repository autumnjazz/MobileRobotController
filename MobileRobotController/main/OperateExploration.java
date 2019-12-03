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
	RealMap rm; //repo�� ���� �ȵ�
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

        rm = new RealMap(repo.m); //���� ������ ����
        robot.hs.setRM(rm);
        robot.cs.setRM(rm);

        rm = new RealMap(repo.m); //repository �� map ���� ���� ���� ����
        robot.hs.setRM(rm); //�κ��� hazard sensor �� ���� ���� ����
        robot.cs.setRM(rm); //�κ��� colorblob sensor�� ���� ���� ����

	}
	
	public void inputrobotinfo() {
		System.out.print("\nStart coordinate: ");
        int x,y;
        x = sc.nextInt();
        y = sc.nextInt();
        robot.setCurrent(x, y); //ù ���� ��ġ �ޱ�
        Point p = new Point(x,y); 
        repo.setDM(p); //dynamic map(���� �������� �κ�)�� ���� ��ġ ǥ��
        
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
			System.out.print("Next Path after detecting: ");
			System.out.println(robot.readpath());
			repo.p.printPath();

			robot.move();
			Boolean checkmotionFlag = repo.p.checkmotion(robot);
			// 에러가 난 경
			if (!checkmotionFlag) {
				// 뒤로 가는 함수가 굳이 필요한가? 그냥 두 칸 이동한 곳에서 경로 재생성하니까 문제 없을 듯 
				repo.p.clearPath();
			}
			System.out.println("continue exploring? (y/n) : ");
			
			c = sc.next().charAt(0);
		}while(c != 'n');
		
		
	}
	
	public static void main(String[] args) {
		OperateExploration oe = new OperateExploration();
		
		//�غ�
		oe.inputmapinfo();
		oe.inputrobotinfo();
		oe.createpath();
		oe.setreal();
		oe.printall();
		
		//����
		System.out.println("Start Exploring? (y/n): ");
		Scanner sc = new Scanner(System.in); char c;
		if(sc.next().charAt(0) == 'y') {
			oe.explore();
			oe.printall();
		}
		

	}

}
