package com.portfolioAp.pdg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
@Table(name="jobs")

public class Job {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
            
    public Long idjobs;       
    public String job_name;
    public String job_place;
           
    public Job() { }

    public Job(Long idjobs, String job_name, String job_place) {
        this.idjobs = idjobs;
        this.job_name = job_name;
        this.job_place = job_place;
    }
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore()
    @JoinColumn ( name = "portfolio_id") 
    private Portfolio portfolio;
    
}
