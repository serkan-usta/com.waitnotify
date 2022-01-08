package WaitNotifydetails;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class WaitNotify{
    Object lock = new Object();

    public void thread1Function(){

        synchronized(lock) {
            System.out.println("Thread 1 working....");
            System.out.println("Thread 1 is waiting to wake up by Thread2 ...");
            
            try {
                lock.wait(); // wait() method
            } catch (InterruptedException ex) {
                Logger.getLogger(WaitNotify.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            System.out.println("Thread 1 woke up and go on...");
           
        }
        
    }
    public void thread2Function() {
        Scanner scanner = new Scanner(System.in);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ex) {
            Logger.getLogger(WaitNotify.class.getName()).log(Level.SEVERE, null, ex);
        }
        synchronized(lock) {
            System.out.println("Thread 2 working ....");
            
            System.out.println("Press the enter key buttom to go on ....");
            
            scanner.nextLine();
            
            
            lock.notify();  //notify() method
            System.out.println("I woke up thanks.Please wait 2 sec. and I am going...");
            
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                Logger.getLogger(WaitNotify.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }

    }

}
