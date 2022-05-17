package com.portfolioAp.pdg.services;


import com.portfolioAp.pdg.model.Job;
import com.portfolioAp.pdg.repository.JobsRepository;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JobService implements IJobService {

    @Autowired
    JobsRepository JobRepo;
    
    @Override
    public List<Job> listJobs() {
        return JobRepo.findAll();
    }

    @Override
    public void saveJob(Job trabajo) {
        JobRepo.save(trabajo);
    }

    @Override
    public void deleteJob(Long id) {
        JobRepo.deleteById(id);
    }

    @Override
    public Optional<Job> getOne(Long id) {
      return JobRepo.findById(id);
    }

    @Override
    public boolean existJobsById(Long id) {
        return JobRepo.existsById(id);
    }
    
}
