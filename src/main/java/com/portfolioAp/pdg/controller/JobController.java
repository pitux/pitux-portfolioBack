package com.portfolioAp.pdg.controller;

import com.portfolioAp.pdg.model.Job;
import com.portfolioAp.pdg.model.Mensaje;
import com.portfolioAp.pdg.services.IJobService;

import static java.lang.System.console;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/jobs")
@CrossOrigin
@RestController

public class JobController {
    
    @Autowired 
    private IJobService trabajo;

    @GetMapping ("/all")
    @ResponseBody
    public List<Job> listJobs(){
        return trabajo.listJobs();
    }
    @GetMapping ("/view/{id}")
    @ResponseBody
    public Job verStudies(@PathVariable Long id){
     return trabajo.buscarJob(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/new")
    public void addJob(@RequestBody Job work){
        trabajo.saveJob(work);
    } 
  
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/{id}")
    public void borrarJob(@PathVariable Long id){
    trabajo.deleteJob(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Job jobs){
      Job trabajo_mod = trabajo.getOne(id).get();
      trabajo_mod.setJob_name(jobs.getJob_name());
      trabajo_mod.setJob_place(jobs.getJob_place());
      //trabajo_mod.setPortfolio(jobs.getPortfolio());
      
      trabajo.saveJob(trabajo_mod);
      return new ResponseEntity(new Mensaje("El trabajo ha sido actualizado"),HttpStatus.OK);
    }

}