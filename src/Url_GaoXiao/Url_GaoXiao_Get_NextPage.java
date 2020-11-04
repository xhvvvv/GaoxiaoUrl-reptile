package Url_GaoXiao;

import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import MyClasses.Interface.Analysis_Document_GAOxiao;
import MyClasses.Util.Get_String_File_Suffer;

public class Url_GaoXiao_Get_NextPage implements  Analysis_Document_GAOxiao{

	@Override
	public Map Analysis_Document_AND_GetIfor(Document doc) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String Analysis_Document_To_getNextPages(Document doc) {
		// TODO Auto-generated method stub
		Elements elements_I=doc.getElementsByClass("pagination");
		
		System.out.println("wc"+elements_I);
		String back=null;
		for(Element element:elements_I) {
			/*
			 * 得到图片url，名称设置为map的value
			 */
			elements_I=	element.select("a:contains(下一页)");
			back=elements_I.attr("href");

		}
		
		return back;
	}

}
