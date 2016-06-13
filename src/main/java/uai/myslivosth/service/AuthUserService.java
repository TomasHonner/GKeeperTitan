package uai.myslivosth.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import uai.myslivosth.model.User;

/**
 *
 * @author Tomáš Honner
 */
public class AuthUserService implements UserDetailsService{

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
         if ("test-a".equals(username)) {
             User user = new User();
             user.setLogin(username);
             user.setPassword("tom");
             return (UserDetails) user;
        }
        throw new UsernameNotFoundException("Username '" + username + "' was not found.");
    }
    
}
