package com.portfolioAp.pdg.controller;

import com.portfolioAp.pdg.model.Mensaje;
import com.portfolioAp.pdg.model.Study;
import com.portfolioAp.pdg.services.IStudyService;
import java.util.List;

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

@RequestMapping("/studies")
@CrossOrigin
@RestController

public class StudyController {
    
    @Autowired 
    private IStudyService estudios;

    @GetMapping ("/all")
    @ResponseBody
    public List<Study> listStudies(){
        return estudios.listStudies();
    }
       
    @GetMapping ("/view/{id}")
    @ResponseBody
    public Study verStudies(@PathVariable Long id){
     return estudios.buscarStudies(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")  
    @PostMapping ("/new")
    public void addStudies(@RequestBody Study studies){
        estudios.saveStudy(studies);
    } 
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/{id}")
    public void borrarStudy(@PathVariable Long id){
        estudios.deleteStudy(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Study study){
      Study study_mod = estudios.getOne(id).get();
      study_mod.setStudies_institute(study.getStudies_institute());
      study_mod.setStudies_title(study.getStudies_title());
      study_mod.setStudies_year(study.getStudies_year());
                   
      estudios.saveStudy(study_mod);
      return new ResponseEntity(new Mensaje("Los estudios han sido actualizados"),HttpStatus.OK);
    }
}
