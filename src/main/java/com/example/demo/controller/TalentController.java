package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.service.TalentService;

@Controller
public class TalentController {

	@Autowired
	private TalentService talentService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		model.addAttribute("listTalent",talentService.getAllTalent());
		return "index";
	}
}
