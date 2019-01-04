package com.gui;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.filechooser.FileSystemView;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class BuXueZhongYaoXingPaiMing {
	/**
     * 用HashMap的key来存放数组中存在的数字，value存放该数字在数组中出现的次数
     * @author xiangwei 
     */
	static int i,j; //index1是小分子靶标相关联的第一个数据横坐标，index2是小分子第一个数据横坐标，index3是靶标第一个数据横坐标
	static String[] xiaofenzi = new String[10000];//存小分子序号
	static String[] babiao = new String[10000];//存靶标序号
	static String[] everytablexiaofenzipaiming = new String[10000];//依次存放每张表的小分子重要排名
	static int[] everytablexiaofenzicishu = new int[10000];//依次存放每张表的靶标重要性排名
	static String[] everytablebabiaopaiming = new String[10000];//依次存放每张表的小分子重要排名
	static int[] everytablebabiaocishu = new int[10000];//依次存放每张表的靶标重要性排名
	static String[] xiaofenzipaiming = new String[10000];//依次存放小分子重要排名
	static String[] babiaopaiming = new String[10000];//依次存放靶标重要性排名
	static String[] xiaofenzicishu = new String[10000];
	static String[] babiaocishu = new String[10000];//存放靶标对应出现次数
	static JtableZhongYaoXingPaiMingBuXue buxuezhongyao = new JtableZhongYaoXingPaiMingBuXue();
	static JtableZhongYaoXingPaiMingBuXueBaBiao buxuezhongyaobabiao = new JtableZhongYaoXingPaiMingBuXueBaBiao();
	
	static String path;
	//初始化路径
	static{
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File desktop=fsv.getHomeDirectory();  
		path = desktop.getAbsolutePath();
	}
	public static void Buxuexiaofenzipaiming(String[] buxueroad1){
		int index1 = 0,index2 = 0,index3 = 0;
		try{
			int k=0,k1=0,m;
			for(int y=0;y<ZhuJieMian.h;y++){
			File file2 = new File(buxueroad1[y]);//黄芪
			InputStream is2 = new FileInputStream(file2.getAbsolutePath());//黄芪
			Workbook book2 = Workbook.getWorkbook(is2); //黄芪
			Sheet sheet2 = book2.getSheet(0); //黄芪
			
			for(i = 0;i<sheet2.getRows();i ++){  //黄芪 行
				Cell celld = sheet2.getCell(0, i);  
				System.out.println(celld.getContents());
				if(celld.getContents().equals("")){
					break;
				}else if(celld.getContents().equals("小分子")){
					index2 = i+2; //index2是小分子第一个数据横坐标
					continue;
				}else if(celld.getContents().equals("靶标")){
					index3 = i+2; //index3是靶标第一个数据横坐标
					continue;
				}
				else if(celld.getContents().equals("小分子-靶标相关联")){
					index1 = i+2; //index1 是小分子-靶标相关联的第一个数据横坐标
					break;
				}
			}
			//System.out.println(index1 +" "+ index2 +" "+ index3);
			//System.out.println(sheet2.getCell(0, index1).getContents() +" "+ sheet2.getCell(0, index2).getContents() +" "+ sheet2.getCell(0, index3).getContents());
			//清空数组
			for(i=0;i<xiaofenzi.length;i++){
				xiaofenzi[i]=null;
			}
			//将小分子-靶标相关联对应编号存入数组中
			for(i=index1-1,m = 0;i < sheet2.getRows();i++){
				Cell celld0 = sheet2.getCell(0, i);  
				 
				if(celld0.getContents().equals("")){
					break;
				}else{
					xiaofenzi[m] = celld0.getContents();
					
					m++;
				}
			}
		System.out.println("统计各个数字出现的次数并存储到map中");
        //map的key存放数组中存在的数字，value存放该数字在数组中出现的次数
        HashMap<String, Integer> map = new HashMap<String, Integer>(); //小分子
        
        for(i = 0; i < xiaofenzi.length; i++)
        {
        	if(xiaofenzi[i] == null)
        		break;
        	else if(map.containsKey(xiaofenzi[i]))  //判断map中是否已经包含了array[i]
            {
                int temp = map.get(xiaofenzi[i]);//返回xiaofenzi[i]出现的次数
                System.out.println(xiaofenzi[i]);
                map.put(xiaofenzi[i], temp + 1);//将xiaofenzi[i]和对应的出现次数写入map中
            }
            else
            {
                map.put(xiaofenzi[i], 1);//将xiaofenzi[i]和对应的出现次数写入map中
            }
        } 
       
        List<Map.Entry<String, Integer>> infoIds = new ArrayList<Map.Entry<String, Integer>>(map.entrySet()); //小分子

        System.out.println("--------------排序前--------------");  //小分子
        for (i = 0; i < infoIds.size(); i++) {  
            String id = infoIds.get(i).toString();  
            System.out.println(id);  
        }    
        // 排序  
        Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {  //小分子
            public int compare(Map.Entry<String, Integer> o1,  
                    Map.Entry<String, Integer> o2) {  
                return ( o1.getValue()-o2.getValue());  
            }  
        });  
        //按次数从高到低顺序找出小分子
      
        
        System.out.println("--------------按次数从高到低顺序找出小分子--------------"); 
        
        for (i = infoIds.size()-1; i >= 0 ; i--) {  //从后往前输出
        	
            Entry<String,Integer> ent = infoIds.get(i);
           
            for(j = index2-1; j <index3-1; j ++){
            
            	if(sheet2.getCell(0, j+1).getContents().equals(ent.getKey())){
            		
            		everytablexiaofenzipaiming[k] = sheet2.getCell(1, j+1).getContents();
            		everytablexiaofenzicishu[k] = ent.getValue();
            		
            		k++;
            		
            		break;
            	}
            }
          
            System.out.println(ent.getKey()+"="+ent.getValue()); 
        }
        
			}
	 HashMap<String, Integer> map3 = new HashMap<String, Integer>(); //将多个表的排名整合到一个map中
	 for(i=0;i<everytablexiaofenzipaiming.length;i++){
		 if(everytablexiaofenzipaiming[i]==null){
			 break;
		 }else{
			 map3.put(everytablexiaofenzipaiming[i],everytablexiaofenzicishu[i]);
		 }
	 }
	 List<Map.Entry<String, Integer>> infoIdsx = new ArrayList<Map.Entry<String, Integer>>(map3.entrySet()); //小分子整合
     Collections.sort(infoIdsx, new Comparator<Map.Entry<String, Integer>>() {  //小分子
         public int compare(Map.Entry<String, Integer> o3,  
                 Map.Entry<String, Integer> o4) {  
             return ( o3.getValue()-o4.getValue());  
         }  
     }); 
			
		for(i=infoIdsx.size()-1;i>=0;i--){
			Entry<String,Integer> ent1=infoIdsx.get(i);
			xiaofenzipaiming[k1]=ent1.getKey();
			xiaofenzicishu[k1]=ent1.getValue().toString();
			k1++;
			
		}	
			  
        buxuezhongyao.huabiao(xiaofenzipaiming,xiaofenzicishu);
      //导出小分子重要性排名txt文件***********************************************************************************
       String file4name4="";
        if(ZhuJieMian.h!=0){
			for(int y=0;y<ZhuJieMian.h;y++){
			File file4 = new File(buxueroad1[y]);
			String file4name=(file4.getName()).substring((file4.getName()).lastIndexOf("."));//获取不带后缀名的文件名称
			int num2=file4name.length();
			String file2name2=(file4.getName()).substring(0,file4.getName().length()-num2);
			file4name4+=file2name2+"、";
			}
			}else{
				file4name4="";
			}
		FileOutputStream fs1 = new FileOutputStream(new File(path+"/"+file4name4+"补血小分子重要性.txt")); //file1.getName().substring(0, file1.getName().indexOf("."))去掉文件后缀名
		PrintStream p = new PrintStream(fs1);
		for(i = 0;i < xiaofenzipaiming.length;i++){
			if(xiaofenzipaiming[i] == null)
				continue;
			else{
				p.println(i+1 + " " + xiaofenzipaiming[i]);//往文件里写进数据
			}
		}	
		p.close();  
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public static void Buxuebabiaopaiming(String[] buxueroad1){
		int index1 = 0,index2 = 0,index3 = 0;
		try{
			int m,n=0,n1=0;
			for(int y=0;y<ZhuJieMian.h;y++){
			File file2 = new File(buxueroad1[y]);//黄芪
			InputStream is2 = new FileInputStream(file2.getAbsolutePath());//黄芪
			Workbook book2 = Workbook.getWorkbook(is2); //黄芪
			//System.out.println("呦呦呦");
			//获得第一个工作表对象(ecxel中sheet的编号从0开始,0,1,2,3,....)
			Sheet sheet2 = book2.getSheet(0); //黄芪
			for(i = 0;i<sheet2.getRows();i ++){  //黄芪 行
				Cell celld = sheet2.getCell(0, i);  
				if(celld.getContents().equals("")){
					break;
				}else if(celld.getContents().equals("小分子")){
					index2 = i+2; //index2是小分子第一个数据横坐标
					continue;
				}else if(celld.getContents().equals("靶标")){
					index3 = i+2; //index3是靶标第一个数据横坐标
					continue;
				}
				else if(celld.getContents().equals("小分子-靶标相关联")){
					index1 = i+2; //index1 是小分子-靶标相关联的第一个数据横坐标
					break;
				}
			}
			//System.out.println(index1 +" "+ index2 +" "+ index3);
			System.out.println(sheet2.getCell(0, index1).getContents() +" "+ sheet2.getCell(0, index2).getContents() +" "+ sheet2.getCell(0, index3).getContents());
			for(i=0;i<babiao.length;i++){
				babiao[i]=null;
			}
			//将小分子-靶标相关联对应编号存入数组中
			for(i=index1-1,m = 0;i < sheet2.getRows();i++){
				Cell celld0 = sheet2.getCell(0, i);  
				Cell celld1 = sheet2.getCell(1, i);  
				if(celld0.getContents().equals("")){
					break;
				}else{
					
					babiao[m] = celld1.getContents();
					m++;
				}
			}
		System.out.println("统计各个数字出现的次数并存储到map中");
        //map的key存放数组中存在的数字，value存放该数字在数组中出现的次数
      
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();//靶标
       
        //map1的key存放数组存在的数字，value存放该数字在数组中出现的次数
        for(i = 0; i < babiao.length; i++)
        {
        	if(babiao[i] == null)
        		break;
        	else if(map1.containsKey(babiao[i]))  //判断map1中是否已经包含了array[i]
            {
                int temp = map1.get(babiao[i]);//返回babiao[i]出现的次数
                map1.put(babiao[i], temp + 1);//将babiao[i]和对应的出现次数写入map1中
            }
            else
            {
                map1.put(babiao[i], 1);//将babiao[i]和对应的出现次数写入map1中
            }
        }

        List<Map.Entry<String, Integer>> infoIds1 = new ArrayList<Map.Entry<String, Integer>>(map1.entrySet());//靶标
        System.out.println("--------------排序前--------------");  //靶标
        for (i = 0; i < infoIds1.size(); i++) {  
            String id1 = infoIds1.get(i).toString();  
            System.out.println(id1);  
        }  
        // 排序  
        Collections.sort(infoIds1, new Comparator<Map.Entry<String, Integer>>() {  //靶标
            public int compare(Map.Entry<String, Integer> o1,  
                    Map.Entry<String, Integer> o2) {  
                return ( o1.getValue()-o2.getValue());  
            }  
        }); 
        System.out.println("--------------按次数从高到低顺序找出靶标--------------");  
       
        
        for (i = infoIds1.size()-1; i >= 0 ; i--) {     //从后往前输出
            Entry<String,Integer> ent1 = infoIds1.get(i);  
            for(j = index3-1; j < index1-1; j ++){
            	if(sheet2.getCell(0, j).getContents().equals(ent1.getKey())){
            		everytablebabiaopaiming[n] = sheet2.getCell(1, j).getContents();
            		everytablebabiaocishu[n] = ent1.getValue();
            		
            		n++;
            		break;
            	}
            }
        }
            
        }
			
			HashMap<String, Integer> map3 = new HashMap<String, Integer>(); //将多个表的排名整合到一个map中
			 for(i=0;i<everytablebabiaopaiming.length;i++){
				 if(everytablebabiaopaiming[i]==null){
					 break;
				 }else{
					 map3.put(everytablebabiaopaiming[i],everytablebabiaocishu[i]);
				 }
			 }
			 List<Map.Entry<String, Integer>> infoIds2 = new ArrayList<Map.Entry<String, Integer>>(map3.entrySet()); //小分子整合
		     Collections.sort(infoIds2, new Comparator<Map.Entry<String, Integer>>() {  //小分子
		         public int compare(Map.Entry<String, Integer> o3,  
		                 Map.Entry<String, Integer> o4) {  
		             return ( o3.getValue()-o4.getValue());  
		         }  
		     }); 
					
				for(i=infoIds2.size()-1;i>=0;i--){
					Entry<String,Integer> ent1=infoIds2.get(i);
					babiaopaiming[n1]=ent1.getKey();
					babiaocishu[n1]=ent1.getValue().toString();
					n1++;
					
				}	
        buxuezhongyaobabiao.babiao(babiaopaiming, babiaocishu);
		//导出靶标重要性排名txt文件***********************************************************************************
       /*String file4name4="";
        if(ZhuJieMian.h!=0){
			for(int y=0;y<ZhuJieMian.h;y++){
			File file4 = new File(buxueroad1[y]);
			String file4name=(file4.getName()).substring((file4.getName()).lastIndexOf("."));//获取不带后缀名的文件名称
			int num2=file4name.length();
			String file2name2=(file4.getName()).substring(0,file4.getName().length()-num2);
			file4name4+=file2name2+"、";
			}
			}else{
				file4name4="";
			}*/
		FileOutputStream fs2 = new FileOutputStream(new File(path+"/补血靶标重要性.txt")); //file1.getName().substring(0, file1.getName().indexOf("."))去掉文件后缀名
		PrintStream p2 = new PrintStream(fs2);
		for(i = 0;i < babiaopaiming.length;i++){
			if(babiaopaiming[i] == null)
				continue;
			else{
				p2.println(i+1 + " " + babiaopaiming[i]);//往文件里写进数据
			}
		}	
		p2.close();      

		}catch(Exception e){
			e.printStackTrace();
		}
	}
/*	public static void main(String[] args) {
		Buxuezhongyaoxing();
	}*/

}
