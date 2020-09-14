package idv.chou.chou_springboot.controller;

import java.util.Arrays;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import idv.chou.chou_springboot.bean.Anki;
import idv.chou.chou_springboot.bean.AnkiResponse_get;
import idv.chou.chou_springboot.bean.AnkiResponse_post;
import idv.chou.chou_springboot.bean.Field;
import idv.chou.chou_springboot.bean.Note;
import idv.chou.chou_springboot.bean.Param;
import idv.chou.chou_springboot.bean.ResponseBean;
import idv.chou.chou_springboot.service.RedisService;
import idv.chou.chou_springboot.util.HttpUtil;

@Controller
public class RESTController {
	@Value("${anki.version}")
	private Integer version;
	
	@Value("${anki.url}")
	private String url;
	
	@Value("${project.encode}")
	private String encode;
	
	@Autowired
    private Gson gson;
	
	//查詢get
	@GetMapping("/anki/{deck}")
	@ResponseBody
	public String findCards(@PathVariable String deck)
	{

		Param param = new Param();
		param.setQuery("deck:"+deck);

		
		Anki data = new Anki("findCards", version, param);
		String content = gson.toJson(data);
		System.out.println(content);
		String result = HttpUtil.sendPost(url,content, encode);
		AnkiResponse_get res = (AnkiResponse_get)gson.fromJson(result, AnkiResponse_get.class);
		System.out.println(res);
		ResponseBean responsebean = new ResponseBean();
		if(res.getError()!=null) {
			responsebean.setResult("error");
			return responsebean.toString();
		}else {
			responsebean.setData(res.getResult());
			return responsebean.toString();
		}
		
	}
	
	//新增post
	@PostMapping("/anki")
	@ResponseBody
	public String addNote(@ModelAttribute Note note, @RequestParam("front") String front, @RequestParam("back") String back)
	{
		
		note.setFields(new Field(front, back));
		Param param = new Param();
		param.setNote(note);
		
		Anki data = new Anki("addNote", version, param);
		String content = gson.toJson(data);
		System.out.println(content);
		String result = HttpUtil.sendPost(url,content, encode);
		System.out.println(result);
		AnkiResponse_post res = (AnkiResponse_post)gson.fromJson(result, AnkiResponse_post.class);
		System.out.println(res);
		ResponseBean responsebean = new ResponseBean();
		if(res.getError()!=null) {
			responsebean.setResult("error");
			return responsebean.toString();
		}else {
			responsebean.setData(res.getResult());
			return responsebean.toString();
		}
	}
	
	
	
}