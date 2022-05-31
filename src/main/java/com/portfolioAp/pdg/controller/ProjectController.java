package com.portfolioAp.pdg.controller;

import com.portfolioAp.pdg.model.Mensaje;
import com.portfolioAp.pdg.model.Project;
import com.portfolioAp.pdg.services.IProjectService;
import java.util.List;
import javax.persistence.OrderBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/projects")
@CrossOrigin
@RestController

public class ProjectController {

    @Autowired
    private IProjectService proyectos;
  
    @GetMapping ("/all")
    @ResponseBody
    @OrderBy("project_start DESC")
    public List<Project> listJobs(){
        return proyectos.listProjects();
    }
    
    @GetMapping ("/view/{id}")
    @ResponseBody
    public Project verProject(@PathVariable Long id){
     return proyectos.buscarProject(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/new")
    public void newProject(@RequestBody Project projects){
        proyectos.saveProjects(projects);
    } 
  
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/{id}")
    public void deleteProject(@PathVariable Long id){
        proyectos.deleteProject(id);
    }
     
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Project project){
/*  public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Job jobs){*/

      Project project_mod = proyectos.getOne(id).get();
      /* Project name */
      project_mod.setProject_name(project.getProject_name());
      /* Project description */
      project_mod.setProject_description(project.getProject_description());
      /* Project start */
      project_mod.setProject_start(project.getProject_start());
      /* Project end */
      project_mod.setProject_end(project.getProject_end());
      /* Project img*/
      project_mod.setProject_img(project.getProject_img());
      /* Project url*/
      project_mod.setProject_url(project.getProject_url());
      /* Project tools*/
      project_mod.setProject_tools(project.getProject_tools());
      
      proyectos.saveProjects(project_mod);
      return new ResponseEntity(new Mensaje("El proyecto ha sido actualizado"),HttpStatus.OK);
    }

}
