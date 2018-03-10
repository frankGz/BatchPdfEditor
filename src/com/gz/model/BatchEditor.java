package com.gz.model;

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
	
	public void start(){
		LinkedList<String> names = StudentNameScanner.scanNameList(list);
		Iterator<String> it = names.iterator();
		String name;
		try {
			while(it.hasNext()) {
				name = it.next();
				PDFeditor.addWaterMark(basemark, name, src, dest + "\\" + name + ".pdf");
				System.out.println("working on..." + name);
			}
		}catch(DocumentException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
	}

}
