package DownLoad_File_Util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import MyClasses.Interface.Url_Download;

public class Download_picture implements Url_Download {
	private static String  FileName=null;
	
	public  Download_picture() {
		this.FileName="F:\\EPWO1\\WXGC_Reptile\\DOWN\\Downpicture";
	}
	public  Download_picture(String file ) {
		this.FileName=file;

	}
	/*
	 * 
	 * ���������뱣���·���ļ�������������ָ����Ŀ¼��
	 */
	public static void Download_Picture(String url,String filename)  {
		// TODO Auto-generated method stub
		System.out.println("��ס2");
		URLConnection con;
		try {
			con = new URL(url).openConnection();
		

				String name=FileName+"/"+filename;
				try(InputStream is = con.getInputStream(); // ������
		
					FileOutputStream os = new FileOutputStream(name, true)	){ // ������
				  // 1K�����ݻ���
			       byte[] bs = new byte[1024*1024];
			       // ��ȡ�������ݳ���
			       int len,size=0,count=0;
			       // ������ļ���
			       
			       // ��ʼ��ȡ
			       while ((len = is.read(bs)) != -1) {
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
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}	
	
}
