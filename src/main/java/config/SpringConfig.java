package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * Configuration class for spring project
 * @autor Georgios Davakos
 * @since 2020-11-05
 */
@EnableWebMvc
@Configuration
@ComponentScan(basePackages = {"com.wiw.core.webscraper", "com.wiw.core.controllers"})
public class SpringConfig implements WebMvcConfigurer{

	/**
	 * Meant to allow your controllers from refering to files without the need
	 * of using file type
	 * @return the view class
	 */
	@Bean
	public ViewResolver viewResolver() {
		InternalResourceViewResolver view = new InternalResourceViewResolver();
		view.setPrefix("/WEB-INF/view/");
		view.setSuffix(".jsp");
		return view;
	}
	
	/**
	 * Takes care for all mappings to static files
	 */
	@Override 
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
}
