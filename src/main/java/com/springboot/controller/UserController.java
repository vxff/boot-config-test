package com.springboot.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.pojo.User;
import com.springboot.service.UserService;

/**
 *
 * @author  chengfan
 * @version 2018年9月5日
 */
@RestController
public class UserController {
	
	@Autowired
	private UserService userService;

	@RequestMapping("hello")
	public User index() {
		return userService.findByUsername("aaa");
	}
	
}
