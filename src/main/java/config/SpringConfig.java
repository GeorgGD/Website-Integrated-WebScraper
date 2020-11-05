package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


/**
 * Configuration class for spring project
 * @autor Georgios Davakos
 * @since 2020-11-05
 */
@Configuration
@ComponentScan(basePackages = {"com.wiw.core.webscraper", "com.wiw.core.controllers"})
public class SpringConfig {

	/**
	 * Meant to allow your controllers from refering to files without the need
	 * of using file type
	 * @return the view class
	 */
	@Bean
	public InternalResourceViewResolver viewResolver() {
		InternalResourceViewResolver vr = new InternalResourceViewResolver();
		vr.setPrefix("/WEB-INF/");
		vr.setSuffix(".jsp");
		return vr;
	}
}
