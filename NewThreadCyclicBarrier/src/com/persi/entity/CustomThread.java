package com.persi.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CustomThread implements Runnable{

	private int id;
	CyclicBarrier barrier;
	public CustomThread(int id, CyclicBarrier barrier)
	{
		this.id=id;
		this.barrier=barrier;
		
	}
	@Override
	public void run() {
		System.out.println("Starting...."+id);
		try
		{
			
			Thread.sleep(1000);
		}
		catch(InterruptedException ie)
		{
			ie.printStackTrace();
		}
		try {
			barrier.await();
			System.out.println("Completed and passed the barrier...."+id);
			Thread.sleep(2000);
			
			barrier.await();
			System.out.println("Completed and passed the barrier second time...."+id);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (BrokenBarrierException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Completed and passed the barrier...."+id);
		
	}
	
	}
