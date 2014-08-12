package com.persi.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Processor implements Runnable{

	private CountDownLatch latch;
	public Processor(CountDownLatch latch)
	{
		this.latch=latch;
	}
	@Override
	public void run() {
		System.out.println("Starting....");
		try
		{
			Thread.sleep(1000);
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
		System.out.println("Completed....");
		latch.countDown();
	}
	
	}
