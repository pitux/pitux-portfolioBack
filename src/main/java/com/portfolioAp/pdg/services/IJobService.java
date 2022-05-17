package com.portfolioAp.pdg.services;

import com.portfolioAp.pdg.model.Job;
import java.util.List;
import java.util.Optional;

public interface IJobService {
 
    public List<Job> listJobs();
    public Optional<Job> getOne(Long id);
    public void saveJob(Job work);
    public void deleteJob(Long id);
    public boolean existJobsById(Long id);
    
}
