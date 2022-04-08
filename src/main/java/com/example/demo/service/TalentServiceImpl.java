package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.model.Talent;
import com.example.demo.repository.TalentRepository;

public class TalentServiceImpl implements TalentService{

	@Autowired
	private TalentRepository talentRepo;
	
	@Override
	public List<Talent> getAllTalent() {
		// TODO Auto-generated method stub
		return talentRepo.findAll();
	}

}
