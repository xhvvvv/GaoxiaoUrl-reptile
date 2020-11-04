package DownLoad_File_Util;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
/*
 * 
 * BBBBBBBBBBBBBBBBBBBBBBBBBBUUUUUUUUUUUUUUUUUUUUUUUGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG一个无法理解的类
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
	 * BufferedInputStream bos  = response.bodyStream();获取的流总是得到1m的数据，无论io中数据是否有还是超过
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
		
		 BufferedInputStream bos  = response.bodyStream();
		 String name=FileName+"/"+filename;
		 System.out.println(" Download_Picture卡住运行");
		 byte[] bs = new byte[1024*1024];
		 int len,size=0,count=0;
		 
	       // 输出的文件流
		 FileOutputStream os = new FileOutputStream(name, true);
	       // 开始读取
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
