package DownLoad_File_Util;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
/*
 * 
 * BBBBBBBBBBBBBBBBBBBBBBBBBBUUUUUUUUUUUUUUUUUUUUUUUGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGһ���޷�������
 */
import MyClasses.Interface.Url_Download;

public class Download_picture_II implements Url_Download{
private static String  FileName=null;
	
	public  Download_picture_II() {
		this.FileName="F:\\EPWO1\\WXGC_Reptile\\DOWN\\Downpicture";
	}
	public  Download_picture_II(String file ) {
		this.FileName=file;

	}
	/*
	 * BufferedInputStream bos  = response.bodyStream();��ȡ�������ǵõ�1m�����ݣ�����io�������Ƿ��л��ǳ���
	 * ���������뱣����ļ�������������ָ����Ŀ¼��
	 */
	public static void Download_Picture(String url,String filename)  {
		// TODO Auto-generated method stub
//		System.out.println("��ס");
		 Connection.Response response;
		try {
			response = Jsoup.connect(url)
						.header("Accept", "*/*")
						.header("Accept-Encoding", "gzip, deflate")
						.header("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
						.ignoreContentType(true)
						.header("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
						.execute();
		
		 BufferedInputStream bos  = response.bodyStream();
		 String name=FileName+"/"+filename;
		 System.out.println(" Download_Picture��ס����");
		 byte[] bs = new byte[1024*1024];
		 int len,size=0,count=0;
		 
	       // ������ļ���
		 FileOutputStream os = new FileOutputStream(name, true);
	       // ��ʼ��ȡ
	       while ((len =  bos.read(bs)) != -1) {
	    	   
	    	   size+=len;
	    	   System.out.println( "len"+len);
	    	   count++;
	    	   os.write(bs , 0, len);
	       }
	       System.out.println( "size"+size+"-----count"+count);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	
				
			 
		       
		     
				
			       
	}	
}
