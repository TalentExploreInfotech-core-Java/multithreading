package com.persi.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CountDownLatch;

public class Processor{

	private static BlockingQueue<Integer> queue= new ArrayBlockingQueue<Integer>(10);
	
	public static void producer() throws InterruptedException
	{
		Random random= new Random();
		int no;
		while (true)
		{
			Thread.sleep(1000);
			no= random.nextInt(100);
			queue.put(no);
			System.out.println("insertion successful::"+no);
		}
	}
	
	public static void consumer() throws InterruptedException 
	{
		int no;
		while(true)
		{
			Thread.sleep(3000);
			no=queue.take();
			System.out.println("Element thrown out::"+no);
		}
	}
	public static void main(String args[])
	{
		Thread t1= new Thread( new Runnable(){
			public void run()
			{
				try {
					producer();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		Thread t2= new Thread(new Runnable(){
			public void run()
			{
				try
				{
					consumer();
				}
				catch(InterruptedException ie)
				{
					ie.printStackTrace();
				}
			}
		});
		t1.start();
		t2.start();
		System.out.println("Thread is running...");
	}
	}
