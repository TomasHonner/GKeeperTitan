package uai.myslivosth.dao;

import java.util.List;
import uai.myslivosth.model.Role;

/**
 *
 * @author Tomáš Honner
 */
public interface RoleDao {
    
    List<Role> findAllRoles();
    
    Role getDefaultRole();
    
    Role getRoleByID(String id);
    
    void saveRole(Role role);
     
    void deleteRoleById(String id);
    
}
