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
	 * 共同靶标在补气补血中药中的排名对比
	 * break只能终止一层循环
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
	//初始化路径
	static{
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File desktop=fsv.getHomeDirectory();  
		path = desktop.getAbsolutePath();
	}
	
	public static void GongBaBuQi(){ //共同靶标在补气中药的靶点中重要性与补气中药全部靶点的排名对比
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
					
					bqbabiaopaiming[k1] = "共同靶标: " + BuQiZhongYaoXingPaiMing.babiaopaiming[y];
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
		//导出当归 靶标重要性排名txt文件***********************************************************************************
		FileOutputStream fs3 = new FileOutputStream(new File(path+"/共同靶标在补气中药靶标中重要性与补气全部靶标的排名对比.txt")); //file1.getName().substring(0, file1.getName().indexOf("."))去掉文件后缀名
		PrintStream p3 = new PrintStream(fs3);
		for(i = 0;i < bqbabiaopaiming.length;i++){
			if(bqbabiaopaiming[i] == null)
				continue;
			else{
				
				p3.println(i+1 + " " +  bqbabiaopaiming[i]);//往文件里写进数据
			}
		}	
		p3.close(); 


		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void GongBaBuXue(){//共同靶点在补血中药的靶点中重要性与补血中药全部靶点的排名对比
		int i; //index1是小分子靶标相关联的第一个数据横坐标，index2是小分子第一个数据横坐标，index3是靶标第一个数据横坐标
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
						bxbabiaopaiming[k1] = "共同靶标: " + BuXueZhongYaoXingPaiMing.babiaopaiming[y];
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
		//导出黄芪 靶标重要性排名txt文件***********************************************************************************
		
		FileOutputStream fs4 = new FileOutputStream(new File(path+"/共同靶标在补血中药靶标中重要性与补血全部靶标的排名对比.txt")); //file1.getName().substring(0, file1.getName().indexOf("."))去掉文件后缀名
		PrintStream p4 = new PrintStream(fs4);
		for(i = 0;i < bxbabiaopaiming.length;i++){
			if(bxbabiaopaiming[i] == null)
				continue;
			else{
				p4.println(i+1 + " " +  bxbabiaopaiming[i]);//往文件里写进数据
			}
		}	
		p4.close(); 
		

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void GongBaqianshi(){//共同靶点在补血和补气中药排名都靠前的靶标对比(各取前10个)
		int i; //index1是小分子靶标相关联的第一个数据横坐标，index2是小分子第一个数据横坐标，index3是靶标第一个数据横坐标
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
	
		//导出当归-共同靶点在补血中药和补气中药排名都靠前的靶点对比（各取前10个）txt文件***********************************************************************************
		FileOutputStream fs5 = new FileOutputStream(new File(path+"/补气-共同靶标在补血中药和补气中药排名都靠前的靶点对比-前10个.txt")); //file1.getName().substring(0, file1.getName().indexOf("."))去掉文件后缀名
		PrintStream p5 = new PrintStream(fs5);
		for(i = 0;i < 10;i ++){
				p5.println(i+1 + " " +  qianshibq[i]);//往文件里写进数据
		}	
		p5.close(); 		
		//导出黄芪-共同靶点在补血中药和补气中药排名都靠前的靶点对比（各取前10个）txt文件***********************************************************************************
		FileOutputStream fs6 = new FileOutputStream(new File(path+"/补血-共同靶标在补血中药和补气中药排名都靠前的靶点对比-前10个.txt")); //file1.getName().substring(0, file1.getName().indexOf("."))去掉文件后缀名
		PrintStream p6 = new PrintStream(fs6);
		for(i = 0;i < 10;i ++){
				p6.println(i+1 + " " + qianshibx[i]);//往文件里写进数据
		}	
		p6.close(); 
		

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void GongBaqiansanshi(){//共同靶点在补血和补气中药排名都靠前的靶标对比(各取前30个)
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
		//导出当归-共同靶点在补血中药和补气中药排名都靠前的靶点对比（各取前30个）txt文件***********************************************************************************
		FileOutputStream fs7 = new FileOutputStream(new File(path+"/补气-共同靶标在补血中药和补气中药排名都靠前的靶点对比-前30个.txt")); //file1.getName().substring(0, file1.getName().indexOf("."))去掉文件后缀名
		PrintStream p7 = new PrintStream(fs7);
		for(i = 0;i < 30;i ++){
				p7.println(i+1 + " " +  qiansanshibq[i]);//往文件里写进数据
		}	
		p7.close(); 		
		//导出黄芪-共同靶点在补血中药和补气中药排名都靠前的靶点对比（各取前30个）txt文件***********************************************************************************
		FileOutputStream fs8 = new FileOutputStream(new File(path+"/补血-共同靶标在补血中药和补气中药排名都靠前的靶点对比-前30个.txt")); //file1.getName().substring(0, file1.getName().indexOf("."))去掉文件后缀名
		PrintStream p8 = new PrintStream(fs8);
		for(i = 0;i < 30;i ++){
				p8.println(i+1 + " " +  qiansanshibx[i]);//往文件里写进数据
		}	
		p8.close();   
	

		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void GongBaqiansanfenzi(String[] buqiroad1,String[] buxueroad1){//共同靶点重要性排名前3位靶标对应的分子对比
		int i,k1=0,j,n=0,n1=0,n2=0,l1=0,l2=0,l=0,l3=0;
		String[] babiaoxuhaobq=new String [10000];
		String[] xiaofenzixuhaobq=new String [10000];
		String[] babiaoxuhaobx=new String [10000];
		String[] xiaofenzixuhaobx=new String [10000];
		try{
			
			
			if(ZhuJieMian.t!=0){//补气
				//获取前三靶标
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
					File file1 = new File(buqiroad1[y]);//当归
					InputStream is1 = new FileInputStream(file1.getAbsolutePath());//当归
					Workbook book1 = Workbook.getWorkbook(is1); //当归
					//获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
					Sheet sheet1 = book1.getSheet(0); //当归
					for(i=0;i<sheet1.getRows();i++){
						
						if(sheet1.getCell(0,i).getContents().equals("小分子"))  //比较字符串
		            	  {  
							index1=i+1;
		                	  
		                	  break; 
		            	  } else{
		                	   continue;            
		                  }
						
						
					}
					for(i=0;i<sheet1.getRows();i++){
						
						if(sheet1.getCell(0,i).getContents().equals("靶标"))  //比较字符串
		            	  {  
							index2=i+1;
		                	  break; 
		            	  } else{
		                	   continue;            
		                  }
					}
					for(i=0;i<sheet1.getRows();i++){
						
						if(sheet1.getCell(0,i).getContents().equals("小分子-靶标相关联"))  //比较字符串
		            	  {  
							index3=i+1;
		                	  
		                	  break; 
		            	  } else{
		                	   continue;            
		                  }
						
						
					}
					//获得靶标的序号
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
					//获得小分子序号
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
			if(ZhuJieMian.h!=0){//补血
				//获取前三靶标
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
					File file2 = new File(buxueroad1[y]);//当归
					InputStream is2 = new FileInputStream(file2.getAbsolutePath());//当归
					Workbook book2 = Workbook.getWorkbook(is2); //当归
					//获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
					Sheet sheet2 = book2.getSheet(0); //当归
					for(i=0;i<sheet2.getRows();i++){
						
						if(sheet2.getCell(0,i).getContents().equals("小分子"))  //比较字符串
		            	  {  
							index1=i+1;
		                	  
		                	  break; 
		            	  } else{
		                	   continue;            
		                  }
						
						
					}
					for(i=0;i<sheet2.getRows();i++){
						
						if(sheet2.getCell(0,i).getContents().equals("靶标"))  //比较字符串
		            	  {  
							index2=i+1;
		                	  break; 
		            	  } else{
		                	   continue;            
		                  }
					}
					for(i=0;i<sheet2.getRows();i++){
						
						if(sheet2.getCell(0,i).getContents().equals("小分子-靶标相关联"))  //比较字符串
		            	  {  
							index3=i+1;
		                	  
		                	  break; 
		            	  } else{
		                	   continue;            
		                  }
						
						
					}
					//获得靶标的序号
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
					//获得小分子序号
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
		FileOutputStream fs10 = new FileOutputStream(new File(path+"/补气-共同靶点重要性排名前三位靶点对应的分子对比.txt")); //file1.getName().substring(0, file1.getName().indexOf("."))去掉文件后缀名
		PrintStream p10 = new PrintStream(fs10);
		for(i = 0;i <xiaofenzibq.length;i ++){
			if(xiaofenzibq[i] == null)
				break;
			else
				p10.println(i+1 + " " + xiaofenzibq[i]);//往文件里写进数据
		}	
		p10.close();  

		
				
		FileOutputStream fs11 = new FileOutputStream(new File(path+"/补血-共同靶点重要性排名前三位靶点对应的分子对比.txt")); //file1.getName().substring(0, file1.getName().indexOf("."))去掉文件后缀名
		PrintStream p11 = new PrintStream(fs11);
		for(i = 0;i < xiaofenzibx.length;i ++){
			if((xiaofenzibx[i] == null))
				break;
			else
				p11.println(i+1 + " " + xiaofenzibx[i]);//往文件里写进数据
		}	
		p11.close();   

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}