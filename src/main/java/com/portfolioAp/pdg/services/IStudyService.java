package com.portfolioAp.pdg.services;

import com.portfolioAp.pdg.model.Study;
import java.util.List;
import java.util.Optional;


public interface IStudyService {

    public List<Study> listStudies();
    public Optional<Study> getOne(Long id);    
    public void saveStudy(Study studies);
    public void deleteStudy(Long id);
    public boolean existStudyById(Long id);
    
}
