package com.persi.service;

import java.util.WeakHashMap;

public class exe {
	static WeakHashMap map=new WeakHashMap(); 
	static
	{
		
		
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String key="key";
		map.put(key, "lue");
		key=null;
		System.gc();
		System.out.println(map);
		System.gc();
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(map.get("key"));

	}

}
