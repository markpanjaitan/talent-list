package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.Talent;
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
	
	@GetMapping("/showNewTalentForm")
	public String viewNewTalentForm(Model model) {
		Talent talent = new Talent();
		model.addAttribute("talent",talent);
		return "new_talent";
	}
	
	@PostMapping("/saveTalent")
	public String saveTalent(@ModelAttribute("talent") Talent talent) {
		talentService.saveTalent(talent);
		return "redirect:/";
	}
	
	@GetMapping("/showUpdateForm/{id}")
	public String viewUpdateForm(@PathVariable(value = "id") long id, Model model) throws Exception {
		//get talent by Id
		Talent talent = talentService.findById(id);
		model.addAttribute("talent",talent);
		return "update_talent";
	}
	
	@GetMapping("/deleteTalent/{id}")
	public String deleteTalent(@PathVariable(value = "id") long id) {
		this.talentService.deleteTalent(id);
		return "redirect:/";
	}
	
}
