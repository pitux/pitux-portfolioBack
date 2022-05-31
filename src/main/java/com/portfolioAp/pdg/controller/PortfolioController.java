package com.portfolioAp.pdg.controller;

import com.portfolioAp.pdg.model.Portfolio;
import com.portfolioAp.pdg.services.IPortfolioService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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

@RestController
@RequestMapping("/portfolio")
@CrossOrigin

public class PortfolioController {
    
    @Autowired

    private IPortfolioService portfolioServ;
    
    List<PortfolioController> portfolio = new ArrayList();

    @GetMapping ("/all")
    @ResponseBody
    public List<Portfolio> listarPortfolios(){
        return portfolioServ.listarPortfolios();
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping ("/new")
    public void agregarPortfolio(@RequestBody Portfolio portfo){
        portfolioServ.newPortfolio(portfo);
    }
     
    @PreAuthorize("hasRole('ADMIN')")
    @PutMapping ("/update/{id}")
    public void editPortfolio(@RequestBody Portfolio portfo){
        portfolioServ.newPortfolio(portfo);
    }
    
    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping ("/delete/{id}")
    public void borrarPortfolio(@PathVariable Long id){
        portfolioServ.deletePortfolio(id);
    }
    
    @GetMapping ("/view/{id}")
    @ResponseBody
    public Portfolio verPortfolio(@PathVariable Long id){
     return portfolioServ.buscarPortfolio(id);
    }
    
    
}