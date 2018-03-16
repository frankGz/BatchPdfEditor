package com.gz.model;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import com.itextpdf.text.DocumentException;

public class BatchEditor {
	
	String src, dest, list, basemark;
	
	public BatchEditor(String src, String dest, String list, String basemark) {
		this.src = src;
		this.dest = dest;
		this.list = list;
		this.basemark = basemark;
	}
	/*
	 * Start creating edited PDF, if returning string is "", then everything goes OK.
	 * If some thing goes wrong, returning string contains all the e.printStackTrace()
	 * 
	 */
	public String start(){
		
		//get the file name of the original pdf w/o extension
		File f = new File(src);
		String fileName = f.getName().replaceFirst("[.][^.]+$", "");
		
		new File(dest + "\\" +  fileName).mkdirs();
		
		String statement = "";
		String current;
		LinkedList<String> names = StudentNameScanner.scanNameList(list);
		Iterator<String> it = names.iterator();
		String name;
		try {
			while(it.hasNext()) {
				name = it.next();
				current = dest + "\\" +  fileName + "\\" + name + ".pdf";
				statement += PDFeditor.addWaterMark(basemark, name, src, dest + "\\" +  fileName + "\\" + name + ".pdf");
				System.out.println("working on..." + current);
			}
		}catch(DocumentException e){
			statement += e.toString();
		}catch(IOException e){
			statement += e.toString();
			
		}
		return statement;
	}

}
