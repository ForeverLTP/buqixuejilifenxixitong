package com.gui;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class JtableZhongYaoXingPaiMingbabiao {   //����һ��Dialog��ʾһ��
	static class ModelDemo1 extends AbstractTableModel
	{
	       /**
		 * 
		 */
		private static final long serialVersionUID = 5739333445213774740L;
		private Vector<String[]> TableData;//������ű�����ݵ����Ա�
	       private Vector<String> TableTitle;//���� �б���
	       //ע�⹹�캯���ǵ�һ��ִ�еģ����ڳ�ʼ�� TableData��TableTitle
	       public ModelDemo1(String[] cc,String[] cc1)
	       {
	              TableData = new Vector<String[]>();//��new һ��
	              TableTitle= new Vector<String>();
	              //�ȳ�ʼ�� �б���,��3��  һ���ó�ʼ���У��������Ǽ��赱ǰ�ı���� 3x3��
	              TableTitle.add("��һ��");
	              TableTitle.add("�ڶ���");
	              TableTitle.add("������");
	              //��ʼ��3�����ݣ��������ֱ����String���鱣��ÿһ�е�����
	              String[] first = {"���","�б�����","����С���ӵ���Ŀ"};
	              TableData.add(first);
	              int l = 1;
	              for(int i = 0;i < cc1.length;i++){
	            	  if(cc[i] == null || cc1[i] == null){
	            		  continue;
	            	  }else{
	            		  String l1 = String.valueOf(l);
		            	  String []line = {l1,cc[i],cc1[i]};//i1��ʾ��ţ�cc[i]Ϊ�������������
		            	  TableData.add(line);
		            	  l ++;
	            	  }
	              }
	       }
		@Override
	       public int getRowCount()
	       {
	              return TableData.size();//�����Ǹ�֪���Ӧ���ж����У����Ƿ���TableData�Ϲҵ�String�������
	       }
	       @Override
	       public int getColumnCount()
	       {
	              return TableTitle.size();//��֪�������ñ�������Ĵ�С,����������TableData.size()�У�TableTitle.size()����
	       }
	       @Override
	       public Object getValueAt(int rowIndex, int columnIndex)  //���������ȡ����
	       {
	              //��ȡ�˱��Ĵ�С����Ȼ��Ҫ��ȡ���ݣ���������ֱ�ӷ��ض�Ӧ������
	              //С�� ���Ǵ� 0��ʼ�ģ�С���±�Խ�� ������
	              //����֮ǰ�ǽ� String[]�ҵ������Ա��ϣ�����Ҫ�Ȼ�ȡ��String[]
	              //��ȡÿһ�ж�Ӧ��String[]����
	              String LineTemp[] = (String[])this.TableData.get(rowIndex);
	              return LineTemp[columnIndex];//��ȡ���� Ӧ������
	              //��������ǽ� ���Ա�Vector�ҵ���Vector��Ҫע��ÿ�����ǻ�ȡ���� һ�����Ա�
	              //����
	              //return ((Vector)TableData.get(rowIndex)).get(columnIndex);
	       }
	}
	public void babiao(String[] str,String[] str1)
    { 
		  /*String[] strr = new String[10000];//�б�����
		  String[] strr1 = new String[10000];//�б���ִ���
		  System.arraycopy(str, 0, strr, 0, str.length);
		  System.arraycopy(str1, 0, strr1, 0, str.length);*/
		  ModelDemo1 myModel=  new ModelDemo1(str,str1); 
          JTable table = new JTable(myModel);
          JFrame jf = new JFrame();
          jf.setTitle("������ҩ�İб���Ҫ������");
          JScrollPane jsp = new JScrollPane(table);//�������ӹ�����
          jf.add(jsp);
          jf.setBounds(0, 0, 728, 406);
          jf.setLocation(300, 234);
          jf.setVisible(true);    
    }
}
