package com.persi.exe;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import com.persi.entity.Processor;

public class Execut {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CountDownLatch latch=new CountDownLatch(12);
		ExecutorService service= Executors.newFixedThreadPool(4);
		for(int i=0;i<12;i++)
		{
			service.submit(new Processor(latch));
		}
		service.shutdown();
		System.out.println("services are shut down");
		try {
			latch.await();
			System.out.println("Latch await completed...");
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
