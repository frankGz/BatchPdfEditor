package com.gz.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;

public class MergePDF {
	
	public static String mergePDF(String path) {
		
		String statement = "";
		List<InputStream> list = new ArrayList<InputStream>();
		
		File dir = new File(path);
		File[] files = dir.listFiles();
		
		if(!dir.isDirectory()) {
			return "Entry is not a directory!";
		}
		
		if(files  == null) {
			return "No files in the directory!";
		}
		try {
			for (File f : files) {
			     //System.out.println(getFileExtension(f));
				//check if the file is PDF
				if(getFileExtension(f).equals("pdf")) {
					//add current PDF into processing list
					list.add(new FileInputStream(new File(f.getAbsolutePath())));
					
				}
			}
			if(files.length != 0) {
				OutputStream outputStream = new FileOutputStream(new File(path + "\\" + files[0].getParentFile().getName() + "-Collection.pdf"));
				mergePdf(list, outputStream);
			}else {
				return "No PDF file found!";
			}
			
		}catch (FileNotFoundException e)
		{
			statement += e.toString();
		}
		catch (DocumentException e)
		{
			statement += e.toString();
		}
		catch (IOException e)
		{
			statement += e.toString();
		}


		
		return statement;
	}
	
	/*
	 * merge every PDF in the processing list and output
	 */
	private static void mergePdf(List<InputStream> list, OutputStream outputStream) throws DocumentException, IOException
	{
			Document document = new Document();
			PdfWriter pdfWriter = PdfWriter.getInstance(document, outputStream);
			document.open();
			PdfContentByte pdfContentByte = pdfWriter.getDirectContent();

			for (InputStream inStr : list)
			{
					PdfReader pdfReader = new PdfReader(inStr);
					for (int i = 1; i <= pdfReader.getNumberOfPages(); i++)
					{
							document.newPage();
							PdfImportedPage page = pdfWriter.getImportedPage(pdfReader, i);
							pdfContentByte.addTemplate(page, 0, 0);
					}
			}

			outputStream.flush();
			document.close();
			outputStream.close();
	}

	
	/*
	 * get file extension
	 */
	private static String getFileExtension(File file) {
	    String name = file.getName();
	    try {
	        return name.substring(name.lastIndexOf(".") + 1);
	    } catch (Exception e) {
	        return "";
	    }
	}
	
	public static void main(String[] args) {
		mergePDF("C:\\Users\\Frank.Gz\\Desktop\\Data\\test\\test");
	}
}


