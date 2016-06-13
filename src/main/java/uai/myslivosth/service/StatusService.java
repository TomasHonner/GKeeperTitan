package uai.myslivosth.service;

import java.util.List;
import uai.myslivosth.model.Status;

/**
 *
 * @author Tomáš Honner
 */
public interface StatusService {
    
    List<Status> findAllStatuses();
    
    Status getDefaultStatus();
    
    Status getStatusById(String id);
    
    void saveStatus(Status status);
     
    void deleteStatusById(String id);
    
}
