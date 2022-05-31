package com.portfolioAp.pdg.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="portfolio")
@Getter @Setter
public class Portfolio implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="portfolio_id")
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private String creation_date;
    private String title;
    private String location;
    private String about_me;
    private String profile_img;
    

    public Portfolio() {
    }

    public Portfolio(Long id, String firstname, String lastname, String email, String creation_date, String title, String location, String about_me, String profile_img, List<Job> jobs, List<Skill> skills, List<Project> projects, List<Study> studies) {
        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.creation_date = creation_date;
        this.title = title;
        this.location = location;
        this.about_me = about_me;
        this.profile_img = profile_img;
        this.jobs = jobs;
        this.skills = skills;
        this.projects = projects;
        this.studies = studies;
    }

    

    
    @OneToMany(fetch = FetchType.LAZY, mappedBy="portfolio")
    private List<Job> jobs;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy="portfolio")
    private List<Skill> skills;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy="portfolio")
    private List<Project> projects;
    
    @OneToMany(fetch = FetchType.LAZY, mappedBy="portfolio")
    private List<Study> studies;    
}
