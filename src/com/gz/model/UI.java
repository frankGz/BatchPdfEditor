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
		
		private JTextField choose_pdf_field; JButton choose_pdf = new JButton("选择");
		private JTextField choose_txt_field; JButton choose_txt = new JButton("选择");
		private JTextField store_file_field; JButton store_file = new JButton("选择");
		private JTextField merge_pdf_field; JButton merge_pdf = new JButton("选择");
		private JTextField watermark;
		
		JButton confirm = new JButton("开始");
		JButton mergingpdf = new JButton("合并");
		
		//JFileChooser jfc = new JFileChooser();
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
			mergingpdf.addActionListener(this);
			
			JPanel banner = new JPanel();
			JLabel str = new JLabel("欢迎使用PDF批量水印处理器 v1.0");
			banner.add(str);
			//banner.setAlignmentX(Component.LEFT_ALIGNMENT);
			
			
			
			JPanel UI = new JPanel();
			JLabel UI_author = new JLabel("Author: Frank.Gz    UI: Kris Dai");
			UI.add(UI_author);
			
			
			JPanel pdfpanel = new JPanel(); 
			//JPanel choosepdf = new JPanel(); choosepdf.add(choose_pdf);
			Box box1 = Box.createHorizontalBox();
			box1.add(choose_pdf_field);
			box1.add(choose_pdf);
			pdfpanel.add(box1);
			pdfpanel.setBorder(new TitledBorder(new EtchedBorder(), "选择PDF原件"));
			
			JPanel txtpanel = new JPanel(); 
			//JPanel choosetxt = new JPanel(); choosetxt.add(choose_txt);
			Box box2 = Box.createHorizontalBox();
			box2.add(choose_txt_field);
			box2.add(choose_txt);
			txtpanel.add(box2);
			txtpanel.setBorder(new TitledBorder (new EtchedBorder(),"选择一份.txt名单，一行一个名字（暂不支持中文名）"));
			
			JPanel storepanel = new JPanel(); 
			JPanel store = new JPanel(); store.add(store_file);
			Box box3 = Box.createHorizontalBox();
			box3.add(store_file_field);
			box3.add(store_file);
			storepanel.add(box3);
			storepanel.setBorder(new TitledBorder (new EtchedBorder(),"选择要保存的位置"));
			
			JPanel watermark_text = new JPanel();
			Box box4 = Box.createHorizontalBox();
			box4.add(watermark);
			watermark_text.add(box4);
			watermark_text.setBorder(new TitledBorder (new EtchedBorder(),"输入一段文字作为水印和页眉底板（暂不支持中文）"));
			
			JPanel confirmpanel = new JPanel();
			confirmpanel.add(confirm);
			confirmpanel.setAlignmentX(CENTER_ALIGNMENT);
			
			JPanel mergepanel = new JPanel();
			Box box5 = Box.createHorizontalBox();
			box5.add(merge_pdf_field);
			box5.add(merge_pdf);
			mergepanel.add(box5);
			mergepanel.setBorder(new TitledBorder (new EtchedBorder(), "Merging all pdf files under the directory"));
			
			JPanel mergingpanel = new JPanel();
			mergingpanel.add(mergingpdf);
			
			
			// add all components to contentpanel
			JPanel contentpanel = new JPanel();
			contentpanel.setLayout(new BoxLayout(contentpanel, BoxLayout.Y_AXIS));
			contentpanel.add(banner);
			contentpanel.add(UI);
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
			contentpanel.add(Box.createRigidArea(new Dimension(0,10)));
			contentpanel.add(mergingpanel);
			
			
			
			this.setContentPane(contentpanel);
		}
		
		public void actionPerformed (ActionEvent ae)
		{
			Object source = ae.getSource();
			JFileChooser jfc = new JFileChooser();
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
				if (source == confirm)
				{
					pdfpath = choose_pdf_field.getText();
					txtpath = choose_txt_field.getText();
					storepath = store_file_field.getText();
				
					/*int pdfpath_length = pdfpath.length();
					int txtpath_length = txtpath.length();*/
				
					if (!pdfpath.endsWith("pdf") || !txtpath.endsWith("txt"))
					{
						JOptionPane.showMessageDialog(choose_pdf, "Please put pdf file in pdf field, txt file in txt field");
					}else
						if (storepath.isEmpty())
						{
							JOptionPane.showMessageDialog(confirm, "The store location can not be emoty");
						}else
						{
							BatchEditor b = new BatchEditor(pdfpath, storepath, txtpath, watermark.getText());
							System.out.println(pdfpath);
							System.out.println(storepath);
							System.out.println(txtpath);
							System.out.println(watermark.getText());
							String msg = b.start();
							
							if(msg.equals("")) {
						
								File f = new File(choose_pdf_field.getText());
								String fileName = f.getName().replaceFirst("[.][^.]+$", "");
							
								merge_pdf_field.setText(store_file_field.getText() + fileName);
								mergepath = merge_pdf_field.getText();
								JOptionPane.showMessageDialog(confirm, "Complete");
							}else {
							
								JOptionPane.showMessageDialog(confirm, msg);
							}
						}									
			}else
			{
				mergepath = merge_pdf_field.getText();
				if (mergepath.isEmpty())
				{
					JOptionPane.showMessageDialog(mergingpdf, "The target folder can not be empty");
				}else
				{
					String msg_merge = MergePDF.mergePDF(mergepath);
					if(msg_merge.equals("")) {
						JOptionPane.showMessageDialog(confirm, "Merge completed");
					}else
					{
						JOptionPane.showMessageDialog(confirm, msg_merge);
					}
				}
			}
		}
		
		
		
	}
}