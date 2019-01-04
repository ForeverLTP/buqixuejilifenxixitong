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
                           "", // ͼ�����  
                          "��������", // Ŀ¼�����ʾ��ǩ  
                          "ֵ", // ��ֵ�����ʾ��ǩ  
                          dataset, // ���ݼ�  
                          PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ  
                          true,           // �Ƿ���ʾͼ��(���ڼ򵥵���״ͼ������false)  
                          false,          // �Ƿ����ɹ���  
                          false           // �Ƿ�����URL����  
                          );  
        
      //�����￪ʼ  
      CategoryPlot plot=chart.getCategoryPlot();//��ȡͼ���������  
      CategoryAxis domainAxis=plot.getDomainAxis();         //ˮƽ�ײ��б�  
       domainAxis.setLabelFont(new Font("����",Font.BOLD,14));         //ˮƽ�ײ�����  
       domainAxis.setTickLabelFont(new Font("����",Font.BOLD,12));  //��ֱ����  
       ValueAxis rangeAxis=plot.getRangeAxis();//��ȡ��״  
       rangeAxis.setLabelFont(new Font("����",Font.BOLD,15));  
        chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));  
        chart.getTitle().setFont(new Font("����",Font.BOLD,20));//���ñ�������  
          
        //�������������Ȼ�����е�࣬��ֻΪһ��Ŀ�ģ����������������  
        
        
        BarRenderer3D renderer = new BarRenderer3D();

        renderer.setSeriesPaint(0, new Color(241,9,14)); //9��

        renderer.setSeriesPaint(1, new Color(243,92,0)); //8��

        renderer.setSeriesPaint(2, new Color(100,0,220));

        renderer.setSeriesPaint(3, new Color(2,93,220));

        renderer.setSeriesPaint(4, new Color(142,204,241));

        renderer.setSeriesPaint(5, new Color(15,160,0));

        renderer.setSeriesPaint(6, new Color(173,220,0));

         

        //�����������Ƿ���ʾ���ӵ���ֵ

        renderer.setItemLabelGenerator(new StandardCategoryItemLabelGenerator());

        renderer.setItemLabelsVisible(true);

        //������������ֵ����ʾλ�ã������ӵı�����Сʱ�����ӵ���ֵ���޷���ʾ�����Ը�����ֵ����ʾλ���������Ϸ�������ֵ����ʱ����������ֵ��ƫ�ƶ�,���һ������(-1.57D)Ϊ��ת�ĽǶ�ֵ(90��)/3.14.

        renderer.setPositiveItemLabelPosition(new ItemLabelPosition(  

        ItemLabelAnchor.OUTSIDE12, TextAnchor.BOTTOM_LEFT,TextAnchor.HALF_ASCENT_LEFT,0D));

        renderer.setItemLabelFont(new Font("��ɫ",Font.BOLD,12));

        //ʹ������

        plot.setRenderer(renderer);
          
       frame1=new ChartPanel(chart,true); //����Ҳ������chartFrame,����ֱ������һ��������Frame  
       frame1.setVerticalAxisTrace(true);
      // frame1.setHorizontalAxisTrace(true);���ŵĸ�����
       frame1.setMouseZoomable(false, false);//˫flase����ʹ�������ͼ���ƶ����ı�ͼ����״
       setContentPane(frame1);
       //this.add(frame1);
       this.setTitle("��״ͼ");
       this.setSize(250,450);
       this.setLocation(510,240);
       this.setVisible(true);
       this.setResizable(false);
  } 
public void paint(Graphics g) {
	
	//this.setBackground(Color.white);
	//g.setFont(new Font("����",Font.BOLD,18));  ��������ʹ�С
	super.paint(g);
	//д��
	
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
	//g.drawString("����·������", 60, 185);
	//g.drawString("���·����Ŀ", 60,210);
	//g.drawString("��·���Ķ�", 65, 235);
	
	
	//���߶�
   
    
	
	
}  
     private static CategoryDataset getDataSet() {  
         DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
         /*dataset.addValue(canvas.s, "����", "�ڵ���Ŀ");  
         dataset.addValue(canva.s, "��Ѫ", "�ڵ���Ŀ"); */ 
        /* 
         dataset.addValue(canvas.h, "����", "����Ŀ");  
         dataset.addValue(canva.h, "��Ѫ", "����Ŀ");  */
         dataset.addValue(canvas.xishu1, "����", "����ϵ��");  
         dataset.addValue(canva.xishu1, "��Ѫ", "����ϵ��");  
          
        /* dataset.addValue(canvas.zhongxindu1, "����", "����������");  
         dataset.addValue(canva.zhongxindu1, "��Ѫ", "����������");  
        
         dataset.addValue(canvas.m, "����", "ƽ�����ڽڵ���");  
         dataset.addValue(canva.m, "��Ѫ", "ƽ�����ڽڵ���");  
         */
      
        
         return dataset;  
         
}  
public ChartPanel getChartPanel(){  
  return frame1;  
    
}  
}  