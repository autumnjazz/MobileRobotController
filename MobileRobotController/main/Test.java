package main;

import java.util.ArrayList;

import basic.Point;
import mappackage.RealMap;
import repositorypackage.Repository;
import robotpackage.Robot;
import spotpackage.*;

public class Test {
    public static void main(String[] args) {
        Runnable runnable = new RunnableTest2();
        Thread thread01 = new Thread(runnable);
        Thread thread02 = new Thread(runnable);
 
        thread01.start();
        thread02.start();
    }
}
 
class Account_2 {
    int balance = 1000;
 
    /*
     * ����� ���� withdraw()�� ȣ��Ǿ��� �� �ܰ� �����ϸ� wait()�� ȣ���ؼ� �����尡 ��ü�� lock�� Ǯ�� �� ��ü��
     * waiting pool�� ���鼭 ������� �ٸ� �����忡�� �纸�ϰ� �ȴ�.
     */
    public synchronized void withdraw(int money) {
        /*
         * ���⼭ if�� ��� while���� ����� ������, ���� �����尡 Account��ü�� �����ϱ� ������ �ٽ� ����� ���� �ٽ�
         * �� �� ������ Ȯ���ؾ��ϱ� �����̴�.
         */
        while (balance < money) {
            try {
                wait();
            } catch (Exception e) {
            }
        }
        balance -= money;
    }
 
    /*
     * �ٸ� �����忡 ���ؼ� deposit()�޼��尡 ȣ��Ǿ� �ܰ� �����ϸ鼭 notify()�� ȣ���ϸ� ��ü�� wating pool����
     * ��ٸ��� �ִ� �����带 ����� �ȴ�.
     */
    public synchronized void deposit(int money) {
        balance += money;
        notify();
    }
}
 
class RunnableTest2 implements Runnable {
    Account_2 account = new Account_2();
 
    public void run() {
        while (account.balance > 0) {
            int money = (int) (Math.random() * 3 + 1) * 100;
            account.withdraw(money);
            System.out.println("balance : " + account.balance);
        }
        account.deposit(1000);
    }

}