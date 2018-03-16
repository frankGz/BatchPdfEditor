package com.gz.model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class StudentNameScanner {
	
	public static LinkedList<String> scanNameList(String path){
		
		LinkedList<String> nameList = new LinkedList<String>();
			try {
				//read file
				BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)),
	                "gbk"));
			String line;
		    while ((line = br.readLine()) != null) {
		    	nameList.add(line);
		    }
		    br.close();
			
		}catch (Exception e) {
            System.err.println("read errors :" + e);
        }
		//Boolean b = nameList.isEmpty();
		return nameList;
	}
	/*
	public static void main(String[] args) {
		LinkedList<String> nameList = scanNameList("C:\\Users\\Frank.Gz\\Desktop\\name.txt");
		System.out.print(nameList.toString());
	}
	*/
}
