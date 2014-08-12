package com.persi.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class CustomThread implements Runnable{

	private int id;
	public CustomThread(int id)
	{
		this.id=id;
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
		System.out.println("Completed...."+id);
		
	}
	
	}
