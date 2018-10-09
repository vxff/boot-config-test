package com.springboot.config.shiro;

import java.util.LinkedHashMap;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author  chengfan
 * @version 2018年9月18日
 */
@Configuration
public class ShiroConfig {
	
	@Bean
	public HashedCredentialsMatcher hashedCredentialsMatcher() {
		HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
		hashedCredentialsMatcher.setHashAlgorithmName("MD5");
		hashedCredentialsMatcher.setHashIterations(1024);
		return hashedCredentialsMatcher;
	}
	
	@Bean(name="myShiroRealm")
	public MyShiroRealm myShiroRealm() {
		MyShiroRealm myShiroRealm = new MyShiroRealm();
		myShiroRealm.setName("myShiroRealm");
		myShiroRealm.setCredentialsMatcher(hashedCredentialsMatcher());
		return myShiroRealm;
	}
	
	@Bean(name="securityManager")
	public DefaultWebSecurityManager securityManager(@Qualifier("myShiroRealm")MyShiroRealm myShiroRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(myShiroRealm);
		return securityManager;
	}
	
	@Bean
	public ShiroFilterFactoryBean shiroFilter(@Qualifier("securityManager") DefaultWebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean=new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //配置登录的url和登录成功的url
        shiroFilterFactoryBean.setLoginUrl("/login.html");
        shiroFilterFactoryBean.setSuccessUrl("/toLogin.html");
        shiroFilterFactoryBean.setUnauthorizedUrl("/403");
        //配置访问权限
        LinkedHashMap<String, String> filterChainDefinitionMap=new LinkedHashMap<>();
        filterChainDefinitionMap.put("/base/**","anon");//表示可以匿名访问
        filterChainDefinitionMap.put("/global/**","anon");
        filterChainDefinitionMap.put("/js/**","anon");
        filterChainDefinitionMap.put("/getValidateCode.html","anon");
        filterChainDefinitionMap.put("/register.html","anon");
        filterChainDefinitionMap.put("/toRegister.html","anon");
        filterChainDefinitionMap.put("/login.html","anon");
        filterChainDefinitionMap.put("/toLogin.html","anon");
        filterChainDefinitionMap.put("/403.html","anon");
        
        
        filterChainDefinitionMap.put("/logout*","anon");
        filterChainDefinitionMap.put("/jsp/error.jsp*","anon");
        filterChainDefinitionMap.put("/jsp/index.jsp*","authc");
        filterChainDefinitionMap.put("/*", "authc");//表示需要认证才可以访问
        filterChainDefinitionMap.put("/**", "authc");//表示需要认证才可以访问
        filterChainDefinitionMap.put("/*.*", "authc");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }
	
	/**
	* 开启shiro aop注解支持. 使用代理方式;所以需要开启代码支持;
	* 
	* @param securityManager
	* @return
	*/
	@Bean
	public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(@Qualifier("securityManager")DefaultWebSecurityManager securityManager) {
		AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
		authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
		return authorizationAttributeSourceAdvisor;
	}
}
