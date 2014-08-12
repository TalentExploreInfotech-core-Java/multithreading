package com.persi.exe;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import com.persi.entity.CustomThread;

public class Execut {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService service= Executors.newFixedThreadPool(5);
		CyclicBarrier barrier=new CyclicBarrier(4);
		for(int i=0;i<9;i++)
		{
			service.submit(new CustomThread(i,barrier));
		}
		service.shutdown();
		System.out.println("Now service will shutdown");
		try {
			service.awaitTermination(2, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Now service will terminate after a day");

	}

}
