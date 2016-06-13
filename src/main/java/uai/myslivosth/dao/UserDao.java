package uai.myslivosth.dao;

import java.util.List;
import uai.myslivosth.model.User;

/**
 *
 * @author Tomáš Honner
 */
public interface UserDao {
    
    void saveUser(User user);
     
    List<User> findAllUsers();
    
    User findUserByID(String id);
    
    User finUserByUsername(String name);
     
    void deleteUserById(String id);
    
    void updateUser(User user);
}
