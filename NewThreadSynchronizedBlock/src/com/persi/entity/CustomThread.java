package com.persi.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomThread{
	private List<Integer> longList1= new ArrayList<Integer>();
	private List<Integer> longList2= new ArrayList<Integer>();
	private Object lock1 =new Object();
	private Object lock2 =new Object();
	private Random random= new Random();
	public void addLongList1()
	{
		
		int no1=0;
		synchronized(lock1)
		{
		for(int i=0;i<500;i++)
		{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			no1= random.nextInt(10);
			longList1.add(no1);
		}
		}
	}
	
	public void addLongList2()
	{
		
		int no1=0;
		synchronized(lock2)
		{
		for(int i=0;i<500;i++)
		{
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			no1= random.nextInt(10);
			longList2.add(no1);
		}
		}
	}
	//private int count=0;
		public static void main(String args[])
		{
			final CustomThread custom= new CustomThread();
			Thread t1= new Thread( new Runnable(){
			public void run()
			{
				custom.addLongList1();
			}});
			
		Thread t2= new Thread( new Runnable(){
			public void run()
			{
				custom.addLongList2();
			}});
			
		t1.start();
		t2.start();
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			System.out.println("longList1.size()::"+custom.longList1.size());
			System.out.println("longList2.size()::"+custom.longList2.size());
		}
}
