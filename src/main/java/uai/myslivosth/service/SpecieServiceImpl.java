package uai.myslivosth.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uai.myslivosth.dao.SpecieDao;
import uai.myslivosth.model.Specie;

/**
 *
 * @author Tomáš Honner
 */

@Service("specieService")
@Transactional
public class SpecieServiceImpl implements SpecieService{

    @Autowired
    SpecieDao dao;
    
    @Override
    public List<Specie> findAllSpecies() {
        return dao.findAllSpecies();
    }

    @Override
    public void saveSpecie(Specie specie) {
        dao.saveSpecie(specie);
    }

    @Override
    public void deleteSpecieById(String id) {
        dao.deleteSpecieById(id);
    }

    @Override
    public Specie getDefaultSpecie() {
        return dao.getDefaultSpecie();
    }

    @Override
    public Specie getSpecieById(String id) {
        return dao.getSpecieById(id);
    }
    
}
