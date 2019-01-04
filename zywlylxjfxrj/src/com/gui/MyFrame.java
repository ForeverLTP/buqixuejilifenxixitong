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
	private List<JMenuItem> list;// list���ڴ�Ų˵�ѡ����ÿ���˵�ѡ����Ӽ�����
	String buqiroad;//������ҩ�ɷ�·��
	String buxueroad;//��Ѫ��ҩ�ɷ�·��
	/**
	 * @���� ����ΰ
	 *  ʱ�� 2016/5/1 ���
	 *  ���� ʵ�����ݵ��� ����ͼ���� ���ݷ�����
	 */
	public static void main(String[] args) {
		MyFrame myframe = new MyFrame();
		myframe.initUI();
	}
	/**
	* �����๹�췽��
	*/
	public MyFrame(){
		this.list = new ArrayList<JMenuItem>();
	}
	/**
	   * ��ʼ������������ķ���
	   */
	public void initUI() {
	    // ���ô��������
		this.setUndecorated(false);//�����Ƿ���ʾ�˵���Χ
	//	AWTUtilities.setWindowOpaque(this, false);   //�ؼ��㣬���ô����͸��������͸������Ӱ�쵽�ڲ������������Ʊ���
	    this.setTitle("ҩ�����-�б����");
	    this.setSize(new Dimension(660, 470));
	    this.setLocationRelativeTo(null);
	    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    //Image img = Toolkit.getDefaultToolkit ().getImage ("F:\\x.png");
	    //ImageIcon img1 = new ImageIcon("F:\\yaocai.jpg");

	   // this.setIconImage(img);//����logo
	    // ���ô����˵�ѡ��ķ����ڴ����ϴ����˵�ѡ��
	    creatMenuBar();
	    JPanel centerPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 4, 4));
	    centerPanel.setLayout(new BorderLayout());
	   // JLabel label = new JLabel(img1);
	    //centerPanel.add("Center",label);
	    // ���ñ���ɫΪ��ɫ
	    centerPanel.setBackground(Color.DARK_GRAY);
//	    Button but1 = new Button("���ݵ���");
//	    but1.setBounds(10, 10, 50, 25);
	    this.add(centerPanel);
	//    centerPanel.add(but1);

	    this.setVisible(true);//��������Ϊ�ɼ�
	 // ʵ����һ���˵�ѡ�����������
//	    MenuListener ml = new MenuListener(graphics2d);
//	    System.out.println("ʲôaaaaaa��");
	    
