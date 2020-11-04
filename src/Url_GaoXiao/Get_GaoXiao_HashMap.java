package Url_GaoXiao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import MyClasses.Interface.Analysis_Document_GAOxiao;
import MyClasses.Util.Get_String_File_Suffer;


public class Get_GaoXiao_HashMap implements Analysis_Document_GAOxiao{

	@Override
	public Map Analysis_Document_AND_GetIfor(Document doc) {
		// TODO Auto-generated method stub
		Elements elements_I=doc.getElementsByClass("block");
		Map Contine_UrlAndName_HashMap=new HashMap();
		Elements elements_II;
		String key,value,suffer;
		
		for(Element element:elements_I) {
			/*
			 * 得到图片url，名称设置为map的value
			 */
			elements_II=	element.select("img[src]");
			value=elements_II.attr("src");
			suffer=Get_String_File_Suffer.getSuffer(value);
			/*
			 * 得到图片名称设置为map的key
			 */
			elements_II=	element.select("h2");
			elements_II=elements_II.select("a[target=\"_ablank\"]");
			key=elements_II.text()+suffer;
			
			Contine_UrlAndName_HashMap.put(key, value);
		}
		return Contine_UrlAndName_HashMap;
	}

	@Override
	public String Analysis_Document_To_getNextPages(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

}
