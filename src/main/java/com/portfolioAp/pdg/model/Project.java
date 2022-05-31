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
@Table(name="projects")
public class Project implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)   
    
    private Long project_id;
    private String project_name;
    private String project_description;
    private String project_start;
    private String project_end;
    private String project_url;
    private String project_img;
    private String project_tools;
    

    public Project() {
    }

    public Project(Long project_id, String project_name, String project_description, String project_start, String project_end, String project_url, String project_img, String project_tools, Portfolio portfolio) {
        this.project_id = project_id;
        this.project_name = project_name;
        this.project_description = project_description;
        this.project_start = project_start;
        this.project_end = project_end;
        this.project_url = project_url;
        this.project_img = project_img;
        this.project_tools = project_tools;
        this.portfolio = portfolio;
    }
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore()
    @JoinColumn ( name = "portfolio_id")
    
    private Portfolio portfolio;

}
