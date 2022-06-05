package com.portfolioAp.pdg.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
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

public class Job implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
            
    private Long idjobs;       
    private String job_name;
    private String job_place;
    private String job_year;
           
    public Job() { }

public Job(Long idjobs, String job_name, String job_place, String job_year, Portfolio portfolio) {
        this.idjobs = idjobs;
        this.job_name = job_name;
        this.job_place = job_place;
        this.job_year = job_year;
        this.portfolio = portfolio;
    }
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore()
    @JoinColumn ( name = "portfolio_id") 
    private Portfolio portfolio;
    
}
