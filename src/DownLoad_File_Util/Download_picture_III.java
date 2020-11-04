package DownLoad_File_Util;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import MyClasses.Interface.GetHtml;
import MyClasses.Interface.Url_Download;

public class Download_picture_III  implements Url_Download{

	
	private static String  FileName=null;
	
	public  Download_picture_III() {
		this.FileName="F:\\EPWO1\\WXGC_Reptile\\DOWN\\Downpicture";
	}
	public  Download_picture_III(String file ) {
		this.FileName=file;

	}
	/*
	 * 
	 * 输入链接与保存的文件名，将下载至指定的目录中
	 */
	public static void Download_Picture(String onlinePath, String localPath) {
		localPath=FileName+"/"+localPath;
        try (DataInputStream dataInputStream = new DataInputStream(new URL(onlinePath).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(new File(localPath))) {
        	
            ByteArrayOutputStream output = new ByteArrayOutputStream();

            byte[] buffer = new byte[1024];
            int length,size=0;
          
            while ((length = dataInputStream.read(buffer)) > 0) {
                output.write(buffer, 0, length);
                size+=length;
               
            }
            System.out.println( "size"+size);
            fileOutputStream.write(output.toByteArray());

           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
