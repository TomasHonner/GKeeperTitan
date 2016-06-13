package uai.myslivosth.service;

import java.util.List;
import uai.myslivosth.model.Region;

/**
 *
 * @author Tomáš Honner
 */
public interface RegionService {
    
    void saveRegion(Region region);
    
    Region getDefaultRegion();
    
    Region getRegionById(String id);
     
    List<Region> findAllRegions();
     
    void deleteRegionById(String id); 
}
