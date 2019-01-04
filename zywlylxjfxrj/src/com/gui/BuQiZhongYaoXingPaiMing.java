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

import javax.swing.JFrame;


import javax.swing.filechooser.FileSystemView;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

public class BuQiZhongYaoXingPaiMing extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5371023542251538811L;
	/**
     * �ҳ�һ��������һ�����ֳ��ִ�����������
     * ��HashMap��key����������д��ڵ����֣�value��Ÿ������������г��ֵĴ���
     * @author xiangwei 
     */
	static JtableZhongYaoXingPaiMing zhongyaoxing = new JtableZhongYaoXingPaiMing();
	static JtableZhongYaoXingPaiMingbabiao babiaozhongyaoxing = new JtableZhongYaoXingPaiMingbabiao();
	static int i,j; 
	static String[] xiaofenzi = new String[10000];//��С�������
	static String[] babiao = new String[10000];//��б����
	static String[] xiaofenzipaiming = new String[10000];//���δ��С������Ҫ����
	static String[] babiaopaiming = new String[10000];//���δ�Űб���Ҫ������
	static String[] xiaofenzicishu = new String[10000];
	static String[] babiaocishu = new String[10000];
	static String[] everytablexiaofenzipaiming = new String[100000];//���δ��ÿ�ű��С������Ҫ����
	static int[] everytablexiaofenzicishu = new int[100000];//���δ��ÿ�ű�İб���Ҫ������
	static String[] everytablebabiaopaiming = new String[10000];//���δ��ÿ�ű��С������Ҫ����
	static int[] everytablebabiaocishu = new int[10000];//���δ��ÿ�ű�İб���Ҫ������
	static String path;
	//��ʼ��·��
	static{
		FileSystemView fsv = FileSystemView.getFileSystemView();
		File desktop=fsv.getHomeDirectory();  
		path = desktop.getAbsolutePath();
	}
	public static void Buqixiaofenzipaiming(String[] buqiroad1){
		int index1 = 0,index2 = 0,index3 = 0;
		
		try{
			 
			int k1=0,k=0;
			int m;
			for(int y=0;y<ZhuJieMian.t;y++){
			File file1 = new File(buqiroad1[y]);//����
			//File file2 = new File(filename2);//����
			
			InputStream is1 = new FileInputStream(file1.getAbsolutePath());//����
			//InputStream is2 = new FileInputStream(file2.getAbsolutePath());//����
			
			Workbook book1 = Workbook.getWorkbook(is1); //����
			//Workbook book2 = Workbook.getWorkbook(is2); //����
			
			//��õ�һ�����������(ecxel��sheet�ı�Ŵ�0��ʼ,0,1,2,3,....)
			Sheet sheet1 = book1.getSheet(0); //����
			//Sheet sheet2 = book2.getSheet(0); //����
			
			for(i = 0;i<sheet1.getRows();i ++){  //���� ��
				Cell celld = sheet1.getCell(0, i);  
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
			//System.out.println(sheet1.getCell(0, index1).getContents() +" "+ sheet1.getCell(0, index2).getContents() +" "+ sheet1.getCell(0, index3).getContents());
			//��С����-�б��������Ӧ��Ŵ���������
			for(i=0;i<xiaofenzi.length;i++){
				xiaofenzi[i]=null;
			}
			for(i=index1-1,m = 0;i < sheet1.getRows();i++){
				Cell celld0 = sheet1.getCell(0, i);  
				 
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
        	//System.out.println(xiaofenzi[i]);
        	if(xiaofenzi[i] == null)
        		break;
        	else if(map.containsKey(xiaofenzi[i]))  //�ж�map���Ƿ��Ѿ�������array[i]
            {
                int temp = map.get(xiaofenzi[i]);//����xiaofenzi[i]���ֵĴ���
                map.put(xiaofenzi[i], temp + 1);//��xiaofenzi[i]�Ͷ�Ӧ�ĳ��ִ���д��map��
            }
            else
            {
                map.put(xiaofenzi[i], 1);//��xiaofenzi[i]�Ͷ�Ӧ�ĳ��ִ���д��map��
            }
        	System.out.println(xiaofenzi[i]);
        } 
       
       /* for(Entry<String, Integer> vo : map.entrySet()){ 
            vo.getKey(); 
            vo.getValue(); 
            System.out.println(vo.getKey()+"  "+vo.getValue()); }*/
        List<Map.Entry<String, Integer>> infoIds = new ArrayList<Map.Entry<String, Integer>>(map.entrySet()); //С����
   
        System.out.println("--------------����ǰ--------------");  //С����
        for (i = 0; i < infoIds.size(); i++) {  
        	Entry<String,Integer> ent2 = infoIds.get(i);   
            System.out.println(ent2.getKey()+"="+ent2.getValue());  
        }    

        // ����  
        Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {  //С����
            public int compare(Map.Entry<String, Integer> o1,  
                    Map.Entry<String, Integer> o2) {  
                return ( o1.getValue()-o2.getValue());  
            }  
        });  

        System.out.println("--------------�����--------------");  //С����
        for (i = infoIds.size()-1; i >=0 ; i--) {     //�Ӻ���ǰ���
            Entry<String,Integer> ent=infoIds.get(i);  
            System.out.println(ent.getKey()+"="+ent.getValue());  
        }

        //�������Ӹߵ���˳���ҳ�С����
        
        System.out.println("--------------�������Ӹߵ���˳���ҳ�С����--------------"); 
       
        for (i = infoIds.size()-1; i >= 0 ; i--) {     //�Ӻ���ǰ���
            Entry<String,Integer> ent = infoIds.get(i);  
            for(j = index2-1; j < index3-1; j ++){
            	if(sheet1.getCell(0, j+1).getContents().equals(ent.getKey())){
            		everytablexiaofenzipaiming[k] = sheet1.getCell(1, j+1).getContents();
            		everytablexiaofenzicishu[k] = ent.getValue();
            		k++;
            		break;
            	}
            }
       
           // System.out.println(ent.getKey()+"="+ent.getValue()); 
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
			 List<Map.Entry<String, Integer>> infoIds1 = new ArrayList<Map.Entry<String, Integer>>(map3.entrySet()); //С��������
		     Collections.sort(infoIds1, new Comparator<Map.Entry<String, Integer>>() {  //С����
		         public int compare(Map.Entry<String, Integer> o3,  
		                 Map.Entry<String, Integer> o4) {  
		             return ( o3.getValue()-o4.getValue());  
		         }  
		     }); 
					
				for(i=infoIds1.size()-1;i>=0;i--){
					Entry<String,Integer> ent1=infoIds1.get(i);
					xiaofenzipaiming[k1]=ent1.getKey();
					xiaofenzicishu[k1]=ent1.getValue().toString();
					k1++;
					
				}	
				 //System.out.println("2222222222222222222222"+xiaofenzipaiming[2]+"="+xiaofenzicishu[2]);
        zhongyaoxing.huabiao(xiaofenzipaiming,xiaofenzicishu);
      //����С������Ҫ������txt�ļ�***********************************************************************************
        String file3name3="";
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
		FileOutputStream fs1 = new FileOutputStream(new File(path+"/"+file3name3+"����С������Ҫ��.txt")); //file1.getName().substring(0, file1.getName().indexOf("."))ȥ���ļ���׺��
		PrintStream p = new PrintStream(fs1);
		for(i = 0;i < xiaofenzipaiming.length;i++){
			if(xiaofenzipaiming[i] == null)
				continue;
			else{
				
				p.println(i+1 +" "+ xiaofenzipaiming[i]);//���ļ���д������
			}
		}	
		p.close();  
	
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}
	public static void Buqibabiaopaiming(String[] buqiroad1){
		int index1 = 0,index2 = 0,index3 = 0;
	try{
		int l,l1=0,l2=0;
			for(int y=0;y<ZhuJieMian.t;y++){
			File file1 = new File(buqiroad1[y]);//����

			
			InputStream is1 = new FileInputStream(file1.getAbsolutePath());//����

			
			Workbook book1 = Workbook.getWorkbook(is1); //����

			
		
			Sheet sheet1 = book1.getSheet(0); //����

			
			for(i = 0;i<sheet1.getRows();i ++){  //���� ��
				Cell celld = sheet1.getCell(0, i);  
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
			System.out.println(index1 +" "+ index2 +" "+ index3);
			System.out.println(sheet1.getCell(0, index1).getContents() +" "+ sheet1.getCell(0, index2).getContents() +" "+ sheet1.getCell(0, index3).getContents());
			//�������
			for(i=0;i<babiao.length;i++){
				babiao[i]=null;
			}
			//��С����-�б��������Ӧ��Ŵ���������
			for(i=index1-1,l=0;i < sheet1.getRows();i++){
				Cell celld0 = sheet1.getCell(0, i);  
				Cell celld1 = sheet1.getCell(1, i);  
				if(celld0.getContents().equals("")){
					break;
				}else{
					
					babiao[l] = celld1.getContents();
					l++;
				}
			}
			//�������

		System.out.println("ͳ�Ƹ������ֳ��ֵĴ������洢��map��");
        //map��key��������д��ڵ����֣�value��Ÿ������������г��ֵĴ���
       
        HashMap<String, Integer> map1 = new HashMap<String, Integer>();  //�б�
       
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
/*        System.out.println("--------------����ǰ--------------");  //С����
        for (i = 0; i < infoIds.size(); i++) {  
            String id = infoIds.get(i).toString();  
            System.out.println(id);  
        }    */
        System.out.println("--------------����ǰ--------------");  //�б�
        for (i = 0; i < infoIds1.size(); i++) {  
            String id1 = infoIds1.get(i).toString();  
            System.out.println(id1);  
        }  
        // ����  
/*        Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {  //С����
            public int compare(Map.Entry<String, Integer> o1,  
                    Map.Entry<String, Integer> o2) {  
                return ( o1.getValue()-o2.getValue());  
            }  
        });  */
        Collections.sort(infoIds1, new Comparator<Map.Entry<String, Integer>>() {  //�б�
            public int compare(Map.Entry<String, Integer> o1,  
                    Map.Entry<String, Integer> o2) {  
                return ( o1.getValue()-o2.getValue());  
            }  
        }); 
/*        System.out.println("--------------�����--------------");  //С����
        for (i = infoIds.size()-1; i >=0 ; i--) {     //�Ӻ���ǰ���
            Entry<String,Integer> ent=infoIds.get(i);  
            System.out.println(ent.getKey()+"="+ent.getValue());  
        }  */
        System.out.println("--------------�����--------------");  //�б�
        for (i = infoIds1.size()-1; i >=0 ; i--) {     //�Ӻ���ǰ���
            Entry<String,Integer> ent1=infoIds1.get(i);  
            System.out.println(ent1.getKey()+"="+ent1.getValue());  
        }
      
        
        System.out.println("--------------�������Ӹߵ���˳���ҳ��б�--------------");  
        for (i = infoIds1.size()-1; i >= 0 ; i--) {     //�Ӻ���ǰ���
            Entry<String,Integer> ent1 = infoIds1.get(i);  
            for(j = index3-1; j < index1-1; j ++){
            	if(sheet1.getCell(0, j).getContents().equals(ent1.getKey())){
            		everytablebabiaopaiming[l1] = sheet1.getCell(1, j).getContents();
            		everytablebabiaocishu[l1] = ent1.getValue();
            		l1++;
            		break;
            	}
            }
            System.out.println(ent1.getKey()+"="+ent1.getValue());  
        }
			}      

      //����С������Ҫ������txt�ļ�***********************************************************************************
			 HashMap<String, Integer> map3 = new HashMap<String, Integer>(); //���������������ϵ�һ��map��
			 for(i=0;i<everytablexiaofenzipaiming.length;i++){
				 if(everytablebabiaopaiming[i]==null){
					 break;
				 }else{
					 map3.put(everytablebabiaopaiming[i],everytablebabiaocishu[i]);
				 }
			 }
			 List<Map.Entry<String, Integer>> infoIds1 = new ArrayList<Map.Entry<String, Integer>>(map3.entrySet()); //С��������
		     Collections.sort(infoIds1, new Comparator<Map.Entry<String, Integer>>() {  //С����
		         public int compare(Map.Entry<String, Integer> o3,  
		                 Map.Entry<String, Integer> o4) {  
		             return ( o3.getValue()-o4.getValue());  
		         }  
		     }); 
					
				for(i=infoIds1.size()-1;i>=0;i--){
					Entry<String,Integer> ent1=infoIds1.get(i);
					babiaopaiming[l2]=ent1.getKey();
					babiaocishu[l2]=ent1.getValue().toString();
					l2++;
					
				}	
        babiaozhongyaoxing.babiao(babiaopaiming, babiaocishu);
		//�����б���Ҫ������txt�ļ�***********************************************************************************
       /* String file3name3="", file4name4="";
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
		}*/
		FileOutputStream fs2 = new FileOutputStream(new File(path+"/�����б���Ҫ��.txt")); //file1.getName().substring(0, file1.getName().indexOf("."))ȥ���ļ���׺��
		PrintStream p2 = new PrintStream(fs2);
		for(i = 0;i < babiaopaiming.length;i++){
			if(babiaopaiming[i] == null)
				continue;
			else{
				
				p2.println(i+1 +" "+ babiaopaiming[i]);//���ļ���д������
			}
		}	
		p2.close();      

		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
