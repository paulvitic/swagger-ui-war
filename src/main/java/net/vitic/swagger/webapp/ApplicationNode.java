package net.vitic.swagger.webapp;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.UrlBasedViewResolver;

@Configuration
@PropertySource(ignoreResourceNotFound= true, value={
		"classpath:conf/app.properties"})
@EnableWebMvc
@ComponentScan(basePackages={"net.vitic.swagger.controller"})
public class ApplicationNode extends WebMvcConfigurerAdapter {
	
	private final static Logger LOG = Logger.getLogger(ApplicationNode.class);
		
	@Bean
	public PropertySourcesPlaceholderConfigurer propertySourcesPlaceholderConfigurer() {
		return new PropertySourcesPlaceholderConfigurer();
	}

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry aRegistry) {
    		aRegistry.addResourceHandler("/**").addResourceLocations("/");
    }

	@Bean
    public ViewResolver viewResolver() {
            UrlBasedViewResolver viewResolver = new UrlBasedViewResolver();
            viewResolver.setViewClass(JstlView.class);
            viewResolver.setPrefix("WEB-INF/view/");
            viewResolver.setSuffix(".jsp");
            return viewResolver;
    }

    /////////////////////
    // Message Templates
    /////////////////////
	@Bean(name="messageSource")
	public ResourceBundleMessageSource resourceBundleMessageSource(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		String[] basenames = new String[]{"msg/notification"};
		messageSource.setBasenames(basenames );
		return messageSource;
	}

}
