package com.gui;

import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

public class JtableQianSanShi {   //����һ��Dialog��ʾһ��
	static class ModelDemo1 extends AbstractTableModel
	{
	       /**
		 * 
		 */
		private static final long serialVersionUID = -9118663610958829859L;
		private Vector<String[]> TableData;//������ű�����ݵ����Ա�
	       private Vector<String> TableTitle;//���� �б���
	       //ע�⹹�캯���ǵ�һ��ִ�еģ����ڳ�ʼ�� TableData��TableTitle
	       public void Demo(String[] strr, String[] strr1)
	       {
	              TableData = new Vector<String[]>();//��new һ��
	              TableTitle= new Vector<String>();
	              //�ȳ�ʼ�� �б���,��3��  һ���ó�ʼ���У��������Ǽ��赱ǰ�ı���� 3x3��
	              TableTitle.add("��һ��");
	              TableTitle.add("�ڶ���");
	              TableTitle.add("������");
	      //        TableTitle.add("������");
	              String[] first = {"���","������ҩ�б�����","��Ѫ��ҩ�б�����"};
	              TableData.add(first);
	              //��ʼ��3�����ݣ��������ֱ����String���鱣��ÿһ�е�����
	              int l = 0;
	              for(int i = 0;i < 30;i++){
	            	  
	            		  String l1 = String.valueOf(l+1);
		            	  String []line = {l1,strr[i],strr1[i]};//i1��ʾ��ţ�cc[i]Ϊ�������������
		            	  l ++;
		            	  System.out.println("11111111111111111111111");
		            	  TableData.add(line);
		            	  System.out.println("22222222222222222222222222");
	            	  
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
	public void huabiaoge(String[] str,String[] str1)
    { 
//		  String[] strr = new String[1000];//babiao����
//		  String[] strr1 = new String[1000];//�б���ִ���
//		  System.arraycopy(str, 0, strr, 0, str.length);
//		  System.arraycopy(str1, 0, strr1, 0, str.length);
		  ModelDemo1 myModel=  new ModelDemo1(); 
		  myModel.Demo(str,str1);
          JTable table = new JTable(myModel);
          JFrame jf = new JFrame();
          jf.setTitle("��ͬ�б��ڲ�Ѫ��ҩ�Ͳ�����ҩ��������ǰ�İб�Ա�(��ȡǰ10��)");
          JScrollPane jsp = new JScrollPane(table);//�������ӹ�����
          jf.add(jsp);
          jf.setBounds(0, 0, 728, 406);
          jf.setLocation(300, 234);
          jf.setVisible(true);    
    }
}
