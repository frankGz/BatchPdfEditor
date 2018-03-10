package com.gz.model;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;


public class CopyAndRename {
	/*
	 * src: source pdf file
	 * dest: destnation folder path
	 * nameList: list of every name from txt
	 * 
	 */
	public static Map<String,String> copyAndRename(String src, String dest, LinkedList<String> nameList) throws Exception {
		
		String urls = src;
		String urld;
		
		Map<String,String> fileMapping = new HashMap<String,String>();
		Iterator<String> it = nameList.iterator();
		
		while(it.hasNext()) {
			urld = (String) it.next();
			copy(urls, dest + "\\" +  urld + ".pdf");
			fileMapping.put(urld, dest + "\\" +  urld + ".pdf");
			//System.out.println(it.next());
		}
		
		return fileMapping;
		
	}
	
	private static void copy(String url1, String url2) throws Exception {
		FileInputStream in = new FileInputStream(new File(url1));
		FileOutputStream out = new FileOutputStream(new File(url2));
		byte[] buff = new byte[512];
		int n = 0;
		System.out.println("复制文件：" + "\n" + "源路径：" + url1 + "\n" + "目标路径："
		+ url2);
		while ((n = in.read(buff)) != -1) {
		out.write(buff, 0, n);
		}
		out.flush();
		in.close();
		out.close();
		System.out.println("复制完成");
	}
	
	
	/*
	public static void main(String[] args) {
		LinkedList<String> nameList = StudentNameScanner.scanNameList("C:\\Users\\Frank.Gz\\Desktop\\name.txt");
		Map<String,String> m = null;
		try {
			m = copyAndRename("G:\\资料\\2016 fall\\nats 1870\\ppt 2017 winter\\Lesson 04 - slides.pdf","C:\\Users\\Frank.Gz\\Desktop\\Data\\test",nameList);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(m.toString());

	}
	*/
	
		
}
