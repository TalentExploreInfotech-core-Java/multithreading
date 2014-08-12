package com.persi.entity;

public class ConnectionHandler implements Runnable{
	Connection c;
	public ConnectionHandler(Connection c)
	{
		this.c=c;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(2000);
			c.getConnection();
			Thread.sleep(5000);
			c.releaseConnection();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
