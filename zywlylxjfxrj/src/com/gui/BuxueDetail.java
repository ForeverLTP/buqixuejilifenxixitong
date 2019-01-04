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
	static int dotzuobiaoxhua[];  //存储化合物横坐标
	static int dotzuobiaoyhua[];  //存储化合物纵坐标
	static int dotzuobiaoxba[];  //存储靶点横坐标
	static int dotzuobiaoyba[];  //存储靶点纵坐标
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
			//g.setFont(new Font("黑体",Font.BOLD,18));  设置字体和大小
			super.paint(g);
			//写字
			//
			g.drawString("网络参数", 70,30);
			g.drawString("补血类中药", 230,30);
			
			g.drawString("节点数目", 70,60);
			g.drawString("边数目", 75, 85);
			g.drawString("聚类系数", 75, 110);
			g.drawString("网络中心性", 65, 135);
			g.drawString("平均相邻节点数", 55, 160);
			//按照上面顺序画图
			
			g.drawString(canva.s1, 252, 60);
			
			g.drawString(canva.h1 , 252, 85);
			
			g.drawString(canva.xishu2 , 247, 110);
			
			g.drawString(canva.zhongxindu2 , 247,135);
			
			g.drawString(canva.m1, 251, 160);
			
			
			
			//画线段
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
			//执行导入文件********************************************************************************
			int i,j,k=0;
		    Cell cell1;
		    //System.out.println("哈哈哈哈");
		    String filename = bbb;
			File file = new File(filename);
			tuming = file.getName();
		    try { 
		      //danggui3.xls为要读取的excel文件名
//****		      String filename="F:/danggui3.xls";
//****		      File file = new File(filename);
		      //System.out.println("嘿嘿黑");
		      InputStream is = new FileInputStream(file.getAbsolutePath());
		      //System.out.println("逗我吧");
		      Workbook book = Workbook.getWorkbook(is); 
		      //System.out.println("呦呦呦");
		      //获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
		      Sheet sheet=book.getSheet(0); 
		      //获取左上角的单元格
		      cell1=sheet.getCell(0,0);
		     // System.out.println("哇咔咔");
		      System.out.println("标题："+cell1.getContents()); 
		      
		      for (i = 0; i < sheet.getRows(); i++) {                     // 循环打印Excel表中的内容   ROW行
	              for (int l = 0; l < sheet.getColumns(); l++) {          //Column列
	                  Cell cell = sheet.getCell(l, i);  
	                  System.out.print(cell.getContents()+" "); 
	              }  
	              System.out.println();  
	              k++;
	          }  
		      System.out.println(sheet.getRows());      //行数
		      System.out.println(sheet.getColumns());   //列数
		      System.out.println(k);
		      hang = sheet.getRows();
		      lie = sheet.getColumns();
		      dotzuobiaoxhua = new int[20000];
		      dotzuobiaoyhua = new int[20000];
		      dotzuobiaoxba = new int[20000];
		      dotzuobiaoyba = new int[20000];
		      //画散点图*********************************************************************************************
		      for ( i = 0; i < 44; i++) {
		    	    //g.setColor(Color.green);               //绿色表示化合物
		    	    //x=new Random().nextInt(800);
		    	   // y=new Random().nextInt(700);
					//g.fillOval(x, y,6, 6);   //画实心椭圆
		    	    //dotzuobiaoxhua[i] = x+2;//p1.getX();    //记录化合物点x坐标
					//dotzuobiaoyhua[i] = y+3;//p1.getY();    //记录化合物点y坐标
              //    String ax = Integer.toString(x);  String ay = Integer.toString(y+2);  //将int类型转换成String类型数据
					//g.setColor(Color.darkGray);
                    //g.drawString(Integer.toString(i+1), x+4, y+4);
                   // a++;
				} 
		      for ( j = 0; j < 296; j++){
		    	    //g.setColor(Color.blue);    //蓝色表示靶点
		    	    //x1=new Random().nextInt(800);
		    	    //y1=new Random().nextInt(700); 	    
					//g.fillOval(x1, y1,6,6);  //画实心椭圆       //		Point p2 = new Point(x1,y1);
					//dotzuobiaoxba[j] = x1+2;      //(int) p2.getX();    //记录靶点点x坐标
					//dotzuobiaoyba[j] = y1+3;    //(int) p2.getY();    //记录靶点点y坐标
					//g.setColor(Color.darkGray);
                    //g.drawString(Integer.toString(j+1), x1+4, y1+4);  
                   // b++;
				} 
		      	//	s=a+b;
		     // g.drawString(Integer.toString(s), 100, 100);
		      //System.out.println(s);
		      //按联系连线
		     
		     // System.out.println("到这都没事啊！");//***************************************************************** 
		      for (i = 0; i < sheet.getRows(); i++) {                     // 循环打印Excel表中的内容   ROW行   Column列
	            	  if(sheet.getCell(0,i).getContents().equals("化合物-靶标相关联"))  //比较字符串
	            	  {   i1=i+1;
	                	  System.out.println("嘿嘿小伙子，你不行！");
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
			random.setTitle("补血类中药数据显示");
		}
	}
}
