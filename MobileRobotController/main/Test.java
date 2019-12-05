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
     * 출금을 위해 withdraw()가 호출되었을 때 잔고가 부족하면 wait()을 호출해서 쓰레드가 객체의 lock을 풀고 그 객체의
     * waiting pool에 들어가면서 제어권을 다른 쓰레드에게 양보하게 된다.
     */
    public synchronized void withdraw(int money) {
        /*
         * 여기서 if문 대신 while문을 사용한 이유는, 여러 쓰레드가 Account객체를 공유하기 때문에 다시 깨어났을 때도 다시
         * 한 번 조건을 확인해야하기 때문이다.
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
     * 다른 쓰레드에 의해서 deposit()메서드가 호출되어 잔고가 증가하면서 notify()를 호출하면 객체의 wating pool에서
     * 기다리고 있던 쓰레드를 깨우게 된다.
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