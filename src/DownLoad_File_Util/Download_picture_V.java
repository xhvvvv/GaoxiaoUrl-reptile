package DownLoad_File_Util;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.jsoup.Connection;
import org.jsoup.Jsoup;

import MyClasses.Interface.Url_Download;

public class Download_picture_V implements Url_Download{
private static String  FileName=null;
	
	public  Download_picture_V() {
		this.FileName="F:\\EPWO1\\WXGC_Reptile\\DOWN\\Downpicture";
	}
	public  Download_picture_V(String file ) {
		this.FileName=file;

	}
	/*
	 * 
	 * 输入链接与保存的文件名，将下载至指定的目录中
	 */
	public static void Download_Picture(String url,String filename)  {
		// TODO Auto-generated method stub
//		System.out.println("卡住");
		 Connection.Response response;
		try {
			response = Jsoup.connect(url)
						.header("Accept", "*/*")
						.header("Accept-Encoding", "gzip, deflate")
						.header("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
						.ignoreContentType(true)
						.header("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
						.execute();
		
			
		 String name=FileName+"/"+filename;
		 System.out.println(" Download_Picture_V卡住运行");
		 byte[] bs= response.bodyAsBytes();
		 FileOutputStream os = new FileOutputStream(name, true);
		 BufferedOutputStream bos = new BufferedOutputStream(os);
		 System.out.println( "bs.size"+bs.length);
		 bos.write(bs);
		 bos.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}	
    
}
