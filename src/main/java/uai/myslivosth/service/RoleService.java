package uai.myslivosth.service;

import java.util.List;
import uai.myslivosth.model.Role;

/**
 *
 * @author Tomáš Honner
 */
public interface RoleService {
    
    List<Role> findAllRoles();
    
    Role getDefaultRole();
    
    Role getRoleByID(String id);
    
    void saveRole(Role role);
     
    void deleteRoleById(String id);
    
}
