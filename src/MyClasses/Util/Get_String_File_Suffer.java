package MyClasses.Util;

import org.junit.Assert;
import org.junit.Test;

import MyClasses.Interface.Dispose_String;
/*
 *�����ļ�������ȡ�ļ���׺.�ļ���׺���������
 */
public  class Get_String_File_Suffer implements Dispose_String{
	
	
	 @Test
	 public void test() {
		 System.out.println(getSuffer("ʱ�����ios�������ֻ�ŶƤ��.jsp"));
		 Assert.assertEquals(getSuffer("ʱ�����ios�������ֻ�ŶƤ��.jsp"),".jsp");
	 }
	public static String getSuffer(String filename) {
		
		filename=filename.substring(filename.lastIndexOf("."), filename.length());
		return filename;
		
	}
	
}