/*	    for (JMenuItem item : list) {
	    	list.get(1).addMouseListener(new MouseAdapter() {
	    		 public void mouseClicked(ActionEvent e) {
	    			 System.out.println("ʲôʲô��");
	    			 }
	    			 });
	    //  item.addActionListener(null);
	      System.out.println("ʲôʲô��");
	    } */
	}
	/**
	* �����˵���
	*/
	private void creatMenuBar(){
		    JMenuBar menuBar = new JMenuBar();
		    String[] arrayMenu = { "���ݵ���(F)", "��ͬ����(E)", "��Ҫ������(V)", "�����Ա�(I)", "����(H)" };
		    String[][] arrayMenuItem = { { "������ҩ�ɷֵ���(N)", "��Ѫ��ҩ�ɷֵ���(O)", "���ɲ�����ҩ����ҩ��ͼ(S)","���ɲ�Ѫ��ҩ����ҩ��ͼ(S)" }, { "����ҩ�ﹲͬ�б�(C)", "����ҩ�ﹲͬС����(P)" },
		        { "������ҩС������Ҫ������(T)", "������ҩ�б���Ҫ������","��Ѫ��ҩС������Ҫ������","��Ѫ��ҩ�б���Ҫ������" }, { "��ͬ�б��ڲ�Ѫ��ҩ�İб�����Ҫ���벹Ѫȫ���б�������Ա�", "��ͬ�б��ڲ�����ҩ�İб�����Ҫ���벹��ȫ���б�������Ա�", "��ͬ�б��ڲ�Ѫ��ҩ�Ͳ�����ҩ��������ǰ�İе�Ա�(��ȡǰ10��)", "��ͬ�б��ڲ�Ѫ��ҩ�Ͳ�����ҩ��������ǰ�İе�Ա�(��ȡǰ30��)","��ͬ�б���Ҫ������ǰ��λ�б��Ӧ�ķ��ӶԱ�" },{ "��������", "����ҩ��ͼ" } };
		    for (int i = 0; i < arrayMenu.length; i++) {
		      // ʵ����һ��JMenu����
		      JMenu menu = new JMenu(arrayMenu[i]);
		      for (int j = 0; j < arrayMenuItem[i].length; j++) {
		        // ʵ����һ��JMenuItem����
		        JMenuItem item = new JMenuItem(arrayMenuItem[i][j]);
		        list.add(item);
		        // ��JMenuItem������ӵ�JMenu��
		        menu.add(item);
		        //ʵ����  ������ҩ�ɷֵ���(N) �˵�ѡ�����������*****************************************************************
		        if(i == 0 && j == 0){
		        	item.addActionListener(new ActionListener() {
		        		 @Override
			    		 public void actionPerformed(ActionEvent e) {
			    			 JFileChooser jf = new JFileChooser(); 
			 				jf.setAcceptAllFileFilterUsed(false);// ȡ�������ļ�������
			 			//	jf.setFileFilter(new FileNameExtensionFilter(".xls", "*"));// ����ֻ������չ��Ϊ.xls��Excel�ļ�
			 				FileNameExtensionFilter filter = new FileNameExtensionFilter(
			                         "Excel�ļ�", "xls", "xlsx");//�ļ���������
			 				jf.setFileFilter(filter);
			 				//���ô��ļ����ڸ�ʽ
			 				try {
			 					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			 				} catch (ClassNotFoundException | InstantiationException
			 						| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			 					e1.printStackTrace();
			 				}  
			 				SwingUtilities.updateComponentTreeUI(jf);
			 			//	jf.setFileSelectionMode(JFileChooser.SAVE_DIALOG | JFileChooser.DIRECTORIES_ONLY); //����ֻѡ���ļ�Ŀ¼
			 				jf.showDialog(null,null); 
			 				jf.showOpenDialog(null);
			 				File fi = jf.getSelectedFile(); 
			 				if(fi != null){
			 					System.out.println("����ʲô��"); 
			 				}
			 				buqiroad = fi.getAbsolutePath(); //��ȡxls�ļ�����·��
			 				System.out.println("save: "+buqiroad); 
			    			System.out.println("ʲôʲô��");
			    		 }
			    });
		        }
		        //ʵ����  ��Ѫ��ҩ�ɷֵ���(N) �˵�ѡ�����������*****************************************************************
		        if(i == 0 && j == 1){
		        	item.addActionListener(new ActionListener() {
		        		 @Override
			    		 public void actionPerformed(ActionEvent e) {
			    			JFileChooser jf = new JFileChooser(); 
			 				jf.setAcceptAllFileFilterUsed(false);// ȡ�������ļ�������
			 				FileNameExtensionFilter filter = new FileNameExtensionFilter("Excel�ļ�", "xls", "xlsx");//�ļ���������
			 				jf.setFileFilter(filter);
			 				//���ô��ļ����ڸ�ʽ
			 				try {
			 					UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
			 				} catch (ClassNotFoundException | InstantiationException
			 						| IllegalAccessException | UnsupportedLookAndFeelException e1) {
			 					e1.printStackTrace();
			 				}  
			 				SwingUtilities.updateComponentTreeUI(jf);
			 			//	jf.setFileSelectionMode(JFileChooser.SAVE_DIALOG | JFileChooser.DIRECTORIES_ONLY); //����ֻѡ���ļ�Ŀ¼
			 				jf.showDialog(null,null); 
			 				jf.showOpenDialog(null);
			 				File fi = jf.getSelectedFile(); 
			 				if(fi != null){
			 					System.out.println("����ʲô��"); 
			 				}
			 				buxueroad = fi.getAbsolutePath(); //��ȡxls�ļ�����·��
			 				System.out.println("save: "+buxueroad); 
			    		 }
		        	});
		        }
		        //ʵ����  ���ɲ�����ҩ����ҩ��ͼ   �˵�����������******************************************************************
		        if(i == 0 && j == 2){
		        	item.addActionListener(new ActionListener() {
		        		 @Override
			    		 public void actionPerformed(ActionEvent e) {
		        			 canvas.p(buqiroad);
		        		 }
		        	});
		        }
		        //ʵ����  ���ɲ�Ѫ��ҩ����ҩ��ͼ   �˵�����������******************************************************************
		        if(i == 0 && j == 3){
		        	item.addActionListener(new ActionListener() {
		        		 @Override
			    		 public void actionPerformed(ActionEvent e) {
		        			 canvas.p(buxueroad);
		        		 }
		        	});
		        }
		        
		      }
		      // ��JMenu��ӵ�JMenuBar��
		      menuBar.add(menu);
		    }
		    // ��menuBar���ô�С
		    menuBar.setPreferredSize(new Dimension(800, 30));
		    // ���������ò˵���
		    this.setJMenuBar(menuBar);
		    
	}
}
