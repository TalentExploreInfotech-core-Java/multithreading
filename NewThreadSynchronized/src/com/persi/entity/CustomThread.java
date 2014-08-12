package com.persi.entity;

public class CustomThread{
	private int count=0;
	public  synchronized void increment()
	{
		for(int i=0;i<1000;i++)
		{
			count++;
		}
	}
	public void doWork()
	{
		Thread t1=new Thread(new Runnable(){
			public void run()
			{
				increment();
			}},"t1");
		Thread t2= new Thread(new Runnable(){
			public void run()
			{
				increment();
			}},"t2");
		t1.start();
		t2.start();
		try {
			t1.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			t2.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(" The value of count is::"+count);
			}
		public static void main(String args[])
		{
			CustomThread custom= new CustomThread();
			custom.doWork();
			//System.out.println(" The value of count is::"+custom.count);
		}
		}
