package uai.myslivosth.service;

import java.util.List;
import uai.myslivosth.model.Specie;

/**
 *
 * @author Tomáš Honner
 */
public interface SpecieService {
 
    List<Specie> findAllSpecies();
    
    Specie getDefaultSpecie();
    
    Specie getSpecieById(String id);
    
    void saveSpecie(Specie specie);
     
    void deleteSpecieById(String id);
    
}
