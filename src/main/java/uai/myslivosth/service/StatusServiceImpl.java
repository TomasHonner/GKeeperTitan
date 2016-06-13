package uai.myslivosth.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uai.myslivosth.dao.StatusDao;
import uai.myslivosth.model.Status;

/**
 *
 * @author Tomáš Honner
 */

@Service("statusService")
@Transactional
public class StatusServiceImpl implements StatusService{

    @Autowired
    StatusDao dao;
    
    @Override
    public List<Status> findAllStatuses() {
        return dao.findAllStatuses();
    }

    @Override
    public void saveStatus(Status status) {
        dao.saveStatus(status);
    }

    @Override
    public void deleteStatusById(String id) {
        dao.deleteStatusById(id);
    }

    @Override
    public Status getDefaultStatus() {
        return dao.getDefaultStatus();
    }

    @Override
    public Status getStatusById(String id) {
        return dao.getStatusById(id);
    }
    
}
