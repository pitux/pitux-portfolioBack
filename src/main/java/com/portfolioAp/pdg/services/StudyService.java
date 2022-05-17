package com.portfolioAp.pdg.services;

import com.portfolioAp.pdg.model.Study;
import com.portfolioAp.pdg.repository.StudyRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service

public class StudyService implements IStudyService {

     @Autowired
    StudyRepository studyRepo;
    
    @Override
    public void saveStudy(Study studies) {
        studyRepo.save(studies);
    }

    @Override
    public void deleteStudy(Long id) {
        studyRepo.deleteById(id);
    }

    @Override
    public Optional<Study> getOne(Long id) {
        return studyRepo.findById(id);
    }

    @Override
    public boolean existStudyById(Long id) {
        return studyRepo.existsById(id);
    }

    @Override
    public List<Study> listStudies() {
        return studyRepo.findAll();
    }

}
