package com.portfolioAp.pdg.repository;


import com.portfolioAp.pdg.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pablo
 */

@Repository
public interface SkillRepository extends JpaRepository <Skill, Long> {

    public void save(Long id);
    
}
