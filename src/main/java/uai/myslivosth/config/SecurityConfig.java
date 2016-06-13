package uai.myslivosth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import uai.myslivosth.service.UserService;

/**
 *
 * @author Tomáš Honner
 */

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@ComponentScan(basePackages = "uai.myslivosth")
public class SecurityConfig extends WebSecurityConfigurerAdapter{
    
    @Autowired
    private UserService userService;
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.exceptionHandling().accessDeniedPage("/login")
            .and()
            .authorizeRequests().antMatchers("/index").permitAll()
                                .antMatchers("/css").permitAll()
                                .antMatchers("/animals").hasAnyRole("USER")
                                .antMatchers("/animalnew").hasAnyRole("USER")
                                .antMatchers("/animaledit").hasAnyRole("USER")
                                .antMatchers("/users").hasAnyRole("ADMIN")
                                .antMatchers("/usernew").hasAnyRole("ADMIN")
                                .antMatchers("/useredit").hasAnyRole("ADMIN")
                                //.antMatchers("/specienew").hasAnyRole("ADMIN")
                                .anyRequest().permitAll()
                .and()
                .formLogin().loginPage("/login").permitAll().loginProcessingUrl("/login")
                .and()
                .csrf().disable()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login")
                .and().httpBasic();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.
            /*    
            inMemoryAuthentication()
            .withUser("admin").password("admin").roles("ADMIN", "USER").and()
            .withUser("tom").password("tom").roles("USER").and()
            .and()
            */
            authenticationProvider(authenticationProvider());
    }
    
    
    private AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService((UserDetailsService) userService);
        
        return authProvider;
    }
    
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
}
