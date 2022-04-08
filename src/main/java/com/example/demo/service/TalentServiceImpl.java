package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Talent;
import com.example.demo.repository.TalentRepository;

@Service
public class TalentServiceImpl implements TalentService{

	@Autowired
	private TalentRepository talentRepo;
	
	@Override
	public List<Talent> getAllTalent() {
		// TODO Auto-generated method stub
		return talentRepo.findAll();
	}

	@Override
	public void saveTalent(Talent talent) {
		// TODO Auto-generated method stub
		this.talentRepo.save(talent);
	}

	@Override
	public Talent findById(long id) throws Exception {
		Optional<Talent> optional = talentRepo.findById(id);
		Talent talent = null;
		if(optional.isPresent()) {
			talent = optional.get();
		}else {
			throw new RuntimeException("Talent Not Found for ID = " + id);
		}
		return talent;
	}

	@Override
	public void deleteTalent(long id) {
		// TODO Auto-generated method stub
		this.talentRepo.deleteById(id);
	}

	
}
