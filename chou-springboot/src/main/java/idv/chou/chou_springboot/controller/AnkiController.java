package idv.chou.chou_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import idv.chou.chou_springboot.bean.Note;

@Controller
public class AnkiController {
	@RequestMapping("/addNote")
	public String findCards(Model model)
	{
		model.addAttribute("note", new Note());
		return "addNote";
		
	}
	
}
