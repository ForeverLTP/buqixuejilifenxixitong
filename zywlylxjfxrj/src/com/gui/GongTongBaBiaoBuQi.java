package com.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import javax.swing.filechooser.FileSystemView;

import jxl.Sheet;
import jxl.Workbook;


public class GongTongBaBiaoBuQi {

	/**
	 * ��ͬ�б��ڲ�����Ѫ��ҩ�е������Ա�
	 * breakֻ����ֹһ��ѭ��
	 */
	static JtableToGongBaBuXue gongbabuxuehaha = new JtableToGongBaBuXue();
	static JtableToGongBaBuQi gongbabuqihaha = new JtableToGongBaBuQi();
	public static Jtableqianshi qianshi = new Jtableqianshi();
	public static JtableQianSanShi qiansanshi = new JtableQianSanShi();
	public static JtableQianSanFenZi qiansan = new JtableQianSanFenZi();
	
	static String[] bqbabiaopaiming = new String[10000];
	static String[] bxbabiaopaiming = new String[10000];
	static String[] qianshibq=new String[10];
	static String[] qianshibx=new String[10];
	static String[] qiansanshibq=new String[30];
	static String[] qiansanshibx=new String[30];
	static String[] qiansanbq=new String[10000];
	static String[] qiansanbx=new String[10000];
	static String[] xiaofenzibq = new String[10000];
	static String[] xiaofenzibx = new String[10000];
	
	static String path;
	//��ʼ��·��
	static{
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File desktop=fsv.getHomeDirectory();  
		path = desktop.getAbsolutePath();
	}
	
