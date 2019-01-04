package com.gui;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class JtableZhongYaoXingPaiMingbabiao {   //创建一个Dialog显示一下
	static class ModelDemo1 extends AbstractTableModel
	{
	       /**
		 * 
		 */
		private static final long serialVersionUID = 5739333445213774740L;
		private Vector<String[]> TableData;//用来存放表格数据的线性表
	       private Vector<String> TableTitle;//表格的 列标题
	       //注意构造函数是第一个执行的，用于初始化 TableData，TableTitle
	       public ModelDemo1(String[] cc,String[] cc1)
	       {
	              TableData = new Vector<String[]>();//先new 一下
	              TableTitle= new Vector<String>();
	              //先初始化 列标题,有3列  一定得初始化列，这里我们假设当前的表格是 3x3的
	              TableTitle.add("第一列");
	              TableTitle.add("第二列");
	              TableTitle.add("第三列");
	              //初始化3行数据，方便起见直接用String数组保存每一行的数据
	              String[] first = {"序号","靶标名称","连接小分子的数目"};
	              TableData.add(first);
	              int l = 1;
	              for(int i = 0;i < cc1.length;i++){
	            	  if(cc[i] == null || cc1[i] == null){
	            		  continue;
	            	  }else{
	            		  String l1 = String.valueOf(l);
		            	  String []line = {l1,cc[i],cc1[i]};//i1表示序号，cc[i]为输出到表格的数据
		            	  TableData.add(line);
		            	  l ++;
	            	  }
	              }
	       }
		@Override
	       public int getRowCount()
	       {
	              return TableData.size();//这里是告知表格应该有多少行，我们返回TableData上挂的String数组个数
	       }
	       @Override
	       public int getColumnCount()
	       {
	              return TableTitle.size();//告知列数，用标题数组的大小,这样表格就是TableData.size()行，TableTitle.size()列了
	       }
	       @Override
	       public Object getValueAt(int rowIndex, int columnIndex)  //根据坐标获取数据
	       {
	              //获取了表格的大小，当然还要获取数据，根据坐标直接返回对应的数据
	              //小心 都是从 0开始的，小心下标越界 的问题
	              //我们之前是将 String[]挂到了线性表上，所以要先获取到String[]
	              //获取每一行对应的String[]数组
	              String LineTemp[] = (String[])this.TableData.get(rowIndex);
	              return LineTemp[columnIndex];//提取出对 应的数据
	              //如果我们是将 线性表Vector挂到了Vector上要注意每次我们获取的是 一行线性表
	              //例如
	              //return ((Vector)TableData.get(rowIndex)).get(columnIndex);
	       }
	}
	public void babiao(String[] str,String[] str1)
    { 
		  /*String[] strr = new String[10000];//靶标名称
		  String[] strr1 = new String[10000];//靶标出现次数
		  System.arraycopy(str, 0, strr, 0, str.length);
		  System.arraycopy(str1, 0, strr1, 0, str.length);*/
		  ModelDemo1 myModel=  new ModelDemo1(str,str1); 
          JTable table = new JTable(myModel);
          JFrame jf = new JFrame();
          jf.setTitle("补气中药的靶标重要性排名");
          JScrollPane jsp = new JScrollPane(table);//给表格添加滚动条
          jf.add(jsp);
          jf.setBounds(0, 0, 728, 406);
          jf.setLocation(300, 234);
          jf.setVisible(true);    
    }
}
