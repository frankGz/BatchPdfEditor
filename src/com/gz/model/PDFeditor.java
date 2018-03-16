package com.gz.model;


import java.io.FileOutputStream;
import java.io.IOException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;


public class PDFeditor {
	
	
	public static String addWaterMark(String basemark, String name, String src, String dest) throws DocumentException, IOException {
		
		String statement = "";
		
		try {
			// io
			
			
			
			PdfReader pdfReader = new PdfReader(src);
			PdfStamper pdfStamper = new PdfStamper(pdfReader, new FileOutputStream(dest));
			
			// set font
			Font helvetica = new Font(FontFamily.HELVETICA, 12,Font.ITALIC, BaseColor.RED);
	        BaseFont bf_helv = helvetica.getCalculatedBaseFont(true);
			
			// in order to display Chinese char, use windows font base
	        //BaseFont bf_helv = BaseFont.createFont("C:/Windows/Fonts/simhei.ttf",BaseFont.IDENTITY_H,BaseFont.NOT_EMBEDDED); 
	        
	        Font helvetica_b = new Font(FontFamily.HELVETICA, 12);
	        BaseFont bf_helv_b = helvetica_b.getCalculatedBaseFont(true);
	        
	        // get page size, find the center
	        Rectangle crop = pdfReader.getCropBox(1);
	        float mid_x = (crop.getLeft() + crop.getRight()) / 2;
	        //float mid_y = (crop.getBottom() + crop.getTop()) / 2;
	        System.out.println(crop.getLeft() + "\n" +  crop.getRight() + "\n" + crop.getBottom() + "\n" + crop.getTop());
	        // find left up corner
	        
	        float x = crop.getRight() * 5 / 100 ;
	        float y = crop.getTop() * 95 / 100;
	        
			for(int i=1; i<= pdfReader.getNumberOfPages(); i++){

		          PdfContentByte content = pdfStamper.getUnderContent(i);
		          
		          content.beginText();
		          
		          //add watermark
		          content.setColorFill(BaseColor.LIGHT_GRAY);
		          content.setFontAndSize(bf_helv, 80);
		          content.showTextAligned(Element.ALIGN_CENTER, name, mid_x ,crop.getTop() * 6 / 10, 45f);
		          content.showTextAligned(Element.ALIGN_CENTER, basemark, mid_x , crop.getTop() * 4 / 10, 45f);
		          
		          //add name
		          content.setColorFill(BaseColor.BLACK);
		          content.setFontAndSize(bf_helv_b, 10);
		          content.showTextAligned(Element.ALIGN_LEFT, name, x, y, 0);
		          
		          //add copyright label
		          content.showTextAligned(Element.ALIGN_CENTER, basemark, mid_x, y, 0);
		          
		          String line = "！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！！";
		          content.showTextAligned(Element.ALIGN_CENTER, line, mid_x, y - 15, 0);
		          content.endText();
		     }
			
			pdfStamper.close();
			
		}catch(DocumentException e){
			statement += e.toString();
		}catch(IOException e){
			statement += e.toString();
		}
		return statement;
	}
	
	
	public static void main(String[] args) throws DocumentException, IOException {
		
		addWaterMark("this is a water mark","兆忖  兆忖","G:\\彿創\\2016 fall\\nats 1870\\ppt 2017 winter\\test.pdf", "C:\\Users\\Frank.Gz\\Desktop\\Data\\test\\aaa.pdf");
	}
	
}
