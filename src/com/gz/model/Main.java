package com.gz.model;

import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		String names, src, dest, basemark;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the path of your student name .txt file.");
		names = in.nextLine();
		System.out.println("Enter the path of your original PDF file.");
		src = in.nextLine();
		System.out.println("Enter the path of your output folder.");
		dest = in.nextLine();
		System.out.println("Enter your watermark prefix.");
		basemark = in.nextLine();
		
		BatchEditor b = new BatchEditor(src,dest,names,basemark);
		
		b.start();
		in.close();
	}
}
