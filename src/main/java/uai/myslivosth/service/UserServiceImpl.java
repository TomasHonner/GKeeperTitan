package uai.myslivosth.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uai.myslivosth.dao.UserDao;
import uai.myslivosth.model.Role;
import uai.myslivosth.model.User;

/**
 *
 * @author Tomáš Honner
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService, UserDetailsService{
    
    @Autowired
    UserDao dao;

    @Override
    public void saveUser(User user) {
        dao.saveUser(user);
    }

    @Override
    public List<User> findAllUsers() {
        return dao.findAllUsers();
    }

    @Override
    public User findUserByID(String id) {
        return dao.findUserByID(id);
    }
    
    

    @Override
    public void deleteUserById(String id) {
        dao.deleteUserById(id);
    }

    @Override
    public void updateUser(User user) {
        dao.updateUser(user);
    }
    
    @Override
    public User findUserByUserName(String name) {
       return dao.finUserByUsername(name);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User u = findUserByUserName(username);
        if (u == null)
        {
            throw new UsernameNotFoundException(username);
        }
        
        List<GrantedAuthority> grantedAuthority;
        Role grantedRole = u.getRole();

        grantedAuthority = new ArrayList<GrantedAuthority>();

        if(grantedRole.getRole().equals("ADMIN"))
        {
            grantedAuthority.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
            grantedAuthority.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        else
        {
           grantedAuthority.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        
        return new org.springframework.security.core.userdetails.User(u.getLogin(),u.getPassword(),true, true, true, true, grantedAuthority);
    }


    
}
