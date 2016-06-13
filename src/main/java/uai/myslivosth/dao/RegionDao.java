package uai.myslivosth.dao;

import java.util.List;
import uai.myslivosth.model.Region;

/**
 *
 * @author Tomáš Honner
 */
public interface RegionDao {
    
    List<Region> findAllRegions();
    
    Region getDefaultRegion();
    
    Region getRegionById(String id);
    
    void saveRegion(Region region);
     
    void deleteRegionById(String id);
}