	public static void GongBaBuQi(){ //��ͬ�б��ڲ�����ҩ�İе�����Ҫ���벹����ҩȫ���е�������Ա�
		int i; 
		int k1=0;
		
		try{
			
			if(ZhuJieMian.t!=0){
			for(int y=0;y<BuQiZhongYaoXingPaiMing.babiaopaiming.length;y++){
				int m=0;
				if(BuQiZhongYaoXingPaiMing.babiaopaiming[y]==null){
					break;
				}else{
			    for(int k=0;k<GongTongShuXing.gongbabiao.length;k++){
				if(GongTongShuXing.gongbabiao[k]==null){
					break;
				}else{
				if(BuQiZhongYaoXingPaiMing.babiaopaiming[y].equals(GongTongShuXing.gongbabiao[k])){
					
					bqbabiaopaiming[k1] = "��ͬ�б�: " + BuQiZhongYaoXingPaiMing.babiaopaiming[y];
					k1++;
					m++;
							}
						}
			    	}
			   if(m==0){
					bqbabiaopaiming[k1]=BuQiZhongYaoXingPaiMing.babiaopaiming[y];
					k1++;
					
					
					
						}
				}
				
			}
			/*for(i=0;i<bqbabiaopaiming.length;i++){
				if(bqbabiaopaiming[i]==null)
					break;
			System.out.println(bqbabiaopaiming[i]);
			}*/
			}
		gongbabuqihaha.huabiaoge(bqbabiaopaiming, BuQiZhongYaoXingPaiMing.babiaocishu);
		//�������� �б���Ҫ������txt�ļ�***********************************************************************************
		FileOutputStream fs3 = new FileOutputStream(new File(path+"/��ͬ�б��ڲ�����ҩ�б�����Ҫ���벹��ȫ���б�������Ա�.txt")); //file1.getName().substring(0, file1.getName().indexOf("."))ȥ���ļ���׺��
		PrintStream p3 = new PrintStream(fs3);
		for(i = 0;i < bqbabiaopaiming.length;i++){
			if(bqbabiaopaiming[i] == null)
				continue;
			else{
				
				p3.println(i+1 + " " +  bqbabiaopaiming[i]);//���ļ���д������
			}
		}	
		p3.close(); 


		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void GongBaBuXue(){//��ͬ�е��ڲ�Ѫ��ҩ�İе�����Ҫ���벹Ѫ��ҩȫ���е�������Ա�
		int i; //index1��С���Ӱб�������ĵ�һ�����ݺ����꣬index2��С���ӵ�һ�����ݺ����꣬index3�ǰб��һ�����ݺ�����
		int k1=0;
		try{
			
			if(ZhuJieMian.h!=0){
			for(int y=0;y<BuXueZhongYaoXingPaiMing.babiaopaiming.length;y++){
				int m=0;
				if(BuXueZhongYaoXingPaiMing.babiaopaiming[y]==null){
					break;
				}else{
				for(int k=0;k<GongTongShuXing.gongbabiao.length;k++){
					if(GongTongShuXing.gongbabiao[k]==null){
						break;
					}
					if(BuXueZhongYaoXingPaiMing.babiaopaiming[y].equals(GongTongShuXing.gongbabiao[k])){
						bxbabiaopaiming[k1] = "��ͬ�б�: " + BuXueZhongYaoXingPaiMing.babiaopaiming[y];
						k1++;
						m++;
					}
				}
				if(m==0){
					bxbabiaopaiming[k1]=BuXueZhongYaoXingPaiMing.babiaopaiming[y];
					k1++;
				}
				}
				}
			}
			
		gongbabuxuehaha.huabiaoge(bxbabiaopaiming, BuXueZhongYaoXingPaiMing.babiaocishu);
		//�������� �б���Ҫ������txt�ļ�***********************************************************************************
		
		FileOutputStream fs4 = new FileOutputStream(new File(path+"/��ͬ�б��ڲ�Ѫ��ҩ�б�����Ҫ���벹Ѫȫ���б�������Ա�.txt")); //file1.getName().substring(0, file1.getName().indexOf("."))ȥ���ļ���׺��
		PrintStream p4 = new PrintStream(fs4);
		for(i = 0;i < bxbabiaopaiming.length;i++){
			if(bxbabiaopaiming[i] == null)
				continue;
			else{
				p4.println(i+1 + " " +  bxbabiaopaiming[i]);//���ļ���д������
			}
		}	
		p4.close(); 
		

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void GongBaqianshi(){//��ͬ�е��ڲ�Ѫ�Ͳ�����ҩ��������ǰ�İб�Ա�(��ȡǰ10��)
		int i; //index1��С���Ӱб�������ĵ�һ�����ݺ����꣬index2��С���ӵ�һ�����ݺ����꣬index3�ǰб��һ�����ݺ�����
		int k1=0,k2=0;
		try{
			
			if(ZhuJieMian.t!=0){
			for(int y=0;y<BuQiZhongYaoXingPaiMing.babiaopaiming.length;y++){
				
				
				if(BuQiZhongYaoXingPaiMing.babiaopaiming[y]==null){
					break;
				}
				if(k1>=10){
					break;
				}
				for(int k=0;k<GongTongShuXing.gongbabiao.length;k++){
					if(GongTongShuXing.gongbabiao[k]==null){
						break;
					}
					
					if(BuQiZhongYaoXingPaiMing.babiaopaiming[y].equals(GongTongShuXing.gongbabiao[k])){
						qianshibq[k1]=BuQiZhongYaoXingPaiMing.babiaopaiming[y];
						
						k1++;
						
					}
					
				}
				
				}
			}
			if(ZhuJieMian.h!=0){
				for(int y=0;y<BuXueZhongYaoXingPaiMing.babiaopaiming.length;y++){
					//System.out.println("qqqqqqqqqqqqqqqqqq"+BuXueZhongYaoXingPaiMing.babiaopaiming[y]);
					if(BuXueZhongYaoXingPaiMing.babiaopaiming[y]==null){
						break;
					}
					if(k2>=10){
						break;
					}
					for(int k=0;k<GongTongShuXing.gongbabiao.length;k++){
						if(GongTongShuXing.gongbabiao[k]==null){
							break;
						}
						
						if(BuXueZhongYaoXingPaiMing.babiaopaiming[y].equals(GongTongShuXing.gongbabiao[k])){
							qianshibx[k2]=BuXueZhongYaoXingPaiMing.babiaopaiming[y];
							System.out.println("qianshibuxue="+qianshibx[k2]);
							k2++;
							
						}
						
					}
					}
				}
				
		qianshi.huabiaoge(qianshibq, qianshibx);
	
		//��������-��ͬ�е��ڲ�Ѫ��ҩ�Ͳ�����ҩ��������ǰ�İе�Աȣ���ȡǰ10����txt�ļ�***********************************************************************************
		FileOutputStream fs5 = new FileOutputStream(new File(path+"/����-��ͬ�б��ڲ�Ѫ��ҩ�Ͳ�����ҩ��������ǰ�İе�Ա�-ǰ10��.txt")); //file1.getName().substring(0, file1.getName().indexOf("."))ȥ���ļ���׺��
		PrintStream p5 = new PrintStream(fs5);
		for(i = 0;i < 10;i ++){
				p5.println(i+1 + " " +  qianshibq[i]);//���ļ���д������
		}	
		p5.close(); 		
		//��������-��ͬ�е��ڲ�Ѫ��ҩ�Ͳ�����ҩ��������ǰ�İе�Աȣ���ȡǰ10����txt�ļ�***********************************************************************************
		FileOutputStream fs6 = new FileOutputStream(new File(path+"/��Ѫ-��ͬ�б��ڲ�Ѫ��ҩ�Ͳ�����ҩ��������ǰ�İе�Ա�-ǰ10��.txt")); //file1.getName().substring(0, file1.getName().indexOf("."))ȥ���ļ���׺��
		PrintStream p6 = new PrintStream(fs6);
		for(i = 0;i < 10;i ++){
				p6.println(i+1 + " " + qianshibx[i]);//���ļ���д������
		}	
		p6.close(); 
		

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void GongBaqiansanshi(){//��ͬ�е��ڲ�Ѫ�Ͳ�����ҩ��������ǰ�İб�Ա�(��ȡǰ30��)
		int i; 
		int k1=0,k2=0;
		try{
			

			if(ZhuJieMian.t!=0){
			for(int y=0;y<BuQiZhongYaoXingPaiMing.babiaopaiming.length;y++){
				if(BuQiZhongYaoXingPaiMing.babiaopaiming[y]==null){
					break;
				}
				if(k1>=30){
					break;
				}
				for(int k=0;k<GongTongShuXing.gongbabiao.length;k++){
					if(GongTongShuXing.gongbabiao[k]==null){
						break;
					}
					
					if(BuQiZhongYaoXingPaiMing.babiaopaiming[y].equals(GongTongShuXing.gongbabiao[k])){
						qiansanshibq[k1]=BuQiZhongYaoXingPaiMing.babiaopaiming[y];
						k1++;
						
					}
					
				}
				}
			}
			if(ZhuJieMian.h!=0){
				for(int y=0;y<BuXueZhongYaoXingPaiMing.babiaopaiming.length;y++){
					if(BuXueZhongYaoXingPaiMing.babiaopaiming[y]==null){
						break;
					}
					if(k2>=30){
						break;
					}
					for(int k=0;k<GongTongShuXing.gongbabiao.length;k++){
						if(GongTongShuXing.gongbabiao[k]==null){
							break;
						}
						
						if(BuXueZhongYaoXingPaiMing.babiaopaiming[y].equals(GongTongShuXing.gongbabiao[k])){
							qiansanshibx[k2]=BuXueZhongYaoXingPaiMing.babiaopaiming[y];
							k2++;
							
						}
						
					}
					}
				}
			
		qiansanshi.huabiaoge(qiansanshibq, qiansanshibx);
		//��������-��ͬ�е��ڲ�Ѫ��ҩ�Ͳ�����ҩ��������ǰ�İе�Աȣ���ȡǰ30����txt�ļ�***********************************************************************************
		FileOutputStream fs7 = new FileOutputStream(new File(path+"/����-��ͬ�б��ڲ�Ѫ��ҩ�Ͳ�����ҩ��������ǰ�İе�Ա�-ǰ30��.txt")); //file1.getName().substring(0, file1.getName().indexOf("."))ȥ���ļ���׺��
		PrintStream p7 = new PrintStream(fs7);
		for(i = 0;i < 30;i ++){
				p7.println(i+1 + " " +  qiansanshibq[i]);//���ļ���д������
		}	
		p7.close(); 		
		//��������-��ͬ�е��ڲ�Ѫ��ҩ�Ͳ�����ҩ��������ǰ�İе�Աȣ���ȡǰ30����txt�ļ�***********************************************************************************
		FileOutputStream fs8 = new FileOutputStream(new File(path+"/��Ѫ-��ͬ�б��ڲ�Ѫ��ҩ�Ͳ�����ҩ��������ǰ�İе�Ա�-ǰ30��.txt")); //file1.getName().substring(0, file1.getName().indexOf("."))ȥ���ļ���׺��
		PrintStream p8 = new PrintStream(fs8);
		for(i = 0;i < 30;i ++){
				p8.println(i+1 + " " +  qiansanshibx[i]);//���ļ���д������
		}	
		p8.close();   
	

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void GongBaqiansanfenzi(String[] buqiroad1,String[] buxueroad1){//��ͬ�е���Ҫ������ǰ3λ�б��Ӧ�ķ��ӶԱ�
		int i,k1=0,j,n=0,n1=0,n2=0,l1=0,l2=0,l=0,l3=0;
		String[] babiaoxuhaobq=new String [10000];
		String[] xiaofenzixuhaobq=new String [10000];
		String[] babiaoxuhaobx=new String [10000];
		String[] xiaofenzixuhaobx=new String [10000];
		try{
			
			
			if(ZhuJieMian.t!=0){//����
				//��ȡǰ���б�
				for(int y=0;y<BuQiZhongYaoXingPaiMing.babiaopaiming.length;y++){
					if(BuQiZhongYaoXingPaiMing.babiaopaiming[y]==null){
						break;
					}
					if(k1>=3){
						break;
					}
					for(int k=0;k<GongTongShuXing.gongbabiao.length;k++){
						if(GongTongShuXing.gongbabiao[k]==null){
							break;
						}
						
						if(BuQiZhongYaoXingPaiMing.babiaopaiming[y].equals(GongTongShuXing.gongbabiao[k])){
							qiansanbq[k1]=BuQiZhongYaoXingPaiMing.babiaopaiming[y];
							//System.out.println("11111111111"+qiansanbq[k1]);
							k1++;
							
						}
						
					}
					}
				for(int y=0;y<ZhuJieMian.t;y++){
					 int index1 = 0,index2=0,index3=0;
					File file1 = new File(buqiroad1[y]);//����
					InputStream is1 = new FileInputStream(file1.getAbsolutePath());//����
					Workbook book1 = Workbook.getWorkbook(is1); //����
					//��õ�һ�����������(ecxel��sheet�ı�Ŵ�0��ʼ,0,1,2,3,....)
					Sheet sheet1 = book1.getSheet(0); //����
					for(i=0;i<sheet1.getRows();i++){
						
						if(sheet1.getCell(0,i).getContents().equals("С����"))  //�Ƚ��ַ���
		            	  {  
							index1=i+1;
		                	  
		                	  break; 
		            	  } else{
		                	   continue;            
		                  }
						
						
					}
					for(i=0;i<sheet1.getRows();i++){
						
						if(sheet1.getCell(0,i).getContents().equals("�б�"))  //�Ƚ��ַ���
		            	  {  
							index2=i+1;
		                	  break; 
		            	  } else{
		                	   continue;            
		                  }
					}
					for(i=0;i<sheet1.getRows();i++){
						
						if(sheet1.getCell(0,i).getContents().equals("С����-�б������"))  //�Ƚ��ַ���
		            	  {  
							index3=i+1;
		                	  
		                	  break; 
		            	  } else{
		                	   continue;            
		                  }
						
						
					}
					//��ðб�����
					for(i=0;i<qiansanbq.length;i++){
						
						if(qiansanbq[i]==null){
							break;
						}
						
						for(j=index2;j<index3;j++){
						if(qiansanbq[i].equals(sheet1.getCell(1,j).getContents())){
							babiaoxuhaobq[n1]=sheet1.getCell(0, j).getContents();
							System.out.println("11111111111"+babiaoxuhaobq[n1]);
							n1++;
							
						}
						
						}
					}
					//���С�������
					for(j=0;j<babiaoxuhaobq.length;j++){
						if(babiaoxuhaobq[j]==null){
							break;
						}
					for(i=index3;i<sheet1.getRows();i++){
						
						if(sheet1.getCell(1,i).getContents().equals(babiaoxuhaobq[j])){
							xiaofenzixuhaobq[n]=sheet1.getCell(0,i).getContents();
						      n++;
						
					}
					}
				}
					for(i=0;i<xiaofenzixuhaobq.length;i++){
						if(xiaofenzixuhaobq[i]==null){
							break;
						}
						for(j=index1;j<index2;j++){
							
								if(xiaofenzixuhaobq[i].equals(sheet1.getCell(0,j).getContents())){
									xiaofenzibq[n2]=sheet1.getCell(1,j).getContents();
									n2++;
								
							}
						}
					}
				}
			}
			if(ZhuJieMian.h!=0){//��Ѫ
				//��ȡǰ���б�
				for(int y=0;y<BuXueZhongYaoXingPaiMing.babiaopaiming.length;y++){
					if(BuXueZhongYaoXingPaiMing.babiaopaiming[y]==null){
						break;
					}
					if(l>=3){
						break;
					}
					for(int k=0;k<GongTongShuXing.gongbabiao.length;k++){
						if(GongTongShuXing.gongbabiao[k]==null){
							break;
						}
						
						if(BuXueZhongYaoXingPaiMing.babiaopaiming[y].equals(GongTongShuXing.gongbabiao[k])){
							qiansanbx[l]=BuXueZhongYaoXingPaiMing.babiaopaiming[y];
							l++;
							
						}
						
					}
					}
				for(int y=0;y<ZhuJieMian.h;y++){
					 int index1 = 0,index2=0,index3=0;
					File file2 = new File(buxueroad1[y]);//����
					InputStream is2 = new FileInputStream(file2.getAbsolutePath());//����
					Workbook book2 = Workbook.getWorkbook(is2); //����
					//��õ�һ�����������(ecxel��sheet�ı�Ŵ�0��ʼ,0,1,2,3,....)
					Sheet sheet2 = book2.getSheet(0); //����
					for(i=0;i<sheet2.getRows();i++){
						
						if(sheet2.getCell(0,i).getContents().equals("С����"))  //�Ƚ��ַ���
		            	  {  
							index1=i+1;
		                	  
		                	  break; 
		            	  } else{
		                	   continue;            
		                  }
						
						
					}
					for(i=0;i<sheet2.getRows();i++){
						
						if(sheet2.getCell(0,i).getContents().equals("�б�"))  //�Ƚ��ַ���
		            	  {  
							index2=i+1;
		                	  break; 
		            	  } else{
		                	   continue;            
		                  }
					}
					for(i=0;i<sheet2.getRows();i++){
						
						if(sheet2.getCell(0,i).getContents().equals("С����-�б������"))  //�Ƚ��ַ���
		            	  {  
							index3=i+1;
		                	  
		                	  break; 
		            	  } else{
		                	   continue;            
		                  }
						
						
					}
					//��ðб�����
					for(i=0;i<qiansanbx.length;i++){
						if(qiansanbx[i]==null){
							break;
						}
						for(j=index2;j<index3;j++){
						if(qiansanbx[i].equals(sheet2.getCell(1,j).getContents())){
							babiaoxuhaobx[l1]=sheet2.getCell(0, j).getContents();
							l1++;
							
						}
						
						}
					}
					//���С�������
					for(j=0;j<babiaoxuhaobx.length;j++){
						if(babiaoxuhaobx[j]==null){
							break;
						}
					for(i=index3;i<sheet2.getRows();i++){
						
						if(sheet2.getCell(1,i).getContents().equals(babiaoxuhaobx[j])){
							xiaofenzixuhaobx[l2]=sheet2.getCell(0,i).getContents();
						      l2++;
						
					}
					}
				}
					for(i=0;i<xiaofenzixuhaobx.length;i++){
						if(xiaofenzixuhaobx[i]==null){
							break;
						}
						for(j=index1;j<index2;j++){
						
								if(xiaofenzixuhaobx[i].equals(sheet2.getCell(0,j).getContents())){
									xiaofenzibx[l3]=sheet2.getCell(1,j).getContents();
									l3++;
								
							}
						}
					}
				}
			}
		qiansan.huabiaoge(xiaofenzibq, xiaofenzibx);	
		FileOutputStream fs10 = new FileOutputStream(new File(path+"/����-��ͬ�е���Ҫ������ǰ��λ�е��Ӧ�ķ��ӶԱ�.txt")); //file1.getName().substring(0, file1.getName().indexOf("."))ȥ���ļ���׺��
		PrintStream p10 = new PrintStream(fs10);
		for(i = 0;i <xiaofenzibq.length;i ++){
			if(xiaofenzibq[i] == null)
				break;
			else
				p10.println(i+1 + " " + xiaofenzibq[i]);//���ļ���д������
		}	
		p10.close();  

		
				
		FileOutputStream fs11 = new FileOutputStream(new File(path+"/��Ѫ-��ͬ�е���Ҫ������ǰ��λ�е��Ӧ�ķ��ӶԱ�.txt")); //file1.getName().substring(0, file1.getName().indexOf("."))ȥ���ļ���׺��
		PrintStream p11 = new PrintStream(fs11);
		for(i = 0;i < xiaofenzibx.length;i ++){
			if((xiaofenzibx[i] == null))
				break;
			else
				p11.println(i+1 + " " + xiaofenzibx[i]);//���ļ���д������
		}	
		p11.close();   

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}