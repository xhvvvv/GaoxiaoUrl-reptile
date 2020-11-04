package MyClasses.Util;

import org.junit.Assert;
import org.junit.Test;

import MyClasses.Interface.Dispose_String;
/*
 *输入文件名，截取文件后缀.文件后缀必须在最后，
 */
public  class Get_String_File_Suffer implements Dispose_String{
	
	
	 @Test
	 public void test() {
		 System.out.println(getSuffer("时刻提防ios及东方手机哦皮肤.jsp"));
		 Assert.assertEquals(getSuffer("时刻提防ios及东方手机哦皮肤.jsp"),".jsp");
	 }
	public static String getSuffer(String filename) {
		
		filename=filename.substring(filename.lastIndexOf("."), filename.length());
		return filename;
		
	}
	
}
