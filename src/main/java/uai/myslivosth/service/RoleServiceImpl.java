package uai.myslivosth.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uai.myslivosth.dao.RoleDao;
import uai.myslivosth.model.Role;

/**
 *
 * @author Tomáš Honner
 */

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService{
    
    @Autowired
    RoleDao dao;

    @Override
    public List<Role> findAllRoles() {
        return dao.findAllRoles();
    }

    @Override
    public void saveRole(Role role) {
        dao.saveRole(role);
    }

    @Override
    public void deleteRoleById(String id) {
        dao.deleteRoleById(id);
    }

    @Override
    public Role getDefaultRole() {
       return dao.getDefaultRole();
    }

    @Override
    public Role getRoleByID(String id) {
        return dao.getRoleByID(id);
    }
    
}
