package com.gui;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Random;

import javax.swing.JFrame;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class paintyaoli {
	JFrame random;
	Random r;
	canvas c;
	
	static String tuming;
	static String aaa;
	static int hang,x,y,x1,y1;
	static int lie,i1,j1,k1,i2,i3;
	static int dotzuobiaoxhua[];  //存储小分子横坐标
	static int dotzuobiaoyhua[];  //存储小分子纵坐标
	static int dotzuobiaoxba[];  //存储靶点横坐标
	static int dotzuobiaoyba[];  //存储靶点纵坐标
	static int result[];//存储扫描excel表每节点的边数
	//static boolean valid=true;
	/*
	public static int output(){
		
		canvas cs=new canvas();
		int c=cs.sum();
		  int d=cs.mounts();
		return c;
		
		
	}*/

	static class canvas extends Canvas {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -1268453131703649837L;
		/**
		 * 
		 */
		public static double s,h,xishu,xishu1,zhongxindu,zhongxindu1;
		public static String s1,h1,m1,xishu2,zhongxindu2;
		public static String getZhongxindu2() {
			return zhongxindu2;
		}
		public static void setZhongxindu2(String zhongxindu2) {
			canvas.zhongxindu2 = zhongxindu2;
		}
		public static double getXishu() {
			return xishu;
		}
		public static void setXishu(double xishu) {
			canvas.xishu = xishu;
		}
		public static double getXishu1() {
			return xishu1;
		}
		public static void setXishu1(double xishu1) {
			canvas.xishu1 = xishu1;
		}
		static double m;
		
		public static double getM() {
			return m;
		}
		public static void setM(double m) {
			//canvas.m = m;
		}
		
			public static String getM1() {
			return m1;
		}
		public static void setM1(String m1) {
			canvas.m1 = m1;
		}
			public static void setH(int h) {
			canvas.h = h;
		}
			public static void setS(int s) {
				canvas.s =s;
			}
			public   double getS(){
				
				//s=a+b;
				
				
				return s;
			}
			public double getH(){
				return h;
			}
		public canvas() {
			
		setSize(800, 800);
		}
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.BLUE);
			//执行导入文件********************************************************************************
			int i,j,k=0;
		    Cell cell0,cell4;
		    System.out.println("哈哈哈哈");
		    String filename = aaa;
			File file = new File(filename);
			tuming = file.getName();
		    try { 
		      //danggui3.xls为要读取的excel文件名
//****		      String filename="F:/danggui3.xls";
//****		      File file = new File(filename);
		      System.out.println("嘿嘿黑");
		      InputStream is = new FileInputStream(file.getAbsolutePath());
		      System.out.println("逗我吧");
		      Workbook book = Workbook.getWorkbook(is); 
		      System.out.println("呦呦呦");
		      //获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
		      Sheet sheet=book.getSheet(0); 
		      //获取左上角的单元格
		     // cell1=sheet.getCell(0,0);
		      System.out.println("哇咔咔");
		   //   System.out.println("标题："+cell1.getContents()); 
		      
		      for (i = 0; i < sheet.getRows(); i++) {                     // 循环打印Excel表中的内容   ROW行
	              for (int l = 0; l < sheet.getColumns(); l++) {          //Column列
	                  Cell cell = sheet.getCell(l, i);  
	                  System.out.print(cell.getContents()+" "); 
	              }  
	              System.out.println();  
	              k++;
	          }  
		      for (i = 0; i < sheet.getRows(); i++) {                     // 循环打印Excel表中的内容   ROW行   Column列
            	  if(sheet.getCell(0,i).getContents().equals("靶标"))  //比较字符串
            	  {   i2=i-1;
                	  
                	 // System.out.println("i2222222222222222222222222222222222222222="+i2);
                	  
                	  break; 
            	  } else{
                	   continue;            
                  }
          }
		    //扫描excel表获得靶标小分子的总数目
		      for (i = 0; i < sheet.getRows(); i++) {                     // 循环打印Excel表中的内容   ROW行   Column列
	            	  if(sheet.getCell(0,i).getContents().equals("化合物-靶标相关联"))  //比较字符串
	            	  {   i1=i+1;
	                	  System.out.println("嘿嘿小伙子，你不行！");
	                	  System.out.println("i1="+i1);
	                	  
	                	  break; 
	            	  } else{
	                	   continue;            
	                  }
	          }
		      i3=i1-i2-4;
		      System.out.println(sheet.getRows());      //行数
		      System.out.println(sheet.getColumns());   //列数
		      hang = sheet.getRows();
		      lie = sheet.getColumns();
		      dotzuobiaoxhua = new int[20000];
		      dotzuobiaoyhua = new int[20000];
		      dotzuobiaoxba = new int[20000];
		      dotzuobiaoyba = new int[20000];
		      result=new int[20000];
		      //画散点图*********************************************************************************************
		      for ( i = 0; i < i2; i++) {
		    	    g.setColor(Color.green);               //绿色表示小分子
		    	    x=new Random().nextInt(800);
		    	    y=new Random().nextInt(700);
					g.fillOval(x, y,6, 6);   //画实心椭圆
		    	    dotzuobiaoxhua[i] = x+2;//p1.getX();    //记录小分子点x坐标
					dotzuobiaoyhua[i] = y+3;//p1.getY();    //记录小分子点y坐标
              //    String ax = Integer.toString(x);  String ay = Integer.toString(y+2);  //将int类型转换成String类型数据
					g.setColor(Color.darkGray);
                    g.drawString(Integer.toString(i+1), x+4, y+4);
                    k1=i+1;
				} 
		      for ( j = 0; j < i3; j++){
		    	    g.setColor(Color.blue);    //蓝色表示靶点
		    	    x1=new Random().nextInt(800);
		    	    y1=new Random().nextInt(700); 	    
					g.fillOval(x1, y1,6,6);  //画实心椭圆       //		Point p2 = new Point(x1,y1);
					dotzuobiaoxba[j] = x1+2;      //(int) p2.getX();    //记录靶点点x坐标
					dotzuobiaoyba[j] = y1+3;    //(int) p2.getY();    //记录靶点点y坐标
					g.setColor(Color.darkGray);
                    g.drawString(Integer.toString(j+1), x1+4, y1+4);  
                    j1=j+1;
				} 
		      s=k1+j1;
		      
		      s1=String.format("%.0f", s);
		    
		      
		      //按联系连线
		     
		      System.out.println("到这都没事啊！");//***************************************************************** 
		      for (i = 0; i < sheet.getRows(); i++) {                     // 循环打印Excel表中的内容   ROW行   Column列
	            	  if(sheet.getCell(0,i).getContents().equals("小分子-靶标相关联"))  //比较字符串
	            	  {   i1=i+1;
	                	  System.out.println("嘿嘿小伙子，你不行！");
	                	  System.out.println("i1="+i1);
	                	  
	                	  break; 
	            	  } else{
	                	   continue;            
	                  }
	          }
		      h=--k-i1;
		      h1=String.format("%.0f", h);
		      m=(2*h)/s;
		      m1 = String.format("%.2f", m);
		     //扫描excel表找出每个节点所连的边数
		    	for(j=1;j<(i2+1);j++){
		    		 int n=0;
		    		
		    		for(i=i1;i<sheet.getRows();i++){
		    		if( Integer.valueOf(sheet.getCell(0, i).getContents())==j){
		    			
		    			n=n+1;
		    		
		    		}	
		    	}
		    		
		    		result[j-1]=n;
		    }
		    	for(j=(i2+1);j<(i1-2);j++){
		    		int n=0;
		    		System.out.println("j="+j);
		    		for(i=i1;i<sheet.getRows();i++){
			    		if( Integer.valueOf(sheet.getCell(1, i).getContents())==j){
			    			
			    			n=n+1;
			    		
			    		}	
		    		}
		    		//System.out.print("n="+n);
		    		//System.out.println();
		    		result[j-1]=n;
		    	}
		    	
		    
		//节点i的聚类系数 CC(i)=2E(i)/(k(k-1))其中E为实际的边数
		    	//网络度等于节点度除于节点总数
		    	//节点度等于 
		    //求聚类系数
		    	xishu=0;
		    	zhongxindu=0;
		    	for( i=0;i<(i1-4);i++){
		    		 if(result[i]!=0&&result[i]!=1){
		    			 xishu+=(2*result[i])/(result[i]*(result[i]-1));
		    			 zhongxindu+=result[i];
		    		 }
		    		//System.out.println("result["+i+"]="+result[i]);
	    		} 
		    	zhongxindu1=(zhongxindu/(i-4))/(i-3);
		    	zhongxindu2=String.format("%.3f", zhongxindu1);
		    	
		    	xishu1=xishu/(i1-3);
		    	xishu2=String.format("%.3f", xishu1);
		    	System.out.println("xishu1="+xishu2);
		      for(int m = i1; m < sheet.getRows(); m++){
		        		  //for( int n = 0; n< sheet.getColumns()-1; n++){
		        		      System.out.println("怎么会这样呢0！");
		        			  cell0=sheet.getCell(0, m);
		        			  cell4=sheet.getCell(1, m);
		        			  String cel0 = cell0.getContents();
		        			  String cel4 = cell4.getContents();
		        			  int cel00 = Integer.parseInt(cel0);
		        			  int cel44 = Integer.parseInt(cel4);
		        			  System.out.print(cel0 + " ");
		        			  System.out.println(cel4);
		        			  System.out.println("怎么会这样呢11！");
		        			  g.setColor(Color.gray);
		        			  g.drawLine(dotzuobiaoxhua[cel00-1], dotzuobiaoyhua[cel00-1], dotzuobiaoxba[cel44-1], dotzuobiaoyba[cel44-1]);//画线连接点
		        			  System.out.println("怎么会这样呢！");
		          	     // }
	          }  //**********************************************************************************************
		     book.close(); 
		    }
		    catch(Exception e) { 
		    	e.printStackTrace();
		    }  
		}  
		public static void p(String filen) {
			aaa = filen;
			JFrame random;
			canvas c;
			random = new JFrame();
			c = new canvas();
			c.setBackground(Color.white);
			random.setSize(900, 900);
			random.add(c);
			random.setLayout(new FlowLayout());
			random.setVisible(true);
			random.setTitle("补气中药网络图");
		}
	}
}
