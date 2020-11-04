package MyClasses.Util;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import MyClasses.Interface.GetHtml;
/*
 * 输入网址的字符串，返回该网址的Document
 */
public class Get_Document_ByJSOUP implements GetHtml{
	public Document GetHtmlDocumentBy_JSOUP(String Url){
		try {
			Document doc = Jsoup
					.connect(Url)
					.header("Accept", "*/*")
					.header("Accept-Encoding", "gzip, deflate")
					.header("Accept-Language","zh-CN,zh;q=0.8,en-US;q=0.5,en;q=0.3")
					.header("Content-Type", "application/json;charset=UTF-8")
					.header("User-Agent","Mozilla/5.0 (Windows NT 6.1; WOW64; rv:48.0) Gecko/20100101 Firefox/48.0")
					.timeout(10000).get();
			return doc;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
			
		
		
	}
}
