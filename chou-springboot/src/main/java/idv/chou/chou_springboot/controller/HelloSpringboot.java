package idv.chou.chou_springboot.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloSpringboot {
	@Value("${test.name}")
	private String name;

	@RequestMapping("/hello")
	public String hello(Model model)
	{
		model.addAttribute("obj", "hello "+name);
		return "jsp/hello";
	}
	
	@RequestMapping("/hi")
	@ResponseBody
	public String hi()
	{
		return "hi world";
	}
}