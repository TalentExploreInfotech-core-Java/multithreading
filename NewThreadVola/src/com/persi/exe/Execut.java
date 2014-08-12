package com.persi.exe;

import java.util.Scanner;

import org.persi.Entity.CustomThread;

public class Execut {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CustomThread thread=new CustomThread();
		Thread t1=new Thread(thread);
		t1.start();
		System.out.println("Press Enter to Stop...");
		Scanner scanner=new Scanner(System.in);
		String str= scanner.nextLine();
		thread.shutDown();

	}

}
