package com.gui;

import java.awt.*;

import javax.swing.*;

import com.gui.paintbuxueyaolitu.canva;
import com.gui.paintyaoli.canvas;


import org.jfree.chart.ChartFactory;  
import org.jfree.chart.ChartPanel;  
import org.jfree.chart.JFreeChart;  
import org.jfree.chart.axis.CategoryAxis;  
import org.jfree.chart.axis.ValueAxis;  
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;  
import org.jfree.chart.plot.PlotOrientation;  
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.data.category.CategoryDataset;  
import org.jfree.data.category.DefaultCategoryDataset;  
import org.jfree.ui.TextAnchor;

public class JuLeiXiShuTu extends JFrame{  
  /**
	 * 
	 */
	private static final long serialVersionUID = -5087813705798671627L;
ChartPanel frame1; 
  
  public static void main(String[]args){
   
  }
 
@SuppressWarnings("deprecation")
public  JuLeiXiShuTu(){  
      CategoryDataset dataset = getDataSet();  
      JFreeChart chart = ChartFactory.createBarChart3D(  
                           "", // 图表标题  
                          "参数类型", // 目录轴的显示标签  
                          "值", // 数值轴的显示标签  
                          dataset, // 数据集  
                          PlotOrientation.VERTICAL, // 图表方向：水平、垂直  
                          true,           // 是否显示图例(对于简单的柱状图必须是false)  
                          false,          // 是否生成工具  
                          false           // 是否生成URL链接  
                          );  
        
      //从这里开始  
      CategoryPlot plot=chart.getCategoryPlot();//获取图表区域对象  
      CategoryAxis domainAxis=plot.getDomainAxis();         //水平底部列表  
       domainAxis.setLabelFont(new Font("黑体",Font.BOLD,14));         //水平底部标题  
       domainAxis.setTickLabelFont(new Font("宋体",Font.BOLD,12));  //垂直标题  
       ValueAxis rangeAxis=plot.getRangeAxis();//获取柱状  
       rangeAxis.setLabelFont(new Font("黑体",Font.BOLD,15));  
        chart.getLegend().setItemFont(new Font("黑体", Font.BOLD, 15));  
        chart.getTitle().setFont(new Font("宋体",Font.BOLD,20));//设置标题字体  
          
        //到这里结束，虽然代码有点多，但只为一个目的，解决汉字乱码问题  
        
        
        BarRenderer3D renderer = new BarRenderer3D();

        renderer.setSeriesPaint(0, new Color(241,9,14)); //9级

        renderer.setSeriesPaint(1, new Color(243,92,0)); //8级

        renderer.setSeriesPaint(2, new Color(100,0,220));

        renderer.setSeriesPaint(3, new Color(2,93,220));

        renderer.setSeriesPaint(4, new Color(142,204,241));

        renderer.setSeriesPaint(5, new Color(15,160,0));

        renderer.setSeriesPaint(6, new Color(173,220,0));

         

        //设置柱子上是否显示柱子的数值

        renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());

        renderer.setItemLabelsVisible(true);

        //设置柱子上数值的显示位置，当柱子的比例过小时，柱子的数值将无法显示，可以更改数值的显示位置在柱子上方。当数值过长时，可设置数值的偏移度,最后一个参数(-1.57D)为旋转的角度值(90°)/3.14.

        renderer.setPositiveItemLabelPosition(new ItemLabelPosition(  

        ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_LEFT,TextAnchor.HALF_ASCENT_LEFT,0D));

        renderer.setItemLabelFont(new Font("黑色",Font.BOLD,12));

        //使用设置

        plot.setRenderer(renderer);
          
       frame1=new ChartPanel(chart,true); //这里也可以用chartFrame,可以直接生成一个独立的Frame  
       frame1.setVerticalAxisTrace(true);
      // frame1.setHorizontalAxisTrace(true);竖着的辅助线
       frame1.setMouseZoomable(false, false);//双flase可以使得鼠标在图中移动不改变图的形状
       setContentPane(frame1);
       //this.add(frame1);
       this.setTitle("柱状图");
       this.setSize(250,450);
       this.setLocation(510,240);
       this.setVisible(true);
       this.setResizable(false);
  } 
public void paint(Graphics g) {
	
	//this.setBackground(Color.white);
	//g.setFont(new Font("黑体",Font.BOLD,18));  设置字体和大小
	super.paint(g);
	//写字
	
	/*g.drawString(String.valueOf(canvas3.jiediancha)+"%", 470, 60);
	g.drawString(String.valueOf(canvas3.biancha)+"%", 470, 85);
	g.drawString(String.valueOf(canvas3.xishucha)+"%", 470, 110);
	g.drawString(String.valueOf(canvas3.zhongxincha)+"%", 470, 135);
	g.drawString(String.valueOf(canvas3.xianglincha)+"%", 470, 160);*/
	
	
	
	
	/*g.drawString(canvas.s1, 113,295);
	g.drawString(canva.s1, 175, 375);*/
	
	
	/*g.drawString(canvas.h1 , 248, 70);
	g.drawString(canva.h1 ,315, 110);*/
	
	
	g.drawString(canvas.xishu2 , 380, 500);
	g.drawString(canva.xishu2 , 440, 500);
	
	/*g.drawString(String.valueOf(canvas.zhongxindu2) ,517,500);
	g.drawString(String.valueOf(canva.zhongxindu2) ,575,500);
	
	g.drawString(canvas.m1, 650, 490);
	g.drawString(canva.m1, 715, 490);*/
	//g.drawString("特征路径长度", 60, 185);
	//g.drawString("最短路径数目", 60,210);
	//g.drawString("网路中心度", 65, 235);
	
	
	//画线段
   
    
	
	
}  
     private static CategoryDataset getDataSet() {  
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
         /*dataset.addValue(canvas.s, "补气", "节点数目");  
         dataset.addValue(canva.s, "补血", "节点数目"); */ 
        /* 
         dataset.addValue(canvas.h, "补气", "边数目");  
         dataset.addValue(canva.h, "补血", "边数目");  */
         dataset.addValue(canvas.xishu1, "补气", "聚类系数");  
         dataset.addValue(canva.xishu1, "补血", "聚类系数");  
          
        /* dataset.addValue(canvas.zhongxindu1, "补气", "网络中心性");  
         dataset.addValue(canva.zhongxindu1, "补血", "网络中心性");  
        
         dataset.addValue(canvas.m, "补气", "平均相邻节点数");  
         dataset.addValue(canva.m, "补血", "平均相邻节点数");  
         */
      
        
         return dataset;  
         
}  
public ChartPanel getChartPanel(){  
  return frame1;  
    
}  
}  