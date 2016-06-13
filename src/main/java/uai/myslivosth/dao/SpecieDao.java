package uai.myslivosth.dao;

import java.util.List;
import uai.myslivosth.model.Specie;

/**
 *
 * @author Tomáš Honner
 */
public interface SpecieDao {
    
    List<Specie> findAllSpecies();
    
    Specie getDefaultSpecie();
    
    Specie getSpecieById(String id);
    
    void saveSpecie(Specie specie);
     
    void deleteSpecieById(String id);
}
