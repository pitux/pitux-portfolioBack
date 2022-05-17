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
@Table(name="studies")

public class Study implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)   
    
    public Long studies_id;
    public String studies_title;
    public String studies_institute;
    public String studies_year;
    
    public Study() {
    }
    
    public Study(Long studies_id, String studies_title, String studies_institute, String studies_year) {
        this.studies_id = studies_id;
        this.studies_title = studies_title;
        this.studies_institute = studies_institute;
        this.studies_year = studies_year;
    }
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JsonIgnore()
    @JoinColumn (name = "portfolio_id")
    
    private Portfolio portfolio;
}
