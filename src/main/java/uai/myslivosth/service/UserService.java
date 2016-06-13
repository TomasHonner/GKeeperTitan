package uai.myslivosth.service;

import java.util.List;
import uai.myslivosth.model.User;

/**
 *
 * @author Tomáš Honner
 */

public interface UserService {
    
    void saveUser(User user);
     
    List<User> findAllUsers();
    
    User findUserByID(String id);
    
    User findUserByUserName(String name);
     
    void deleteUserById(String id); 
    
    void updateUser(User user);
    
}
