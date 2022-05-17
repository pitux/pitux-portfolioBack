package com.portfolioAp.pdg.services;


import com.portfolioAp.pdg.model.Portfolio;
import com.portfolioAp.pdg.repository.PortfolioRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author pablo
 */

@Service
public class PortfolioService implements IPortfolioService {
    
    @Autowired
    PortfolioRepository portfolioRepo;

    @Override
    public List<Portfolio> listarPortfolios() {
      return portfolioRepo.findAll();
    }

    @Override
    public void newPortfolio(Portfolio portfo) {
        portfolioRepo.save(portfo);
    }

    @Override
    public void deletePortfolio(Long id) {
        portfolioRepo.deleteById(id);
    }

    @Override
    public Portfolio buscarPortfolio(Long id) {
       return portfolioRepo.findById(id).orElse(null);
    }

    @Override
    public Portfolio editarPortfolio(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
               
}