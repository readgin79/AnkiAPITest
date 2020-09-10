package idv.chou.chou_springboot.controller;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import idv.chou.chou_springboot.bean.Explanation;
import idv.chou.chou_springboot.bean.Info;
import idv.chou.chou_springboot.bean.Note;
import idv.chou.chou_springboot.bean.Vocabulary;

@Controller
public class ParserController {
	
	@Value("${dictionary.url}")
	private String url;

	//查詢get
	@GetMapping("/dictionary/{vocabulary}")
	public String findVocabulary(Model model, @PathVariable String vocabulary) {
		Document doc = null;
		Elements elements= null;
		Elements sub_elements= null;
		Elements sub2_elements= null;
		Elements sub3_elements= null;
		String exsample = null;
		String pos = null;
		Explanation explanation = null;
		Vocabulary voc = null;
		try {
			doc = Jsoup.connect(url+vocabulary).get();
			//主要大段
			elements = doc.getElementsByClass("pr entry-body__el"); 
			Info[] infoary = new Info[elements.size()];
			for(int i=0; i<elements.size(); i++) {
				Info info = new Info();
				//取得詞性
				sub_elements = elements.get(i).select("div[class=posgram dpos-g hdib lmr-5]>span[class=pos dpos]");
				if(sub_elements.size()>0) {
					System.out.println(sub_elements.get(0).text());
					info.setPos(sub_elements.get(0).text());
				}
				//取得KK音標
				sub_elements = elements.get(i).select("span[class=us dpron-i ] span[class=ipa dipa lpr-2 lpl-1]");
				if(sub_elements.size()>0) {
					System.out.println(sub_elements.get(0).text());
					info.setKk(sub_elements.get(0).text());
				}
				
				sub_elements = elements.get(i).select("div[class=ddef_h] div[class=def ddef_d db]");
				
				Explanation[] exary = new Explanation[sub_elements.size()];
				for(int j=0; j<sub_elements.size(); j++) {
					explanation = new Explanation();
					//取得解釋
					System.out.println(sub_elements.get(j).text());
					explanation.setExplanation(sub_elements.get(j).text());
					//取得中文翻譯
					sub2_elements = elements.get(i).select("div[class=def-body ddef_b]");
				
					sub3_elements = sub2_elements.get(j).select("span[class=trans dtrans dtrans-se ]");
					System.out.println("----"+sub3_elements.get(0).text());
					explanation.setChinese(sub3_elements.get(0).text());
					//取得例句
					sub3_elements = sub2_elements.get(j).select("span[class=eg deg]");
					String examples[] = new String[sub3_elements.size()];
					for(int k=0; k<sub3_elements.size(); k++) {
						System.out.println("--------"+sub3_elements.get(k).text());
						examples[k] = sub3_elements.get(k).text();
					}
					explanation.setExample(examples);
					exary[j] = explanation;
					
				}
				info.setExplanation(exary);
				infoary[i] = info;
				voc = new Vocabulary(vocabulary, infoary);
				
				
				System.out.println("========================");
				System.out.println(voc);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		model.addAttribute("vocabulary", voc);
		return "dictionary";
	}
}
