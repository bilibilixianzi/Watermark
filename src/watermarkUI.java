import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.color.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.Border;
import com.sun.xml.internal.ws.api.server.Container;
public class watermarkUI{
	boolean flag=false;
	int git=0;
	ArrayList<String> list=new ArrayList<String>();
	public watermarkUI() {
		list.add("  本软件制作者为馅子!");
		list.add("email:bliblixianzi@foxmail.com");
		list.add("请多多支持馅子，支持馅子World");
		list.add("www.xianziworld.com");
		list.add("如有任何问题，请联系我们！");
		JFrame f=new JFrame("Watermark");
		java.awt.Container con = f.getContentPane();
		f.setSize(500,400);
		f.setLocation(500, 250);
		f.setLayout(null);
		f.setVisible(true);
		f.setResizable(false);
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		JButton b1=new JButton("单图");
		JButton b2=new JButton("组图");
		JButton b3=new JButton("生成");
		JButton b4=new JButton("取消");
		JButton btn= new JButton("···");
		b1.setFont(new Font("楷体",Font.BOLD,25));
		b2.setFont(new Font("楷体",Font.BOLD,25));
		b3.setFont(new Font("楷体",Font.BOLD,16));
		b4.setFont(new Font("楷体",Font.BOLD,16));
		b1.setActionCommand("oneimg");
		b2.setActionCommand("moreimg");
		b3.setActionCommand("true");
		b4.setActionCommand("false");
		btn.setActionCommand("img1Path");
		b1.setBounds(125,25,100,50);
		b2.setBounds(275,25,100,50);
		b3.setBounds(150,240,70,30);
		b4.setBounds(275,240,70,30);
		btn.setBounds(395,100,20,20);
		f.add(b1);f.add(b2);f.add(b3);f.add(b4);f.add(btn);
		
		JTextField textFile1 = new JTextField(30);
		textFile1.setActionCommand("textfile1");
		textFile1.setBounds(120, 100, 275, 20);
		f.add(textFile1);
		
		JTextField bt1=new JTextField("水印");
		bt1.setFont(new Font("华文彩云",Font.BOLD,30));
		bt1.setBounds(220, 135, 100, 30);
		bt1.setEnabled(false);
		bt1.setBorder(null);
		f.add(bt1);
		
		JTextField text1=new JTextField("选择文件:");
		text1.setFont(new Font("黑体",Font.PLAIN,10));
		text1.setForeground(Color.BLUE);
		text1.setBounds(65,100,55,20);
		text1.setEnabled(false);
		text1.setBorder(null);
		f.add(text1);
		
		JTextField text2=new JTextField("选择图片:");
		text2.setFont(new Font("黑体",Font.PLAIN,10));
		text2.setForeground(Color.BLUE);
		text2.setBounds(65,180,55,20);
		text2.setEnabled(false);
		text2.setBorder(null);
		f.add(text2);
		
		JTextField text3=new JTextField("输出路径:");
		text3.setFont(new Font("黑体",Font.PLAIN,10));
		text3.setForeground(Color.BLUE);
		text3.setBounds(65,210,55,20);
		text3.setEnabled(false);
		text3.setBorder(null);
		f.add(text3);
		
		JTextField textFile2 = new JTextField(30);
		textFile2.setActionCommand("textfile2");
		textFile2.setBounds(120, 180, 275, 20);
		f.add(textFile2);
		
		JTextField textFile3 = new JTextField(list.get(git));
		textFile3.setFont(new Font("华文彩云",Font.PLAIN,24));
		textFile3.setActionCommand("textfile3");
		text2.setForeground(Color.BLUE);
		textFile3.setBounds(80, 280, 350, 40);
		textFile3.setEnabled(false);
		textFile3.setBorder(null);
		f.add(textFile3);
		
		JTextField textFile4 = new JTextField(30);
		textFile4.setActionCommand("textfile4");
		textFile4.setBounds(120, 210, 275, 20);
		f.add(textFile4);
		
		JButton btw=new JButton("···");
		btw.setActionCommand("img2Path");
		btw.setBounds(395,180,20,20);
		f.add(btw);
		
		JButton btm=new JButton("···");
		btm.setActionCommand("img3Path");
		btm.setBounds(395,210,20,20);
		f.add(btm);
		
		b1.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				b1.setEnabled(false);
				b2.setEnabled(true);
				text1.setText("选择文件:");
				flag=false;
				textFile3.setText(""+list.get(git));
				//System.out.println(git+"---"+list.get(git));
				if(++git>4)
					git=0;
			}
		});
		b2.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				b2.setEnabled(false);
				b1.setEnabled(true);
				text1.setText("选择文件夹:");
				flag=true;
				textFile3.setText(""+list.get(git));
				//System.out.println(git+"---"+list.get(git));
				if(++git>4)
					git=0;
			}
		});
		b3.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				b2.setEnabled(true);
				b1.setEnabled(true);
				String Imgtype="jpg";
				watermark c=new watermark();
				if(!flag) {
					String Img1=textFile1.getText().toString();
					String Img2=textFile2.getText().toString();
					String outPath =textFile4.getText().toString()+"\\"+System.currentTimeMillis()+"."+Imgtype;
					try {
						c.bigImgAddSmallImgAndText(Img1,Img2,outPath);
					}catch(IOException e1) {
							e1.printStackTrace();
						}
				}
				else {
					String Img1=textFile1.getText().toString();
					String Img2=textFile2.getText().toString();
					String outPath1 =textFile4.getText().toString()+"\\";
					File fil=new File(Img1);
					if(fil.isDirectory()) {
						File[] files=fil.listFiles();
						for(int i=0;i<files.length;i++) {
							String outPath=outPath1+System.currentTimeMillis()+"."+Imgtype;
							try {
								BufferedImage image = ImageIO.read(files[i]);
								if(image==null)
									continue;
							}catch(IOException ex) {
								ex.printStackTrace();
							}
							try {
								c.bigImgAddSmallImgAndText(files[i].toString(),Img2,outPath);
							}catch(IOException e2){
								e2.printStackTrace();
							}
							/*try {
								Thread.sleep(2000);
							} catch (InterruptedException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}*/
							
						}
					}
				}
				JOptionPane.showMessageDialog(f, "完成！", "watermark",JOptionPane.WARNING_MESSAGE);  
				textFile3.setText(""+list.get(git));
				//System.out.println(git+"---"+list.get(git));
				if(++git>4)
					git=0;
				textFile1.setText("");
				textFile2.setText("");
				textFile4.setText("");
				b1.setEnabled(true);
				b2.setEnabled(true);
			}
		});
		b4.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				textFile1.setText("");
				textFile2.setText("");
				textFile4.setText("");
				b1.setEnabled(true);
				b2.setEnabled(true);
				textFile3.setText(""+list.get(git));
				//System.out.println(git+"---"+list.get(git));
				if(++git>4)
					git=0;
			}
			
		
		});
		btn.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser1 =new JFileChooser();
				chooser1.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooser1.showDialog(new JLabel(), "选择");
				File file1 = chooser1.getSelectedFile();
				textFile1.setText(file1.getAbsoluteFile().toString());
				textFile3.setText(""+list.get(git));
				//System.out.println(git+"---"+list.get(git));
				if(++git>4)
					git=0;
			}
		});
		btw.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser2 =new JFileChooser();
				chooser2.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooser2.showDialog(new JLabel(), "选择");
				File file2 = chooser2.getSelectedFile();
				textFile2.setText(file2.getAbsoluteFile().toString());
				textFile3.setText(""+list.get(git));
				//System.out.println(git+"---"+list.get(git));
				if(++git>4)
					git=0;
			}
		});
		btm.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				JFileChooser chooser3 =new JFileChooser();
				chooser3.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
				chooser3.showDialog(new JLabel(), "选择");
				File file3 = chooser3.getSelectedFile();
				textFile4.setText(file3.getAbsoluteFile().toString());
				textFile3.setText(""+list.get(git));
				//System.out.println(git+"---"+list.get(git));
				if(++git>4)
					git=0;
			}
		});
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			/*
				Windows 风格：           com.sun.java.swing.plaf.windows.WindowsLookAndFeel
				Metal 风格（默认）：javax.swing.plaf.metal.MetalLookAndFeel
				Motif 风格：                  com.sun.java.swing.plaf.motif.MotifLookAndFeel
				Mac 风格：                         com.sun.java.swing.plaf.mac.MacLookAndFeel
				GTK 风格：                         com.sun.java.swing.plaf.gtk.GTKLookAndFeel
			*/
		}catch(Exception e) {
			e.printStackTrace();
		}
		new watermarkUI();
	}
}