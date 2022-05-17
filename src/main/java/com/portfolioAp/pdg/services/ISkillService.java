package com.portfolioAp.pdg.services;


import com.portfolioAp.pdg.model.Skill;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author pablo
 */
public interface ISkillService {
    
    public List<Skill> listSkills();
    public Optional<Skill> getOne(Long id);
    public void saveSkill(Skill skill);
    public void deleteSkill(Long id);
    public boolean existSkillById(Long id);
      
}