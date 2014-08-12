
package com.persi.Entity;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Reentrant {
	private int count=0;
	private Lock lock= new ReentrantLock();
	private Condition cond=lock.newCondition();
	public void firstThread()
	{
		lock.lock();
		try
		{
			System.out.println("Entered into the first lock...");
			cond.await();
			for(int i=0;i<1000;i++)
			{
				count++;
			}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally
			{
				lock.unlock();
				System.out.println("first thread is unlocking the lock");
			}
		
		}
	
	public void secondThread()
	{
		lock.lock();
		try
		{
			System.out.println("Entered into second lock...");
			
		for(int i=0;i<1000;i++)
		{
			count++;
		}
		}
		finally
		{
			System.out.println("press Enter to resume...");
			new Scanner(System.in).nextLine();
			cond.signal();
			System.out.println("second thread has called signal");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			lock.unlock();
			System.out.println("second thread is unlocking the lock");
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final Reentrant r1= new Reentrant();
		Thread t1= new Thread(new Runnable(){
			public void run()
			{
				r1.firstThread();
			}
		});
		Thread t2= new Thread(new Runnable(){
			public void run()
			{
				r1.secondThread();
			}
		});
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("the final value of count is "+r1.count);

	}

}
