package com.portfolioAp.pdg.services;

import com.portfolioAp.pdg.model.Portfolio;
import java.util.List;

/**
 *
 * @author pablo
 */
public interface IPortfolioService {
    //En la interfaz se define los métodos que utilizaremos

    public List<Portfolio> listarPortfolios();
    
    public void newPortfolio(Portfolio portfo);
    
    public void deletePortfolio(Long id);
    
    public Portfolio buscarPortfolio(Long id);
    
    public Portfolio editarPortfolio(Long id);

}
