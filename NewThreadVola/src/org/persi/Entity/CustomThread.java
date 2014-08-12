package org.persi.Entity;

public class CustomThread implements Runnable{
	private volatile boolean running=true;
	public void run()
	{
		while(running)
		{
			System.out.println("The thread is running");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("The thread is stopped...");
	}
	public void shutDown()
	{
		running=false;
	}

}
