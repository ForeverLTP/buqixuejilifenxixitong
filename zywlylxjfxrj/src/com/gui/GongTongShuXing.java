package com.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import java.io.FileOutputStream;
import java.io.PrintStream;

import javax.swing.filechooser.FileSystemView;

import com.gui.ZhuJieMian;
public class GongTongShuXing {
	static Jtable jtabel;
	static Jtablegongxiao jt;
	static String[] gongxiao = new String[10000];//�洢������Ѫ��ͬС����
	static String[] gongbabiao = new String[10000];//�洢������Ѫ��ͬ�б�
	static String path;
	//��ʼ��·��
	static{
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File desktop=fsv.getHomeDirectory();  
		path = desktop.getAbsolutePath();
	}
	public static void shuxingbabiao(String[] buqiroad1, String[] buxueroad1){
		String[] buqi=new String[10000];
		String[] buxue=new String[10000];
		
		String[] gongbabiaobq = new String[1000];//�洢������ͬС����
		String[] gongbabiaobx = new String[1000];//���油Ѫ��ͬС����
		
 		int i,j;
 		int t1 = 0,h1=0,s=0,s1=0,k=0,l = 0,l1=0,l2=0,m,n;//ָ��
 		
	    
		try{
			
			if(ZhuJieMian.t!=0){//����
				//���Ӳ�����ť�е�����ļ��İб�ȫ���ս��Ը�������
				for(int y=0;y<ZhuJieMian.t;y++){
					 int index1 = 0,index2=0;
					File file1 = new File(buqiroad1[y]);//����
					InputStream is1 = new FileInputStream(file1.getAbsolutePath());//����
					Workbook book1 = Workbook.getWorkbook(is1); //����
					//��õ�һ�����������(ecxel��sheet�ı�Ŵ�0��ʼ,0,1,2,3,....)
					Sheet sheet1 = book1.getSheet(0); //����
					for(i=0;i<sheet1.getRows();i++){
						
						if(sheet1.getCell(0,i).getContents().equals("�б�"))  //�Ƚ��ַ���
		            	  {  
							index1=i+1;
		                	  break; 
		            	  } else{
		                	   continue;            
		                  }
					}
					for(i=0;i<sheet1.getRows();i++){
						
						if(sheet1.getCell(0,i).getContents().equals("С����-�б������"))  //�Ƚ��ַ���
		            	  {  
							index2=i+1;
		                	  
		                	  break; 
		            	  } else{
		                	   continue;            
		                  }
						
						
					}
					int num=index2-index1;
					System.out.println("nummmmmmmmmmmmmmmmm"+num);
					
					for(i=index1;i<index2-1;i++){
						
						Cell cellb=sheet1.getCell(1,i);
						buqi[t1]=cellb.getContents();
						//System.out.println("buqi["+t1+"]"+buqi[t1]);
						t1++;
						
						
					}
					}
			}
			if(ZhuJieMian.h!=0){//��Ѫ
				//���Ӳ�Ѫ��ť�е�����ļ��İб�ȫ���ս��Ը�������
				
				for(int y=0;y<ZhuJieMian.h;y++){
				int index1 = 0,index2=0;
				
				File file2 = new File(buxueroad1[y]);//����
				
				InputStream is2 = new FileInputStream(file2.getAbsolutePath());//����
				Workbook book2 = Workbook.getWorkbook(is2); //����
				Sheet sheet2 = book2.getSheet(0); //����
				for(i=0;i<sheet2.getRows();i++){
					
					if(sheet2.getCell(0,i).getContents().equals("�б�"))  //�Ƚ��ַ���
	            	  {   index1=i+1;
	                	 
	                	  break; 
	            	  } else{
	                	   continue;            
	                  }
				}
				for(i=0;i<sheet2.getRows();i++){
					
					if(sheet2.getCell(0,i).getContents().equals("С����-�б������"))  //�Ƚ��ַ���
	            	  {   index2=i+1;
	                	 
	                	  
	                	  break; 
	            	  } else{
	                	   continue;            
	                  }
					
					
				}
				int num=index2-index1;
				System.out.println("nummmmmmmmmmmmmmmmm"+num);
				
				for(i=index1;i<index2-1;i++){
					
					Cell cellx=sheet2.getCell(1,i);
					buxue[h1]=cellx.getContents();
					
					h1++;
					
					
				}
			}
		}
			
	    if(ZhuJieMian.t==0){
				for(i=0;i<h1-1;i++){
					int z=0;
					for(j=s;j<h1-1;j++){
						if(buxue[i].equals(buxue[j])){
							z++;
						}
					}
					s++;
					if(z==ZhuJieMian.h){
						gongbabiao[l]=buxue[i];	
						
						l++;
					}
				}
				
			}else if(ZhuJieMian.h==0){
				
				for(i=0;i<t1-1;i++){
					int z=0;
					for(j=s;j<t1-1;j++){
						if(buqi[i].equals(buqi[j])){
							z++;
					/*System.out.println("buqi["+i+"]"+buqi[i]);
					System.out.println("zzzzzzzzzzzzz"+z);*/
						}
					}
					s++;
					if(z==ZhuJieMian.t){
						gongbabiao[l]=buqi[i];	
						
						l++;
					}
			}
			}else{
				
				

				for(i=0;i<h1;i++){
					int z1=0;
					for(j=s1;j<h1;j++){
						if(buxue[i].equals(buxue[j])){
							z1++;
							System.out.println("buxue["+i+"]"+buqi[i]);
							System.out.println("z111111111111111111111111111="+z1);
						}
					}
					s1++;
					if(z1>=ZhuJieMian.h){
						gongbabiaobx[l1]=buxue[i];
						//System.out.println("gongbabiaobx["+l1+"]"+gongbabiaobx[l1]);
						l1++;
					}
				}
				for(i=0;i<t1;i++){
					
						int z=0;
						for(j=s;j<t1;j++){
							if(buqi[i].equals(buqi[j])){
								z++;
								/*System.out.println("buqi["+i+"]"+buqi[i]);
								System.out.println("zzzzzzzzzzzzz1111111111111="+z);*/
							}
						}
						s++;
						if(z>=ZhuJieMian.t){
							gongbabiaobq[l]=buqi[i];
							
							l++;
						}
				
				}
			for(m=0;m<l-1;m++){
				
					for(n=0;n<l1-1;n++){
						
						if(gongbabiaobq[m].equals(gongbabiaobx[n])){
							gongbabiao[k]=gongbabiaobq[m];
							k++;
						}
					}
				} 
			}
	    	Jtable.babiao(gongbabiao);//����ͬ�б��
			//������ͬ�б�txt�ļ�*************************************************************************************
			/*String file3name3="", file4name4="";
			if(ZhuJieMian.t!=0){
				
			for(int y=0;y<ZhuJieMian.t;y++){
			File file3 = new File(buqiroad1[y]);
			String file3name=(file3.getName()).substring((file3.getName()).lastIndexOf("."));//��ȡ�������׺�����ļ�����
			int num1=file3name.length();
			String file1name1=(file3.getName()).substring(0,file3.getName().length()-num1);
			file3name3 +=file1name1+"��";
			}
			}else{
				file3name3="";
			}
			if(ZhuJieMian.h!=0){
			for(int y=0;y<ZhuJieMian.h;y++){
			File file4 = new File(buxueroad1[y]);
			String file4name=(file4.getName()).substring((file4.getName()).lastIndexOf("."));//��ȡ������׺�����ļ�����
			int num2=file4name.length();
			String file2name2=(file4.getName()).substring(0,file4.getName().length()-num2);
			file4name4+=file2name2+"��";
			}
			}else{
				file4name4="";
			}*/
			FileOutputStream fs2 = new FileOutputStream(new File(path+"/��ͬ�б�.txt"));//file2.getName().substring(0, file2.getName().lastIndexOf("."))ȥ���ļ���׺��
			PrintStream p2 = new PrintStream(fs2);
			
			for(i = 0;i < gongbabiao.length;i++){
				if(gongbabiao[i] == null)
					continue;
				else{
					p2.println(l2+1+" "+gongbabiao[i]);//���ļ���д������
					l2++;
				}
			}	
			p2.close();  			
			
			
		
		}catch(Exception e) { 
	    	e.printStackTrace();
	    }    
	}
	public static void shuxiaofenzi(String[] buqiroad1, String[] buxueroad1){
		String[] buqi=new String[10000];
		String[] buxue=new String[10000];
		//String[] xiaod = new String[1000];//����
		//String[] xiaoh = new String[1000];//����
		String[] gongxiaobq = new String[10000];//�洢������ͬС����
		String[] gongxiaobx = new String[10000];//���油Ѫ��ͬС����
		
 		int i,j;//index1�ǵ���б�������index2�ǻ��ΰб�����
 		int t1 = 0,h1=0,s=0,s1=0,k=0,l = 0,l1=0,l2=0,m,n;//ָ��
	    
	    
		try{
			
			if(ZhuJieMian.t!=0){
				for(int y=0;y<ZhuJieMian.t;y++){
					int index1=0;
					File file1 = new File(buqiroad1[y]);//����
					InputStream is1 = new FileInputStream(file1.getAbsolutePath());//����
					Workbook book1 = Workbook.getWorkbook(is1); //����
					//��õ�һ�����������(ecxel��sheet�ı�Ŵ�0��ʼ,0,1,2,3,....)
					Sheet sheet1 = book1.getSheet(0); //����
					for(i=1;i<sheet1.getRows();i++){
						
						if(sheet1.getCell(1,i).getContents().equals(""))  //�Ƚ��ַ���
		            	  {  
							
		                	  break; 
		            	  } else{
		            		  	index1++;//���ÿ�ű��в�����ҩС���ӵĸ���
								
		                	   continue;   
		                	   
		                  }
					}
					
					
					for(i=1;i<index1+1;i++){
						
						Cell cellb=sheet1.getCell(1,i);
						buqi[t1]=cellb.getContents();
						
						t1++;
						
						
					}
					}
			}
			if(ZhuJieMian.h!=0){
				for(int y=0;y<ZhuJieMian.h;y++){
				//int index2=0;
				File file2 = new File(buxueroad1[y]);//����
				InputStream is2 = new FileInputStream(file2.getAbsolutePath());//����
				Workbook book2 = Workbook.getWorkbook(is2); //����
				Sheet sheet2 = book2.getSheet(0); //����
				for(i=1;i<sheet2.getRows();i++){
					
					Cell cellx=sheet2.getCell(1,i);
					buxue[h1]=cellx.getContents();
					//System.out.println("buxue[]"+buxue[t1]);
					h1++;
					
				if(sheet2.getCell(1,i).getContents().equals(""))  //�Ƚ��ַ���
	            	  {  		                	  
	                	  break; 
	            	  } else{
	            		  	//index2++;
	                	   continue;            
	                  }
				}
			}
			}
			
			if(ZhuJieMian.t==0){
				for(i=0;i<h1-1;i++){
					int z=0;
					for(j=s;j<h1-1;j++){
						if(buxue[i].equals(buxue[j])){
							z++;
							//System.out.println("3333333333333333333333333333333");
						}
					}
					s++;
					if(z==ZhuJieMian.h){
						gongxiao[l]=buxue[i];	
						l++;
					}
				}
				
			}else if(ZhuJieMian.h==0){
				for(i=0;i<t1-1;i++){
					int z=0;
					for(j=s;j<t1-1;j++){
						if(buqi[i].equals(buqi[j])){
							z++;
							//System.out.println("tttttttttttttttttttttttttttttt"+ZhuJieMian.t);
						}
					}
					s++;
					if(z==ZhuJieMian.t){
						gongxiao[l]=buqi[i];	
						l++;
					}
			}
			}else{
				
				

				
				for(i=0;i<h1;i++){
					int z1=0;
					for(j=s1;j<h1;j++){
						if(buxue[i].equals(buxue[j])){
							z1++;
						}
					}
					s1++;
					if(z1>=ZhuJieMian.h){
						gongxiaobq[l1]=buxue[i];
						l1++;
					}
				}
				for(i=0;i<t1;i++){
					int z=0;
						for(j=s;j<t1;j++){
							if(buqi[i].equals(buqi[j])){
								z++;
							}
						}
						s++;
						if(z>=ZhuJieMian.t){
							gongxiaobx[l]=buqi[i];
							l++;
						}
				
				}
			for(m=0;m<l1-1;m++){
					for(n=0;n<l-1;n++){
						if(gongxiaobq[m].equals(gongxiaobx[n])){
							gongxiao[k]=gongxiaobq[m];
							k++;
						}
					}
				}
			}
			Jtablegongxiao.huabiao(gongxiao);//����ͬС���ӱ�
			//������ͬС����txt�ļ�***********************************************************************************
			/*String file3name3="", file4name4="";
			if(ZhuJieMian.t!=0){
				
			for(int y=0;y<ZhuJieMian.t;y++){
			File file3 = new File(buqiroad1[y]);
			String file3name=(file3.getName()).substring((file3.getName()).lastIndexOf("."));//��ȡ�������׺�����ļ�����
			int num1=file3name.length();
			String file1name1=(file3.getName()).substring(0,file3.getName().length()-num1);
			file3name3 +=file1name1+"��";
			}
			}else{
				file3name3="";
			}
			if(ZhuJieMian.h!=0){
			for(int y=0;y<ZhuJieMian.h;y++){
			File file4 = new File(buxueroad1[y]);
			String file4name=(file4.getName()).substring((file4.getName()).lastIndexOf("."));//��ȡ������׺�����ļ�����
			int num2=file4name.length();
			String file2name2=(file4.getName()).substring(0,file4.getName().length()-num2);
			file4name4+=file2name2+"��";
			}
			}else{
				file4name4="";
			}*/
			FileOutputStream fs = new FileOutputStream(new File(path+"/��ͬС����.txt")); //file1.getName().substring(0, file1.getName().indexOf("."))ȥ���ļ���׺��
			PrintStream p = new PrintStream(fs);
			
			for(i = 0;i < gongxiao.length;i++){    
				if(gongxiao[i] == null)
					continue;
				else{
					p.println(l2+1+" "+gongxiao[i]);//���ļ���д������
					l2++;
				}
			}	
			p.close();  	
			/*System.out.println(sheet1.getRows());      //����
			System.out.println(sheet1.getColumns());   //����
*/		}catch(Exception e) { 
	    	e.printStackTrace();
	    }    
	}
}
