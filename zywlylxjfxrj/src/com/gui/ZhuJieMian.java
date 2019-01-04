package com.gui;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.gui.BuqiBuxueshujuduibi.canvas3;
import com.gui.BuqiDetail.canvas1;
import com.gui.BuxueDetail.canvas2;
import com.gui.paintbuxueyaolitu.canva;
import com.gui.paintyaoli.canvas;


public class ZhuJieMian extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1583464171304496594L;
	BianTu bt;
	JuLeiXiShuTu  jlxst; 
	WangLuoZhongXinDuTu  zxdt;
	PingJunXiangLinJieDianShuTu pjxljds;
	ZhuZhuangTujds zzt;
	paintyaoli yaolitu;
	paintbuxueyaolitu buxueyaolitu;
	GongTongShuXing gongtongba;
	BuXueZhongYaoXingPaiMing buxuezhongyao;
	BuQiZhongYaoXingPaiMing buqizhongyao;
	GongTongBaBiaoBuQi gongbabuqi;
	
	
	String[] buqiroad1=new String[1000];//补气中药成分路径
	String[] buxueroad1=new String[1000];//补血中药成分路径
	String buqiroad,buxueroad;
	/*static int q;//获取导入补气或者补血是第几个文件
	static int x;*/
	/*public int getQ() {
		return q;
	}
	public void setQ(int q) {
		this.q = q;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}*/
	static int t,h;//延续前面几次导入文件的次数
	
	JPanel imagepanel1 = new JPanel();
	JPanel imagepanel2 = new JPanel();
	JPanel imagepanel3 = new JPanel();
	JPanel imagepanel4 = new JPanel();
	JPanel imagepanel5 = new JPanel();
	JButton b1,b2,b3,b4,b0; //b1：导入文件, b2：共同性, b3：重要性排名 ,b4：排名对比,b0：logo
	JButton b5,b6,b7,b8,b9,b20; //依次表示 补气导入  补血导入  网络图  共同小分子  共同靶标  补气补血数据对比
	JButton b10,b11,b12,b13;
	JButton b14,b15,b16,b17,b18;
	String shujuduibi="img/shujuduibi.png";
	String buqianniu = "img/buqitu.png",buxueanniu = "img/buxuetu.png";
	String daoru = "img/0.jpg",gongtong = "img/1.png",zhongyao = "img/2.png",paiming = "img/3.png",logo = "img/haopa.png",candanbei = "img/caidanbeijing.png";
	String beijingtu = "img/background.jpg",buqi = "img/buqi.png",buxue = "img/buxue.png",gongtongxiaofenzi = "img/gongtongxiaofenzi.png",wangluotu = "img/wangluotu.png",gongtongbabiao ="img/gongtongbabiao.png";
	String zhong1 = "img/buxuexiaofenzizhongyao.png",zhong2 = "img/buxuebabiaozhongyao.png",zhong3 = "img/buqixiaofenzizhongyao.png",zhong4 = "img/buqibabiaozhongyao.png";
	String pai1 = "img/gongbabuxue.png",pai2 = "img/gongbabuqi.png",pai3 = "img/gongbabuxuebuqiqianshi.png",pai4 = "img/gongbabuxuebuqiqiansanshi.png",pai5 = "img/gongbaqiansan.png";
	@SuppressWarnings("deprecation")
	public void Tianjiatupian(){
		ImageIcon background = new ImageIcon(beijingtu);//背景图片
		final JLabel label1 = new JLabel(background);//把背景图片放在一个标签里
		final JLabel label3 = new JLabel(background);//把背景图片放在一个标签里
		final JLabel label4 = new JLabel(background);//把背景图片放在一个标签里
		final JLabel label5 = new JLabel(background);//把背景图片放在一个标签里
		final JLabel label6 = new JLabel(background);//把背景图片放在一个标签里

/*		ImageIcon image0 = new ImageIcon(logo);//logo
		JLabel label2 = new JLabel(image0);
		label2.setBounds(26, -10, 80, 80);
		this.add(label2);
		ImageIcon image1 = new ImageIcon(daoru);//导入文件
		b1 = new JButton(image1);
		b1.setBounds(120, 10, 100, 40);
		this.add(b1);
		ImageIcon image2 = new ImageIcon(gongtong);//共同性
		b2 = new JButton(image2);
		b2.setBounds(270, 10, 100, 40);
		this.add(b2);
		ImageIcon image3 = new ImageIcon(zhongyao);//重要性排名
		b3 = new JButton(image3);
		b3.setBounds(420, 10, 100, 40);
		this.add(b3);
		ImageIcon image4 = new ImageIcon(paiming);//排名对比
		b4 = new JButton(image4);
		b4.setBounds(570, 10, 100, 40);
		this.add(b4); */
		
		ImageIcon imgg = new ImageIcon(candanbei);//菜单背景
		JLabel labell = new JLabel(imgg);
		labell.setBounds(0, 0, 723, 58);
		this.add(labell);
		
		ImageIcon image0 = new ImageIcon(logo);//logo
		JLabel label2 = new JLabel(image0);
		label2.setBounds(26, -10, 80, 80);
		labell.add(label2);
		ImageIcon image1 = new ImageIcon(daoru);//导入文件
		b1 = new JButton(image1);
		b1.setBounds(120, 10, 100, 40);
		labell.add(b1);
		ImageIcon image2 = new ImageIcon(gongtong);//共同性
		b2 = new JButton(image2);
		b2.setBounds(270, 10, 100, 40);
		labell.add(b2);
		ImageIcon image3 = new ImageIcon(zhongyao);//重要性排名
		b3 = new JButton(image3);
		b3.setBounds(420, 10, 100, 40);
		labell.add(b3);
		ImageIcon image4 = new ImageIcon(paiming);//排名对比
		b4 = new JButton(image4);
		b4.setBounds(570, 10, 100, 40);
		labell.add(b4); 
		
		
		
		
		//数据导入面板
		imagepanel1.setBounds(0, 50, 720, 400);
		this.add(imagepanel1);
		imagepanel1.add(label1);
		label1.setBounds(0, 50, 720, 400);//设置背景图片位置   
		ImageIcon image5 = new ImageIcon(buqi);//导入补气 按钮
		b5 = new JButton(image5);
		b5.setBounds(70, 50, 570, 25);
		label1.add(b5);
		b5.addActionListener(new ActionListener() {
   		 @Override
   		 public void actionPerformed(ActionEvent e) {
   			    JFileChooser jf = new JFileChooser(); 
				jf.setAcceptAllFileFilterUsed(false);// 取消所有文件过滤项
				FileNameExtensionFilter filter = new FileNameExtensionFilter(
                        "Excel文件", "xls", "xlsx");//文件名过滤器
				jf.setFileFilter(filter);
				//设置打开文件窗口格式
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException | UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}  
				SwingUtilities.updateComponentTreeUI(jf);
				//jf.showDialog(null,null); 
				jf.showOpenDialog(null);
				File fi = jf.getSelectedFile(); 
				
				if(fi == null){
					System.out.println("文件为空！"); 
				}else{
				buqiroad = fi.getAbsolutePath(); //获取xls文件绝对路径
				System.out.println("save: "+buqiroad); 
				for(int i=0;i<1;i++){
				buqiroad1[t] = fi.getAbsolutePath(); //获取xls文件绝对路径
				System.out.println("save: "+t+buqiroad1[t]); 
				t++;
				}
				}
				}
			});
		ImageIcon image6 = new ImageIcon(buxue);//导入补血 按钮
		b6 = new JButton(image6);
		b6.setBounds(70, 95, 570, 25);
		label1.add(b6);
		b6.addActionListener(new ActionListener() {
   		 @Override
   		 public void actionPerformed(ActionEvent e) {
   			JFileChooser jf = new JFileChooser(); 
				jf.setAcceptAllFileFilterUsed(false);// 取消所有文件过滤项
				FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel文件", "xls", "xlsx");//文件名过滤器
				jf.setFileFilter(filter);
				//设置打开文件窗口格式
				try {
					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
				} catch (ClassNotFoundException | InstantiationException
						| IllegalAccessException | UnsupportedLookAndFeelException e1) {
					e1.printStackTrace();
				}  
				SwingUtilities.updateComponentTreeUI(jf);
				//jf.showDialog(null,null); 
				jf.showOpenDialog(null);
				File fi = jf.getSelectedFile(); 
				
				if(fi == null){
					System.out.println("该文件为空！"); 
					
				}else{
					buxueroad = fi.getAbsolutePath(); //获取xls文件绝对路径
					System.out.println("save: "+buxueroad); 
				for(int i=0;i<1;i++){
				buxueroad1[h] = fi.getAbsolutePath(); //获取xls文件绝对路径
				
				System.out.println("save: "+h+buxueroad1[h]); 
				h++;
				}
				}
   		 }
		});
		ImageIcon image7 = new ImageIcon(buqianniu);
		b7 = new JButton(image7);    //生成补气图按钮
		b7.setBounds(70, 135, 570, 25);
		label1.add(b7);
		b7.addActionListener(new ActionListener() {
   		 @Override
   		 public void actionPerformed(ActionEvent e) {
   			 canvas.p(buqiroad);
   			
   			canvas1.p(buqiroad);
   			
   			 
   			 }
   	    });
		ImageIcon image19 = new ImageIcon(buxueanniu);
		JButton b19 = new JButton(image19);    //生成补血图按钮
		b19.setBounds(70, 175, 570, 25);
		label1.add(b19);
		b19.addActionListener(new ActionListener() {
   		 @Override
   		 public void actionPerformed(ActionEvent e) {
   			 canva.p(buxueroad);
   			canvas2.p(buxueroad);
   		 }
   	    });
		ImageIcon image20=new ImageIcon(shujuduibi);
		b20=new JButton(image20);//生成补气补血数据对比
		b20.setBounds(70,215,570,25);
		label1.add(b20);
		
		b20.addActionListener(new ActionListener() {
	   		 @Override
	   		 public void actionPerformed(ActionEvent e) {
	   			 
	   			canvas3.p(buqiroad,buxueroad);
		   			zzt=new ZhuZhuangTujds();
		   			bt=new BianTu();
		   			jlxst=new JuLeiXiShuTu();
		   			zxdt=new WangLuoZhongXinDuTu();
		   			pjxljds=new PingJunXiangLinJieDianShuTu();
	   			
	   		 }
	   	    });
		
	
		//共同性面板
		imagepanel3.setBounds(0, 50, 720, 400);
		this.add(imagepanel3);
		imagepanel3.add(label4);
		label4.setBounds(0, 50, 720, 400);//设置背景图片位置
		ImageIcon image8 = new ImageIcon(gongtongbabiao);
		b8 = new JButton(image8);   //生成共同靶标按钮
		b8.setBounds(70, 50, 570, 25);
		label4.add(b8);
		b8.addActionListener(new ActionListener() {
	   		 @Override
	   		 public void actionPerformed(ActionEvent e) {
	   			GongTongShuXing.shuxingbabiao(buqiroad1, buxueroad1);
	   		 }
	   	});
		
		
		ImageIcon image9 = new ImageIcon(gongtongxiaofenzi);
		b9 = new JButton(image9);  //生成共同小分子按钮
		b9.setBounds(70, 95, 570, 25);
		label4.add(b9);
		b9.addActionListener(new ActionListener() {
	   		 @Override
	   		 public void actionPerformed(ActionEvent e) {
	   			GongTongShuXing.shuxiaofenzi(buqiroad1, buxueroad1);
	   		 }
	   	});
		label4.hide();
		imagepanel3.hide();
		//重要性面板
		imagepanel2.setBounds(0, 50, 720, 400);
		this.add(imagepanel2);
		imagepanel2.add(label3);
		label3.setBounds(0, 50, 720, 400);//设置背景图片位置
		ImageIcon image10 = new ImageIcon(zhong1);//补血中药小分子重要性排名
		b10 = new JButton(image10);
		b10.setBounds(70, 50, 570, 25);
		label3.add(b10);
		b10.addActionListener(new ActionListener() {
	   		 @Override
	   		 public void actionPerformed(ActionEvent e) {
	   			BuXueZhongYaoXingPaiMing.Buxuexiaofenzipaiming(buxueroad1);
	   		 }
	   	});
		ImageIcon image11 = new ImageIcon(zhong2);//补血中药靶标重要性排名
		b11 = new JButton(image11);
		b11.setBounds(70, 95, 570, 25);
		label3.add(b11);
		b11.addActionListener(new ActionListener() {
	   		 @Override
	   		 public void actionPerformed(ActionEvent e) {
	   			BuXueZhongYaoXingPaiMing.Buxuebabiaopaiming(buxueroad1);
	   		 }
	   	});
		ImageIcon image12 = new ImageIcon(zhong3);//补气中药小分子重要性排名
		b12 = new JButton(image12);
		b12.setBounds(70, 135, 570, 25);
		label3.add(b12);
		b12.addActionListener(new ActionListener() {
	   		 @Override
	   		 public void actionPerformed(ActionEvent e) {
	   			BuQiZhongYaoXingPaiMing.Buqixiaofenzipaiming(buqiroad1);
	   		 }
	   	});
		ImageIcon image13 = new ImageIcon(zhong4);//补气中药靶标重要性排名
		b13 = new JButton(image13);
		b13.setBounds(70, 175, 570, 25);
		label3.add(b13);
		b13.addActionListener(new ActionListener() {
	   		 @Override
	   		 public void actionPerformed(ActionEvent e) {
	   			BuQiZhongYaoXingPaiMing.Buqibabiaopaiming(buqiroad1);
	   		 }
	   	});
		label3.hide();
		imagepanel2.hide();
		//排名对比面板
		imagepanel4.setBounds(0, 50, 720, 400);
		this.add(imagepanel4);
		imagepanel4.add(label5);
		label5.setBounds(0, 50, 720, 400);//设置背景图片位置   
		ImageIcon image14 = new ImageIcon(pai1);//共同靶标在补血中药的靶标中重要性与补血全部靶标的排名对比
		b14 = new JButton(image14);
		b14.setBounds(70, 50, 570, 25);
		label5.add(b14);
		b14.addActionListener(new ActionListener() {
	   		 @Override
	   		 public void actionPerformed(ActionEvent e) {
	   			GongTongBaBiaoBuQi.GongBaBuXue();
	   		 }
	   	});
		ImageIcon image15 = new ImageIcon(pai2);//共同靶标在补气中药的靶标中重要性与补气全部靶标的排名对比
		b15 = new JButton(image15);
		b15.setBounds(70, 95, 570, 25);
		label5.add(b15);
		b15.addActionListener(new ActionListener() {
	   		 @Override
	   		 public void actionPerformed(ActionEvent e) {
	   			GongTongBaBiaoBuQi.GongBaBuQi();
	   		 }
	   	});
		ImageIcon image16 = new ImageIcon(pai3);//共同靶标在补血中药和补气中药排名都靠前的靶标对比(各取前10个)
		b16 = new JButton(image16);
		b16.setBounds(70, 135, 570, 25);
		label5.add(b16);
		b16.addActionListener(new ActionListener() {
	   		 @Override
	   		 public void actionPerformed(ActionEvent e) {
	   			GongTongBaBiaoBuQi.GongBaqianshi();
	   		 }
	   	});
		ImageIcon image17 = new ImageIcon(pai4);//共同靶标在补血中药和补气中药排名都靠前的靶标对比(各取前30个)
		b17 = new JButton(image17);
		b17.setBounds(70, 175, 570, 25);
		label5.add(b17);
		b17.addActionListener(new ActionListener() {
	   		 @Override
	   		 public void actionPerformed(ActionEvent e) {
	   			GongTongBaBiaoBuQi.GongBaqiansanshi();
	   		 }
	   	});
		ImageIcon image18 = new ImageIcon(pai5);//共同靶标重要性排名前三位靶标对应的分子对比
		b18 = new JButton(image18);
		b18.setBounds(70, 215, 570, 25);
		label5.add(b18);
		b18.addActionListener(new ActionListener() {
	   		 @Override
	   		 public void actionPerformed(ActionEvent e) {
	   			GongTongBaBiaoBuQi.GongBaqiansanfenzi(buqiroad1, buxueroad1);
	   		 }
	   	});
		label5.hide();
		imagepanel4.hide();
		//共同性面板///////////////////////////////////////////////////////////////////无作用面板
				imagepanel5.setBounds(0, 50, 720, 400);
				this.add(imagepanel5);
				imagepanel5.add(label6);
				label6.setBounds(0, 50, 720, 400);//设置背景图片位置
				b8 = new JButton(image8);
				b8.setBounds(70, 50, 570, 25);
				label6.add(b8);
				b9 = new JButton(image9);
				b9.setBounds(70, 95, 570, 25);
				label6.add(b9);
				label6.hide();
				imagepanel5.hide();////////////////////////////////////////////////无作用面板
		//依次给四个按钮添加点击事件
		b1.addActionListener(new ActionListener(){  //给导入文件添加监听事件
			@Override
			public void actionPerformed(ActionEvent e) {
				imagepanel2.hide();
				label3.hide();
				imagepanel3.hide();
				label4.hide();
				label5.hide();
				imagepanel4.hide();
				imagepanel1.setVisible(true);
				label1.setVisible(true);
			}
		});
		b2.addActionListener(new ActionListener(){  //给共同性添加监听事件
			@Override
			public void actionPerformed(ActionEvent e) {
				imagepanel2.hide();
				label3.hide();
				imagepanel1.hide();
				label1.hide();
				label5.hide();
				imagepanel4.hide();
				imagepanel3.setVisible(true);
				label4.setVisible(true);
			}	
		}); 
		b3.addActionListener(new ActionListener(){  //给重要性排名添加监听事件
			@Override
			public void actionPerformed(ActionEvent e) {
				imagepanel1.hide();
				label1.hide();
				imagepanel3.hide();
				label4.hide();
				label5.hide();
				imagepanel4.hide();
				imagepanel2.setVisible(true);
				label3.setVisible(true);
				
			}
		});
		b4.addActionListener(new ActionListener(){  //给排名对比添加监听事件
			@Override
			public void actionPerformed(ActionEvent e) {
				imagepanel1.hide();
				label1.hide();
				imagepanel3.hide();
				label4.hide();
				label3.hide();
				imagepanel2.hide();
				label5.setVisible(true);
				imagepanel4.setVisible(true);
			}
		});   

		this.setTitle("中药网络药理数据分析软件");
//		this.setLocationRelativeTo(null); //设置窗口居中
		this.setLocation(300, 150);
		//Image img = Toolkit.getDefaultToolkit ().getImage ("F:\\logo.png");
		this.setBackground(Color.white);
		this.setSize(727, 490);
		this.setResizable(false);//设置窗口大小不可更改
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		ZhuJieMian zhujiemian = new ZhuJieMian();
		zhujiemian.Tianjiatupian();
	}

}
