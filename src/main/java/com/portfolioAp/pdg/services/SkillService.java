package com.portfolioAp.pdg.services;


import com.portfolioAp.pdg.model.Skill;
import com.portfolioAp.pdg.repository.SkillRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class SkillService implements ISkillService{

    @Autowired
    SkillRepository skillRepo;
    
    @Override
    public List<Skill> listSkills() {
        return skillRepo.findAll();
    }

    @Override
    public void saveSkill(Skill skill) {
        skillRepo.save(skill);
    }

    @Override
    public void deleteSkill(Long id) {
        skillRepo.deleteById(id);
    }

    @Override
    public Optional<Skill> getOne(Long id) {
        return skillRepo.findById(id);
    }

    @Override
    public boolean existSkillById(Long id) {
        return skillRepo.existsById(id);
    }

   
}

