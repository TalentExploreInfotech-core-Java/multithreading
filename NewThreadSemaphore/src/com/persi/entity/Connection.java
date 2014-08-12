package com.persi.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class Connection{

	//private int id;
	private Semaphore s;
	public Connection(int id,Semaphore s)
	{
		//this.id=id;
		this.s=s;
		
	}
	
	public void getConnection() throws InterruptedException
	{
		s.acquire();
		System.out.println("Got the connection::and no of connections available"+s.availablePermits());
	}
	public void releaseConnection() 
	{
		s.release();
		System.out.println("released the connection::and no of connections available"+s.availablePermits());
		
	}

	
	}
