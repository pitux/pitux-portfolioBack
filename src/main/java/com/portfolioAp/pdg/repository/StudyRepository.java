package com.portfolioAp.pdg.repository;

import com.portfolioAp.pdg.model.Study;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author pablo
 */

@Repository

public interface StudyRepository extends JpaRepository <Study, Long>{
    
}