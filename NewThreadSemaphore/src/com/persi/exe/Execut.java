package com.persi.exe;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

import com.persi.entity.Connection;
import com.persi.entity.ConnectionHandler;


public class Execut {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Connection c=new Connection(1,new Semaphore(4));
		ExecutorService service= Executors.newFixedThreadPool(10);
		for(int i=0;i<9;i++)
		{
			service.submit(new ConnectionHandler(c));
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
