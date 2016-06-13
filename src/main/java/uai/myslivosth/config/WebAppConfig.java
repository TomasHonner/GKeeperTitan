package uai.myslivosth.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * @author Tomáš Honner
 */

@Configuration
@ComponentScan("uai.myslivosth.controller")
public class WebAppConfig extends WebMvcConfigurerAdapter{
    
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/img/*").addResourceLocations("/img/");
        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
    }
    
}
