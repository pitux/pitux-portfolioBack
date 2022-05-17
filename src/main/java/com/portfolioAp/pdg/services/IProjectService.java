package com.portfolioAp.pdg.services;

import com.portfolioAp.pdg.model.Project;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author pablo
 */
public interface IProjectService {
    
     
    public List<Project> listProjects();
    public void saveProjects(Project project);
    public void deleteProject(Long id);
    public boolean existProjectById(Long id);
    public Optional<Project> getOne(Long id);

}