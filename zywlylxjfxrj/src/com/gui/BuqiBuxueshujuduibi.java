package com.gui;



import java.awt.*;

import javax.swing.*;

import com.gui.paintbuxueyaolitu.canva;
import com.gui.paintyaoli.canvas;

import java.util.Random;




 class BuqiBuxueshujuduibi {
	JFrame random;
	Random r;
	canvas3 c;
	
	
	static String bbb,aaa;
	

	static class canvas3 extends Canvas {
		/**
		 * 
		 */
		private static final long serialVersionUID = -7699703215000872680L;
		static String jiediancha,biancha,xishucha,xianglincha,zhongxincha;
		public canvas3() {
			
			
		setSize(800, 800);
		
		}
		public void duibicha(){
			if(canvas.s>canva.s){
			jiediancha=String.format("%.3f",((canvas.s-canva.s)/canvas.s)*100);
			}else if(canvas.s<canva.s){
				jiediancha=String.format("%.3f",((canva.s-canvas.s)/canva.s)*100);
			}
			
			if(canvas.h>canva.h){
				biancha=String.format("%.3f",((canvas.h-canva.h)/canvas.h)*100);
			}else if(canvas.h<canva.h){
				biancha=String.format("%.3f",((canva.h-canvas.h)/canva.h)*100);
			}
			if(canvas.m>canva.m){
				xianglincha=String.format("%.3f",((canvas.m-canva.m)/canvas.m)*100);
			}else if(canvas.m<canva.m){
				xianglincha=String.format("%.3f",((canva.m-canvas.m)/canva.m)*100);
			}
			if(canvas.xishu1>canva.xishu1){
				xishucha=String.format("%.3f",((canvas.xishu1-canva.xishu1)/canvas.xishu1)*100);
			}else if(canvas.xishu1<canva.xishu1){
				xishucha=String.format("%.3f",((canva.xishu1-canvas.xishu1)/canva.xishu1)*100);
			}
			
			if(canvas.zhongxindu1>canva.zhongxindu1){
				zhongxincha=String.format("%.3f",((canvas.zhongxindu1-canva.zhongxindu1)/canvas.zhongxindu1)*100);
			}else if(canvas.zhongxindu1<canva.zhongxindu1){
				zhongxincha=String.format("%.3f",((canva.zhongxindu1-canvas.zhongxindu1)/canva.zhongxindu1)*100);
			}
			
			//xishucha=String.valueOf(canvas.xishu1);
			}
		@Override
		public void paint(Graphics g) {
			
			this.setBackground(Color.white);
			//g.setFont(new Font("黑体",Font.BOLD,18));  设置字体和大小
			super.paint(g);
			//写字
			//
			g.drawString("网络参数", 70,30);
			g.drawString("补气类中药", 200,30);
			g.drawString("补血类中药", 340,30);
			g.drawString("对比差", 470, 30);
			
			
			
			
			g.drawString("节点数目", 70,60);
			g.drawString("边数目", 75, 85);
			g.drawString("聚类系数", 75, 110);
			g.drawString("网络中心性", 65, 135);
			g.drawString("平均相邻节点数", 55, 160);
			g.drawString(canvas.s1, 217, 60);
			g.drawString(canva.s1, 357, 60);
			
			//按照上面的顺序
			g.drawString(canvas.h1 , 217, 85);
			g.drawString(canva.h1 , 357, 85);
			
			
			g.drawString(canvas.xishu2 , 212, 110);
			g.drawString(canva.xishu2 , 352, 110);
			
			g.drawString(String.valueOf(canvas.zhongxindu2) ,212,135);
			g.drawString(String.valueOf(canva.zhongxindu2) ,352,135);
			
			g.drawString(canvas.m1, 217, 160);
			g.drawString(canva.m1, 357, 160);
			
			g.drawString(String.valueOf(canvas3.jiediancha)+"%", 470, 60);
			g.drawString(String.valueOf(canvas3.biancha)+"%", 470, 85);
			g.drawString(String.valueOf(canvas3.xishucha)+"%", 470, 110);
			g.drawString(String.valueOf(canvas3.zhongxincha)+"%", 470, 135);
			g.drawString(String.valueOf(canvas3.xianglincha)+"%", 470, 160);
			//g.drawString("特征路径长度", 60, 185);
			//g.drawString("最短路径数目", 60,210);
			//g.drawString("网路中心度", 65, 235);
			
			
			//画线段
		    Graphics2D g2d=(Graphics2D)g;
		    
		    Stroke stroke1=new BasicStroke(1.5f);
		    g2d.setStroke(stroke1);
		    g2d.drawLine(10, 10, 580, 10);
		    
		    Stroke stroke=new BasicStroke(3.0f);
		    g2d.setStroke(stroke);
		    g2d.drawLine(10, 40,580, 40);
		    
		    Stroke stroke2=new BasicStroke(1.5f);
		    g2d.setStroke(stroke2);
		    g2d.drawLine(10, 180, 580, 180);
		    
			
			
		}  
		
		public static void p(String filen,String filen1) {
			bbb = filen;
			aaa=filen1;
			JFrame random;
			canvas3 c;
			random = new JFrame();
			c = new canvas3();
			c.duibicha();
			c.setBackground(Color.white);
			random.setSize(600, 230);
			random.add(c);
			random.setLocation(10,10);
			//random.setLayout(new FlowLayout());
			random.setVisible(true);
			random.setTitle("补气补血类中药数据对比");
		}
	}
}
