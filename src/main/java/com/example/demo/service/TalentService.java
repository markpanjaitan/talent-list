package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Talent;

public interface TalentService {
	
	List<Talent> getAllTalent();
	void saveTalent(Talent talent);
	Talent findById(long id) throws Exception;
}
