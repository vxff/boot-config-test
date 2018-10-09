package com.springboot.service.impl;


import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.dao.UserRepository;
import com.springboot.pojo.User;
import com.springboot.service.UserService;

/**
 *
 * @author  chengfan
 * @version 2018年9月5日
 */
@Service("userService")
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public boolean addUser(User user) {
		User username = userRepository.findByUsername(user.getUsername());
		if (null==username) {
			String salt = new SecureRandomNumberGenerator().nextBytes().toHex();
			String password = new SimpleHash("MD5", user.getPassword(), user.getUsername()+salt, 1024).toString();
			user.setSalt(salt);
			user.setPassword(password);
			userRepository.saveAndFlush(user);
			return true;
		}
		return false;
	}
	
}
