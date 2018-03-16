package com.gz.model;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.filechooser.FileNameExtensionFilter;



public class UI
{

	/*public static void main(String[] args) 
	{
		BasicInterfaceFrame frame = new BasicInterfaceFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("UserInterface");
		frame.pack();
		frame.setVisible(true);

	}*/
	
	public static class UIFrame extends JFrame implements ActionListener
	{
		static final long serialVersionUID = 42L;
		
		private JTextField choose_pdf_field; JButton choose_pdf = new JButton("ѡ��");
		private JTextField choose_txt_field; JButton choose_txt = new JButton("ѡ��");
		private JTextField store_file_field; JButton store_file = new JButton("ѡ��");
		private JTextField merge_pdf_field; JButton merge_pdf = new JButton("ѡ��");
		private JTextField watermark;
		
		JButton confirm = new JButton("OK");
		
		private JFileChooser jfc = new JFileChooser();
		private String pdfpath = new String();
		private String txtpath = new String();
		private String storepath = new String();
		private String mergepath = new String();
		
		
		public UIFrame()
		{
			choose_pdf_field = new JTextField(30);
			choose_txt_field = new JTextField(30);
			store_file_field = new JTextField(30);
			watermark = new JTextField(38);
			merge_pdf_field = new JTextField(30);
			
			choose_pdf.addActionListener(this);
			choose_txt.addActionListener(this);
			store_file.addActionListener(this);
			confirm.addActionListener(this);
			merge_pdf.addActionListener(this);
			
			JPanel banner = new JPanel();
			JLabel str = new JLabel("��ӭʹ��PDF����ˮӡ������ v1.0");
			banner.add(str);
			//banner.setAlignmentX(Component.LEFT_ALIGNMENT);
			
			JPanel pdfpanel = new JPanel(); 
			//JPanel choosepdf = new JPanel(); choosepdf.add(choose_pdf);
			Box box1 = Box.createHorizontalBox();
			box1.add(choose_pdf_field);
			box1.add(choose_pdf);
			pdfpanel.add(box1);
			pdfpanel.setBorder(new TitledBorder(new EtchedBorder(), "ѡ��PDFԭ��"));
			
			JPanel txtpanel = new JPanel(); 
			//JPanel choosetxt = new JPanel(); choosetxt.add(choose_txt);
			Box box2 = Box.createHorizontalBox();
			box2.add(choose_txt_field);
			box2.add(choose_txt);
			txtpanel.add(box2);
			txtpanel.setBorder(new TitledBorder (new EtchedBorder(),"ѡ��һ��.txt������һ��һ�����֣��ݲ�֧����������"));
			
			JPanel storepanel = new JPanel(); 
			JPanel store = new JPanel(); store.add(store_file);
			Box box3 = Box.createHorizontalBox();
			box3.add(store_file_field);
			box3.add(store_file);
			storepanel.add(box3);
			storepanel.setBorder(new TitledBorder (new EtchedBorder(),"ѡ��Ҫ�����λ��"));
			
			JPanel watermark_text = new JPanel();
			Box box4 = Box.createHorizontalBox();
			box4.add(watermark);
			watermark_text.add(box4);
			watermark_text.setBorder(new TitledBorder (new EtchedBorder(),"����һ��������Ϊˮӡ��ҳü�װ壨�ݲ�֧�����ģ�"));
			
			JPanel confirmpanel = new JPanel();
			confirmpanel.add(confirm);
			confirmpanel.setAlignmentX(CENTER_ALIGNMENT);
			
			JPanel mergepanel = new JPanel();
			Box box5 = Box.createHorizontalBox();
			box5.add(merge_pdf_field);
			box5.add(merge_pdf);
			mergepanel.add(box5);
			mergepanel.setBorder(new TitledBorder (new EtchedBorder(), "Merging all pdf files under the directory"));
			
			
			
			// add all components to contentpanel
			JPanel contentpanel = new JPanel();
			contentpanel.setLayout(new BoxLayout(contentpanel, BoxLayout.Y_AXIS));
			contentpanel.add(banner);
			contentpanel.add(Box.createRigidArea(new Dimension(0,10)));
			contentpanel.add(pdfpanel);
			contentpanel.add(Box.createRigidArea(new Dimension(0,10)));
			contentpanel.add(txtpanel);
			contentpanel.add(Box.createRigidArea(new Dimension(0,10)));
			contentpanel.add(storepanel);
			contentpanel.add(Box.createRigidArea(new Dimension(0,10)));
			contentpanel.add(watermark_text);
			contentpanel.add(Box.createRigidArea(new Dimension(0,10)));
			contentpanel.add(confirmpanel);
			contentpanel.add(Box.createRigidArea(new Dimension(0,10)));
			contentpanel.add(mergepanel);
			
			
			this.setContentPane(contentpanel);
		}
		
		public void actionPerformed (ActionEvent ae)
		{
			Object source = ae.getSource();
			File selectedfile;
			
			// reset filter
			jfc.resetChoosableFileFilters();
			
			if (source == choose_pdf || source == choose_txt || source == store_file || source == merge_pdf)
			{	
				if (source == choose_pdf)
				{
					jfc.setDialogTitle("Choose PDF file");
					jfc.setAcceptAllFileFilterUsed(false);
					FileNameExtensionFilter filter = new FileNameExtensionFilter("PDF file(*.pdf)", "pdf");
					jfc.addChoosableFileFilter(filter);
				}else
					if (source == choose_txt)
					{
						jfc.setDialogTitle("Choose TXT file");
						jfc.setAcceptAllFileFilterUsed(false);
						FileNameExtensionFilter filter = new FileNameExtensionFilter("TXT file(*.txt)","txt");
						jfc.addChoosableFileFilter(filter);
					}else
						if (source == store_file)
						{
							jfc.setDialogTitle("Choose target location");
							jfc.setAcceptAllFileFilterUsed(true);
							//jfc.setFileFilter(new FileNameExtensionFilter("All Files","All Files"));
							jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
						}else
						{
							jfc.setDialogTitle("Choose target directory");
							jfc.setAcceptAllFileFilterUsed(true);
							//jfc.setFileFilter(new FileNameExtensionFilter("All Files","All Files")); replaced by last line
							jfc.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
						}
				int status = jfc.showOpenDialog(this);
				
				if (status == JFileChooser.APPROVE_OPTION)
				{
					if (source == choose_pdf)
					{
						selectedfile = jfc.getSelectedFile();
						pdfpath = selectedfile.getAbsolutePath();
						choose_pdf_field.setText(pdfpath);
					}else
						if (source == choose_txt)
						{
							selectedfile = jfc.getSelectedFile();
							txtpath = selectedfile.getAbsolutePath();
							choose_txt_field.setText(txtpath);
						}else
							if (source == store_file)
							{
								selectedfile = jfc.getSelectedFile();
								storepath = selectedfile.getAbsolutePath();
								store_file_field.setText(storepath);
							}else
							{
								selectedfile = jfc.getSelectedFile();
								mergepath = selectedfile.getAbsolutePath();
								merge_pdf_field.setText(mergepath);
							}
				}
			}else
			{
				BatchEditor b = new BatchEditor(choose_pdf_field.getText(),store_file_field.getText(),choose_txt_field.getText(),watermark.getText());
				b.start();
				
				File f = new File(choose_pdf_field.getText());
				String fileName = f.getName().replaceFirst("[.][^.]+$", "");
				
				//mergepath = storepath;
				merge_pdf_field.setText(store_file_field.getText() + "\\" + fileName);
				
			}
		}
		
		
		
	}
}