package com.gz.model;

import javax.swing.JFrame;
import com.gz.model.UI.*;

public class Main {
	
	public static void main(String[] args) {
		/*String names, src, dest, basemark;
		
		Scanner in = new Scanner(System.in);
		System.out.println("Enter the path of your student name .txt file.");
		names = in.nextLine();
		System.out.println("Enter the path of your original PDF file.");
		src = in.nextLine();
		System.out.println("Enter the path of your output folder.");
		dest = in.nextLine();
		System.out.println("Enter your watermark prefix.");
		basemark = in.nextLine();*/
		
		UIFrame frame = new UIFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("PDF Manager");
		frame.pack();
		frame.setVisible(true);
		
		
		
		//BatchEditor b = new BatchEditor(src,dest,names,basemark);
		
		//b.start();
		//in.close();
	}
}
