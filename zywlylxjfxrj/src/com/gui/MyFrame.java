package com.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.filechooser.FileNameExtensionFilter;

import com.gui.paintyaoli.canvas;


public class MyFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9204803298032790647L;
	paintyaoli yaolitu;
	private List<JMenuItem> list;// list用于存放菜单选项方便给每个菜单选项添加监听器
	String buqiroad;//补气中药成分路径
	String buxueroad;//补血中药成分路径
	/**
	 * @作者 曾祥伟
	 *  时间 2016/5/1 完成
	 *  功能 实现数据导入 网络图生成 数据分析等
	 */
	public static void main(String[] args) {
		MyFrame myframe = new MyFrame();
		myframe.initUI();
	}
	/**
	* 窗体类构造方法
	*/
	public MyFrame(){
		this.list = new ArrayList<JMenuItem>();
	}
	/**
	   * 初始化画板主界面的方法
	   */
	public void initUI() {
	    // 设置窗体的属性
		this.setUndecorated(false);//设置是否显示菜单外围
	//	AWTUtilities.setWindowOpaque(this, false);   //关键点，设置窗体的透明，这种透明不会影响到内部组件，方便绘制背景
	    this.setTitle("药物分子-靶标分析");
	    this.setSize(new Dimension(660, 470));
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //Image img = Toolkit.getDefaultToolkit ().getImage ("F:\\x.png");
	    //ImageIcon img1 = new ImageIcon("F:\\yaocai.jpg");

	   // this.setIconImage(img);//设置logo
	    // 调用创建菜单选项的方法在窗体上创建菜单选项
	    creatMenuBar();
	    JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 4, 4));
	    centerPanel.setLayout(new BorderLayout());
	   // JLabel label = new JLabel(img1);
	    //centerPanel.add("Center",label);
	    // 设置背景色为灰色
	    centerPanel.setBackground(Color.DARK_GRAY);
//	    Button but1 = new Button("数据导入");
//	    but1.setBounds(10, 10, 50, 25);
	    this.add(centerPanel);
	//    centerPanel.add(but1);

	    this.setVisible(true);//窗体设置为可见
	 // 实例化一个菜单选项监听器对象
//	    MenuListener ml = new MenuListener(graphics2d);
//	    System.out.println("什么aaaaaa啊");
	    
/*	    for (JMenuItem item : list) {
	    	list.get(1).addMouseListener(new MouseAdapter() {
	    		 public void mouseClicked(ActionEvent e) {
	    			 System.out.println("什么什么鬼啊");
	    			 }
	    			 });
	    //  item.addActionListener(null);
	      System.out.println("什么什么鬼啊");
	    } */
	}
	/**
	* 创建菜单项
	*/
	private void creatMenuBar(){
		    JMenuBar menuBar = new JMenuBar();
		    String[] arrayMenu = { "数据导入(F)", "共同属性(E)", "重要性排名(V)", "排名对比(I)", "帮助(H)" };
		    String[][] arrayMenuItem = { { "补气中药成分导入(N)", "补血中药成分导入(O)", "生成补气中药网络药理图(S)","生成补血中药网络药理图(S)" }, { "两种药物共同靶标(C)", "两种药物共同小分子(P)" },
		        { "补气中药小分子重要性排名(T)", "补气中药靶标重要性排名","补血中药小分子重要性排名","补血中药靶标重要性排名" }, { "共同靶标在补血中药的靶标中重要性与补血全部靶标的排名对比", "共同靶标在补气中药的靶标中重要性与补气全部靶标的排名对比", "共同靶标在补血中药和补气中药排名都靠前的靶点对比(各取前10个)", "共同靶标在补血中药和补气中药排名都靠前的靶点对比(各取前30个)","共同靶标重要性排名前三位靶标对应的分子对比" },{ "帮助主题", "关于药理图" } };
		    for (int i = 0; i < arrayMenu.length; i++) {
		      // 实例化一个JMenu对象
		      JMenu menu = new JMenu(arrayMenu[i]);
		      for (int j = 0; j < arrayMenuItem[i].length; j++) {
		        // 实例化一个JMenuItem对象
		        JMenuItem item = new JMenuItem(arrayMenuItem[i][j]);
		        list.add(item);
		        // 将JMenuItem对象添加到JMenu中
		        menu.add(item);
		        //实例化  补气中药成分导入(N) 菜单选项监听器对象*****************************************************************
		        if(i == 0 && j == 0){
		        	item.addActionListener(new ActionListener() {
		        		 @Override
			    		 public void actionPerformed(ActionEvent e) {
			    			 JFileChooser jf = new JFileChooser(); 
			 				jf.setAcceptAllFileFilterUsed(false);// 取消所有文件过滤项
			 			//	jf.setFileFilter(new FileNameExtensionFilter(".xls", "*"));// 设置只过滤扩展名为.xls的Excel文件
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
			 			//	jf.setFileSelectionMode(JFileChooser.SAVE_DIALOG | JFileChooser.DIRECTORIES_ONLY); //设置只选择文件目录
			 				jf.showDialog(null,null); 
			 				jf.showOpenDialog(null);
			 				File fi = jf.getSelectedFile(); 
			 				if(fi != null){
			 					System.out.println("我是什么鬼"); 
			 				}
			 				buqiroad = fi.getAbsolutePath(); //获取xls文件绝对路径
			 				System.out.println("save: "+buqiroad); 
			    			System.out.println("什么什么鬼啊");
			    		 }
			    });
		        }
		        //实例化  补血中药成分导入(N) 菜单选项监听器对象*****************************************************************
		        if(i == 0 && j == 1){
		        	item.addActionListener(new ActionListener() {
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
			 			//	jf.setFileSelectionMode(JFileChooser.SAVE_DIALOG | JFileChooser.DIRECTORIES_ONLY); //设置只选择文件目录
			 				jf.showDialog(null,null); 
			 				jf.showOpenDialog(null);
			 				File fi = jf.getSelectedFile(); 
			 				if(fi != null){
			 					System.out.println("我是什么鬼"); 
			 				}
			 				buxueroad = fi.getAbsolutePath(); //获取xls文件绝对路径
			 				System.out.println("save: "+buxueroad); 
			    		 }
		        	});
		        }
		        //实例化  生成补气中药网络药理图   菜单监听器对象******************************************************************
		        if(i == 0 && j == 2){
		        	item.addActionListener(new ActionListener() {
		        		 @Override
			    		 public void actionPerformed(ActionEvent e) {
		        			 canvas.p(buqiroad);
		        		 }
		        	});
		        }
		        //实例化  生成补血中药网络药理图   菜单监听器对象******************************************************************
		        if(i == 0 && j == 3){
		        	item.addActionListener(new ActionListener() {
		        		 @Override
			    		 public void actionPerformed(ActionEvent e) {
		        			 canvas.p(buxueroad);
		        		 }
		        	});
		        }
		        
		      }
		      // 将JMenu添加到JMenuBar中
		      menuBar.add(menu);
		    }
		    // 给menuBar设置大小
		    menuBar.setPreferredSize(new Dimension(800, 30));
		    // 给窗体设置菜单栏
		    this.setJMenuBar(menuBar);
		    
	}
}
