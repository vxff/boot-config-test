package com.springboot.config.beetl;
/**
 *
 * @author  chengfan
 * @version 2018年9月18日
 */

import org.beetl.core.resource.ClasspathResourceLoader;
import org.beetl.ext.spring.BeetlGroupUtilConfiguration;
import org.beetl.ext.spring.BeetlSpringViewResolver;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeetlViewConfig {
	
	@Value("${beetl.templatesPath}")
	private String templatesPath;
	
	@Bean(initMethod = "init", name = "beetlConfig")
	public BeetlGroupUtilConfiguration getBeetlGroupUtilConfiguration() {
        BeetlGroupUtilConfiguration beetlGroupUtilConfiguration = new BeetlGroupUtilConfiguration();
        ClassLoader loader = Thread.currentThread().getContextClassLoader();
        if(loader==null){
            loader = BeetlViewConfig.class.getClassLoader();
        }
        ClasspathResourceLoader classpathResourceLoader = new ClasspathResourceLoader(loader,templatesPath);
        beetlGroupUtilConfiguration.setResourceLoader(classpathResourceLoader);
        return beetlGroupUtilConfiguration;
    }
	
	@Bean(name = "beetlViewResolver")
    public BeetlSpringViewResolver getBeetlSpringViewResolver(@Qualifier("beetlConfig") BeetlGroupUtilConfiguration beetlGroupUtilConfiguration) {
        BeetlSpringViewResolver beetlSpringViewResolver = new BeetlSpringViewResolver();
        beetlSpringViewResolver.setSuffix(".html");
        beetlSpringViewResolver.setContentType("text/html;charset=UTF-8");
        beetlSpringViewResolver.setOrder(0);
        beetlSpringViewResolver.setConfig(beetlGroupUtilConfiguration);
        return beetlSpringViewResolver;
    }
}
