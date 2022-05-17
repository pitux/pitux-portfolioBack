package com.portfolioAp.pdg.controller;

import com.portfolioAp.pdg.model.Mensaje;
import com.portfolioAp.pdg.model.Skill;
import com.portfolioAp.pdg.services.ISkillService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author pablo
 */

@RequestMapping("/skills")
@RestController

public class SkillController {
   
    @Autowired
    private ISkillService habilidades;
    
    @GetMapping ("/all")
    @ResponseBody
    public List<Skill> listSkill(){
        return habilidades.listSkills();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/new")
    public void addSkill(@RequestBody Skill skill){
        habilidades.saveSkill(skill);
    } 
  
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/{id}")
    public void borrarSkill(@PathVariable Long id){
        habilidades.deleteSkill(id);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody Skill skill){
      /* 
       - - - - Añadir las comprobaciones necesarias para devolver los estados HTTP que correspondan  - - - -
        
        if(!trabajo.existJobsById(id))
           return new ResponseEntity(new Mensaje("El trabajo solicitado no existe"),HttpStatus.NOT_FOUND);
       if(StringUtils.isBlank(job.getJob_name()))
           return new ResponseEntity(new Mensaje("El nombre del trabajo es obligatorio"),HttpStatus.BAD_REQUEST);
       */
      
      Skill skill_mod = habilidades.getOne(id).get();
      skill_mod.setSkills_name(skill.getSkills_name());
      skill_mod.setSkills_domain(skill.getSkills_domain());
      
      habilidades.saveSkill(skill_mod);
      return new ResponseEntity(new Mensaje("Las habilidades han sido actualizadas"),HttpStatus.OK);
    }
}
