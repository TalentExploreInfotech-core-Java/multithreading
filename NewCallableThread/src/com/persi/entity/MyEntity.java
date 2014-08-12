package com.persi.entity;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class MyEntity {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ExecutorService executor=Executors.newCachedThreadPool();
		Future<Integer> future=executor.submit(new Callable<Integer>(){
			public Integer call() throws IOException
			{
				Random random=new Random();
				int duration= random.nextInt(2000);
				if(duration>200)
				{
					throw new IOException("Duration for sleeping is very long::"+duration);
				}
				try {
					Thread.sleep(duration);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return duration;				
			}
		});
		executor.shutdown();
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			System.out.println(future.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			System.out.println("The cause of the exception is::"+e.getMessage());
			//e.printStackTrace();
		}
	}

}
