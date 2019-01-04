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
     * ��HashMap��key����������д��ڵ����֣�value��Ÿ������������г��ֵĴ���
     * @author xiangwei 
     */
	static int i,j; //index1��С���Ӱб�������ĵ�һ�����ݺ����꣬index2��С���ӵ�һ�����ݺ����꣬index3�ǰб��һ�����ݺ�����
	static String[] xiaofenzi = new String[10000];//��С�������
	static String[] babiao = new String[10000];//��б����
	static String[] everytablexiaofenzipaiming = new String[10000];//���δ��ÿ�ű��С������Ҫ����
	static int[] everytablexiaofenzicishu = new int[10000];//���δ��ÿ�ű�İб���Ҫ������
	static String[] everytablebabiaopaiming = new String[10000];//���δ��ÿ�ű��С������Ҫ����
	static int[] everytablebabiaocishu = new int[10000];//���δ��ÿ�ű�İб���Ҫ������
	static String[] xiaofenzipaiming = new String[10000];//���δ��С������Ҫ����
	static String[] babiaopaiming = new String[10000];//���δ�Űб���Ҫ������
	static String[] xiaofenzicishu = new String[10000];
	static String[] babiaocishu = new String[10000];//��Űб��Ӧ���ִ���
	static JtableZhongYaoXingPaiMingBuXue buxuezhongyao = new JtableZhongYaoXingPaiMingBuXue();
	static JtableZhongYaoXingPaiMingBuXueBaBiao buxuezhongyaobabiao = new JtableZhongYaoXingPaiMingBuXueBaBiao();
	
	static String path;
	//��ʼ��·��
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
			File file2 = new File(buxueroad1[y]);//����
			InputStream is2 = new FileInputStream(file2.getAbsolutePath());//����
			Workbook book2 = Workbook.getWorkbook(is2); //����
			Sheet sheet2 = book2.getSheet(0); //����
			
			for(i = 0;i<sheet2.getRows();i ++){  //���� ��
				Cell celld = sheet2.getCell(0, i);  
				System.out.println(celld.getContents());
				if(celld.getContents().equals("")){
					break;
				}else if(celld.getContents().equals("С����")){
					index2 = i+2; //index2��С���ӵ�һ�����ݺ�����
					continue;
				}else if(celld.getContents().equals("�б�")){
					index3 = i+2; //index3�ǰб��һ�����ݺ�����
					continue;
				}
				else if(celld.getContents().equals("С����-�б������")){
					index1 = i+2; //index1 ��С����-�б�������ĵ�һ�����ݺ�����
					break;
				}
			}
			//System.out.println(index1 +" "+ index2 +" "+ index3);
			//System.out.println(sheet2.getCell(0, index1).getContents() +" "+ sheet2.getCell(0, index2).getContents() +" "+ sheet2.getCell(0, index3).getContents());
			//�������
			for(i=0;i<xiaofenzi.length;i++){
				xiaofenzi[i]=null;
			}
			//��С����-�б��������Ӧ��Ŵ���������
			for(i=index1-1,m = 0;i < sheet2.getRows();i++){
				Cell celld0 = sheet2.getCell(0, i);  
				 
				if(celld0.getContents().equals("")){
					break;
				}else{
					xiaofenzi[m] = celld0.getContents();
					
					m++;
				}
			}
		System.out.println("ͳ�Ƹ������ֳ��ֵĴ������洢��map��");
        //map��key��������д��ڵ����֣�value��Ÿ������������г��ֵĴ���
        HashMap<String, Integer> map = new HashMap<String, Integer>(); //С����
        
        for(i = 0; i < xiaofenzi.length; i++)
        {
        	if(xiaofenzi[i] == null)
        		break;
        	else if(map.containsKey(xiaofenzi[i]))  //�ж�map���Ƿ��Ѿ�������array[i]
            {
                int temp = map.get(xiaofenzi[i]);//����xiaofenzi[i]���ֵĴ���
                System.out.println(xiaofenzi[i]);
                map.put(xiaofenzi[i], temp + 1);//��xiaofenzi[i]�Ͷ�Ӧ�ĳ��ִ���д��map��
            }
            else
            {
                map.put(xiaofenzi[i], 1);//��xiaofenzi[i]�Ͷ�Ӧ�ĳ��ִ���д��map��
            }
        } 
       
        List<Map.Entry<String, Integer>> infoIds = new ArrayList<Map.Entry<String, Integer>>(map.entrySet()); //С����

        System.out.println("--------------����ǰ--------------");  //С����
        for (i = 0; i < infoIds.size(); i++) {  
            String id = infoIds.get(i).toString();  
            System.out.println(id);  
        }    
        // ����  
        Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {  //С����
            public int compare(Map.Entry<String, Integer> o1,  
                    Map.Entry<String, Integer> o2) {  
                return ( o1.getValue()-o2.getValue());  
            }  
        });  
        //�������Ӹߵ���˳���ҳ�С����
      
        
        System.out.println("--------------�������Ӹߵ���˳���ҳ�С����--------------"); 
        
        for (i = infoIds.size()-1; i >= 0 ; i--) {  //�Ӻ���ǰ���
        	
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
	 HashMap<String, Integer> map3 = new HashMap<String, Integer>(); //���������������ϵ�һ��map��
	 for(i=0;i<everytablexiaofenzipaiming.length;i++){
		 if(everytablexiaofenzipaiming[i]==null){
			 break;
		 }else{
			 map3.put(everytablexiaofenzipaiming[i],everytablexiaofenzicishu[i]);
		 }
	 }
	 List<Map.Entry<String, Integer>> infoIdsx = new ArrayList<Map.Entry<String, Integer>>(map3.entrySet()); //С��������
     Collections.sort(infoIdsx, new Comparator<Map.Entry<String, Integer>>() {  //С����
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
      //����С������Ҫ������txt�ļ�***********************************************************************************
       String file4name4="";
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
			}
		FileOutputStream fs1 = new FileOutputStream(new File(path+"/"+file4name4+"��ѪС������Ҫ��.txt")); //file1.getName().substring(0, file1.getName().indexOf("."))ȥ���ļ���׺��
		PrintStream p = new PrintStream(fs1);
		for(i = 0;i < xiaofenzipaiming.length;i++){
			if(xiaofenzipaiming[i] == null)
				continue;
			else{
				p.println(i+1 + " " + xiaofenzipaiming[i]);//���ļ���д������
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
			File file2 = new File(buxueroad1[y]);//����
			InputStream is2 = new FileInputStream(file2.getAbsolutePath());//����
			Workbook book2 = Workbook.getWorkbook(is2); //����
			//System.out.println("������");
			//��õ�һ�����������(ecxel��sheet�ı�Ŵ�0��ʼ,0,1,2,3,....)
			Sheet sheet2 = book2.getSheet(0); //����
			for(i = 0;i<sheet2.getRows();i ++){  //���� ��
				Cell celld = sheet2.getCell(0, i);  
				if(celld.getContents().equals("")){
					break;
				}else if(celld.getContents().equals("С����")){
					index2 = i+2; //index2��С���ӵ�һ�����ݺ�����
					continue;
				}else if(celld.getContents().equals("�б�")){
					index3 = i+2; //index3�ǰб��һ�����ݺ�����
					continue;
				}
				else if(celld.getContents().equals("С����-�б������")){
					index1 = i+2; //index1 ��С����-�б�������ĵ�һ�����ݺ�����
					break;
				}
			}
			//System.out.println(index1 +" "+ index2 +" "+ index3);
			System.out.println(sheet2.getCell(0, index1).getContents() +" "+ sheet2.getCell(0, index2).getContents() +" "+ sheet2.getCell(0, index3).getContents());
			for(i=0;i<babiao.length;i++){
				babiao[i]=null;
			}
			//��С����-�б��������Ӧ��Ŵ���������
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
		System.out.println("ͳ�Ƹ������ֳ��ֵĴ������洢��map��");
        //map��key��������д��ڵ����֣�value��Ÿ������������г��ֵĴ���
      
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();//�б�
       
        //map1��key���������ڵ����֣�value��Ÿ������������г��ֵĴ���
        for(i = 0; i < babiao.length; i++)
        {
        	if(babiao[i] == null)
        		break;
        	else if(map1.containsKey(babiao[i]))  //�ж�map1���Ƿ��Ѿ�������array[i]
            {
                int temp = map1.get(babiao[i]);//����babiao[i]���ֵĴ���
                map1.put(babiao[i], temp + 1);//��babiao[i]�Ͷ�Ӧ�ĳ��ִ���д��map1��
            }
            else
            {
                map1.put(babiao[i], 1);//��babiao[i]�Ͷ�Ӧ�ĳ��ִ���д��map1��
            }
        }

        List<Map.Entry<String, Integer>> infoIds1 = new ArrayList<Map.Entry<String, Integer>>(map1.entrySet());//�б�
        System.out.println("--------------����ǰ--------------");  //�б�
        for (i = 0; i < infoIds1.size(); i++) {  
            String id1 = infoIds1.get(i).toString();  
            System.out.println(id1);  
        }  
        // ����  
        Collections.sort(infoIds1, new Comparator<Map.Entry<String, Integer>>() {  //�б�
            public int compare(Map.Entry<String, Integer> o1,  
                    Map.Entry<String, Integer> o2) {  
                return ( o1.getValue()-o2.getValue());  
            }  
        }); 
        System.out.println("--------------�������Ӹߵ���˳���ҳ��б�--------------");  
       
        
        for (i = infoIds1.size()-1; i >= 0 ; i--) {     //�Ӻ���ǰ���
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
			
			HashMap<String, Integer> map3 = new HashMap<String, Integer>(); //���������������ϵ�һ��map��
			 for(i=0;i<everytablebabiaopaiming.length;i++){
				 if(everytablebabiaopaiming[i]==null){
					 break;
				 }else{
					 map3.put(everytablebabiaopaiming[i],everytablebabiaocishu[i]);
				 }
			 }
			 List<Map.Entry<String, Integer>> infoIds2 = new ArrayList<Map.Entry<String, Integer>>(map3.entrySet()); //С��������
		     Collections.sort(infoIds2, new Comparator<Map.Entry<String, Integer>>() {  //С����
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
		//�����б���Ҫ������txt�ļ�***********************************************************************************
       /*String file4name4="";
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
		FileOutputStream fs2 = new FileOutputStream(new File(path+"/��Ѫ�б���Ҫ��.txt")); //file1.getName().substring(0, file1.getName().indexOf("."))ȥ���ļ���׺��
		PrintStream p2 = new PrintStream(fs2);
		for(i = 0;i < babiaopaiming.length;i++){
			if(babiaopaiming[i] == null)
				continue;
			else{
				p2.println(i+1 + " " + babiaopaiming[i]);//���ļ���д������
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
