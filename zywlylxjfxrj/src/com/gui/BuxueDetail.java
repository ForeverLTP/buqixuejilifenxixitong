package com.gui;

import java.awt.*;

import javax.swing.*;

import com.gui.paintbuxueyaolitu.canva;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Random;






import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;




 class BuxueDetail {
	JFrame random;
	Random r;
	canvas2 c;
	
	static String tuming;
	static String bbb;
	static int hang,x,y,x1,y1;
	static int lie,i1;
	static int dotzuobiaoxhua[];  //�洢�����������
	static int dotzuobiaoyhua[];  //�洢������������
	static int dotzuobiaoxba[];  //�洢�е������
	static int dotzuobiaoyba[];  //�洢�е�������
	//public static int output(){
	//canvas1 cs=new canvas1();
		  // int h=cs.sum();
		
		//	return 0;
		
		
	//}

	static class canvas2 extends Canvas {
		  //static int a,b,s;
			
			/**
		 * 
		 */
		private static final long serialVersionUID = -5435694980206288624L;
		//public static int getS() {
			//	return s;
			//}
			//public  void setS(int s) {
			//	this.s = s;
			//}
			//public static int sum(){
			//	s=a+b;
			//	return s;
			//}
		public canvas2() {
			
			
		setSize(800, 800);
		}
		@Override
		public void paint(Graphics g) {
			
			this.setBackground(Color.white);
			//g.setFont(new Font("����",Font.BOLD,18));  ��������ʹ�С
			super.paint(g);
			//д��
			//
			g.drawString("�������", 70,30);
			g.drawString("��Ѫ����ҩ", 230,30);
			
			g.drawString("�ڵ���Ŀ", 70,60);
			g.drawString("����Ŀ", 75, 85);
			g.drawString("����ϵ��", 75, 110);
			g.drawString("����������", 65, 135);
			g.drawString("ƽ�����ڽڵ���", 55, 160);
			//��������˳��ͼ
			
			g.drawString(canva.s1, 252, 60);
			
			g.drawString(canva.h1 , 252, 85);
			
			g.drawString(canva.xishu2 , 247, 110);
			
			g.drawString(canva.zhongxindu2 , 247,135);
			
			g.drawString(canva.m1, 251, 160);
			
			
			
			//���߶�
		    Graphics2D g2d=(Graphics2D)g;
		    
		    Stroke stroke1=new BasicStroke(1.5f);
		    g2d.setStroke(stroke1);
		    g2d.drawLine(10, 10, 380, 10);
		    
		    Stroke stroke=new BasicStroke(3.0f);
		    g2d.setStroke(stroke);
		    g2d.drawLine(10, 40, 380, 40);
		    
		    Stroke stroke2=new BasicStroke(1.5f);
		    g2d.setStroke(stroke2);
		    g2d.drawLine(10, 180, 380, 180);
		    
			
			
			//super.paint(g);
			//g.setColor(Color.BLUE);
			//ִ�е����ļ�********************************************************************************
			int i,j,k=0;
		    Cell cell1;
		    //System.out.println("��������");
		    String filename = bbb;
			File file = new File(filename);
			tuming = file.getName();
		    try { 
		      //danggui3.xlsΪҪ��ȡ��excel�ļ���
//****		      String filename="F:/danggui3.xls";
//****		      File file = new File(filename);
		      //System.out.println("�ٺٺ�");
		      InputStream is = new FileInputStream(file.getAbsolutePath());
		      //System.out.println("���Ұ�");
		      Workbook book = Workbook.getWorkbook(is); 
		      //System.out.println("������");
		      //��õ�һ�����������(ecxel��sheet�ı�Ŵ�0��ʼ,0,1,2,3,....)
		      Sheet sheet=book.getSheet(0); 
		      //��ȡ���Ͻǵĵ�Ԫ��
		      cell1=sheet.getCell(0,0);
		     // System.out.println("������");
		      System.out.println("���⣺"+cell1.getContents()); 
		      
		      for (i = 0; i < sheet.getRows(); i++) {                     // ѭ����ӡExcel���е�����   ROW��
	              for (int l = 0; l < sheet.getColumns(); l++) {          //Column��
	                  Cell cell = sheet.getCell(l, i);  
	                  System.out.print(cell.getContents()+" "); 
	              }  
	              System.out.println();  
	              k++;
	          }  
		      System.out.println(sheet.getRows());      //����
		      System.out.println(sheet.getColumns());   //����
		      System.out.println(k);
		      hang = sheet.getRows();
		      lie = sheet.getColumns();
		      dotzuobiaoxhua = new int[20000];
		      dotzuobiaoyhua = new int[20000];
		      dotzuobiaoxba = new int[20000];
		      dotzuobiaoyba = new int[20000];
		      //��ɢ��ͼ*********************************************************************************************
		      for ( i = 0; i < 44; i++) {
		    	    //g.setColor(Color.green);               //��ɫ��ʾ������
		    	    //x=new Random().nextInt(800);
		    	   // y=new Random().nextInt(700);
					//g.fillOval(x, y,6, 6);   //��ʵ����Բ
		    	    //dotzuobiaoxhua[i] = x+2;//p1.getX();    //��¼�������x����
					//dotzuobiaoyhua[i] = y+3;//p1.getY();    //��¼�������y����
              //    String ax = Integer.toString(x);  String ay = Integer.toString(y+2);  //��int����ת����String��������
					//g.setColor(Color.darkGray);
                    //g.drawString(Integer.toString(i+1), x+4, y+4);
                   // a++;
				} 
		      for ( j = 0; j < 296; j++){
		    	    //g.setColor(Color.blue);    //��ɫ��ʾ�е�
		    	    //x1=new Random().nextInt(800);
		    	    //y1=new Random().nextInt(700); 	    
					//g.fillOval(x1, y1,6,6);  //��ʵ����Բ       //		Point p2 = new Point(x1,y1);
					//dotzuobiaoxba[j] = x1+2;      //(int) p2.getX();    //��¼�е��x����
					//dotzuobiaoyba[j] = y1+3;    //(int) p2.getY();    //��¼�е��y����
					//g.setColor(Color.darkGray);
                    //g.drawString(Integer.toString(j+1), x1+4, y1+4);  
                   // b++;
				} 
		      	//	s=a+b;
		     // g.drawString(Integer.toString(s), 100, 100);
		      //System.out.println(s);
		      //����ϵ����
		     
		     // System.out.println("���ⶼû�°���");//***************************************************************** 
		      for (i = 0; i < sheet.getRows(); i++) {                     // ѭ����ӡExcel���е�����   ROW��   Column��
	            	  if(sheet.getCell(0,i).getContents().equals("������-�б������"))  //�Ƚ��ַ���
	            	  {   i1=i+1;
	                	  System.out.println("�ٺ�С���ӣ��㲻�У�");
	                	  System.out.println(i1);
	                	  break; 
	            	  }
	            	  else{
	                	   continue;            
	                  }
	          }
		      for(int m = i1; m < sheet.getRows(); m++){
		        		
	          }  //**********************************************************************************************
		     book.close(); 
		    }
		    catch(Exception e) { 
		    	e.printStackTrace();
		    }  
		}  
		/*private static int output() {
			return 0;
		}*/
		public static void p(String filen) {
			bbb = filen;
			JFrame random;
			canvas2 c;
			random = new JFrame();
			c = new canvas2();
			c.setBackground(Color.white);
			random.setSize(400, 230);
			random.add(c);
			random.setLocation(900,10);
			//random.setLayout(new FlowLayout());
			random.setVisible(true);
			random.setTitle("��Ѫ����ҩ������ʾ");
		}
	}
}
