package uai.myslivosth.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uai.myslivosth.dao.RegionDao;
import uai.myslivosth.model.Region;

/**
 *
 * @author Tomáš Honner
 */

@Service("regionService")
@Transactional
public class RegionServiceImpl implements RegionService{

    @Autowired
    RegionDao dao;
    
    @Override
    public void saveRegion(Region region) {
        dao.saveRegion(region);
    }

    @Override
    public List<Region> findAllRegions() {
        return dao.findAllRegions();
    }

    @Override
    public void deleteRegionById(String id) {
        dao.deleteRegionById(id);
    }

    @Override
    public Region getDefaultRegion() {
        return dao.getDefaultRegion();
    }

    @Override
    public Region getRegionById(String id) {
        return dao.getRegionById(id);
    }
    
    
}
