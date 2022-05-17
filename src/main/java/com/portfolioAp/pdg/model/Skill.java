package com.portfolioAp.pdg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="skills")

public class Skill {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    public Long idSkills;
    
    public String skills_name;
    public String skills_domain;

    public Skill() {
    }

    public Skill(Long idSkills, String skills_name, String skills_domain) {
        this.idSkills = idSkills;
        this.skills_name = skills_name;
        this.skills_domain = skills_domain;
    }
    
    @ManyToOne()
    @JsonIgnore()
    private Portfolio portfolio;

}
