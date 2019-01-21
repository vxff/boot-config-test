package com.springboot.config.properties;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

/**
 *
 * @author chengfan
 * @version 2019年1月21日
 */
@Configuration
public class PropertiesConfig {

	@Bean
	public PropertySourcesPlaceholderConfigurer createPropertySourcesPlaceholderConfigurer() {
		ClassPathResource resource = new ClassPathResource("pay-dev.properties");
		PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer = new PropertySourcesPlaceholderConfigurer();
		propertyPlaceholderConfigurer.setLocation(resource);
		return propertyPlaceholderConfigurer;
	}

}
