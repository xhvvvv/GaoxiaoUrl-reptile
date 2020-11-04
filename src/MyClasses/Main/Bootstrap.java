package MyClasses.Main;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Test;

import DownLoad_File_Util.Download_picture;
import DownLoad_File_Util.Download_picture_II;
import DownLoad_File_Util.Download_picture_III;
import DownLoad_File_Util.Download_picture_V;
import MyClasses.Interface.Analysis_Document;
import MyClasses.Interface.Analysis_Document_GAOxiao;
import MyClasses.Interface.Url_Download;
import MyClasses.Util.Get_Document_ByJSOUP;
import Url_GaoXiao.Get_GaoXiao_HashMap;
import Url_GaoXiao.Url_GaoXiao_Get_NextPage;

public class Bootstrap {
	String URL="http://www.gaoxiaogif.cn/diaobaogif/";
	@Test
	public void MAIN() {
		String Url_back="",url=URL;
		while(Url_back!=null) {
			
			Url_back=mainA (url);
			url=URL+Url_back;
			System.out.println("即将要进行下载的页面是url为"+url);
		}
		
	}
	public String  mainA (String uRl) {
		Document doc=new Get_Document_ByJSOUP().GetHtmlDocumentBy_JSOUP(uRl);
		/*
		 * 分析Document,得到图片网址与名称
		 */
		Map Contine_UrlAndName_HashMap=new Get_GaoXiao_HashMap().Analysis_Document_AND_GetIfor(doc);
		Set<String> keySet=Contine_UrlAndName_HashMap.keySet();
		Iterator<String> it=keySet.iterator();
		String key,value;
		/*
		 * 对图片进行下载
		 */
		Download_picture_V download_picture=new Download_picture_V();
		while(it.hasNext()){
			key=it.next();
			value=(String)Contine_UrlAndName_HashMap.get(key);	
			System.out.println(key+"---------------------"+value);
			System.out.println("Bootstrap卡住1");
//				download_picture.Download_Picture(new URL(value), key);
			download_picture.Download_Picture(value, key);
		}
		
		String Dis_url=new Url_GaoXiao_Get_NextPage().Analysis_Document_To_getNextPages(doc);
		return Dis_url;
		
	}
	
	
}
