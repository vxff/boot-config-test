package com.springboot.config.shiro;


import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.springboot.pojo.User;
import com.springboot.service.UserService;

/**
 *
 * @author  chengfan
 * @version 2018年9月6日
 */
public class MyShiroRealm extends AuthorizingRealm{
	
	@Autowired
	private UserService userService;
	
	//登录认证
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		UsernamePasswordToken upToken = (UsernamePasswordToken)token;
		String username = upToken.getUsername();
		User user = userService.findByUsername(username);
		if (user==null) {
			throw new UnknownAccountException("用户名不存在");
		}
		Object principal = username;
		Object hashedCredentials = user.getPassword();
		ByteSource credentialsSalt = ByteSource.Util.bytes(user.getCredentialsSalt());
		// realName 父类的
		String realmName = getName();
		SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(principal, hashedCredentials,credentialsSalt,realmName);
		return info;
	}

	//授权
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		return (AuthorizationInfo) principals;
	}
	
}
