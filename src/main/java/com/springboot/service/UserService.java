package com.springboot.service;


import com.springboot.pojo.User;

/**
 *
 * @author  chengfan
 * @version 2018年9月5日
 */
public interface UserService {

	public User findByUsername(String username);
	
	public boolean addUser(User user);
}
